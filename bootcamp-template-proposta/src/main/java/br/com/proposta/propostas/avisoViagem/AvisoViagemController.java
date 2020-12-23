package br.com.proposta.propostas.avisoViagem;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
public class AvisoViagemController {

    @PostMapping(path = "/avisoviagem/{id}")
    @Transactional
    public ResponseEntity<?> incluiAvisoViagem(@RequestBody @Valid AvisoViagemRequest avisoViagemRequest, UriComponentsBuilder uriComponentsBuilder, HttpServletRequest httpServletRequest){

    }


}
