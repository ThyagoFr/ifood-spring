package github.thyagofr.ifood.api.resource;

import github.thyagofr.ifood.api.assembler.OccurrenceAssembler;
import github.thyagofr.ifood.api.dto.CreateOccurrenceDTO;
import github.thyagofr.ifood.api.dto.CreatedOccurrenceDTO;
import github.thyagofr.ifood.domain.entity.OccurrenceEntity;
import github.thyagofr.ifood.domain.entity.Pagination;
import github.thyagofr.ifood.domain.service.occurrence.IOccurrenceService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/deliveries/{id}/occurrences")
public class OccurrenceResource {

  private final IOccurrenceService occurrenceService;

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public CreatedOccurrenceDTO register(@PathVariable("id") Long id, @Valid @RequestBody CreateOccurrenceDTO body) {
    OccurrenceEntity entity = this.occurrenceService.register(id, body.getDescription());
    return OccurrenceAssembler.toDTO(entity);
  }

  @GetMapping
  @ResponseStatus(HttpStatus.OK)
  public Pagination findAllByDeliveryID(
      @PathVariable("id") Long id,
      @RequestParam(defaultValue = "10", name = "pageSize") Integer pageSize,
      @RequestParam(defaultValue = "0", name = "page") Integer page
  ) {
    Pagination response = this.occurrenceService.findAll(id,page,pageSize);
    List<Object> elements = response.getElements();
    response.getElements().clear();
    elements.forEach(e -> response.getElements().add(OccurrenceAssembler.toDTO((OccurrenceEntity) e)));
    return response;
  }


}
