package github.thyagofr.ifood.domain.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class Pagination implements Serializable{
    private Integer page;

    private Integer pageSize;

    private Integer totalPages;

    private Long totalElements;

    private List<Object> elements = new ArrayList<>();
}
