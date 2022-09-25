package com.project.api.repository;

import com.project.api.model.Person;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

// Repositorio

@Repository
public interface Repositorio extends CrudRepository<Person, Integer> {

    List <Person> findAll();

    Person findByCodigo(int codigo);

    List <Person> findByOrderByNomeDesc(); // pódese adicionar Asc ou Desc


    List <Person> findByNomeOrderByIdade(String nome); // filtrando por nome e ordear por idade

    List <Person> findByNomeContaining(String termo); // buscar por termo

    List<Person> findByNomeStartsWith(String termo);
    List<Person> findByNomeEndsWith(String termo);

    @Query(value = "SELECT SUM(idade) FROM persons", nativeQuery = true)
    int SomaIdades();


    @Query(value = "SELECT * FROM persons WHERE idade >= :idade", nativeQuery = true)
    List<Person> idadeMaiorIgual(int idade);



}
