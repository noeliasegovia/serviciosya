package com.capgemini.serviciosya.rest.controller;

import com.capgemini.serviciosya.beans.entity.ProviderEntity;
import com.capgemini.serviciosya.repository.IProviderRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("providers")
public class ProviderController {

    private IProviderRepository providerRepository;

    public ProviderController(){
        super();
    }

    /**
     *
     *  <p>Return a JSON file with all the providers of the database.
     *
     *  @Method GET
     *  @return Return the providers.
     * */
    @RequestMapping(method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> get() {
        return ResponseEntity.ok(this.providerRepository.findAll());
    }

/*
    */
/**
     *
     *  <p>Return a JSON file with a provider of the database.
     *
     *  @Method GET
     *  @return Return a provider by id.
     * *//*

    @RequestMapping(value = "{id}", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> get(@PathVariable("id") Integer id) {

        ProviderEntity provider = this.providerRepository.findOne(id);
        if (provider == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(this.providerRepository.findOne(id));
        }

    }

    */
/**
     *
     *  <p>Add a provider to database.
     *
     *  @Method POST
     * *//*

    @RequestMapping(method = RequestMethod.POST, consumes={ MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public ResponseEntity<?> add (@RequestBody ProviderEntity provider){

        try {
            ProviderEntity p = new ProviderEntity();
            p.setName(provider.getName());
            p.setLastName(provider.getLastName());
            p.setDni(provider.getDni());
            p.setEmail(provider.getEmail());
            p.setPhone(provider.getPhone());
            p.setAddress(provider.getAddress());
            p.setCity(provider.getCity());
            p.setStatus(provider.getStatus());

            this.providerRepository.save(p);

        } catch ( Exception e){
            return ResponseEntity.badRequest().build();
        }
        return  ResponseEntity.noContent().build();
    }

    */
/**
     *
     *  <p>Update a client to database.
     *
     *  @Method PUT
     * *//*

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public ResponseEntity<?> update (@RequestBody ProviderEntity provider, @PathVariable("id") int id) {

        try {

            ProviderEntity p = new ProviderEntity();
            p.setId(id);
            p.setName(provider.getName());
            p.setLastName(provider.getLastName());
            p.setDni(provider.getDni());
            p.setEmail(provider.getEmail());
            p.setPhone(provider.getPhone());
            p.setCity(provider.getCity());
            p.setAddress(provider.getAddress());
            p.setStatus(provider.getStatus());

            this.providerRepository.save(p);

        } catch (Exception e) {

            return ResponseEntity.unprocessableEntity().build();
        }

        return ResponseEntity.noContent().build();
    }

    */
/**
     *
     *  <p>Delete a client to database.
     *
     *  @Method DELETE
     * *//*

    @RequestMapping (value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> delete (@PathVariable ("id") int id) {

        this.providerRepository.delete(id);

        return ResponseEntity.noContent ().build ();
    }

*/

}
