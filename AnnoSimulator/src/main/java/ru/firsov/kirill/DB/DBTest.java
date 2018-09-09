package ru.firsov.kirill.DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBTest {

    static Connection conn;
    static Statement st;

    /*static {
        try(Connection connection = DriverManager.getConnection("jdbc:sqlite:dbjava")){
            System.out.println(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }*/

    /*
    public void ConnectDB() throws SQLException{
        try{
            conn = DriverManager.getConnection("jdbc:sqlite:dbjava");
        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            conn.close();
        }
    }*/


    //Connect to DataBase and create table
    public void ConnectDB() {
        try {
            conn = DriverManager.getConnection("jdbc:sqlite:dbjava");
            String sql = "CREATE TABLE IF NOT EXISTS PERSON(\n" +
                    "   ID INT PRIMARY KEY     NOT NULL,\n" +
                    "   NAME           TEXT    NOT NULL,\n" +
                    "   AGE            INT     NOT NULL,\n" +
                    "   SALARY         REAL)";
            st = conn.createStatement();
            st.execute(sql);

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try{
                st.close();
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
