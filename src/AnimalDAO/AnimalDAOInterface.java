package AnimalDAO;

import Animal.Animal;

import java.sql.SQLException;
import java.util.List;

public interface AnimalDAOInterface {

    void AddAnimal(Animal animal) throws SQLException;

    String Race() throws SQLException;

    void SetSpeedByName(String Name, Integer Speed) throws SQLException;

    void DeleteById(int Id) throws  SQLException;

    List<Animal> GetWinners() throws SQLException;

    void CloseConnection() throws SQLException;

}
