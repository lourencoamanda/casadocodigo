package br.com.casadocodigo.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;

@Entity
public class Livro implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private @NotBlank @NotEmpty String titulo;
    private @NotBlank @NotEmpty @Size(min = 1 , max =500) String resumo;
    private @NotBlank @NotEmpty String sumario;
    private @NotBlank @NotEmpty Double preco;
    private @NotBlank @NotEmpty @Size(min = 100) Integer numPag;
    private @NotBlank String identLivro;

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date dataPublicacao;

    private @NotBlank @NotEmpty String nomeCategoria;
    private @NotBlank @NotEmpty String nomeAutor;

    public Livro() {
    }
}
