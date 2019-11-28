package com.forge.service;

import com.forge.model.Person;

import java.util.List;

public interface IPersonService {
    /**
     * Aqui se crea la interfaz de mi servicio ( de mi codigo)
     * la cual se va a implementar en el implement
     *
    **/
    Person save(Person person);
    List<Person> findAll();
    List<Person> findByNombre(String nombre);

}
