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
@Table(name = "tipAtrib")
public class TipAtrib implements Serializable {

    @Id
    @Column(name = "sifTipAtrib")
    @NotNull
    private Integer sifTipAtrib;

    @Column(name = "nazTipAtrib")
    @NotNull
    private String nazTipAtrib;

    public TipAtrib() {
    }

    public TipAtrib(Integer sifTipAtrib, String nazTipAtrib) {
        this.sifTipAtrib = sifTipAtrib;
        this.nazTipAtrib = nazTipAtrib;
    }

    public Integer getSifTipAtrib() {
        return sifTipAtrib;
    }

    public void setSifTipAtrib(Integer sifTipAtrib) {
        this.sifTipAtrib = sifTipAtrib;
    }

    public String getNazTipAtrib() {
        return nazTipAtrib;
    }

    public void setNazTipAtrib(String nazTipAtrib) {
        this.nazTipAtrib = nazTipAtrib;
    }
}
