package ru.firsov.kirill.DB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
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

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public Person get(int id) {
        return null;
    }

    @Override
    public List<Person> get() {
        return null;
    }
}
