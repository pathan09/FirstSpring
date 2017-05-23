package com.technobangla.spring.dao;

import com.technobangla.spring.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * Created by Ayakuth Pathan on 23-May-17.
 */
public class EmployeeDAOImpl implements EmployeeDAO {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    DesignationDAO designationDAO;

    @Autowired
    DepartmentDAO departmentDAO;

    @Autowired
    CompanyDAO companyDAO;

    public EmployeeDAOImpl(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }
    @Override
    public void saveOrUpdate(Employee employee) {


        if (employee.getId() > 0) {
            // update
            String sql = "UPDATE employee SET employee_id=?, first_name=?, last_name=?, designation_id=?, department_id=?, company_id=? " +
                    ", phone=?, email=?     WHERE id=?";
            jdbcTemplate.update(sql, employee.getEmployeeId(),employee.getFirstName(),employee.getLastName(),employee.getDesignationId(),
                    employee.getDepartmentId(),employee.getCompanyId(),employee.getPhone(),
                    employee.getEmail() ,employee.getId());
        } else {
            // insert
            String sql = "INSERT INTO employee (employee_id, first_name, last_name, designation_id, department_id, company_id" +
                    ", phone, email ) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            jdbcTemplate.update(sql, employee.getEmployeeId(),employee.getFirstName(),employee.getLastName(),employee.getDesignationId(),
                    employee.getDepartmentId(),employee.getCompanyId(),employee.getPhone(),
                    employee.getEmail());
        }

    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM employee WHERE id=?";
        jdbcTemplate.update(sql, id);

    }

    @Override
    public Employee get(int id) {
        String sql = "SELECT * FROM employee WHERE id=" + id;
        return jdbcTemplate.query(sql, new ResultSetExtractor<Employee>() {

            @Override
            public Employee extractData(ResultSet rs) throws SQLException,
                    DataAccessException {
                if (rs.next()) {
                    Employee employee = new Employee();
                    employee.setId(rs.getInt("id"));
                    employee.setEmployeeId(rs.getString("employee_id"));
                    employee.setFirstName(rs.getString("first_name"));
                    employee.setEmail(rs.getString("email"));
                    employee.setLastName(rs.getString("last_name"));
                    employee.setPhone(rs.getString("phone"));
                    employee.setDesignationId(rs.getInt("designation_id"));
                    employee.setDepartmentId(rs.getInt("department_id"));
                    employee.setDepartmentId(rs.getInt("company_id"));

                    return employee;
                }

                return null;
            }

        });
    }

    @Override
    public List<Employee> list() {
        String sql = "SELECT * FROM employee";
        List<Employee> employeeList = jdbcTemplate.query(sql, new RowMapper<Employee>() {

            @Override
            public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
                Employee employee = new Employee();
                employee.setId(rs.getInt("id"));
                employee.setEmployeeId(rs.getString("employee_id"));
                employee.setFirstName(rs.getString("first_name"));
                employee.setEmail(rs.getString("email"));
                employee.setLastName(rs.getString("last_name"));
                employee.setPhone(rs.getString("phone"));
                employee.setDesignationId(rs.getInt("designation_id"));
                employee.setDepartmentId(rs.getInt("department_id"));
                employee.setDepartmentId(rs.getInt("company_id"));

                return employee;
            }

        });

        return employeeList;
    }
}

