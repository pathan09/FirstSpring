package com.technobangla.spring.dao;

import com.technobangla.spring.model.LeadSteps;
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
public class LeadStepsDAOImpl implements LeadStepsDAO {

    private JdbcTemplate jdbcTemplate;

    public LeadStepsDAOImpl(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public void saveOrUpdate(LeadSteps leadSteps) {
        if (leadSteps.getId() > 0) {
            // update
            String sql = "UPDATE lead_steps SET sl_no=?, name=? WHERE id=?";
            jdbcTemplate.update(sql, leadSteps.getSlNo(),leadSteps.getName(), leadSteps.getId());
        } else {
            // insert
            String sql = "INSERT INTO lead_steps (sl_no,name)"
                    + " VALUES (?,?)";
            jdbcTemplate.update(sql, leadSteps.getSlNo(), leadSteps.getName());
        }

    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM lead_steps WHERE id=?";
        jdbcTemplate.update(sql, id);

    }

    @Override
    public LeadSteps get(int id) {
        String sql = "SELECT * FROM lead_steps WHERE id=" + id;
        return jdbcTemplate.query(sql, new ResultSetExtractor<LeadSteps>() {

            @Override
            public LeadSteps extractData(ResultSet rs) throws SQLException,
                    DataAccessException {
                if (rs.next()) {
                    LeadSteps leadSteps = new LeadSteps();
                    leadSteps.setId(rs.getInt("id"));
                    leadSteps.setSlNo(rs.getString("sl_no"));
                    leadSteps.setName(rs.getString("name"));

                    return leadSteps;
                }

                return null;
            }

        });
    }

    @Override
    public List<LeadSteps> list() {
        String sql = "SELECT * FROM lead_steps";
        List<LeadSteps> leadStepsList = jdbcTemplate.query(sql, new RowMapper<LeadSteps>() {

            @Override
            public LeadSteps mapRow(ResultSet rs, int rowNum) throws SQLException {
                LeadSteps department = new LeadSteps();

                department.setId(rs.getInt("id"));
                department.setSlNo(rs.getString("sl_no"));
                department.setName(rs.getString("name"));


                return department;
            }

        });

        return leadStepsList;
    }
}
