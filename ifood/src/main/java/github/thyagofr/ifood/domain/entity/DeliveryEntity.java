package github.thyagofr.ifood.domain.entity;

import github.thyagofr.ifood.domain.enums.DeliveryStatus;
import github.thyagofr.ifood.domain.exceptions.BadRequestException;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "deliveries")
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@AllArgsConstructor
@NoArgsConstructor
public class DeliveryEntity implements Serializable{

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private ClientEntity client;

    @Embedded
    private Receiver receiver;

    @OneToMany(mappedBy = "delivery")
    private List<OccurrenceEntity> occurrences = new ArrayList<>();

    private BigDecimal fee;

    @Enumerated(EnumType.STRING)
    private DeliveryStatus status;

    private OffsetDateTime dateOrder;

    private OffsetDateTime dateCompletion;

    public OccurrenceEntity addOccurrence(String description) {
        OccurrenceEntity occurrence = new OccurrenceEntity();
        occurrence.setDateRegister(OffsetDateTime.now());
        occurrence.setDescription(description);
        occurrence.setDelivery(this);
        this.getOccurrences().add(occurrence);
        return  occurrence;
    }

    public void finish() {
        if (!this.canBeFinished()) {
            throw new BadRequestException(String.format("entrega com ID %d nao pode ser finalizada", this.getId()));
        }
        this.setStatus(DeliveryStatus.FINISHED);
        this.setDateCompletion(OffsetDateTime.now());
    }

    private boolean canBeFinished() {
        return this.getStatus().equals(DeliveryStatus.PENDING);
    }
    
}
