package br.com.casadocodigo.compra;

import br.com.casadocodigo.entity.Cupom;
import br.com.casadocodigo.entity.Livro;
import br.com.casadocodigo.repositories.CupomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Optional;

@Component
public class ValidaCupom implements Validator {

    @PersistenceContext
    private EntityManager manager;

    @Autowired
    private CupomRepository cupomRepository;

    @Override
    public boolean supports(Class<?> clazz) {
        return CompraRequest.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        if(errors.hasErrors()) {
            return ;
        }

        CompraRequest request = (CompraRequest) target;

        Optional<Cupom> buscarCupom = cupomRepository.findByCodigoCupom(request.getCodigoCupom());

     //   Cupom buscarCupom = manager.find(Cupom.class, 33);

        System.out.println("deu certo" + buscarCupom);


    }
}
