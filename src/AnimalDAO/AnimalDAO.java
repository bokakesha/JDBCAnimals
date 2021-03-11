package AnimalDAO;

import Animal.Animal;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class AnimalDAO implements AnimalDAOInterface {

    private Connection connection;

    public AnimalDAO() throws SQLException {
        Driver driver = new org.postgresql.Driver();
        DriverManager.registerDriver(driver);

        connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Exercise","postgres","postgres");
    }



    @Override
    public void AddAnimal(Animal animal) throws SQLException {

        PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO Animal (AnimalId, AnimalName, AnimalSpeed, AnimalPower, Winner) VALUES (?,?,?,?,?)");
        preparedStatement.setLong(1,animal.getID());
        preparedStatement.setString(2,animal.getName());
        preparedStatement.setInt(3,animal.getSpeed());
        preparedStatement.setInt(4,animal.getPower());
        preparedStatement.setBoolean(5,animal.isWinner());

        preparedStatement.executeUpdate();
        preparedStatement.close();
    }

    @Override
    public String Race() throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM Animal");

        int RaceResult = 0;
        String winner = null;
        while (resultSet.next()) {
            String name = resultSet.getString("AnimalName");
            int speed = resultSet.getInt("AnimalSpeed");
            int power = resultSet.getInt("AnimalPower");
            Random random = new Random();
            int randomInt = random.nextInt(10) + 1;
            int result;
            result = (speed + power) * randomInt;
            if (result > RaceResult) {
                RaceResult = result;
                winner = name;
            }
        }

        ResultSet newResultSet = statement.executeQuery("UPDATE Animal SET Winner = true WHERE AnimalName = " + winner);

        String resultText = "The winner is: " + winner;

        return resultText;
    }

    @Override
    public void SetSpeedByName(String Name,Integer speed) throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("UPDATE Animal SET AnimalSpeed = " + speed +  " WHERE AnimalName = '" + Name + "'");

        statement.close();
    }

    @Override
    public void DeleteById(int Id) throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("DELETE FROM Animal WHERE AnimalId = " + Id);

        statement.close();
    }

    @Override
    public List<Animal> GetWinners() throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet =  statement.executeQuery("SELECT * FROM Animal WHERE Winner = true");

        List<Animal> winners = new ArrayList<>();
        while (resultSet.next()) {
            int id = resultSet.getInt("AnimalId");
            String name = resultSet.getString("AnimalName");
            int speed = resultSet.getInt("AnimalSpeed");
            int power = resultSet.getInt("AnimalPower");
            boolean winner = resultSet.getBoolean("Winner");
            Animal animal = new Animal(id,name,speed,power,winner);
            winners.add(animal);
        }

        statement.close();
        return winners;
    }

    @Override
    public void CloseConnection() throws SQLException {
        connection.close();
    }

}
