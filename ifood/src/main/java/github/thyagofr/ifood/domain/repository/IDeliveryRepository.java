package github.thyagofr.ifood.domain.repository;

import java.util.Optional;

import github.thyagofr.ifood.common.PaginationResponse;
import github.thyagofr.ifood.domain.entity.DeliveryEntity;

public interface IDeliveryRepository {

    Optional<DeliveryEntity> findByID(Long ID);

    void removeByID(Long ID);

    DeliveryEntity save(DeliveryEntity delivery);

    PaginationResponse findAllByClientID(Integer page, Integer pageSize,Long clientID);

    PaginationResponse findAll(Integer page, Integer pageSize);
    
}
