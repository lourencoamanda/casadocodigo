package br.com.casadocodigo.controller;

import br.com.casadocodigo.entity.Categoria;
import br.com.casadocodigo.repositories.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
public class CategoriaController {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @PostMapping(path = "/save/categoria")
    @Transactional
    public ResponseEntity<?> cadastraCat(@Valid @RequestBody Categoria categoria){

        if(categoriaRepository.findByDescricao(categoria.getDescricao()).isPresent()){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(categoria);
        }
        categoriaRepository.save(categoria);
        return ResponseEntity.status(HttpStatus.CREATED).body(categoria);
    }

}
