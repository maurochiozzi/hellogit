package processador;

import java.util.List;

import DAO.PessoaDAO;
import dominio.Pessoa;

public class PessoaProcessador {	
	public void salvar(Pessoa pessoa){
		PessoaDAO pessoaDao = new PessoaDAO();
		
		if(validate(pessoa) == true){
			pessoaDao.salvar(pessoa);
		}
	}
	
	public boolean validate(Pessoa pessoa){
		return true;
	}

	public Pessoa findByCPF(String CPF) {
		PessoaDAO pessoaDao = new PessoaDAO();
		Pessoa pessoaEncontrada;
		
		pessoaEncontrada = pessoaDao.findByCPF(CPF);
		
		return pessoaEncontrada;
	}
	
	public List<Pessoa> findByNome(String nome){
		PessoaDAO pessoaDao = new PessoaDAO();
		List<Pessoa> pessoas;
		
		pessoas = pessoaDao.findByName(nome);
		
		if(!pessoas.isEmpty()){
			return pessoas;
		}else{
			return null;
		}
	}
	
	public boolean remover(Pessoa pessoa){
		PessoaDAO pessoaDao = new PessoaDAO();
		Pessoa p;
		
		p = pessoaDao.findByCPF(pessoa.getCPF());
		
		if(p != null){
			pessoaDao.remover(p);
			return true;
		}else{
			return false;
		}
	}
}
