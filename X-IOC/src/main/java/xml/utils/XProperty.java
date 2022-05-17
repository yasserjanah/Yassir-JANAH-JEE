package xml.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@XmlRootElement(name = "xproperty")
@XmlAccessorType(XmlAccessType.FIELD)
public class XProperty implements Serializable {

    @XmlAttribute(required = true)
    private String name;

    @XmlAttribute(required = true)
    private String ref;

}