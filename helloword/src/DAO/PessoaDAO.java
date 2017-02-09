package DAO;

import org.hibernate.Session;
import org.hibernate.Transaction;

import dominio.Pessoa;

public class PessoaDAO {
		
	public static void main(String[] args) {
		
		Pessoa p = new Pessoa();
		
		p.setCPF("12345");
		p.setCargo("asd");
		p.setNome("asfa");
		p.setSalario(1233d);
		p.setSobrenome("asdfa");
		
		PessoaDAO dao = new PessoaDAO();
		dao.salvar(p);
	}
	
	
	public void salvar(Pessoa pessoa){
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		session.save(pessoa);
		t.commit();
	}
	
	public void consultarByName(String nome){
		
	}
	
	public void consultarByCPF(String cpf){
		
	}
	
	public void atualizar(Pessoa pessoaOld, Pessoa pessoaNew){
		
	}
	
	public void remover(Pessoa pessoa){
		
	}
}
