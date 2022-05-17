package annotations;

import org.reflections.Reflections;
import org.reflections.scanners.ResourcesScanner;
import org.reflections.scanners.SubTypesScanner;
import org.reflections.util.ClasspathHelper;
import org.reflections.util.ConfigurationBuilder;
import org.reflections.util.FilterBuilder;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class AnnotationsInjector {
    private static final String XCOMPONENT_ANNOTATION = "XComponent";
    private static final String XAUTOWIRED_ANNOTATION = "XAutowired";
    private HashMap<Class<?>, Object> instances = new HashMap<>();

    public void getClasses(String... packages) throws InstantiationException, IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException, InvocationTargetException, InvocationTargetException {
        ArrayList<Class<?>> classes=new ArrayList<>();
        Set<Class<?>> subTypesOf = null;
        for(String packageName : packages) {
            Reflections reflections = new Reflections(new ConfigurationBuilder()
                    .setScanners(new SubTypesScanner(false), new ResourcesScanner())
                    .addUrls(ClasspathHelper.forJavaClassPath())
                    .filterInputsBy(new FilterBuilder()
                            .include(FilterBuilder.prefix(packageName))));

            subTypesOf = reflections.getSubTypesOf(Object.class);
            for( Class<?> c :subTypesOf) {
                if(c.toString().contains("class")) {
                    Object o = c.newInstance();
                    instances.put(c.getInterfaces()[0], o);
                    classes.add(c);
                }
            }


        }
        for(Class<?> c : classes) {
            if( c.getAnnotations()[0].toString().contains(XCOMPONENT_ANNOTATION) && c.getDeclaredFields().length > 0 ) {
                Field[] fields = c.getDeclaredFields();
                for(Field f : fields) {
                    if(f.getAnnotations()[0].toString().contains(XAUTOWIRED_ANNOTATION)) {
                        System.out.println(c);
                        System.out.println(f);
                        Method method = c.getMethod("setUserRepository",f.getType());
                        method.invoke(instances.get(c.getInterfaces()[0]), instances.get(f.getType()));
                    }
                }
            }
        }

    }
    public HashMap<Class<?>, Object> getInstances(){
        return instances;
    }
}
