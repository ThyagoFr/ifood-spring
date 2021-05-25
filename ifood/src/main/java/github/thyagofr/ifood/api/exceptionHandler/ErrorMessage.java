package github.thyagofr.ifood.api.exceptionHandler;

import java.io.Serializable;
import java.time.OffsetDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(Include.NON_NULL)
public class ErrorMessage implements Serializable{

    private String path;

    private String message;

    private OffsetDateTime timeStamp;

    private List<Field> fields;

    @Getter
    @Setter
    @AllArgsConstructor
    public static class Field {
        
        private String name;

        private String message;

    }
    
}
