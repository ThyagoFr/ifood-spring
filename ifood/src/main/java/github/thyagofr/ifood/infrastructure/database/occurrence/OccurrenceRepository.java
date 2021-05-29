package github.thyagofr.ifood.infrastructure.database.occurrence;

import github.thyagofr.ifood.domain.entity.OccurrenceEntity;
import github.thyagofr.ifood.domain.entity.Pagination;
import github.thyagofr.ifood.domain.repository.IOccurrenceRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class OccurrenceRepository implements IOccurrenceRepository {

  private final SpringDataIOccurrenceRepository occurrenceRepository;


  private Pagination setPagination(Integer page, Page<OccurrenceEntity> dbPage) {
    Pagination response = new Pagination();
    dbPage.getContent().forEach(c -> response.getElements().add(c));
    response.setPage(page);
    response.setPageSize(response.getElements().size());
    response.setTotalPages(dbPage.getTotalPages());
    response.setTotalElements(dbPage.getTotalElements());
    return response;
  }

  @Override
  public Pagination findAll(Long deliveryID , Integer page, Integer pageSize) {
    Pageable request = PageRequest.of(page, pageSize);
    Page<OccurrenceEntity> dbPage = this.occurrenceRepository.findAllByDeliveryId(deliveryID,request);
    return setPagination(page, dbPage);
  }
}
