package mbeans;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import dominio.Pessoa;
import processador.PessoaProcessador;

/**
 * @author MChiozzi
 *
 */
@ManagedBean(eager = true)
@SessionScoped
public class PessoaMBean {
	
	/**
	 * A pessoa a ser cadastrada
	 */
	Pessoa pessoa = new Pessoa();
	List<Pessoa> pessoas;
	
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
	
	public String consultar(){
		PessoaProcessador pessoaProcessador = new PessoaProcessador();
		
		Pessoa pessoaVerif = pessoaProcessador.find(this.pessoa.getCPF());
		
		if(pessoaVerif != null){
			this.pessoa = pessoaVerif;
			this.pessoa.toString();
			return("resultado_consulta");
		}else{
			return ("erro");
		}
	}
	
	public String remover(){
		PessoaProcessador pessoaProcessador = new PessoaProcessador();
		
		if(pessoaProcessador.remover(this.pessoa)){
			return "removido";
		}else{
			return "erro";
		}
	}
}

