package com.technobangla.spring.dao;

import com.technobangla.spring.model.Department;
import com.technobangla.spring.model.User;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Ayakuth Pathan on 13-May-17.
 */
public class UserDAOImpl implements UserDAO {

    private JdbcTemplate jdbcTemplate;

    public UserDAOImpl(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public void saveOrUpdate(User user) {
        if (user.getId() > 0) {
            // update
            String sql = "UPDATE user SET user_name=?, password=?, is_active=?, employee_id WHERE id=?";
            jdbcTemplate.update(sql, user.getUserName(),user.getPassword(),user.isActive(),user.getEmployeeId(),user.getId());
        } else {
            // insert
            String sql = "INSERT INTO user (user_name,password,is_active,employee_id)"
                    + " VALUES (?,?,?,?)";
            jdbcTemplate.update(sql, user.getUserName(),user.getPassword(),user.isActive(),user.getEmployeeId());
        }

    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM user WHERE id=?";
        jdbcTemplate.update(sql, id);

    }

    @Override
    public User get(int id) {
        String sql = "SELECT * FROM user WHERE id=" + id;
        return jdbcTemplate.query(sql, new ResultSetExtractor<User>() {

            @Override
            public User extractData(ResultSet rs) throws SQLException,
                    DataAccessException {
                if (rs.next()) {
                    User user = new User();
                    user.setId(rs.getInt("id"));
                    user.setUserName(rs.getString("user_name"));
                    user.setPassword(rs.getString("password"));
                    user.setActive(rs.getBoolean("is_active"));
                    user.setEmployeeId(rs.getInt("employee_id"));

                    return user;
                }

                return null;
            }

        });
    }

    @Override
    public List<User> list() {
        String sql = "SELECT * FROM user";
        List<User> userList = jdbcTemplate.query(sql, new RowMapper<User>() {

            @Override
            public User mapRow(ResultSet rs, int rowNum) throws SQLException {
                User user = new User();

                user.setId(rs.getInt("id"));
                user.setUserName(rs.getString("user_name"));
                user.setPassword(rs.getString("password"));
                user.setActive(rs.getBoolean("is_active"));
                user.setEmployeeId(rs.getInt("employee_id"));
                return user;
            }

        });

        return userList;
    }
}
