package github.thyagofr.ifood.api.assembler;

import github.thyagofr.ifood.api.dto.ReceiverDTO;
import github.thyagofr.ifood.domain.entity.Receiver;

public final class ReceiverAssembler {

    public static Receiver toEntity(ReceiverDTO dto) {
        Receiver entity = new Receiver();
        entity.setNumber(dto.getNumber());
        entity.setNeighborhood(dto.getNeighborhood());
        entity.setName(dto.getName());
        entity.setComplement(dto.getComplement());
        entity.setPublicPlace(dto.getPublicPlace());
        return entity;
    }

    public static ReceiverDTO toDTO(Receiver entity) {
        ReceiverDTO dto = new ReceiverDTO();
        dto.setNumber(entity.getNumber());
        dto.setNeighborhood(entity.getNeighborhood());
        dto.setName(entity.getName());
        dto.setComplement(entity.getComplement());
        dto.setPublicPlace(entity.getPublicPlace());
        return dto;
    }
    
}
