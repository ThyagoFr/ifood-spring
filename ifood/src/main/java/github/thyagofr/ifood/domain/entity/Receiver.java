package github.thyagofr.ifood.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class Receiver implements Serializable{

    @Column(name = "receiver_name")
    private String name;

    @Column(name = "receiver_public_place")
    private String publicPlace;

    @Column(name = "receiver_number")
    private String number;

    @Column(name = "receiver_complement")
    private String complement;

    @Column(name = "receiver_neighborhood")
    private String neighborhood;
    
}
