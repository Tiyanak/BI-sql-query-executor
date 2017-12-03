package hr.fer.pi.model.entity;

import hr.fer.pi.model.embedded.DimCinjId;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Igor Farszky on 1.12.2017..
 */

@Entity
@Table(name = "dimCinj")
public class DimCinj implements Serializable {

    @EmbeddedId
    private DimCinjId dimCinjId;

    public DimCinj() {
    }

    public DimCinj(DimCinjId dimCinjId) {
        this.dimCinjId = dimCinjId;
    }

    public DimCinjId getDimCinjId() {
        return dimCinjId;
    }

    public void setDimCinjId(DimCinjId dimCinjId) {
        this.dimCinjId = dimCinjId;
    }
}
