package com.project.api.controlador;

import com.project.api.model.Cliente;
import com.project.api.model.Person;
import com.project.api.repository.Repositorio;
import com.project.api.service.Servizo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

// Rutas
@RestController
public class Controlador {

    @Autowired
    private Repositorio action;

    @Autowired
    private Servizo servizo;
    
    @PostMapping("/api")
    public ResponseEntity<?> cadastrar(@RequestBody Person obj){

        return servizo.cadastrar(obj);
    }


    @GetMapping("/api")
    public ResponseEntity<?> selecionar(){
        return servizo.seleccionar();
    }

    @GetMapping("/api/{codigo}")
    public ResponseEntity<?> seleccionaPorCodigo(@PathVariable int codigo){

        return servizo.selecionarPeloCodigo(codigo);
    }

    @PutMapping("/api")
    public ResponseEntity<?> editar(@RequestBody Person obj){

        return servizo.editar(obj);
    }

    @DeleteMapping("/api/{codigo}")
    public ResponseEntity<?> remover(@PathVariable int codigo){

        return servizo.remover(codigo);

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

    @GetMapping("/api/nomecontem")
    public List<Person> nomeContem(){

        return action.findByNomeContaining("el");

    }

    @GetMapping("/api/nomecomezacom")
    public List<Person> nomeComezaCom(){

        return action.findByNomeStartsWith("Man");

    }

    @GetMapping("/api/nomerematacom")
    public List<Person> nomeRemataCom(){

        return action.findByNomeEndsWith("guel");

    }

    @GetMapping("/api/somaidades")
    public int somaIdades(){
        return action.SomaIdades();
    }


    @GetMapping("/api/idademaiorigual")
    public List<Person> idadeMaiorIgual(){
        return action.idadeMaiorIgual(50);
    }


    @GetMapping("/status")
    public ResponseEntity<?> status(){
        return new ResponseEntity<>(HttpStatus.CREATED);
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

    @PostMapping("/cliente")
    public void cliente(@Valid @RequestBody Cliente obj){

    }



}
