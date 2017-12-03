package hr.fer.pi.model.embedded;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * Created by Igor Farszky on 1.12.2017..
 */
@Embeddable
public class TabAtributId implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "sifTablica")
    @NotNull
    private Integer sifTablica;

    @Column(name = "rbrAtrib")
    @NotNull
    private Integer rbrAtrib;

    public TabAtributId() {
    }

    public TabAtributId(Integer sifTablica, Integer rbrAtrib) {
        this.sifTablica = sifTablica;
        this.rbrAtrib = rbrAtrib;
    }

    public Integer getSifTablica() {
        return sifTablica;
    }

    public void setSifTablica(Integer sifTablica) {
        this.sifTablica = sifTablica;
    }

    public Integer getRbrAtrib() {
        return rbrAtrib;
    }

    public void setRbrAtrib(Integer rbrAtrib) {
        this.rbrAtrib = rbrAtrib;
    }
}
