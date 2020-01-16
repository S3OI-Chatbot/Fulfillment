package database;

import interfaces.CRUD;
import models.Film;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class FilmCommunicator implements CRUD<Film, Integer> {
    private Communicator communicator = Communicator.getInstance();
    private static FilmCommunicator instance = new FilmCommunicator();

    public static FilmCommunicator getInstance() {
        return instance;
    }

    @Override
    public void create(Film entity) {
        try {
            if (communicator.getConnection().isClosed()) communicator.connect();
            PreparedStatement statement = communicator.getConnection().prepareStatement("INSERT INTO `film`(`name`, `age_limit`, `price`, `realistic`, `duration`, `breaks`) VALUES (?,?,?,?,?,?)");

            statement.setString(1,entity.getName());
            statement.setInt(2,entity.getAgeLimit());
            statement.setDouble(3,entity.getPrice());
            statement.setBoolean(4,entity.isRealistic());
            statement.setTime(5,entity.getDuration());
            statement.setInt(6,entity.getBreaks());

            statement.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Film read(Integer id) {
        try {
            if (communicator.getConnection().isClosed()) communicator.connect();
            Statement statement = communicator.getConnection().createStatement();

            ResultSet resultSet = statement.executeQuery("SELECT `idFilm`, `name`, `age_limit`, `price`, `realistic`, `duration`, `breaks` FROM `film` WHERE `idFilm` = " + id);

            resultSet.last();
            if (resultSet.getRow() == 1) {

                return new Film(
                        resultSet.getInt("idFilm"),
                        resultSet.getString("name"),
                        resultSet.getInt("age_limit"),
                        resultSet.getDouble("price"),
                        resultSet.getBoolean("realistic"),
                        resultSet.getTime("duration"),
                        resultSet.getInt("breaks")
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Iterable<Film> readAll() {
        try {
            if (communicator.getConnection().isClosed()) communicator.connect();
            Statement statement = communicator.getConnection().createStatement();

            ResultSet resultSet = statement.executeQuery(
                    "SELECT `idFilm`, `name`, `age_limit`, `price`, `realistic`, `duration`, `breaks` FROM `film`");

            List<Film> attacks = new ArrayList<>();

            while (resultSet.next()) {

                attacks.add(new Film(
                        resultSet.getInt("idFilm"),
                        resultSet.getString("name"),
                        resultSet.getInt("age_limit"),
                        resultSet.getDouble("price"),
                        resultSet.getBoolean("realistic"),
                        resultSet.getTime("duration"),
                        resultSet.getInt("breaks")
                ));
            }

            return attacks;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;    }

    @Override
    public Film update(Film entity) {
        try {
            if (communicator.getConnection().isClosed()) communicator.connect();
            PreparedStatement statement = communicator.getConnection().prepareStatement("UPDATE `film` SET `name`=?,`age_limit`=?,`price`=?,`realistic`=?,`duration`=?,`breaks`=? WHERE `idFilm` = ?");

            statement.setString(1,entity.getName());
            statement.setInt(2,entity.getAgeLimit());
            statement.setDouble(3,entity.getPrice());
            statement.setBoolean(4,entity.isRealistic());
            statement.setTime(5,entity.getDuration());
            statement.setInt(6,entity.getBreaks());
            statement.setInt(7,entity.getId());

            statement.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;    }

    @Override
    public boolean delete(Film entity) throws NoSuchMethodException {
        try {
            if (communicator.getConnection().isClosed()) communicator.connect();
            PreparedStatement statement = communicator.getConnection().prepareStatement("DELETE FROM `film` WHERE `name` = ? AND `age_limit` = ? AND `price` = ? AND `realistic` = ? AND `duration` = ? AND `breaks` = ?");

            statement.setString(1,entity.getName());
            statement.setInt(2,entity.getAgeLimit());
            statement.setDouble(3,entity.getPrice());
            statement.setBoolean(4,entity.isRealistic());
            statement.setTime(5,entity.getDuration());
            statement.setInt(6,entity.getBreaks());

            statement.execute();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }    }

    @Override
    public boolean deleteById(Integer id) {
        try {
            if (communicator.getConnection().isClosed()) communicator.connect();
            PreparedStatement statement = communicator.getConnection().prepareStatement("DELETE FROM `film` WHERE `id` = ?");
            statement.setInt(1,id);
            statement.execute();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public Film readByName(String name) {
        try {
            if (communicator.getConnection().isClosed()) communicator.connect();
            Statement statement = communicator.getConnection().createStatement();

            ResultSet resultSet = statement.executeQuery("SELECT `idFilm`, `name`, `age_limit`, `price`, `realistic`, `duration`, `breaks` FROM `film` WHERE `name` like '" + name + "'");

            resultSet.last();
            if (resultSet.getRow() == 1) {

                return new Film(
                        resultSet.getInt("idFilm"),
                        resultSet.getString("name"),
                        resultSet.getInt("age_limit"),
                        resultSet.getDouble("price"),
                        resultSet.getBoolean("realistic"),
                        resultSet.getTime("duration"),
                        resultSet.getInt("breaks")
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
