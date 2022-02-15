package presentation;

import dao.IDao;
import metier.IMetier;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

public class PresentationDynamic {
    public static void main(String[] args) throws FileNotFoundException, ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        // dynamic dependency injection from configuration file
        // in /DynamicDI.txt
        Scanner scanner = new Scanner(new File("DynamicDI.txt"));
        String daoClassName = scanner.nextLine();
        Class<?> daoClass = Class.forName(daoClassName);
        IDao dao = (IDao) daoClass.newInstance();

        String metierClassName = scanner.nextLine();
        Class<?> metierClass = Class.forName(metierClassName);
        IMetier metier = (IMetier) metierClass.newInstance();

        // injection via setter
        Method method = metierClass.getMethod("setDao", IDao.class);
        method.invoke(metier, dao);
        System.out.println(metier.calcule());
    }
}
