package github.thyagofr.ifood.infrastructure.database.client;

import github.thyagofr.ifood.domain.entity.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SpringDataIClientRepository extends JpaRepository<ClientEntity,Long>{

    Optional<ClientEntity> findByEmail(String email);
    
}
