package com.technobangla.spring.dao;

import com.technobangla.spring.model.OrganizationIndustry;
import com.technobangla.spring.model.OrganizationType;
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
public class OrganizationIndustryDAOImpl implements OrganizationIndustryDAO {

    private JdbcTemplate jdbcTemplate;

    public OrganizationIndustryDAOImpl(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public void saveOrUpdate(OrganizationIndustry organizationIndustry) {
        if (organizationIndustry.getId() > 0) {
            // update
            String sql = "UPDATE OrganizationType SET name=? WHERE id=?";
            jdbcTemplate.update(sql, organizationIndustry.getName(), organizationIndustry.getId());
        } else {
            // insert
            String sql = "INSERT INTO OrganizationIndustry (name)"
                    + " VALUES (?)";
            jdbcTemplate.update(sql, organizationIndustry.getName());
        }

    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM OrganizationIndustry WHERE id=?";
        jdbcTemplate.update(sql, id);

    }

    @Override
    public OrganizationIndustry get(int id) {
        String sql = "SELECT * FROM OrganizationIndustry WHERE id=" + id;
        return jdbcTemplate.query(sql, new ResultSetExtractor<OrganizationIndustry>() {

            @Override
            public OrganizationIndustry extractData(ResultSet rs) throws SQLException,
                    DataAccessException {
                if (rs.next()) {
                    OrganizationIndustry organizationIndustry = new OrganizationIndustry();
                    organizationIndustry.setId(rs.getInt("id"));
                    organizationIndustry.setName(rs.getString("name"));

                    return organizationIndustry;
                }

                return null;
            }

        });
    }

    @Override
    public List<OrganizationIndustry> list() {
        String sql = "SELECT * FROM OrganizationIndustry";
        List<OrganizationIndustry> listTest = jdbcTemplate.query(sql, new RowMapper<OrganizationIndustry>() {

            @Override
            public OrganizationIndustry mapRow(ResultSet rs, int rowNum) throws SQLException {
                OrganizationIndustry aTest = new OrganizationIndustry();

                aTest.setId(rs.getInt("id"));
                aTest.setName(rs.getString("name"));


                return aTest;
            }

        });

        return listTest;
    }
}
