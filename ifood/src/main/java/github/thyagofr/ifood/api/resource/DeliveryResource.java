package github.thyagofr.ifood.api.resource;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import github.thyagofr.ifood.domain.entity.DeliveryEntity;
import github.thyagofr.ifood.domain.service.delivery.IDeliveryService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping(
    path = "/deliveries"
    )
public class DeliveryResource {

    private final IDeliveryService deliveryService;

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public DeliveryEntity create(@Valid @RequestBody DeliveryEntity delivery) {
        return this.deliveryService.create(delivery);
    }
    
}
