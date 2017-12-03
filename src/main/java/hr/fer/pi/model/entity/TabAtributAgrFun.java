package hr.fer.pi.model.entity;

import hr.fer.pi.model.embedded.TabAtributAgrFunId;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * Created by Igor Farszky on 1.12.2017..
 */

@Entity
@Table(name = "tabAtributAgrFun")
public class TabAtributAgrFun implements Serializable {

    private static final long serialVersionUID = 1L;

    @EmbeddedId
    private TabAtributAgrFunId tabAtributAgrFunId;

    @Column(name = "sifAgrFun")
    @NotNull
    private Integer sifAgrFun;

    @Column(name = "imeAtrib")
    @NotNull
    private String imeAtrib;

    public TabAtributAgrFun() {
    }

    public TabAtributAgrFun(Integer sifAgrFun, String imeAtrib) {
        this.sifAgrFun = sifAgrFun;
        this.imeAtrib = imeAtrib;
    }

    public TabAtributAgrFun(TabAtributAgrFunId tabAtributAgrFunId, Integer sifAgrFun, String imeAtrib) {
        this.tabAtributAgrFunId = tabAtributAgrFunId;
        this.sifAgrFun = sifAgrFun;
        this.imeAtrib = imeAtrib;
    }

    public TabAtributAgrFunId getTabAtributAgrFunId() {
        return tabAtributAgrFunId;
    }

    public void setTabAtributAgrFunId(TabAtributAgrFunId tabAtributAgrFunId) {
        this.tabAtributAgrFunId = tabAtributAgrFunId;
    }

    public Integer getSifAgrFun() {
        return sifAgrFun;
    }

    public void setSifAgrFun(Integer sifAgrFun) {
        this.sifAgrFun = sifAgrFun;
    }

    public String getImeAtrib() {
        return imeAtrib;
    }

    public void setImeAtrib(String imeAtrib) {
        this.imeAtrib = imeAtrib;
    }
}
