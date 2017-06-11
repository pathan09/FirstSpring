package com.technobangla.spring.dao;

import com.technobangla.spring.model.AccountInfo;
import com.technobangla.spring.model.LeadInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by Ayakuth Pathan on 13-May-17.
 */
public class LeadInfoDAOImpl implements LeadInfoDAO {

    private JdbcTemplate jdbcTemplate;
    @Autowired
    EmployeeDAO employeeDAO ;


    Date getDate(String st){
        try {
            return new SimpleDateFormat("dd/MM/yyyy").parse(st);
        } catch (ParseException e) {
           return  new Date();
        }
    }


    public LeadInfoDAOImpl(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    /*String leadName, String leadDescription, String initiateDate, Employee initiateEmployeeId*/

    @Override
    public void saveOrUpdate(LeadInfo leadInfo) {
        if (leadInfo.getId() > 0) {
            // update
            String sql = "UPDATE lead_info SET name=?, description=?, initiate_date=?, employee_id=?, latitude=?, longitude=? WHERE id=?";
            jdbcTemplate.update(sql, leadInfo.getLeadName(),leadInfo.getLeadDescription(),getDate(leadInfo.getInitiateDate()),
                    leadInfo.getInitiateEmployeeId(),leadInfo.getLatitude(),leadInfo.getLongitude(),leadInfo.getId());
        } else {
            // insert
            String sql = "INSERT INTO lead_info ( name, description, initiate_date, employee_id, latitude, longitude ) VALUES (?, ?, ?, ?, ?, ?)";
            jdbcTemplate.update(sql, leadInfo.getLeadName(),leadInfo.getLeadDescription(),getDate(leadInfo.getInitiateDate()),
                    leadInfo.getInitiateEmployeeId(),leadInfo.getLatitude(),leadInfo.getLongitude());
        }

    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM lead_info WHERE id=?";
        jdbcTemplate.update(sql, id);

    }

    @Override
    public LeadInfo get(int id) {
        String sql = "SELECT * FROM lead_info WHERE id=" + id;
        return jdbcTemplate.query(sql, new ResultSetExtractor<LeadInfo>() {

            @Override
            public LeadInfo extractData(ResultSet rs) throws SQLException,
                    DataAccessException {
                if (rs.next()) {
                    LeadInfo leadInfo = new LeadInfo();
                    leadInfo.setId(rs.getInt("id"));
                    leadInfo.setLeadName(rs.getString("name"));
                    leadInfo.setLeadDescription(rs.getString("description"));
                    leadInfo.setInitiateDate(new SimpleDateFormat("dd/MM/yyyy").format(rs.getDate("initiate_date")));
                    leadInfo.setInitiateEmployeeId(rs.getInt("employee_id"));
                    leadInfo.setLatitude(rs.getString("latitude"));
                    leadInfo.setLongitude(rs.getString("longitude"));
                    return leadInfo;
                }

                return null;
            }

        });
    }

    @Override
    public List<LeadInfo> list() {
        String sql = "SELECT * FROM lead_info";
        List<LeadInfo> companyList = jdbcTemplate.query(sql, new RowMapper<LeadInfo>() {

            @Override
            public LeadInfo mapRow(ResultSet rs, int rowNum) throws SQLException {
                LeadInfo leadInfo = new LeadInfo();
                leadInfo.setId(rs.getInt("id"));
                leadInfo.setLeadName(rs.getString("name"));
                leadInfo.setLeadDescription(rs.getString("description"));
                leadInfo.setInitiateDate(new SimpleDateFormat("dd/MM/yyyy").format(rs.getDate("initiate_date")));
                leadInfo.setInitiateEmployeeId(rs.getInt("employee_id"));
                leadInfo.setLatitude(rs.getString("latitude"));
                leadInfo.setLongitude(rs.getString("longitude"));

                return leadInfo;
            }

        });

        return companyList;
    }
}
