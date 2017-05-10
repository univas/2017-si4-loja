import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import edu.univas.si4.entity.Cliente;


public class TesteHibernate {

	/**
	 * @param args
	 */
	/**
	 * @param args
	 */
	public static void main(String[] args) {

		EntityManagerFactory factory = 
			Persistence.createEntityManagerFactory("loja");
		
		EntityManager entityManager = factory.createEntityManager();


		Cliente cliente = new Cliente();
		cliente.setEmail("artur@gmail.com");
		cliente.setNome("Artur Barbosa");
		
		entityManager.getTransaction().begin();
		
		entityManager.persist(cliente);

		entityManager.getTransaction().commit();
		
		System.out.println("Cod: " + cliente.getCod());
		
		entityManager.close();
		factory.close();
		
		System.out.println("Done");
	}

}
