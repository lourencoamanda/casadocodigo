package br.com.casadocodigo.pais;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

public class PaisRequest {

    private @NotBlank String descricao;

    public PaisRequest() {
    }
    public PaisRequest(@NotBlank String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

}
