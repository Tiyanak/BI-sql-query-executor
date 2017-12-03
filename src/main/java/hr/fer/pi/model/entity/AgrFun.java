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

@Entity(name = "agrFun")
@Table(name = "agrFun")
public class AgrFun implements Serializable {

    @Id
    @Column(name = "sifAgrFun")
    @NotNull
    private Integer sifAgrFun;

    @Column(name = "nazAgrFun")
    @NotNull
    private String nazAgrFun;

    public AgrFun() {
    }

    public AgrFun(Integer sifAgrFun, String nazAgrFun) {
        this.sifAgrFun = sifAgrFun;
        this.nazAgrFun = nazAgrFun;
    }

    public Integer getSifAgrFun() {
        return sifAgrFun;
    }

    public void setSifAgrFun(Integer sifAgrFun) {
        this.sifAgrFun = sifAgrFun;
    }

    public String getNazAgrFun() {
        return nazAgrFun;
    }

    public void setNazAgrFun(String nazAgrFun) {
        this.nazAgrFun = nazAgrFun;
    }
}
