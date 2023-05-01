package Hibernate.DAO;

import Hibernate.City;
import Hibernate.MyConnection;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public class CityDAOImpl implements CityDAO{
    @Override
    public void addCity(City city) {
        try (MyConnection connection = new MyConnection()) {
            EntityManager manager = connection.getEntityManager();

            manager.getTransaction().begin();
            manager.persist(city);
            manager.getTransaction().commit();
        }
    }

    @Override
    public void delete(City city) {
        try (MyConnection connection = new MyConnection()) {
            EntityManager manager = connection.getEntityManager();

            manager.getTransaction().begin();
            manager.remove(manager.merge(city));
            manager.getTransaction().commit();
        }
    }

    @Override
    public void update(City city) {
        try (MyConnection connection = new MyConnection()) {
            EntityManager manager = connection.getEntityManager();

            manager.getTransaction().begin();
            manager.merge(city);
            manager.getTransaction().commit();
        }
    }

    @Override
    public City getById(int id) {
        City city = null;
        try (MyConnection connection = new MyConnection()) {
            EntityManager manager = connection.getEntityManager();

            manager.getTransaction().begin();
            city=manager.find(City.class,id);
            manager.getTransaction().commit();
        }
        return city;
    }

    @Override
    public List<City> getAllCity() {
        List<City> listCity = new ArrayList<>();
        try (MyConnection connection = new MyConnection()) {
            EntityManager manager = connection.getEntityManager();

            manager.getTransaction().begin();
            Query query = manager.createQuery("SELECT c FROM City c");
            listCity = query.getResultList();
            manager.getTransaction().commit();
        }
        return listCity;
    }
}
