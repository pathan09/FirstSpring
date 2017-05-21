package com.technobangla.spring.dao;

import com.technobangla.spring.model.Department;
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
public class DepartmentDAOImpl implements DepartmentDAO {

    private JdbcTemplate jdbcTemplate;

    public DepartmentDAOImpl(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public void saveOrUpdate(Department department) {
        if (department.getId() > 0) {
            // update
            String sql = "UPDATE department SET code=?, name=? WHERE id=?";
            jdbcTemplate.update(sql, department.getDepartmentCode(),department.getDepartmentName(), department.getId());
        } else {
            // insert
            String sql = "INSERT INTO department (code,name)"
                    + " VALUES (?,?)";
            jdbcTemplate.update(sql, department.getDepartmentCode(), department.getDepartmentName());
        }

    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM department WHERE id=?";
        jdbcTemplate.update(sql, id);

    }

    @Override
    public Department get(int id) {
        String sql = "SELECT * FROM department WHERE id=" + id;
        return jdbcTemplate.query(sql, new ResultSetExtractor<Department>() {

            @Override
            public Department extractData(ResultSet rs) throws SQLException,
                    DataAccessException {
                if (rs.next()) {
                    Department department = new Department();
                    department.setId(rs.getInt("id"));
                    department.setDepartmentCode(rs.getString("code"));
                    department.setDepartmentName(rs.getString("name"));

                    return department;
                }

                return null;
            }

        });
    }

    @Override
    public List<Department> list() {
        String sql = "SELECT * FROM department";
        List<Department> departmentList = jdbcTemplate.query(sql, new RowMapper<Department>() {

            @Override
            public Department mapRow(ResultSet rs, int rowNum) throws SQLException {
                Department department = new Department();

                department.setId(rs.getInt("id"));
                department.setDepartmentCode(rs.getString("code"));
                department.setDepartmentName(rs.getString("name"));


                return department;
            }

        });

        return departmentList;
    }
}
