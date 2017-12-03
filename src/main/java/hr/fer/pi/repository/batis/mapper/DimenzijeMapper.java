package hr.fer.pi.repository.batis.mapper;

import hr.fer.pi.model.custom_sql_model.DimenzijeSQL;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by Igor Farszky on 2.12.2017..
 */
@Mapper
public interface DimenzijeMapper {

    static final String SELECT_DIMENZIJE =
            "SELECT"
                    + " tabA.sifTablica AS sifTablica,"
                    + " tabA.rbrAtrib AS rbrAtrib,"
                    + " tabA.imeSQLAtrib AS imeSQLAtrib,"
                    + " tabA.sifTipAtrib AS sifTipAtrib,"
                    + " tabA.imeAtrib AS imeAtrib,"
                    + " dc.sifCinjTablica AS sifCinjTablica,"
                    + " dc.sifDimTablica AS sifDimTablica,"
                    + " dc.rbrCinj AS rbrCinj,"
                    + " dc.rbrDim AS rbrDim,"
                    + " dTab.sifTablica AS sifTablicaDim,"
                    + " dTab.nazTablica AS nazTablicaDim,"
                    + " dTab.nazSQLTablica AS nazSQLTablicaDim,"
                    + " dTab.sifTipTablica AS sifTipTablicaDim,"
                    + " cTab.sifTablica AS sifTablicaCinj,"
                    + " cTab.nazTablica AS nazTablicaCinj,"
                    + " cTab.nazSQLTablica AS nazSQLTablicaCinj,"
                    + " cTab.sifTipTablica AS sifTipTablicaCinj,"
                    + " cTabAtr.sifTablica AS sifTablicaCinjAtr,"
                    + " cTabAtr.rbrAtrib AS rbrAtribCinjAtr,"
                    + " cTabAtr.imeSQLAtrib AS imeSQLAtribCinjAtr,"
                    + " cTabAtr.sifTipAtrib AS sifTipAtribCinjAtr,"
                    + " cTabAtr.imeAtrib AS imeAtribCinjAtr,"
                    + " dTabAtr.sifTablica AS sifTablicaDimAtr,"
                    + " dTabAtr.rbrAtrib AS rbrAtribDimAtr,"
                    + " dTabAtr.imeSQLAtrib AS imeSQLAtribDimAtr,"
                    + " dTabAtr.sifTipAtrib AS sifTipAtribDimAtr,"
                    + " dTabAtr.imeAtrib AS imeAtribDimAtr"
                    + " FROM tabAtribut AS tabA, dimCinj AS dc, tablica AS dTab,"
                    + " tablica AS cTab, tabAtribut AS cTabAtr, tabAtribut AS dTabATr"
                    + " WHERE dc.sifCinjTablica = #{ID}"
                    + " AND tabA.sifTipAtrib = 2"
                    + " AND dc.sifDimTablica = dTab.sifTablica"
                    + " AND dc.sifCinjTablica = cTab.sifTablica"
                    + " AND dc.sifCinjTablica = cTabAtr.sifTablica"
                    + " AND dc.rbrCinj = cTabAtr.rbrAtrib"
                    + " AND dc.sifDimTablica = dTabAtr.sifTablica"
                    + " AND dc.rbrDim = dTabAtr.rbrAtrib"
                    + " AND tabA.sifTablica = dc.sifDimTablica"
                    + " ORDER BY dTab.nazTablica, tabA.rbrAtrib";

    @Select(SELECT_DIMENZIJE) public List<DimenzijeSQL> getDimenzije(Integer ID);

}
