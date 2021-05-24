package github.thyagofr.ifood.infrastructure.database.delivery;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import github.thyagofr.ifood.common.PaginationResponse;
import github.thyagofr.ifood.domain.entity.DeliveryEntity;
import github.thyagofr.ifood.domain.repository.IDeliveryRepository;
import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class DeliveryRepository implements IDeliveryRepository {

    private final SpringDataIDeliveryRepository deliveryRepository;

    @Override
    public Optional<DeliveryEntity> findByID(Long ID) {
        return this.deliveryRepository.findById(ID);
    }

    @Override
    public void removeByID(Long ID) {
        this.deliveryRepository.deleteById(ID);
    }

    @Override
    public DeliveryEntity save(DeliveryEntity delivery) {
        return this.deliveryRepository.save(delivery);
    }

    @Override
    public PaginationResponse findAllByClientID(Integer page, Integer pageSize, Long clientID) {
        Pageable request = PageRequest.of(page, pageSize);
        Page<DeliveryEntity> dbPage = this.deliveryRepository.findAllByClientId(clientID, request);
        PaginationResponse response = new PaginationResponse();
        dbPage.getContent().forEach(c -> response.getElements().add(c));
        response.setPage(page);
        response.setPageSize(pageSize);
        response.setTotalPages(dbPage.getTotalPages());
        response.setTotalElements(dbPage.getTotalElements());
        return response;
    }

    @Override
    public PaginationResponse findAll(Integer page, Integer pageSize) {
        Pageable request = PageRequest.of(page, pageSize);
        Page<DeliveryEntity> dbPage = this.deliveryRepository.findAll(request);
        PaginationResponse response = new PaginationResponse();
        dbPage.getContent().forEach(c -> response.getElements().add(c));
        response.setPage(page);
        response.setPageSize(pageSize);
        response.setTotalPages(dbPage.getTotalPages());
        response.setTotalElements(dbPage.getTotalElements());
        return response;
    }
    
}
