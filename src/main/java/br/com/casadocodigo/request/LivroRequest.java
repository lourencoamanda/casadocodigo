package br.com.casadocodigo.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Date;

public class LivroRequest {

    private @NotBlank @NotEmpty String titulo;
    private @NotBlank @NotEmpty @Size(max = 500) String resumo;
    private @NotBlank @NotEmpty String sumario;
    private Double preco;
    private Integer numPag;
    private @NotBlank @NotEmpty String identLivro;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date dataPublicacao;

    private @NotBlank @NotEmpty String nomeCategoria;
    private @NotBlank @NotEmpty String nomeAutor;

    public LivroRequest() {
    }

    public LivroRequest(@NotBlank @NotEmpty String titulo, @NotBlank @NotEmpty @Size(max = 500) String resumo, @NotBlank @NotEmpty String sumario, Double preco, Integer numPag, @NotBlank @NotEmpty String identLivro, Date dataPublicacao, @NotBlank @NotEmpty String nomeCategoria, @NotBlank @NotEmpty String nomeAutor) {
        this.titulo = titulo;
        this.resumo = resumo;
        this.sumario = sumario;
        this.preco = preco;
        this.numPag = numPag;
        this.identLivro = identLivro;
        this.dataPublicacao = dataPublicacao;
        this.nomeCategoria = nomeCategoria;
        this.nomeAutor = nomeAutor;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getResumo() { return resumo; }

    public void setResumo(String resumo) {
        this.resumo = resumo;
    }

    public String getSumario() {
        return sumario;
    }

    public void setSumario(String sumario) {
        this.sumario = sumario;
    }

    public Integer getNumPag() {
        return numPag;
    }

    public void setNumPag(Integer numPag) {
        this.numPag = numPag;
    }

    public String getIdentLivro() {
        return identLivro;
    }

    public void setIdentLivro(String identLivro) {
        this.identLivro = identLivro;
    }

    public String getNomeCategoria() {
        return nomeCategoria;
    }

    public void setNomeCategoria(String nomeCategoria) {
        this.nomeCategoria = nomeCategoria;
    }

    public String getNomeAutor() {
        return nomeAutor;
    }

    public void setNomeAutor(String nomeAutor) {
        this.nomeAutor = nomeAutor;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public Date getDataPublicacao() {
        return dataPublicacao;
    }

    public void setDataPublicacao(Date dataPublicacao) {
        this.dataPublicacao = dataPublicacao;
    }

    @Override
    public String toString() {
        return "Categoria [ Titulo=" + titulo + ", resumo=" + resumo + "" +
                ", sumario=" + sumario + ", Preço=" + preco + ", Numero Paginas=" + numPag +
                ", Identificação Livro=" + identLivro + ", Categoria=" + nomeCategoria +
                ", Autor=" + nomeAutor +   ", Data publicação= " + dataPublicacao + " ]";
    }

}
