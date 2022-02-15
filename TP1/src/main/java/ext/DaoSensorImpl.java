package ext;

import dao.IDao;
import org.springframework.stereotype.Component;

@Component("dao")
public class DaoSensorImpl implements IDao {

    @Override
    public double getData() {
        return Math.random() * 200;
    }
}
