package br.com.casadocodigo.controller;

import br.com.casadocodigo.repositories.LivroRepository;
import br.com.casadocodigo.request.LivroRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
public class LivroController {

   @Autowired
    private LivroRepository livroRepository;

    @PostMapping(path = "/save/livro")
    @Transactional
    public String cadastraLivro(@Valid @RequestBody LivroRequest livroRequest){

    //{ categoriaRepository.save(categoria);

        return  livroRequest.toString();
    }

}
