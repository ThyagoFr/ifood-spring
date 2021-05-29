package github.thyagofr.ifood.domain.service.client;

import github.thyagofr.ifood.domain.entity.ClientEntity;
import github.thyagofr.ifood.domain.exceptions.ConflictException;
import github.thyagofr.ifood.domain.exceptions.NotFoundException;
import github.thyagofr.ifood.domain.repository.IClientRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class IClientServiceTest {

    private final IClientRepository clientRepository = Mockito.mock(IClientRepository.class);

    @InjectMocks
    private final IClientService clientService = new ClientService(clientRepository);

    @DisplayName("Should fail - Email already used")
    @Test
    void shouldFailEmailAlreadyUsed() {
        String email = "thyagofr@alu.ufc.br";
        Mockito.when(this.clientRepository.findByEmail(email)).thenReturn(Optional.of(new ClientEntity()));
        ClientEntity client = new ClientEntity();
        client.setEmail(email);
        Assertions.assertThrows(ConflictException.class, () -> this.clientService.create(client));
    }
    
    @DisplayName("Should fail - Client not found")
    @Test
    void shouldFailClientNotFound() {
        Long ID = 1L;
        Mockito.when(this.clientRepository.findByID(ID)).thenReturn(Optional.empty());
        Long fakeID = 2L;
        Assertions.assertThrows(NotFoundException.class, () -> this.clientService.findByID(fakeID));
    }

    @DisplayName("Should fail - Can't remove client not found")
    @Test
    void shouldFailRemoveClientNotFound() {
        Long ID = 1L;
        Mockito.when(this.clientRepository.findByID(ID)).thenReturn(Optional.empty());
        Long fakeID = 2L;
        Assertions.assertThrows(NotFoundException.class, () -> this.clientService.remove(fakeID));
    }
}
