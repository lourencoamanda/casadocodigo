package br.com.casadocodigo.controller;

import br.com.casadocodigo.entity.Autor;
import br.com.casadocodigo.repositories.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class AutorController {

    @Autowired
    private AutorRepository autorRepository;

    @PostMapping(path = "/save/autor")
    public void cadastraAutor(@Valid @RequestBody Autor autor){
        autorRepository.save(autor);
    }

}
