package com.capgemini.serviciosya.rest.controller;

import com.capgemini.serviciosya.beans.entity.CityEntity;
import com.capgemini.serviciosya.repository.ICityRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 *
 *  <p>The class <code>com.capgemini.serviciosya.rest.controller.CityController<code/>
 *  is controller object for the management of messages HTTP.
 *
 *
 * */
@RestController
@RequestMapping("cities")
public class CityController {

    @Autowired
    private ICityRepository cityRepository;

    public CityController() {
        super();
    }

    /**
     *
     *  <p>Return a JSON file with all the Cities of the database.
     *
     *  @Method GET
     *  @return Return the Cities.
     * */
    @RequestMapping(method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> get() {
        return ResponseEntity.ok(this.cityRepository.findAll());
    }

    /**
     *
     *  <p>Return a JSON file with a city of the database.
     *
     *  @Method GET
     *  @return Return a city by id.
     * */
    @RequestMapping(value = "{id}", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> get(@PathVariable("id") Integer id) {

        CityEntity city = this.cityRepository.findOne(id);
        if (city == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(this.cityRepository.findOne(id));
        }

    }

    /**
     *
     *  <p>Add a city to database.
     *
     *  @Method POST
     * */
    @RequestMapping(method = RequestMethod.POST, consumes={ MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public ResponseEntity<?> add (@RequestBody CityEntity city){

        try {
            CityEntity c = new CityEntity();
            c.setName(city.getName());
            c.setProvince(city.getProvince());

            this.cityRepository.save(c);
        } catch ( Exception e){
            return ResponseEntity.badRequest().build();
        }

        return  ResponseEntity.noContent().build();
    }

    /**
     *
     *  <p>Update a city to database.
     *
     *  @Method PUT
     * */
    @RequestMapping(value = {"id"}, method = RequestMethod.PUT, consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public ResponseEntity<?> update (@RequestBody CityEntity city, @PathVariable("id") int id) {

        try {

            CityEntity c = new CityEntity();
            c.setId(id);
            c.setName(city.getName());
            city.setProvince(city.getProvince());

            this.cityRepository.save(c);

        } catch (Exception e) {

            return ResponseEntity.unprocessableEntity().build();
        }

        return ResponseEntity.noContent().build();

    }

    /**
     *
     *  <p>Delete a city to database.
     *
     *  @Method DELETE
     * */
    @RequestMapping (value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> delete (@PathVariable ("id") int id) {

        this.cityRepository.delete(id);

        return ResponseEntity.noContent ().build ();
    }
 }

