package github.thyagofr.ifood.infrastructure.database.delivery;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import github.thyagofr.ifood.domain.entity.DeliveryEntity;

@Repository
public interface SpringDataIDeliveryRepository extends JpaRepository<DeliveryEntity,Long>{
    
    Page<DeliveryEntity> findAllByClientId(Long clientID, Pageable pageable);

}
