package hr.fer.pi.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * Created by Igor Farszky on 1.12.2017..
 */

@Entity
@Table(name = "tipTablica")
public class TipTablica implements Serializable {

    @Id
    @Column(name = "sifTipTablica")
    @NotNull
    private Integer sifTipTablica;

    @Column(name = "nazTipTablica")
    @NotNull
    private String nazTipTablica;

    public TipTablica() {
    }

    public TipTablica(Integer sifTipTablica, String nazTipTablica) {
        this.sifTipTablica = sifTipTablica;
        this.nazTipTablica = nazTipTablica;
    }

    public Integer getSifTipTablica() {
        return sifTipTablica;
    }

    public void setSifTipTablica(Integer sifTipTablica) {
        this.sifTipTablica = sifTipTablica;
    }

    public String getNazTipTablica() {
        return nazTipTablica;
    }

    public void setNazTipTablica(String nazTipTablica) {
        this.nazTipTablica = nazTipTablica;
    }
}
