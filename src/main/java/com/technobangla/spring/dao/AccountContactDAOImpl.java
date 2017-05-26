package com.technobangla.spring.dao;

import com.technobangla.spring.model.AccountContact;
import com.technobangla.spring.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Ayakuth Pathan on 23-May-17.
 */
public class AccountContactDAOImpl implements AccountContactDAO {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    DesignationDAO designationDAO;

    @Autowired
    DepartmentDAO departmentDAO;

    @Autowired
    CompanyDAO companyDAO;

    @Autowired
    AccountInfoDAO accountInfoDAO;

    public AccountContactDAOImpl(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }
    @Override
    public void saveOrUpdate(AccountContact employee) {


        if (employee.getId() > 0) {
            // update
            String sql = "UPDATE account_contact SET account_info_id=?, first_name=?, last_name=?, designation_id=?, department_id=?, company_id=? " +
                    ", phone=?, email=?     WHERE id=?";
            jdbcTemplate.update(sql, employee.getAccountInfoId(),employee.getFirstName(),employee.getLastName(),employee.getDesignationId(),
                    employee.getDepartmentId(),employee.getCompanyId(),employee.getPhone(),
                    employee.getEmail() ,employee.getId());
        } else {
            // insert
            String sql = "INSERT INTO account_contact (account_info_id, first_name, last_name, designation_id, department_id, company_id" +
                    ", phone, email ) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            jdbcTemplate.update(sql, employee.getAccountInfoId(),employee.getFirstName(),employee.getLastName(),employee.getDesignationId(),
                    employee.getDepartmentId(),employee.getCompanyId(),employee.getPhone(),
                    employee.getEmail());
        }

    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM account_contact WHERE id=?";
        jdbcTemplate.update(sql, id);

    }

    @Override
    public AccountContact get(int id) {
        String sql = "SELECT * FROM account_contact WHERE id=" + id;
        return jdbcTemplate.query(sql, new ResultSetExtractor<AccountContact>() {

            @Override
            public AccountContact extractData(ResultSet rs) throws SQLException,
                    DataAccessException {
                if (rs.next()) {
                    AccountContact employee = new AccountContact();
                    employee.setId(rs.getInt("id"));
                    employee.setAccountInfoId(rs.getInt("account_info_id"));
                    employee.setFirstName(rs.getString("first_name"));
                    employee.setEmail(rs.getString("email"));
                    employee.setLastName(rs.getString("last_name"));
                    employee.setPhone(rs.getString("phone"));
                    employee.setDesignationId(rs.getInt("designation_id"));
                    employee.setDepartmentId(rs.getInt("department_id"));
                    employee.setCompanyId(rs.getInt("company_id"));

                    return employee;
                }

                return null;
            }

        });
    }

    @Override
    public List<AccountContact> list() {
        String sql = "SELECT * FROM account_contact";
        List<AccountContact> employeeList = jdbcTemplate.query(sql, new RowMapper<AccountContact>() {

            @Override
            public AccountContact mapRow(ResultSet rs, int rowNum) throws SQLException {
                AccountContact employee = new AccountContact();
                employee.setId(rs.getInt("id"));
                employee.setAccountInfoId(rs.getInt("account_info_id"));
                employee.setFirstName(rs.getString("first_name"));
                employee.setEmail(rs.getString("email"));
                employee.setLastName(rs.getString("last_name"));
                employee.setPhone(rs.getString("phone"));
                employee.setDesignationId(rs.getInt("designation_id"));
                employee.setDepartmentId(rs.getInt("department_id"));
                employee.setCompanyId(rs.getInt("company_id"));

                return employee;
            }

        });

        return employeeList;
    }
}

