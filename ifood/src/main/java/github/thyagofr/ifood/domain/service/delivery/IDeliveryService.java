package github.thyagofr.ifood.domain.service.delivery;

import github.thyagofr.ifood.domain.entity.DeliveryEntity;
import github.thyagofr.ifood.domain.entity.Pagination;

public interface IDeliveryService {

    DeliveryEntity create (DeliveryEntity delivery);

    Pagination findAll(Integer page, Integer pageSize);
    
}
