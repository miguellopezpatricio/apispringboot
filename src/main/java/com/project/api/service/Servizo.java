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

    // Método para selecionar persoas a través do código
    public ResponseEntity<?> selecionarPeloCodigo(int codigo){
        if(action.countByCodigo(codigo) == 0){
            mensagem.setMensagem("Nao foi atopada a persoa");
            return new ResponseEntity<>(mensagem,HttpStatus.BAD_REQUEST);
        } else{
            return new ResponseEntity<>(action.findByCodigo(codigo), HttpStatus.OK);
        }
    }


    // Método para editar datos
    public ResponseEntity<?> editar(Person obj){
        if(action.countByCodigo(obj.getCodigo()) == 0){

            mensagem.setMensagem("O código non existe");
            return new ResponseEntity<>(mensagem, HttpStatus.NOT_FOUND);

        } else if(obj.getNome().equals("")){

            mensagem.setMensagem("É necesario un nome");
            return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);

        } else if(obj.getIdade()< 0){

            mensagem.setMensagem("Idade non válida");
            return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);

        } else return new ResponseEntity<>(action.save(obj), HttpStatus.OK);
    }

    // Método para eliminar registros
    public ResponseEntity<?> remover(int codigo){
        if(action.countByCodigo(codigo) == 0){
            mensagem.setMensagem("Nao existe a persoa con ese código");
            return new ResponseEntity<>(mensagem, HttpStatus.NOT_FOUND);

        } else{
            Person obj = action.findByCodigo(codigo);
            action.delete(obj);
            mensagem.setMensagem("Persoa eliminada");
            return new ResponseEntity<>(mensagem, HttpStatus.OK);
        }
    }
}
