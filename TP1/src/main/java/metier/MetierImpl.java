package metier;

import dao.IDao;
import org.springframework.stereotype.Component;

@Component("metier")
public class MetierImpl implements IMetier {
    // couplage faible : injection de dépendance
    private IDao dao;

    // constructeur
    // NoArgsConstructor
    public MetierImpl() {
    }

    public MetierImpl(IDao dao) {
        this.dao = dao;
    }

    @Override
    public double calcule() {
        double temperature = dao.getData();
        return temperature * 540 / Math.cos(temperature * Math.PI);
    }

    // inject via setter
    public void setDao(IDao dao) {
        this.dao = dao;
    }
}
