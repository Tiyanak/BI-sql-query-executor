package hr.fer.pi.repository.metadata_repository;

import hr.fer.pi.model.entity.Tablica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Igor Farszky on 1.12.2017..
 */
@Transactional
public interface TablicaRepository extends JpaRepository<Tablica, Integer> {

    List<Tablica> findBySifTipTablica(Integer siftiptablica);

    Tablica findBySifTablica(Integer sif);
}
