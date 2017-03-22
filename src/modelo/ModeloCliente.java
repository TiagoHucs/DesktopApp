package modelo;

import java.util.Date;

public class ModeloCliente {

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @return the cpf
     */
    public String getCpf() {
        return cpf;
    }

    /**
     * @return the telefone
     */
    public String getTelefone() {
        return telefone;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @param cpf the cpf to set
     */
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    /**
     * @param telefone the telefone to set
     */
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }
    
    private String nome;
    private String cpf;
    private String telefone;
    private String email;
    private String apolice;
    private String vencimento;
    
    public String getApolice() {
		return apolice;
	}

	public void setApolice(String apolice) {
		this.apolice = apolice;
	}

    public String getVencimento() {
		return vencimento;
	}

	public void setVencimento(String vencimento) {
		this.vencimento = vencimento;
	}

	private String pesquisa;
    

    /**
     * @return the pesquisa
     */
    public String getPesquisa() {
        return pesquisa;
    }

}
