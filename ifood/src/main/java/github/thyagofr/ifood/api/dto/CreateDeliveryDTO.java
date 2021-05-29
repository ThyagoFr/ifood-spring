package github.thyagofr.ifood.api.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
public class CreateDeliveryDTO implements Serializable {
    
    @NotNull
    private Long clientId;

    private ReceiverDTO receiver;

    private BigDecimal fee;

}
