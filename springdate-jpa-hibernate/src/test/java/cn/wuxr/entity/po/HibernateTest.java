package cn.wuxr.entity.po;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class HibernateTest {

    private SessionFactory sessionFactory;

    @Before
    public void init(){
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure("/hibernate.cfg.xml").build();
        sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
    }

    @Test
    public void testInsert(){
        try (Session session = sessionFactory.openSession()){
            Transaction transaction = session.beginTransaction();
            Customer customer = new Customer("1","zs", "cq");
            session.save(customer);
            transaction.commit();
        }
    }

    @Test
    public void testFind(){
        try (Session session = sessionFactory.openSession()){
            Customer customer = session.find(Customer.class, "1d76bb6d-83d7-4c96-8d5a-9050674e356d");
            System.out.println("==============");
            System.out.println(customer);
        }
    }

    @Test
    public void testLoad(){
        try (Session session = sessionFactory.openSession()){
            Customer customer = session.load(Customer.class, "1d76bb6d-83d7-4c96-8d5a-9050674e356d");
            System.out.println("==============");
            System.out.println(customer);
        }
    }

    @Test
    public void testDelete(){
        try (Session session = sessionFactory.openSession()){
            Transaction transaction = session.beginTransaction();
            Customer customer = new Customer("ls", "bj");
            session.save(customer);
            transaction.commit();
            System.out.println(customer);
            Long beforeSum = session.createQuery("select count(*) from Customer", Long.class).uniqueResult();
            System.out.println("Before Delete Table sum: " + beforeSum);

            Transaction tx = session.beginTransaction();
            session.remove(customer);
            tx.commit();
            Long afterSum = session.createQuery("select count(*) from Customer", Long.class).uniqueResult();
            System.out.println("After Delete Table sum: " + afterSum);
            Assert.assertEquals(1, beforeSum - afterSum);
        }
    }

}