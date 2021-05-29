package github.thyagofr.ifood.infrastructure.database.client;

import github.thyagofr.ifood.domain.entity.ClientEntity;
import github.thyagofr.ifood.domain.entity.Pagination;
import github.thyagofr.ifood.domain.repository.IClientRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.Optional;

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
    public Pagination findAll(Integer page, Integer pageSize) {
        Pageable request = PageRequest.of(page, pageSize);
        Page<ClientEntity> dbResult = this.clientRepository.findAll(request);
        Pagination response = new Pagination();
        dbResult.getContent().forEach(e -> response.getElements().add(e));
        response.setPage(page);
        response.setPageSize(response.getElements().size());
        response.setTotalPages(dbResult.getTotalPages());
        response.setTotalElements(dbResult.getTotalElements());
        return response;
    }
    
}
