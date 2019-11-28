package com.forge.repository;

import com.forge.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IPersonRepository extends JpaRepository<Person,Long> {
    /**
     * JPA (java persistence api) esto transforma objetos para ser usados directamente en la base de datos
     *
     * propetirs dan la propiedades de conexcion puede ser a una base de datos o a otras cosas
     *
     * esta interfaz es para hacer la conexcion con base de datos
     *
     * y aqui es donde coloco el crudRepository o el JpaRepository dentro de ellas estan un monton de operaciones
     * como guardar actualizar
     * **/



    List<Person> findByNombre(String nombre);
}
