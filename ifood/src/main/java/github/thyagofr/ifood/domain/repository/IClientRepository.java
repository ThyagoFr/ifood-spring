package github.thyagofr.ifood.domain.repository;

import java.util.Optional;

import github.thyagofr.ifood.common.PaginationResponse;
import github.thyagofr.ifood.domain.entity.ClientEntity;

public interface IClientRepository{

    Optional<ClientEntity> findByEmail(String email);

    Optional<ClientEntity> findByID(Long ID);

    void removeByID(Long ID);

    ClientEntity save(ClientEntity client);

    PaginationResponse findAll(Integer page, Integer pageSize);
    
}
