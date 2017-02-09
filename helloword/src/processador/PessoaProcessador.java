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
}
