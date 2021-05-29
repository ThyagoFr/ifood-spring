package github.thyagofr.ifood.domain.service.delivery;

import github.thyagofr.ifood.domain.entity.ClientEntity;
import github.thyagofr.ifood.domain.entity.DeliveryEntity;
import github.thyagofr.ifood.domain.entity.Pagination;
import github.thyagofr.ifood.domain.enums.DeliveryStatus;
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
    public DeliveryEntity create(DeliveryEntity delivery) {
        Long clientID = delivery.getClient().getId();
        ClientEntity client = this.clientService.findByID(clientID);
        delivery.setClient(client);
        delivery.setDateOrder(OffsetDateTime.now());
        delivery.setStatus(DeliveryStatus.PENDING);
        return this.deliveryRepository.save(delivery);
    }

    @Override
    public Pagination findAll(Integer page, Integer pageSize) {
        return this.deliveryRepository.findAll(page, pageSize);
    }
    
}
