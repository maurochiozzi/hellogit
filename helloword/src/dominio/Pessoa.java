package dominio;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "pessoa", schema="empresa")
public class Pessoa implements Serializable{
	
	@Id
	@Column(name="cpf", nullable=false)
	private String CPF;
	
	@Column(name="nome", nullable=false)
	private String nome;
	
	@Column(name="sobrenome", nullable=false)
	private String sobrenome;
	
	@Column(name="cargo", nullable=false)
	private String cargo;
	
	@Column(name="salario", nullable=false)
	private Double salario;
	
	public String getCPF() {
		return CPF;
	}

	public void setCPF(String cpf) {
		this.CPF = cpf;
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

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public Double getSalario() {
		return salario;
	}

	public void setSalario(Double salario) {
		this.salario = salario;
	}
	
	public List<String> validate(){
		List<String> erros = new ArrayList<String>();
		
		return erros;
	}

	@Override
	public String toString() {
		return "Pessoa [cpf=" + CPF + ", nome=" + nome + ", sobrenome=" + sobrenome + ", cargo=" + cargo + ", salario="
				+ salario + "]";
	}


}
