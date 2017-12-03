package hr.fer.pi.repository.metadata_repository;

import hr.fer.pi.model.embedded.DimCinjId;
import hr.fer.pi.model.entity.DimCinj;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Igor Farszky on 1.12.2017..
 */
@Transactional
public interface DimCinjRepository extends JpaRepository<DimCinj, Integer> {

    @Query("SELECT dc FROM DimCinj dc WHERE dc.dimCinjId.sifCinjTablica = ?1 AND dc.dimCinjId.sifDimTablica = ?2")
    List<DimCinj> findBySifCinjTablicaAndSifDimTablica(Integer sifCinjTablica, Integer sifDimTablica);

}
