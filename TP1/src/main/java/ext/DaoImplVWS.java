package ext;

import dao.IDao;

public class DaoImplVWS implements IDao {
    @Override
    public double getData() {
        System.out.println("DaoImplVWS.getData(): Version Web Service.\n");
        return 0;
    }
}
