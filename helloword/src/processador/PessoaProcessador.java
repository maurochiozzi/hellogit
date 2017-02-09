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

	@SuppressWarnings("null")
	public List<Pessoa> find(Pessoa pessoa) {
		PessoaDAO pessoaDao = new PessoaDAO();
		List<Pessoa> pessoas = null;
		
		if(pessoa.getCPF() != null){
			pessoas.add(pessoaDao.findByCPF(pessoa.getCPF()));
		}else{
			pessoas = pessoaDao.findByName(pessoa.getNome());
		}
		
		return pessoas;
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
