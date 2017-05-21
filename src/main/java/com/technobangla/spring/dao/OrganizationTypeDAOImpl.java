package com.technobangla.spring.dao;

import com.technobangla.spring.model.OrganizationType;
import org.springframework.context.annotation.Bean;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Ayakuth Pathan on 13-May-17.
 */

public class OrganizationTypeDAOImpl implements OrganizationTypeDAO {

    private JdbcTemplate jdbcTemplate;

    public OrganizationTypeDAOImpl(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public void saveOrUpdate(OrganizationType organizationType) {
        if (organizationType.getId() > 0) {
            // update
            String sql = "UPDATE OrganizationType SET name=? WHERE id=?";
            jdbcTemplate.update(sql, organizationType.getName(), organizationType.getId());
        } else {
            // insert
            String sql = "INSERT INTO OrganizationType (name)"
                    + " VALUES (?)";
            jdbcTemplate.update(sql, organizationType.getName());
        }

    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM OrganizationType WHERE id=?";
        jdbcTemplate.update(sql, id);

    }

    @Override
    public OrganizationType get(int id) {
        String sql = "SELECT * FROM OrganizationType WHERE id=" + id;
        return jdbcTemplate.query(sql, new ResultSetExtractor<OrganizationType>() {

            @Override
            public OrganizationType extractData(ResultSet rs) throws SQLException,
                    DataAccessException {
                if (rs.next()) {
                    OrganizationType organizationType = new OrganizationType();
                    organizationType.setId(rs.getInt("id"));
                    organizationType.setName(rs.getString("name"));

                    return organizationType;
                }

                return null;
            }

        });
    }

    @Override
    public List<OrganizationType> list() {
        String sql = "SELECT * FROM OrganizationType";
        List<OrganizationType> listTest = jdbcTemplate.query(sql, new RowMapper<OrganizationType>() {

            @Override
            public OrganizationType mapRow(ResultSet rs, int rowNum) throws SQLException {
                OrganizationType aTest = new OrganizationType();

                aTest.setId(rs.getInt("id"));
                aTest.setName(rs.getString("name"));


                return aTest;
            }

        });

        return listTest;
    }
}
