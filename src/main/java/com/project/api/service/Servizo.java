package com.project.api.service;

import com.project.api.model.Mensagem;
import com.project.api.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.project.api.repository.Repositorio;

@Service
public class Servizo {

    @Autowired
    private Mensagem mensagem;

    @Autowired
    private Repositorio action;

    // Método para cadastrar persoas que verifica se está o nome e/ou a idade
    public ResponseEntity<?> cadastrar(Person obj){

        if(obj.getNome().equals("")){
            mensagem.setMensagem("O nome precisa ser preenchido");
            return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
        }else if(obj.getIdade() <0){
            mensagem.setMensagem("Informe uma idade válida");
            return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);


        } else {
            return new ResponseEntity<>(action.save(obj), HttpStatus.CREATED);
        }
    }

    // Método para seleccionar persoas
    public ResponseEntity<?> seleccionar(){
        return new ResponseEntity<>(action.findAll(), HttpStatus.OK);
    }

}
