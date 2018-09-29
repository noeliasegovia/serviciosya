package com.capgemini.serviciosya.rest.controller;

import com.capgemini.serviciosya.beans.entity.CountryEntity;
import com.capgemini.serviciosya.repository.ICountryRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 *
 *  <p>The class <code>com.capgemini.serviciosya.rest.controller.CountryController<code/>
 *  is controller object for the management of messages HTTP.
 *
 *
 * */
@RestController
@RequestMapping ("countries")
public class CountryController {

    @Autowired
    private ICountryRepository countryRepository;

    /**
     *
     *
     * <p>Constructor without arguments
     */
    public CountryController() {

        // Call to super class.
        super ();
    }

    /**
     *
     *  <p>Return a JSON file with all the countries of the database.
     *
     *  @Method GET
     *  @return Return the countries.
     * */
    @RequestMapping (method = RequestMethod.GET, produces={MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> get () {

        // Return the value.
        return ResponseEntity.ok (this.countryRepository.findAll());
    }

    /**
     *
     *  <p>Return a JSON file with a country of the database.
     *
     *  @Method GET
     *  @return Return a country by id.
     * */
    @RequestMapping (value = "/{id}", method = RequestMethod.GET, produces={MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> get (@PathVariable("id") Integer id) {


        CountryEntity country = this.countryRepository.findOne (id);

        if (country == null) {

            return ResponseEntity.notFound().build();

        } else {

            return ResponseEntity.ok (this.countryRepository.findOne (id));
        }
    }

    /**
     *
     *  <p>Add a country to database.
     *
     *  @Method POST
     * */
    @RequestMapping (method = RequestMethod.POST, consumes={MediaType.APPLICATION_JSON_VALUE},
            produces={MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public ResponseEntity<?> save (@RequestBody Map<String, Object> data) {

        try {

            CountryEntity country = new CountryEntity();
            country.setName ((String)data.get ("name"));

            this.countryRepository.save (country);

        } catch (Exception e) {

            return ResponseEntity.badRequest ().build ();
        }

        return ResponseEntity.noContent().build ();
    }

    /**
     *
     *  <p>Update a country to database.
     *
     *  @Method PUT
     * */
    @RequestMapping (value="/{id}", method = RequestMethod.PUT, consumes={MediaType.APPLICATION_JSON_VALUE},
            produces={MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public ResponseEntity<?> save (@RequestBody Map<String, Object> data, @PathVariable ("id") int id) {

        try {

            CountryEntity country = new CountryEntity();
            country.setId (id);
            country.setName ((String)data.get ("name"));

            this.countryRepository.save (country);

        } catch (Exception e) {

            return ResponseEntity.unprocessableEntity().build ();
        }

        return ResponseEntity.noContent().build ();
    }

    /**
     *
     *  <p>Delete a country to database.
     *
     *  @Method DELETE
     * */
    @RequestMapping (value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> delete (@PathVariable ("id") int id) {

        this.countryRepository.delete (id);

        return ResponseEntity.noContent ().build ();
    }
}

