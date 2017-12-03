package hr.fer.pi.repository.metadata_repository;

import hr.fer.pi.model.entity.TabAtribut;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Igor Farszky on 1.12.2017..
 */
@Transactional
public interface TabAtributRepository extends JpaRepository<TabAtribut, Integer> {

    @Query("SELECT tabA FROM TabAtribut tabA WHERE tabA.tabAtributId.sifTablica = ?1 AND tabA.tabAtributId.rbrAtrib = ?2")
    TabAtribut findBySifTablicaAndRbrAtrib(Integer sifTablica, Integer rbrAtrib);

}
