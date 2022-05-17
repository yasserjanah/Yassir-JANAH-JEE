package xml;

import xml.user.services.UserService;
import xml.utils.XMLInjector;

import javax.xml.bind.JAXBException;
import java.lang.reflect.InvocationTargetException;

public class MainApplication {

    public static void main(String[] args) throws JAXBException, ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {

        XMLInjector xmlInjector = new XMLInjector("xioc.xml");
        UserService userService = (UserService) xmlInjector.getObject();
        System.out.println("FindUserByName => "+ userService.findUserByName("user1"));

    }
}
