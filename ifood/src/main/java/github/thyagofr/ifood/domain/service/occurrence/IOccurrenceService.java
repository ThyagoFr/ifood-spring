package github.thyagofr.ifood.domain.service.occurrence;

import github.thyagofr.ifood.domain.entity.OccurrenceEntity;
import github.thyagofr.ifood.domain.entity.Pagination;

public interface IOccurrenceService {
  OccurrenceEntity register(Long deliveryID, String description);
  Pagination findAll(Long deliveryID,Integer page, Integer pageSize);
}
