package br.com.casadocodigo.controller;

import br.com.casadocodigo.entity.Livro;
import br.com.casadocodigo.repositories.LivroRepository;
import br.com.casadocodigo.request.LivroRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
public class LivroController {

    @PersistenceContext
    private EntityManager entityManager;

   @Autowired
    private LivroRepository livroRepository;

    @PostMapping(path = "/save/livro")
    @Transactional
    public ResponseEntity<?> cadastraLivro(@Valid @RequestBody LivroRequest livroRequest){
        Livro novoLivro = livroRequest.toModel(entityManager);
        entityManager.persist(novoLivro);
        return ResponseEntity.status(HttpStatus.CREATED).body(livroRequest);
    }
}
