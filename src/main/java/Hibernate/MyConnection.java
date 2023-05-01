package Hibernate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class MyConnection implements AutoCloseable{
    public EntityManagerFactory entityManagerFactory;
    public EntityManager entityManager;
    @Override
    public void close() {
        entityManager.close();
        entityManagerFactory.close();
    }

    public MyConnection() {
        entityManagerFactory = Persistence.createEntityManagerFactory("myPersistenceUnit");
        entityManager=entityManagerFactory.createEntityManager();
    }

    public EntityManagerFactory getEntityManagerFactory() {
        return entityManagerFactory;
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }
}
