package br.com.casadocodigo.categoria;

import br.com.casadocodigo.entity.Categoria;
import br.com.casadocodigo.repositories.CategoriaRepository;
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
public class CategoriaController {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private CategoriaRepository categoriaRepository;

    @PostMapping(path = "/save/categoria")
    @Transactional
    public ResponseEntity<?> cadastraCat(@Valid @RequestBody CategoriaRequest requestCategoria){

        if(categoriaRepository.findByDescricao(requestCategoria.getDescricao()).isPresent()){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(requestCategoria);
        }

        Categoria novaCategoria = new Categoria(requestCategoria.getDescricao());
        entityManager.persist(novaCategoria);

        return ResponseEntity.status(HttpStatus.CREATED).body(novaCategoria);
    }

}
