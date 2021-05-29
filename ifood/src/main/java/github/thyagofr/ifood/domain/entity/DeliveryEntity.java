package github.thyagofr.ifood.domain.entity;

import github.thyagofr.ifood.domain.enums.DeliveryStatus;
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
    private List<OccurrenceEntity> occurences = new ArrayList<>();

    private BigDecimal fee;

    @Enumerated(EnumType.STRING)
    private DeliveryStatus status;

    private OffsetDateTime dateOrder;

    private OffsetDateTime dateCompletion;
    
}
