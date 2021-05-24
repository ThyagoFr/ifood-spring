package github.thyagofr.ifood.infrastructure.database.client;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import github.thyagofr.ifood.common.PaginationResponse;
import github.thyagofr.ifood.domain.entity.ClientEntity;
import github.thyagofr.ifood.domain.repository.IClientRepository;
import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class ClientRepository implements IClientRepository{

    private final SpringDataIClientRepository clientRepository;

    @Override
    public Optional<ClientEntity> findByEmail(String email) {
        return this.clientRepository.findByEmail(email);
    }

    @Override
    public Optional<ClientEntity> findByID(Long ID) {
        return this.clientRepository.findById(ID);
    }

    @Override
    public void removeByID(Long ID) {
        this.clientRepository.deleteById(ID);
        
    }

    @Override
    public ClientEntity save(ClientEntity client) {
        return this.clientRepository.save(client);
    }

    @Override
    public PaginationResponse findAll(Integer page, Integer pageSize) {
        Pageable request = PageRequest.of(page, pageSize);
        Page<ClientEntity> dbPage = this.clientRepository.findAll(request);
        PaginationResponse response = new PaginationResponse();
        dbPage.getContent().forEach(c -> response.getElements().add(c));
        response.setPage(page);
        response.setPageSize(pageSize);
        response.setTotalPages(dbPage.getTotalPages());
        response.setTotalElements(dbPage.getTotalElements());
        return response;
    }
    
}
