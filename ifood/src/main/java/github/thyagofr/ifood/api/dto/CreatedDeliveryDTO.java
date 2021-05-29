package github.thyagofr.ifood.api.dto;

import github.thyagofr.ifood.domain.enums.DeliveryStatus;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Getter
@Setter
@NoArgsConstructor
public class CreatedDeliveryDTO implements Serializable{

    private String nameClient;
    private ReceiverDTO receiver;
    private BigDecimal fee;
    private DeliveryStatus status;
    private OffsetDateTime dateOrder;
    private OffsetDateTime dateCompletion;

}
