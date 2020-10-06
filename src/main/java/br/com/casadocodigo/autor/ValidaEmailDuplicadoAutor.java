package br.com.casadocodigo.autor;

import br.com.casadocodigo.entity.Autor;
import br.com.casadocodigo.repositories.AutorRepository;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;

@Component
public class ValidaEmailDuplicadoAutor implements Validator {

    @Autowired
    private AutorRepository autorRepository;

    @Override
    public boolean supports(Class<?> clazz) {
        return Autor.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        if (errors.hasErrors()) {
            return;
        }

        Autor request = (Autor) target;

        Optional<Autor> possivelAutor = autorRepository
                .findByEmail(request.getEmail());

        if (possivelAutor.isPresent()) {
            errors.rejectValue("email", null,
                    "Já existe um(a) outro(a) autor(a) com o mesmo email "
                            + request.getEmail());
        }
    }

}

