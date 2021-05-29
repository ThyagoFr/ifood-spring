package github.thyagofr.ifood.api.assembler;

import github.thyagofr.ifood.api.dto.CreateDeliveryDTO;
import github.thyagofr.ifood.api.dto.CreatedDeliveryDTO;
import github.thyagofr.ifood.domain.entity.ClientEntity;
import github.thyagofr.ifood.domain.entity.DeliveryEntity;

public final class DeliveryAssembler {

    public static DeliveryEntity toEntity(CreateDeliveryDTO dto) {
        DeliveryEntity entity = new DeliveryEntity();
        entity.setFee(dto.getFee());
        entity.setClient(new ClientEntity());
        entity.getClient().setId(dto.getClientId());;
        entity.setReceiver(ReceiverAssembler.toEntity(dto.getReceiver()));
        return entity;
    }
    
    public static CreatedDeliveryDTO toDTO(DeliveryEntity entity) {
        CreatedDeliveryDTO dto = new CreatedDeliveryDTO();
        dto.setDateCompletion(entity.getDateCompletion());
        dto.setDateOrder(entity.getDateOrder());
        dto.setFee(entity.getFee());
        dto.setNameClient(entity.getClient().getName());
        dto.setStatus(entity.getStatus());
        dto.setReceiver(ReceiverAssembler.toDTO(entity.getReceiver()));
        return dto;
    }
}
