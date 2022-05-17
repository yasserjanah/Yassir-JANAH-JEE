package xml.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@AllArgsConstructor
@NoArgsConstructor
@Data
@XmlRootElement(name = "xbeans")
public class XBeans implements Serializable {
    @XmlElement(name = "xbean")
    private List<XBean> xBeans = new ArrayList<>();

    public void addObject(XBean xb) {
        xBeans.add(xb);
    }
}