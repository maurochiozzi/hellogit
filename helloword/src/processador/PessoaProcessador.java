package processador;

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

	public Pessoa find(String CPF) {
		PessoaDAO pessoaDao = new PessoaDAO();
		Pessoa pessoaEncontrada;
		
		pessoaEncontrada = pessoaDao.findByCPF(CPF);
		
		return pessoaEncontrada;
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
