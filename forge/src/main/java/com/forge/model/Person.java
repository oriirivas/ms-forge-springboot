package com.forge.model;

import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity // persistir en la base de datos
@Table(name = "Person") //aqui se crea un a table// esto va en una tabla porque va a la base de datos por ende lo primero es crear es una tabla y le asignamos su nombre
public class Person {

    @Id
    @Column(name = "id_person") //crea y da nombre  a la columa
    @GeneratedValue(strategy = GenerationType.IDENTITY) //genera un valor autoincrementable
    private Long id;

    @Column(name = "nombre")
    @NotNull
    private String nombre;

    @Column(name = "apellido")
    @NotNull
    private String apellido;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
}
