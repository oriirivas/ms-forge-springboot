package com.forge.controller;

import com.forge.imp.PersonImp;
import com.forge.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;
/**
 * El controller comunica entre front y back y tambien en el se trabja el tipo de peticiones
 * las peticiones son get, put,post...
 * **/
@RestController // con esta anotacion estoy definiendo que esta clase es un controller

@RequestMapping(value = "/api/person") // esto es la ruta URL que voy a exponer
// api es un estandar // el value le da el valor a mi ruta, la define

public class PersonController {

    @Autowired // es como instanciar, con esto me ahorro el new
    PersonImp iPersonImp; // esto seria lo mismo a PersonImp iPersonImp = new PersonImp

    @RequestMapping(method = RequestMethod.POST) //method es el que me dice que metodo(peticion) se va a usar (post, put,get...)

    public Person saveUser(@RequestBody Person person) //@requestBody se trata del cuerpo completo, es mi path en este caso es pathvariable (creo)
            /**
             * esta el pathVariable que son los que me traen un solo dato
             * se escriben con /
             * y los queryparam me traen mas de un dato
             * se escriben con una ?
             * **/
    {
        Person personLocal = new Person(); //creo un nuevo objeto para guardar los datos que lleguen
        try{
                if(null == person.getId()){
                    personLocal = iPersonImp.save(person);//ese nuevo objeto de va a conectar con PersonImp ya que ahi esta mi logica
                //save me guarda y actualiza por eso la validacion de que tiene quqe ser null
                }
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return personLocal;
    }

    @RequestMapping(method = RequestMethod.GET) // aqui hacemos otro metodo,  pero este es para traer
    // se  utiliza la anotacion @RequestMappin para hacer referencia a esta ruta (la que se definio arriba)

    public List<Person> getUserAll(@RequestParam String nombre) //@RequestParam es un queryparam (creo que cuando son asi necesitan  parametros)
    {
        List<Person> personLocal = new ArrayList<>();//aqui voy a llamar y retornar listas, por eso creo una nueva lista
        try{
            if(null != nombre || !nombre.equals("")){
                personLocal = iPersonImp.findByNombre(nombre); //igual que el anterio esto nos conecta con implement que es donde esta la logica
            }else{
                personLocal = iPersonImp.findAll();
            }

        }catch (Exception ex){
            ex.printStackTrace();
        }
        return personLocal;
    }

}
