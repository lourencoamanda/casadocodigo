package br.com.casadocodigo.cliente;

import org.hibernate.validator.internal.constraintvalidators.hv.br.CNPJValidator;
import org.hibernate.validator.internal.constraintvalidators.hv.br.CPFValidator;
import org.springframework.util.Assert;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class ClienteRequest {

    private @Email(message = "Email Inválido") String email;
    private @NotBlank(message  ="Nome Inválido") String nome;
    private @NotBlank(message  ="Sobrenome Inválido") String sobrenome;
    private @NotBlank @NotNull (message  ="CPF/CPNJ Inválido")String cpfCnpj;
    private @NotBlank(message  ="Endereço Inválido") String endereco;
    private @NotBlank(message  ="Complemento Inválido") String complemento;
    private @NotBlank(message  ="Cidade Inválido") String cidade;
    private @NotNull(message  ="País Inválido") Long idPais;
    private Long idEstado;
    private @NotBlank(message  ="Telefone Inválido") String telefone;
    private @NotBlank(message  ="CEP Inválido") String cep;

    public ClienteRequest() {
    }

    public ClienteRequest(@Email(message = "Email Inválido") String email, @NotBlank(message = "Nome Inválido") String nome, @NotBlank(message = "Sobrenome Inválido") String sobrenome, @NotBlank @NotNull(message = "CPF/CPNJ Inválido") String cpfCnpj, @NotBlank(message = "Endereço Inválido") String endereco, @NotBlank(message = "Complemento Inválido") String complemento, @NotBlank(message = "Cidade Inválido") String cidade, @NotNull(message = "País Inválido") Long idPais, Long idEstado, @NotBlank(message = "Telefone Inválido") String telefone, @NotBlank(message = "CEP Inválido") String cep) {
        this.email = email;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.cpfCnpj = cpfCnpj;
        this.endereco = endereco;
        this.complemento = complemento;
        this.cidade = cidade;
        this.idPais = idPais;
        this.idEstado = idEstado;
        this.telefone = telefone;
        this.cep = cep;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getCpfCnpj() {
        return cpfCnpj;
    }

    public void setCpfCnpj(String cpfCnpj) {
        this.cpfCnpj = cpfCnpj;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public Long getIdPais() {
        return idPais;
    }

    public void setIdPais(Long idPais) {
        this.idPais = idPais;
    }

    public Long getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(Long idEstado) {
        this.idEstado = idEstado;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public boolean validaCpfCpnj() {
        Assert.hasLength(this.cpfCnpj, "{ CPF/CPNJ Inválido }");

        CPFValidator cpfValidator = new CPFValidator();
        cpfValidator.initialize(null);

        CNPJValidator cnpjValidator = new CNPJValidator();
        cnpjValidator.initialize(null);

        return cpfValidator.isValid(this.cpfCnpj, null)
                || cnpjValidator.isValid(this.cpfCnpj, null);
    }

//  / // public Pais toModel(EntityManager manager) {
   //     @NotNull Pais pais = manager.find(Pais.class, idPais);
      //  @NotNull Categoria categoria = manager.find(Categoria.class, idCategoria);

  //      Assert.state(pais!=null,"Você esta querendo cadastrar um pais que nao existe no banco "+idPais);
        //Assert.state(categoria!=null,"Você esta querendo cadastrar um livro para uma categoria que nao existe no banco "+idCategoria);

    //    return new Pais(idPais);
    //}

}
