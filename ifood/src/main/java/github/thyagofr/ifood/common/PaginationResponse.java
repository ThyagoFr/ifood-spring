package github.thyagofr.ifood.common;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PaginationResponse implements Serializable{
    
    private Integer page;

    private Integer pageSize;

    private Integer totalPages;

    private Long totalElements;

    private List<Object> elements = new ArrayList<>();
}
