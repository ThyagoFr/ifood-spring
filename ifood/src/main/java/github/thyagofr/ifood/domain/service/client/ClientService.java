package github.thyagofr.ifood.domain.service.client;

import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import github.thyagofr.ifood.common.PaginationResponse;
import github.thyagofr.ifood.domain.entity.ClientEntity;
import github.thyagofr.ifood.domain.exceptions.ConflictException;
import github.thyagofr.ifood.domain.exceptions.NotFoundException;
import github.thyagofr.ifood.domain.repository.IClientRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ClientService implements IClientService{

    private IClientRepository clientRepository;

    @Override
    public ClientEntity findByID(Long id) {
        return this.clientRepository.findByID(id)
                                    .orElseThrow(() -> new NotFoundException(String.format("cliente com id %d não encontrado", id)));
    }

    @Override
    @Transactional
    public void remove(Long id) {
        this.clientRepository.findByID(id)
                             .orElseThrow(() -> new NotFoundException(String.format("cliente com id %d não encontrado", id)));
        this.clientRepository.removeByID(id);
    }

    @Override
    @Transactional
    public ClientEntity create(ClientEntity client) {
        if (this.clientRepository.findByEmail(client.getEmail()).isPresent()) {
            throw new ConflictException(String.format("email %s ja utilizado", client.getEmail()));
        }
        return this.clientRepository.save(client);
    }

    @Override
    @Transactional
    public ClientEntity update(Long id, ClientEntity client) {
        ClientEntity oldClient = this.clientRepository.findByID(id)
                                                      .orElseThrow( () -> new NotFoundException(String.format("cliente com id %d não encontrado", id)));
        Optional<ClientEntity> clientWithSameEmail = this.clientRepository.findByEmail(client.getEmail());
        if (clientWithSameEmail.isPresent() && clientWithSameEmail.get().getId() != id) {
            throw new ConflictException(String.format("email %s ja utilizado", client.getEmail()));
        }
        oldClient.setEmail(client.getEmail());
        oldClient.setName(client.getName());
        oldClient.setPhone(client.getPhone());
        return this.clientRepository.save(oldClient);
    }

    @Override
    public PaginationResponse findAll(Integer page, Integer pageSize) {
        return this.clientRepository.findAll(page, pageSize);
    }
    
}
