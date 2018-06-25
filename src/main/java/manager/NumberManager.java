package manager;

import db.DBConnectionProvider;
import model.Number;


import java.sql.*;
import java.util.LinkedList;
import java.util.List;


public class NumberManager {

    private Connection connection;

    public NumberManager(){
        connection = DBConnectionProvider.getInstance().getConnection();
    }

    public List<Number> getNumberr() {
        PreparedStatement preparedStatement = null;
        List<Number> numbers = new LinkedList<Number>();
        try {
            preparedStatement = connection.prepareStatement("SELECT * FROM number");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Number number = new Number();
                number.setId(resultSet.getInt("id"));
                number.setOddNumber(resultSet.getInt("odd_number"));
                number.setEvenNumber(resultSet.getInt("even_number"));
                numbers.add(number);
            }
            return  numbers;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  numbers;
    }

    public void add(Number number)  {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement
                    ("Insert into number(odd_number,even_number) Values(?,?)", Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1,number.getOddNumber());
            statement.setInt(2,number.getEvenNumber());
            statement.executeUpdate();
            ResultSet resultSet = statement.getGeneratedKeys();
            if (resultSet.next()){
                int id = resultSet.getInt(1);
                number.setId(id);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
