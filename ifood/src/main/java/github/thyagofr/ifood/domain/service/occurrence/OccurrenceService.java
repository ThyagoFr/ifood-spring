package github.thyagofr.ifood.domain.service.occurrence;

import github.thyagofr.ifood.domain.entity.DeliveryEntity;
import github.thyagofr.ifood.domain.entity.OccurrenceEntity;
import github.thyagofr.ifood.domain.entity.Pagination;
import github.thyagofr.ifood.domain.repository.IOccurrenceRepository;
import github.thyagofr.ifood.domain.service.delivery.IDeliveryService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class OccurrenceService implements IOccurrenceService {

  private final IDeliveryService deliveryService;

  private final IOccurrenceRepository occurrenceRepository;

  @Override
  public OccurrenceEntity register(Long deliveryID, String description) {
    DeliveryEntity delivery = this.deliveryService.findByID(deliveryID);
    OccurrenceEntity occ = delivery.addOccurrence(description);
    this.deliveryService.save(delivery);
    return occ;
  }

  @Override
  public Pagination findAll(Long deliveryID,Integer page, Integer pageSize) {
    return this.occurrenceRepository.findAll(deliveryID,page,pageSize);
  }
}
