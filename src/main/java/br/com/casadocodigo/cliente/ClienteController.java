package br.com.casadocodigo.cliente;

import br.com.casadocodigo.autor.AutorRequest;
import br.com.casadocodigo.entity.Autor;
import br.com.casadocodigo.repositories.AutorRepository;
import br.com.casadocodigo.repositories.EstadoRepository;
import br.com.casadocodigo.repositories.PaisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
public class ClienteController {

    @Autowired
    private EntityManager entityManager;

    @Autowired
    private PaisRepository paisRepository;

    @Autowired
    private EstadoRepository estadoRepository;

    @PostMapping(path = "/validar/cliente")
    @Transactional
    public ResponseEntity<?> cadastraAutor(@Valid @RequestBody ClienteRequest clienteRequest) {

        if (paisRepository.findById(clienteRequest.getIdPais()).isPresent()) {
            return ResponseEntity.status(HttpStatus.CREATED).body(clienteRequest);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(clienteRequest);

    }
}