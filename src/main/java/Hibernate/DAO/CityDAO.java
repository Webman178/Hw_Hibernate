package Hibernate.DAO;

import Hibernate.City;

import java.util.List;

public interface CityDAO {
    public void addCity(City city);
    public void delete(City city);
    public void update(City city);
    public City getById(int id);
    public List<City> getAllCity();
}
