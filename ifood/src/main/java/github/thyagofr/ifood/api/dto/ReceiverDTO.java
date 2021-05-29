package github.thyagofr.ifood.api.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
public class ReceiverDTO implements Serializable{

    private String name;

    private String publicPlace;

    private String number;

    private String complement;

    private String neighborhood;

}
