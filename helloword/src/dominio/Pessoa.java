package dominio;

import java.io.Serializable;

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
	
	@Column(name = "sexo", nullable = false)
	private String sexo;
	
	public String getFullSexo() {
		if(this.sexo.equals("M")){
			return "Masculino";
		}else{
			return "Feminino";
		}
	}
	
	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo.toUpperCase();
	}

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
	
	public String validate(){
		String erros = new String();
		
		return erros;
	}

	@Override
	public String toString() {
		return "Pessoa [CPF=" + CPF + ", nome=" + nome + ", sobrenome=" + sobrenome + ", cargo=" + cargo + ", salario="
				+ salario + ", sexo=" + sexo + "]";
	}
}
