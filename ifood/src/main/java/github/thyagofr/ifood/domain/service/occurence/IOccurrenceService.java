package github.thyagofr.ifood.domain.service.occurence;

import github.thyagofr.ifood.domain.entity.OccurrenceEntity;

public interface IOccurrenceService {
  OccurrenceEntity register(Long deliveryID, String description);
}
