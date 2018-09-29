package com.capgemini.serviciosya.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 *
 *  <p>The class <code>com.capgemini.serviciosya.rest.Application<code/>
 *  main class of initiation of the application in Spring-Boot
 *
 *
 * */
@SpringBootApplication
public class Application {

    /**
     *
     *
     * <p>Constructor without arguments
     */
    public Application () {

        // Call to super class.
        super ();
    }

    /**
     *
     * @Method main
     */
    public static void main (String[] args) {

        SpringApplication.run (Application.class, args);
    }
}
