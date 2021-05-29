package github.thyagofr.ifood.domain.repository;

import github.thyagofr.ifood.domain.entity.ClientEntity;
import github.thyagofr.ifood.domain.entity.Pagination;

import java.util.Optional;

public interface IClientRepository{

    Optional<ClientEntity> findByEmail(String email);

    Optional<ClientEntity> findByID(Long ID);

    void removeByID(Long ID);

    ClientEntity save(ClientEntity client);

    Pagination findAll(Integer page, Integer pageSize);
    
}
