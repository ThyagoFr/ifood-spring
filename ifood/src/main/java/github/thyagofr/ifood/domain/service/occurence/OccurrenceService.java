package github.thyagofr.ifood.domain.service.occurence;

import github.thyagofr.ifood.domain.entity.DeliveryEntity;
import github.thyagofr.ifood.domain.entity.OccurrenceEntity;
import github.thyagofr.ifood.domain.service.delivery.IDeliveryService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class OccurrenceService implements IOccurrenceService {

  private final IDeliveryService deliveryService;

  @Override
  public OccurrenceEntity register(Long deliveryID, String description) {
    DeliveryEntity delivery = this.deliveryService.findByID(deliveryID);
    OccurrenceEntity occ = delivery.addOccurrence(description);
    this.deliveryService.save(delivery);
    return occ;
  }
}
