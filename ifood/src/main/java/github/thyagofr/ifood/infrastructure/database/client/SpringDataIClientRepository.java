package github.thyagofr.ifood.infrastructure.database.client;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import github.thyagofr.ifood.domain.entity.ClientEntity;

@Repository
public interface SpringDataIClientRepository extends JpaRepository<ClientEntity,Long>{

    Optional<ClientEntity> findByEmail(String email);
    
}
