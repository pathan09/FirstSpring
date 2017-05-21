package com.technobangla.spring.dao;


import com.technobangla.spring.model.Designation;
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
public class DesignationDAOImpl implements DesignationDAO {

    private JdbcTemplate jdbcTemplate;

    public DesignationDAOImpl(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public void saveOrUpdate(Designation designation) {
        if (designation.getId() > 0) {
            // update
            String sql = "UPDATE designation SET code=?, name=? WHERE id=?";
            jdbcTemplate.update(sql, designation.getCode(),designation.getName(), designation.getId());
        } else {
            // insert
            String sql = "INSERT INTO designation (code,name)"
                    + " VALUES (?,?)";
            jdbcTemplate.update(sql, designation.getCode(), designation.getName());
        }

    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM designation WHERE id=?";
        jdbcTemplate.update(sql, id);

    }

    @Override
    public Designation get(int id) {
        String sql = "SELECT * FROM designation WHERE id=" + id;
        return jdbcTemplate.query(sql, new ResultSetExtractor<Designation>() {

            @Override
            public Designation extractData(ResultSet rs) throws SQLException,
                    DataAccessException {
                if (rs.next()) {
                    Designation designation = new Designation();
                    designation.setId(rs.getInt("id"));
                    designation.setCode(rs.getString("code"));
                    designation.setName(rs.getString("name"));

                    return designation;
                }

                return null;
            }

        });
    }

    @Override
    public List<Designation> list() {
        String sql = "SELECT * FROM designation";
        List<Designation> designationList = jdbcTemplate.query(sql, new RowMapper<Designation>() {

            @Override
            public Designation mapRow(ResultSet rs, int rowNum) throws SQLException {
                Designation designation = new Designation();

                designation.setId(rs.getInt("id"));
                designation.setCode(rs.getString("code"));
                designation.setName(rs.getString("name"));


                return designation;
            }

        });

        return designationList;
    }
}
