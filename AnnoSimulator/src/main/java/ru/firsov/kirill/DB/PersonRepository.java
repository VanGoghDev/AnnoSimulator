package ru.firsov.kirill.DB;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class PersonRepository implements IRepository<Person> {

    Connection conn;
    PreparedStatement st;
    @Override
    public void insert(Person entity) {
        String sql = "INSERT INTO PERSON (ID, NAME, AGE, SALARY) VALUES(?, ?, ?, ?)";
        try {
            conn = MyConnection.getConnection();
            st = conn.prepareStatement(sql);
            st.setInt(1, entity.id);
            st.setString(2, entity.name);
            st.setInt(3, entity.age);
            st.setFloat(4, entity.salary);

            st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                st.close();
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void update(Person entity) {
        String sql = "UPDATE PERSON set NAME = ?, AGE = ?, SALARY = ? WHERE id = ?";
        try {
            conn = MyConnection.getConnection();
            st = conn.prepareStatement(sql);
            st.setString(1, entity.name);
            st.setInt(2, entity.age);
            st.setFloat(3, entity.salary);
            st.setInt(4, entity.id);
            st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                st.close();
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM PERSON WHERE id=?";

        try{
            conn = MyConnection.getConnection();
            st = conn.prepareStatement(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                st.close();
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public Person get(int id) {
        String sql = "SELECT * FROM PERSON WHERE id=?";
        Person p = null;
        try {
            conn = MyConnection.getConnection();
            st = conn.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                p = new Person(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getFloat(4));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return p;
    }

    @Override
    public List<Person> get() {
        String sql = "SELECT ID, NAME, AGE, SALARY FROM PERSON";
        List<Person> list = new LinkedList<>();
        try {
            conn = MyConnection.getConnection();
            st = conn.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                list.add(new Person(rs.getInt(1),
                             rs.getString(2),
                             rs.getInt(3),
                             rs.getFloat(4)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
