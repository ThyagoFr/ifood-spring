package github.thyagofr.ifood.api.assembler;

import github.thyagofr.ifood.api.dto.CreateClientDTO;
import github.thyagofr.ifood.domain.entity.ClientEntity;

public final class ClientAssember {

    public static ClientEntity toEntity(CreateClientDTO dto) {
        ClientEntity client = new ClientEntity();
        client.setEmail(dto.getEmail());
        client.setName(dto.getName());
        client.setPhone(dto.getPhone());
        return client;
    }
    
}
