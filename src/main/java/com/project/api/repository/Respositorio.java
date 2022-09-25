package com.project.api.repository;

import com.project.api.model.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

// Repositorio

@Repository
public interface Respositorio extends CrudRepository<Person, Integer> {

    List <Person> findAll();

    Person findByCodigo(int codigo);

    List <Person> findByOrderByNomeDesc(); // pódese adicionar Asc ou Desc


    List <Person> findByNomeOrderByIdade(String nome); // filtrando por nome e ordear por idade
}
