package github.thyagofr.ifood.api.resource;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import github.thyagofr.ifood.common.PaginationResponse;
import github.thyagofr.ifood.domain.entity.ClientEntity;
import github.thyagofr.ifood.domain.service.client.IClientService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping(
    path = "/clients"
    )
public class ClientResource {

    private IClientService clientService;

    @GetMapping(produces = "application/json")
    @ResponseStatus(code = HttpStatus.OK)
    public PaginationResponse findAll(
        @RequestParam(defaultValue = "10", name = "pageSize") Integer pageSize, 
        @RequestParam(defaultValue = "0", name = "page") Integer page) {
        return this.clientService.findAll(page,pageSize);
    } 

    @GetMapping(
        path = "/{id}", 
        produces = "application/json"
        )
    @ResponseStatus(code = HttpStatus.OK)
    public ClientEntity findByID(@PathVariable("id") Long id) {
        return this.clientService.findByID(id);
    } 

    @DeleteMapping(
        path = "/{id}"
        )
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void remove(@PathVariable("id") Long id) {
        this.clientService.remove(id);
    }

    @PostMapping(
        produces = "application/json",
        consumes = "application/json"
    )
    @ResponseStatus(code = HttpStatus.CREATED)
    public ClientEntity create(@Valid @RequestBody ClientEntity client) {
        return this.clientService.create(client);
    }

    @PutMapping(
        produces = "application/json",
        consumes = "application/json",
        path = "/{id}"
    )
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    public ClientEntity update(@PathVariable("id") Long id, @RequestBody ClientEntity client) {
        return this.clientService.update(id,client);
    }
    
}
