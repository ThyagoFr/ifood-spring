package github.thyagofr.ifood.api.resource;

import github.thyagofr.ifood.api.assembler.ClientAssember;
import github.thyagofr.ifood.api.dto.CreateClientDTO;
import github.thyagofr.ifood.domain.entity.ClientEntity;
import github.thyagofr.ifood.domain.entity.Pagination;
import github.thyagofr.ifood.domain.service.client.IClientService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@AllArgsConstructor
@RestController
@RequestMapping(
    path = "/clients"
    )
public class ClientResource {

    private IClientService clientService;

    @GetMapping(produces = "application/json")
    @ResponseStatus(code = HttpStatus.OK)
    public Pagination findAll(
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
    public ClientEntity create(@Valid @RequestBody CreateClientDTO client) {
        return this.clientService.create(ClientAssember.toEntity(client));
    }

    @PutMapping(
        produces = "application/json",
        consumes = "application/json",
        path = "/{id}"
    )
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    public ClientEntity update(@PathVariable("id") Long id, @RequestBody CreateClientDTO client) {
        return this.clientService.update(id,ClientAssember.toEntity(client));
    }
    
}
