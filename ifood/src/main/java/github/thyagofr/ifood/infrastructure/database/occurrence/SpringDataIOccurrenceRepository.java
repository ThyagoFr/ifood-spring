package github.thyagofr.ifood.infrastructure.database.occurrence;

import github.thyagofr.ifood.domain.entity.OccurrenceEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpringDataIOccurrenceRepository extends JpaRepository<OccurrenceEntity,Long>{
    
    Page<OccurrenceEntity> findAllByDeliveryId(Long deliveryID, Pageable pageable);

}
