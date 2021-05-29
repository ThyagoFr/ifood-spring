package github.thyagofr.ifood.domain.repository;

import github.thyagofr.ifood.domain.entity.Pagination;

public interface IOccurrenceRepository {
  Pagination findAll(Long deliveryID, Integer page, Integer pageSize);
}
