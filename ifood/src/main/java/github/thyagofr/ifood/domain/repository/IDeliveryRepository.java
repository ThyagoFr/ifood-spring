package github.thyagofr.ifood.domain.repository;

import github.thyagofr.ifood.domain.entity.DeliveryEntity;
import github.thyagofr.ifood.domain.entity.Pagination;

import java.util.Optional;

public interface IDeliveryRepository {
    Optional<DeliveryEntity> findByID(Long ID);
    DeliveryEntity save(DeliveryEntity delivery);
    Pagination findAll(Integer page, Integer pageSize);
}
