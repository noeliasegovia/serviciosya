package com.capgemini.serviciosya.rest.controller;

import com.capgemini.serviciosya.beans.entity.ClientEntity;
import com.capgemini.serviciosya.repository.IClientRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("clients")
public class ClientController {

    @Autowired
    private IClientRepository clientRepository;

    public ClientController() {
        super();
    }

    /**
     *
     *  <p>Return a JSON file with all the clients of the database.
     *
     *  @Method GET
     *  @return Return the clients.
     * */
    @RequestMapping(method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> get() {
        return ResponseEntity.ok(this.clientRepository.findAll());
    }

    /**
     *
     *  <p>Return a JSON file with a Client of the database.
     *
     *  @Method GET
     *  @return Return a Client by id.
     * */
    @RequestMapping(value = "{id}", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> get(@PathVariable("id") Integer id) {

        ClientEntity client = this.clientRepository.findOne(id);
        if (client == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(this.clientRepository.findOne(id));
        }

    }

    /**
     *
     *  <p>Return a JSON file with a Client of the database.
     *
     *  @Method GET
     *  @return Return a Client by dni.
     * */
    @RequestMapping(value = "/dni/{dni}", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> get(@PathVariable("dni") int dni) {

        ClientEntity client = this.clientRepository.findBydni(dni);
        if (client == null) {
            return ResponseEntity.notFound().build();
        } else {
            return client;
        }

    }

    /**
     *
     *  <p>Add a client to database.
     *
     *  @Method POST
     * */
    @RequestMapping(method = RequestMethod.POST, consumes={ MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public ResponseEntity<?> add (@RequestBody ClientEntity client){

        try {
            ClientEntity c = new ClientEntity();
            c.setName(client.getName());
            c.setLastName(client.getLastName());
            c.setDni(client.getDni());
            c.setEmail(client.getEmail());
            c.setPhone(client.getPhone());
            c.setAddress(client.getAddress());
            c.setCity(client.getCity());

            this.clientRepository.save(c);

        } catch ( Exception e){
            return ResponseEntity.badRequest().build();
        }
        return  ResponseEntity.noContent().build();
    }

    /**
     *
     *  <p>Update a client to database.
     *
     *  @Method PUT
     * */
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public ResponseEntity<?> update (@RequestBody ClientEntity client, @PathVariable("id") int id) {

        try {

            ClientEntity c = new ClientEntity();
            c.setId(id);
            c.setName(client.getName());
            c.setLastName(client.getLastName());
            c.setDni(client.getDni());
            c.setEmail(client.getEmail());
            c.setPhone(client.getPhone());
            c.setCity(client.getCity());
            c.setAddress(client.getAddress());

            this.clientRepository.save(c);

        } catch (Exception e) {

            return ResponseEntity.unprocessableEntity().build();
        }

        return ResponseEntity.noContent().build();
    }

    /**
     *
     *  <p>Delete a client to database.
     *
     *  @Method DELETE
     * */
    @RequestMapping (value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> delete (@PathVariable ("id") int id) {

        this.clientRepository.delete(id);

        return ResponseEntity.noContent ().build ();
    }

}
