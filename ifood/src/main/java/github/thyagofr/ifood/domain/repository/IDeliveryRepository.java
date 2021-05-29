package github.thyagofr.ifood.domain.repository;

import github.thyagofr.ifood.domain.entity.DeliveryEntity;
import github.thyagofr.ifood.domain.entity.Pagination;

import java.util.Optional;

public interface IDeliveryRepository {

    Optional<DeliveryEntity> findByID(Long ID);

    void removeByID(Long ID);

    DeliveryEntity save(DeliveryEntity delivery);

    Pagination findAllByClientID(Integer page, Integer pageSize,Long clientID);

    Pagination findAll(Integer page, Integer pageSize);
    
}
