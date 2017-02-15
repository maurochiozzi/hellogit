package mbeans;

import java.util.ArrayList;
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
		PessoaProcessador pessoaProcessador = new PessoaProcessador();
		pessoaProcessador.salvar(this.pessoa);
		
		//FacesContext.getCurrentInstance().getExternalContext().getSession(arg0)
		return "cadastro_sucesso";
	}
	
	public List<Pessoa> getPessoas() {
		return pessoas;
	}

	public void setPessoas(List<Pessoa> pessoas) {
		this.pessoas = pessoas;
	}

	public String consultarByCPF(){
		PessoaProcessador pessoaProcessador = new PessoaProcessador();
		
		Pessoa pessoaVerif = pessoaProcessador.findByCPF(this.pessoa.getCPF());
		
		if(pessoaVerif != null){
			pessoas = new ArrayList<Pessoa>();
			this.pessoas.add(pessoaVerif);
			return("resultado_consulta");
		}else{
			return ("erro");
		}
	}
	
	public String consultarByNome(){
		PessoaProcessador pessoaProcessador = new PessoaProcessador();
		
		pessoas = pessoaProcessador.findByNome(this.pessoa.getNome());
		
		if(!pessoas.isEmpty()){
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

