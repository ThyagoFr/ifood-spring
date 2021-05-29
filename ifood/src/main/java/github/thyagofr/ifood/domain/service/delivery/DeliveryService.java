package github.thyagofr.ifood.domain.service.delivery;

import github.thyagofr.ifood.domain.entity.ClientEntity;
import github.thyagofr.ifood.domain.entity.DeliveryEntity;
import github.thyagofr.ifood.domain.entity.Pagination;
import github.thyagofr.ifood.domain.enums.DeliveryStatus;
import github.thyagofr.ifood.domain.exceptions.NotFoundException;
import github.thyagofr.ifood.domain.service.client.IClientService;
import github.thyagofr.ifood.infrastructure.database.delivery.DeliveryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;

@Service
@AllArgsConstructor
public class DeliveryService implements IDeliveryService{

    private final DeliveryRepository deliveryRepository;

    private final IClientService clientService;

    @Override
    public DeliveryEntity save(DeliveryEntity delivery) {
        Long clientID = delivery.getClient().getId();
        ClientEntity client = this.clientService.findByID(clientID);
        delivery.setClient(client);
        delivery.setDateOrder(OffsetDateTime.now());
        delivery.setStatus(DeliveryStatus.PENDING);
        return this.deliveryRepository.save(delivery);
    }

    @Override
    public DeliveryEntity findByID(Long deliveryID) {
        return this.deliveryRepository.findByID(deliveryID)
                                      .orElseThrow(() -> new NotFoundException(String.format("entrega com ID %s nao encontrada", deliveryID)));
    }

    @Override
    public Pagination findAll(Integer page, Integer pageSize) {
        return this.deliveryRepository.findAll(page, pageSize);
    }
    
}
