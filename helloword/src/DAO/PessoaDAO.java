package DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import dominio.Pessoa;

public class PessoaDAO {
	/*
	public static void main(String[] args) {
		System.out.println("teste");
		Pessoa p = new Pessoa();
		String cpf = "1332316";
		
		p.setCPF(cpf);
		p.setCargo("aSDsd");
		p.setNome("asfa");
		p.setSalario(1233d);
		p.setSobrenome("asdfa");
		System.out.println(p.toString());
		
		PessoaDAO dao = new PessoaDAO();
		
		//dao.salvar(p);
		//System.out.println("Salvo");
		//dao.remover(p);
		
		//Pessoa p1 =	dao.consultarByCPF(cpf);
		//System.out.println(p1.toString());
		dao.findByName("asfa");
		//dao.findAll();
	}
	*/
	
	public void salvar(Pessoa pessoa){
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		session.save(pessoa);
		t.commit();
	}

	public void atualizar(Pessoa pessoa){
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		session.update(pessoa);
		t.commit();
	}
	
	public void remover(Pessoa pessoa){
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		session.delete(pessoa);
		t.commit();
	}
	
	@SuppressWarnings("unchecked")
	public List<Pessoa> findAll(){
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		List<Pessoa> pessoas = session.createQuery("from Pessoa").getResultList();
		t.commit();
		
		return pessoas;
	}
	
	public Pessoa findByCPF(String cpf){
		Pessoa pessoa;
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		pessoa = session.load(Pessoa.class, cpf);
		t.commit();
		
		return pessoa;
	}

	@SuppressWarnings("unchecked")
	public List<Pessoa> findByName(String nome){
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		List<Pessoa> pessoas = session.createQuery("SELECT p FROM Pessoa p WHERE p.nome = '" + nome + "'").getResultList();
		t.commit();
		
		return pessoas;
	}		
}
