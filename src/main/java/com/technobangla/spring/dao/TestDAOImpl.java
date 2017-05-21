package com.technobangla.spring.dao;

import com.technobangla.spring.model.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Ayakuth Pathan on 12-May-17.
 */
public class TestDAOImpl implements TestDAO {

    private JdbcTemplate jdbcTemplate;

    public TestDAOImpl(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public void saveOrUpdate(Test test) {

        if (test.getId() > 0) {
            // update
            String sql = "UPDATE test SET name=? WHERE id=?";
            jdbcTemplate.update(sql, test.getName(), test.getId());
        } else {
            // insert
            String sql = "INSERT INTO test (name)"
                    + " VALUES (?)";
            jdbcTemplate.update(sql, test.getName());
        }

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public Test get(int id) {
        return null;
    }

    @Override
    public List<Test> list() {
        String sql = "SELECT * FROM test";
        List<Test> listTest = jdbcTemplate.query(sql, new RowMapper<Test>() {

            @Override
            public Test mapRow(ResultSet rs, int rowNum) throws SQLException {
                Test aTest = new Test();

                aTest.setId(rs.getInt("id"));
                aTest.setName(rs.getString("name"));


                return aTest;
            }

        });

        return listTest;
    }
}

   /* private JdbcTemplate jdbcTemplate;

    public ContactDAOImpl(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public void saveOrUpdate(Contact contact) {
        if (contact.getId() > 0) {
            // update
            String sql = "UPDATE contact SET name=?, email=?, address=?, "
                    + "telephone=? WHERE contact_id=?";
            jdbcTemplate.update(sql, contact.getName(), contact.getEmail(),
                    contact.getAddress(), contact.getTelephone(), contact.getId());
        } else {
            // insert
            String sql = "INSERT INTO contact (name, email, address, telephone)"
                    + " VALUES (?, ?, ?, ?)";
            jdbcTemplate.update(sql, contact.getName(), contact.getEmail(),
                    contact.getAddress(), contact.getTelephone());
        }

    }

    @Override
    public void delete(int contactId) {
        String sql = "DELETE FROM contact WHERE contact_id=?";
        jdbcTemplate.update(sql, contactId);
    }

    @Override
    public List<Contact> list() {
        String sql = "SELECT * FROM contact";
        List<Contact> listContact = jdbcTemplate.query(sql, new RowMapper<Contact>() {

            @Override
            public Contact mapRow(ResultSet rs, int rowNum) throws SQLException {
                Contact aContact = new Contact();

                aContact.setId(rs.getInt("contact_id"));
                aContact.setName(rs.getString("name"));
                aContact.setEmail(rs.getString("email"));
                aContact.setAddress(rs.getString("address"));
                aContact.setTelephone(rs.getString("telephone"));

                return aContact;
            }

        });

        return listContact;
    }

    @Override
    public Contact get(int contactId) {
        String sql = "SELECT * FROM contact WHERE contact_id=" + contactId;
        return jdbcTemplate.query(sql, new ResultSetExtractor<Contact>() {

            @Override
            public Contact extractData(ResultSet rs) throws SQLException,
                    DataAccessException {
                if (rs.next()) {
                    Contact contact = new Contact();
                    contact.setId(rs.getInt("contact_id"));
                    contact.setName(rs.getString("name"));
                    contact.setEmail(rs.getString("email"));
                    contact.setAddress(rs.getString("address"));
                    contact.setTelephone(rs.getString("telephone"));
                    return contact;
                }

                return null;
            }

        });
    }
*/