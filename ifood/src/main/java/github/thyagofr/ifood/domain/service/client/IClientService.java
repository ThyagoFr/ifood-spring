package github.thyagofr.ifood.domain.service.client;

import github.thyagofr.ifood.domain.entity.ClientEntity;
import github.thyagofr.ifood.domain.entity.Pagination;

public interface IClientService {

    ClientEntity create(ClientEntity client);

    ClientEntity update(Long id, ClientEntity client);

    Pagination findAll(Integer page, Integer pageSize);

    ClientEntity findByID(Long id);

    void remove(Long id);
        
}
