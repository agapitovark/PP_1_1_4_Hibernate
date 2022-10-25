//package jm.task.core.jdbc.dao;
//// здест весь SQL code
//
//import jm.task.core.jdbc.model.User;
//import jm.task.core.jdbc.util.Util;
//
//
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//import java.util.ArrayList;
//import java.util.List;
//
//public class UserDaoJDBCImpl  implements UserDao {
//    public UserDaoJDBCImpl() {
//
//    }
//
//    public void createUsersTable() {
//        try (Statement statement = Util.getInstance().getConnection().createStatement()){
//        String SQL = "CREATE TABLE IF NOT EXISTS users" +
//                "(id BIGINT," +
//                "name VARCHAR(255)," +
//                "lastName VARCHAR(255)," +
//                "age TINYINT)";
//            statement.executeUpdate(SQL);
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//
//
//    }
//
//    public void dropUsersTable() {
//        try (Statement statement = Util.getInstance().getConnection().createStatement()){
//            String SQL = "DROP TABLE IF EXISTS users";
//            statement.executeUpdate(SQL);
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//
//
//    }
//
//    public void saveUser(String name, String lastName, byte age) {
//        try {
//            PreparedStatement preparedStatement;
//            preparedStatement = Util.getInstance().getConnection().prepareStatement
//                    ("INSERT INTO users (name, lastname, age) VALUES(?,?,?)");
//            preparedStatement.setString(1, name);
//            preparedStatement.setString(2, lastName);
//            preparedStatement.setByte(3,age);
//            preparedStatement.executeUpdate();
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//
//    }
//
//    public void removeUserById(long id) {
//        try(PreparedStatement preparedStatement = Util.getInstance().getConnection().prepareStatement(
//                "DELETE FROM users WHERE id=?")) {
//            preparedStatement.setLong(1,id);
//            preparedStatement.executeUpdate();
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//
//
//    }
//
//    public List<User> getAllUsers() {
//        List<User> allUsers = new ArrayList<>();
//        try (Statement statement = Util.getInstance().getConnection().createStatement()) {
//            String SQL = "SELECT * FROM users";
//            ResultSet resultSet = statement.executeQuery(SQL);
//            while(resultSet.next()) {
//               User user = new User();
//               user.setAge(resultSet.getByte(4));
////               user.setId(resultSet.getLong(3));
//               user.setName(resultSet.getString("name"));
//               user.setLastName(resultSet.getString("lastName"));
//               allUsers.add(user);
//            }
//            } catch (SQLException e) {
//            throw new RuntimeException(e);
//        } return  allUsers;
//
//    }
//
//
//
//    public void cleanUsersTable() {
//
//        try (Statement statement = Util.getInstance().getConnection().createStatement()) {
//            String SQL = "DELETE FROM users";
//            statement.executeUpdate(SQL);
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//
//
//    }
//}
