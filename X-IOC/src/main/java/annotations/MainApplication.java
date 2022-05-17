package annotations;

import annotations.user.services.UserService;

import java.lang.reflect.InvocationTargetException;

public class MainApplication {
    public static void main(String[] args) throws InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException {
        AnnotationsInjector contx=new AnnotationsInjector();
        contx.getClasses("user");
        UserService userService = (UserService) contx.getInstances().get(UserService.class);

        System.out.println(userService.findUserByName("user1"));
    }
}
