package br.com.casadocodigo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
public class Cupom implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private @NotBlank(message  ="Código Cupom Inválido") String codigoCupom;
    private @Positive(message  ="Percentual Desconto Inválido") @NotNull BigDecimal percentualDesconto;
    private @Future(message  ="Data Validade não está no futuro")@NotNull LocalDate validade;

    public Cupom() {
    }

    public Cupom(@NotBlank(message = "Código Cupom Inválido") String codigoCupom, @Positive(message = "Percentual Desconto Inválido") @NotNull BigDecimal percentualDesconto, @Future(message = "Data Validade não está no futuro") @NotNull LocalDate validade) {
        this.codigoCupom = codigoCupom;
        this.percentualDesconto = percentualDesconto;
        this.validade = validade;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getPercentualDesconto() {
        return percentualDesconto;
    }

    public void setPercentualDesconto(BigDecimal percentualDesconto) {
        this.percentualDesconto = percentualDesconto;
    }

    public LocalDate getValidade() {
        return validade;
    }

    public void setValidade(LocalDate validade) {
        this.validade = validade;
    }
}
