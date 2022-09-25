package com.project.api.controlador;

import com.project.api.model.Person;
import com.project.api.repository.Respositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// Rutas
@RestController
public class Controlador {

    @Autowired
    private Respositorio action;
    
    @PostMapping("/api")
    public Person cadastrar(@RequestBody Person obj){
        return action.save(obj);
    }


    @GetMapping("/api")
    public List<Person> selecionar(){
        return action.findAll();
    }

    @GetMapping("/api/{codigo}")
    public Person seleccionaPorCodigo(@PathVariable int codigo){

        return action.findByCodigo(codigo);
    }

    @PutMapping("/api")
    public Person editar(@RequestBody Person obj){
      return action.save(obj);
    }

    @DeleteMapping("/api/{codigo}")
    public void remover(@PathVariable int codigo){

        Person obj = seleccionaPorCodigo(codigo);
        action.delete(obj);
    }

    @GetMapping("/api/contador")
    public long contador(){
        return action.count();
    }

    @GetMapping("/api/listapornomes")
    public List<Person> listaPersoas(){
        return action.findByOrderByNomeDesc();
    }


    @GetMapping("/api/listapornome")
    public List<Person> ordenarPorNome(){

        return action.findByNomeOrderByIdade("Manuel");
    }

    @GetMapping("")
    public String mensagem(){
        return "Hello World";
    }

    @GetMapping("/benvido/{nome}")
    public String welcome(@PathVariable String nome){
        return "Benvido " + nome;
    }


    // enlazando con modelo
    @PostMapping("/persoa")
    public Person person(@RequestBody Person p){

        return p;

    }



}
