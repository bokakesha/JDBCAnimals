package Race;
import Animal.Animal;
import AnimalDAO.*;

import java.sql.SQLException;

public class Runner {
    public static void main(String[] args) throws SQLException {
        AnimalDAO animalDao = new AnimalDAO();

        animalDao.AddAnimal(new Animal(0,"Dog",15,15));
        animalDao.AddAnimal(new Animal(1,"Cat",15,15));
        animalDao.AddAnimal(new Animal(2,"Horse",38,89,true));
        System.out.println(animalDao.GetWinners());
        animalDao.DeleteById(2);
        animalDao.Race();
        animalDao.SetSpeedByName("Cat",55);

    }
}
