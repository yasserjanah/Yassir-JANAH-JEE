package xml.utils;

import lombok.Data;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@Data
public class XMLInjector {

    private File xmlFile;
    private JAXBContext jaxbContext;

    private Object object;

    public XMLInjector(String xmlFilePath) throws JAXBException, ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        this.xmlFile = new File(xmlFilePath);
        this.jaxbContext = JAXBContext.newInstance(XBeans.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        XBeans xBeans = (XBeans) unmarshaller.unmarshal(xmlFile);
        XBean xBean1 = xBeans.getXBeans().get(1);
        XBean xBean2 = xBeans.getXBeans().get(0);

        Class<?> clazz1 = Class.forName(xBean2.getClassName());
        Class<?> clazz2 = Class.forName(xBean1.getClassName());

        Object object = clazz2.newInstance();
        Method method = clazz2.getMethod("set"+xBean1.getXproperty().getName().substring(0,1)
                .toUpperCase()+xBean1.getXproperty().getName().substring(1)
                , clazz1.getInterfaces());

        method.invoke(object, clazz1.newInstance());
        this.object = object;

    }
}
