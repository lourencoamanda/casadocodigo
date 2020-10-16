package br.com.casadocodigo.compra;

import br.com.casadocodigo.entity.*;
import br.com.casadocodigo.estado.ValidaEstadoPertencePais;
import br.com.casadocodigo.repositories.CupomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.net.URI;
import java.util.List;

@RestController
public class CompraController {

    @Autowired
    private EntityManager entityManager;

    @Autowired
    private CupomRepository cupomRepository;

    @Autowired
    private ValidaEstadoPertencePais validaEstadoPertencePais;

    @Autowired
    private ValidaCpfCnpj validaCpfCnpj;

    @Autowired
    private ValidaCupom validaCupom;

    @Autowired
    private ValidaTotal validaTotal;

    @InitBinder
    public void init(WebDataBinder binder) {
       binder.addValidators(validaCpfCnpj, validaEstadoPertencePais, validaCupom, validaTotal);
    }

    @PostMapping(path = "/validar/compra")
    @Transactional
    public ResponseEntity<?> validarCliente(@Valid @RequestBody CompraRequest compraRequest) {

        Cliente novoCliente = compraRequest.toModel(entityManager);

        entityManager.persist(novoCliente);

        URI location = URI.create(String.format("/validar/compra", novoCliente.getId()));

        return ResponseEntity.status(HttpStatus.CREATED).body(compraRequest);
    }

}