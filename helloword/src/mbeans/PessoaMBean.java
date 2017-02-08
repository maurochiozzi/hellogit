package mbeans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import dominio.Pessoa;
import processador.PessoaProcessador;

@ManagedBean(eager = true)
@RequestScoped
public class PessoaMBean {
	
	/**
	 * A pessoa a ser cadastrada
	 */
	Pessoa pessoa = new Pessoa();
	
	public PessoaMBean(){
		System.out.println("Iniciou");
	};
	
	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
	
	public String adicionar(){
		// Cadastra funcionario no banco de dados
		PessoaProcessador pessoaProcessador = new PessoaProcessador();
		
		pessoaProcessador.salvar(this.pessoa);
		
		return "cadastro_sucesso";
	}
}

