package br.com.casadocodigo.cupom;

import br.com.casadocodigo.cliente.ClienteRequest;
import br.com.casadocodigo.entity.Cupom;
import br.com.casadocodigo.repositories.CupomRepository;
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
import java.util.Optional;

@RestController
public class CupomController {

    @Autowired
    private EntityManager entityManager;

    @Autowired
    private CupomRepository cupomRepository;

    @PostMapping(path = "/save/cupom")
    @Transactional
    public ResponseEntity<?> cadastraCupom(@Valid @RequestBody CupomRequest cupomRequest) {

        if(cupomRepository.findByCodigoCupom(cupomRequest.getCodigoCupom()).isPresent()){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(cupomRequest);
        }
        
        Cupom novoCupom = new Cupom(cupomRequest.getCodigoCupom(),cupomRequest.getPercentualDesconto(),cupomRequest.getValidade());
        entityManager.persist(novoCupom);

        return ResponseEntity.status(HttpStatus.CREATED).body(novoCupom);

    }
}