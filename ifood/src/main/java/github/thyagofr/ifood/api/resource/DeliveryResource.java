package github.thyagofr.ifood.api.resource;

import github.thyagofr.ifood.api.assembler.DeliveryAssembler;
import github.thyagofr.ifood.api.dto.CreateDeliveryDTO;
import github.thyagofr.ifood.api.dto.CreatedDeliveryDTO;
import github.thyagofr.ifood.domain.entity.DeliveryEntity;
import github.thyagofr.ifood.domain.entity.Pagination;
import github.thyagofr.ifood.domain.service.delivery.IDeliveryService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@AllArgsConstructor
@RestController
@RequestMapping(
    path = "/deliveries"
    )
public class DeliveryResource {

    private final IDeliveryService deliveryService;

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public CreatedDeliveryDTO create(@Valid @RequestBody CreateDeliveryDTO dto) {
        DeliveryEntity entity = this.deliveryService.save(DeliveryAssembler.toEntity(dto));
        return DeliveryAssembler.toDTO(entity);
    }

    @GetMapping
    @ResponseStatus(code = HttpStatus.OK)
    public Pagination findAll(
        @RequestParam(defaultValue = "10", name = "pageSize") Integer pageSize, 
        @RequestParam(defaultValue = "0", name = "page") Integer page
    ) {
        return this.deliveryService.findAll(page, pageSize);
    }
    
}
