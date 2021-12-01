package crudandview;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import models.Clientes;
import models.Fornecedores;


public class Crud {
    protected SessionFactory sessionFactory;
 
    protected void setup() {
        // code to load Hibernate Session factory
    	final StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
    	      //  .configure() // configures settings from hibernate.cfg.xml
    	      //  .build();
    	try {
    	    sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
    		//sessionFactory = configuration.buildSessionFactory();
    	} catch (Exception ex) {
    	   StandardServiceRegistryBuilder.destroy(registry);
    		
    	}
    }
 
    protected void exit() {
        // code to close Hibernate Session factory
    }

    
    protected void create(Object object) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
     
        session.save(object);
        
        session.getTransaction().commit();
        session.close();
    }
    /*
    protected void create(Object object) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
     
        session.save(object);
        
        session.getTransaction().commit();
        session.close();
    }
 	*/
    protected Fornecedores read2 (int fornecedoresId) {
    	Session session = sessionFactory.openSession();
    	session.beginTransaction();

        Fornecedores fornecedores = session.get(Fornecedores.class, fornecedoresId);
     
        session.close();
        return fornecedores;
    }
    
    protected Clientes read1 (int clientesId) {
    	Session session = sessionFactory.openSession();
    	session.beginTransaction();

        Clientes clientes = session.get(Clientes.class, clientesId);
     
        session.close();
        return clientes;
    }
 
    protected void update(Object object) {
    	Session session = sessionFactory.openSession();
    	session.beginTransaction();

    	session.update(object);

    	session.getTransaction().commit();
    	session.close(); 	
    }
    
    
    
    public List<Object> listAll() {
    	Session session = sessionFactory.openSession();
        session.beginTransaction();

        // leitura via Hibernate Query Language (HQL).
        List<Object> object = session.createQuery("from Pessoa", Object.class).getResultList();
        
        session.getTransaction().commit();
        session.close();
        
        return object;
    }
    
    
    public Object queryWhere(int id) {
    	Session session = sessionFactory.openSession();
    	session.beginTransaction();

        Object object = session.createQuery("from Pessoa where id="+id, Object.class).getSingleResult();
        
        session.close();
        return object;
    }
    
    /*
    public Pessoa queryWhere(int id) {
    	Session session = sessionFactory.openSession();
    	session.beginTransaction();

        Pessoa pessoa = session.createQuery("from Pessoa where id="+id, Pessoa.class).getSingleResult();
        
        session.close();
        return pessoa;
    }
 */

}