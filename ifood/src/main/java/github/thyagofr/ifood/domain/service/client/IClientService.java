package github.thyagofr.ifood.domain.service.client;

import github.thyagofr.ifood.common.PaginationResponse;
import github.thyagofr.ifood.domain.entity.ClientEntity;

public interface IClientService {

    ClientEntity create(ClientEntity client);

    ClientEntity update(Long id, ClientEntity client);

    PaginationResponse findAll(Integer page, Integer pageSize);

    ClientEntity findByID(Long id);

    void remove(Long id);
        
}
