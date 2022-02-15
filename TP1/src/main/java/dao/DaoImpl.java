package dao;

public class DaoImpl implements IDao{
    @Override
    public double getData() {
        System.out.println("DaoImpl.getData(): Version Database\n");
        // return a random number
        return Math.random() * 40;
    }
}
