package github.thyagofr.ifood.api.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.OffsetDateTime;

@Getter
@Setter
public class CreatedOccurrenceDTO implements Serializable {
  private Long id;
  private String description;
  private OffsetDateTime dateRegister;
}
