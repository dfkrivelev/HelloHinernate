package hibernate;

import org.hibernate.cfg.Configuration;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;


public class EntityManagerDemo {
    public static void main(String[] args) {
        EntityManagerFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();

        EntityManager em = factory.createEntityManager();

        Person person = new Person("Ivan", "Ivanov");

//        em.getTransaction().begin();
//        em.persist(person);
//        em.getTransaction().commit();

        //поиск
        em.getTransaction().begin();
        Person findPerson = em.find(Person.class, 1);
        em.getTransaction().commit();
        System.out.println(findPerson);

        //изменить
        findPerson.setLastname("Ivanovic");
        em.getTransaction().begin();
        em.merge(findPerson);
        em.getTransaction().commit();

        //delete
        em.getTransaction().begin();
        Person removePerson = em.find(Person.class, 1);
        em.remove(removePerson);
        em.getTransaction().commit();
    }
}
