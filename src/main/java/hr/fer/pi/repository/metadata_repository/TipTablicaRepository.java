package hr.fer.pi.repository.metadata_repository;

import hr.fer.pi.model.entity.TipTablica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Igor Farszky on 1.12.2017..
 */
@Transactional
public interface TipTablicaRepository extends JpaRepository<TipTablica, Integer>{
}
