package br.com.casadocodigo.controller;

import br.com.casadocodigo.entity.Categoria;
import br.com.casadocodigo.repositories.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
    public String cadastraCat(@Valid @RequestBody Categoria categoria){ categoriaRepository.save(categoria);



        return  categoria.toString();
    }

}
