package hr.fer.pi.model.embedded;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * Created by Igor Farszky on 1.12.2017..
 */
@Embeddable
public class DimCinjId implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "sifCinjTablica")
    @NotNull
    private Integer sifCinjTablica;

    @Column(name = "sifDimTablica")
    @NotNull
    private Integer sifDimTablica;

    @Column(name = "rbrCinj")
    @NotNull
    private Integer rbrCinj;

    @Column(name = "rbrDim")
    @NotNull
    private Integer rbrDim;

    public DimCinjId() {
    }

    public DimCinjId(Integer sifCinjTablica, Integer sifDimTablica, Integer rbrCinj, Integer rbrDim) {
        this.sifCinjTablica = sifCinjTablica;
        this.sifDimTablica = sifDimTablica;
        this.rbrCinj = rbrCinj;
        this.rbrDim = rbrDim;
    }

    public Integer getSifCinjTablica() {
        return sifCinjTablica;
    }

    public void setSifCinjTablica(Integer sifCinjTablica) {
        this.sifCinjTablica = sifCinjTablica;
    }

    public Integer getSifDimTablica() {
        return sifDimTablica;
    }

    public void setSifDimTablica(Integer sifDimTablica) {
        this.sifDimTablica = sifDimTablica;
    }

    public Integer getRbrCinj() {
        return rbrCinj;
    }

    public void setRbrCinj(Integer rbrCinj) {
        this.rbrCinj = rbrCinj;
    }

    public Integer getRbrDim() {
        return rbrDim;
    }

    public void setRbrDim(Integer rbrDim) {
        this.rbrDim = rbrDim;
    }
}
