package jm.task.core.jdbc.util;

import jm.task.core.jdbc.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util implements AutoCloseable {

    private static volatile Util instance;


    private static final String DB_URL = "jdbc:mysql://localhost:3306/myschema";
    private static final String DB_PASSWORD = "root";
    private static final String DB_USERNAME = "root";
    public static Util getInstance() {
        Util localInstance = instance;
        if (localInstance == null) {
            synchronized (Util.class) {
                localInstance = instance;
                if (localInstance == null) {
                    instance = localInstance = new Util();
                }
            }
        }
        return localInstance;
    }
//    SessionFactory factory = new Configuration().
//            configure("hibernate.cfg.xml")
//            .addAnnotatedClass(User.class).buildSessionFactory();
//    Session session = factory.getCurrentSession();



    public static Connection getConnection(){
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(DB_URL,DB_USERNAME,DB_PASSWORD);
            System.out.println("Connection succeed");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Connection failed");
        } return connection;
    }

    @Override
    public void close() throws Exception {

    }
}
