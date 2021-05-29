package github.thyagofr.ifood.api.assembler;

import github.thyagofr.ifood.api.dto.CreatedOccurrenceDTO;
import github.thyagofr.ifood.domain.entity.OccurrenceEntity;

public final class OccurrenceAssembler {

  public static CreatedOccurrenceDTO toDTO(OccurrenceEntity entity) {
    CreatedOccurrenceDTO dto = new CreatedOccurrenceDTO();
    dto.setDescription(entity.getDescription());
    dto.setId(entity.getId());
    dto.setDateRegister(entity.getDateRegister());
    return dto;
  }

}
