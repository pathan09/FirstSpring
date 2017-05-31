package com.technobangla.spring.dao;

import com.technobangla.spring.model.Company;
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
public class CompanyDAOImpl implements CompanyDAO {

    private JdbcTemplate jdbcTemplate;
    @Autowired
    OrganizationTypeDAO organizationTypeDAO ;

    @Autowired
    OrganizationIndustryDAO organizationIndustryDAO;

    Date getDate(String st){
        try {
            return new SimpleDateFormat("dd/MM/yyyy").parse(st);
        } catch (ParseException e) {
           return new Date();
        }
    }


    public CompanyDAOImpl(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    /*String code, String name, String email, String webAddress, String phone,
    Date establishDate, OrganizationType organizationType, OrganizationIndustry organizationIndustry*/

    @Override
    public void saveOrUpdate(Company company) {
        if (company.getId() > 0) {
            // update
            String sql = "UPDATE company SET code=?, name=?, email=?, web_address=?, phone=?, establish_date=? " +
                    ", organization_type=?, organization_industry=?     WHERE id=?";
            jdbcTemplate.update(sql, company.getCode(),company.getName(),company.getEmail(),company.getWebAddress(),
                    company.getPhone(),getDate(company.getEstablishDate()),company.getOrganizationType(),
                    company.getOrganizationIndustry() ,company.getId());
        } else {
            // insert
            String sql = "INSERT INTO company (code, name, email, web_address, phone, establish_date" +
                    ", organization_type, organization_industry ) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            jdbcTemplate.update(sql, company.getCode(), company.getName(),company.getEmail(),company.getWebAddress(),
                    company.getPhone(),getDate(company.getEstablishDate()),company.getOrganizationType(),
                    company.getOrganizationIndustry());
        }

    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM company WHERE id=?";
        jdbcTemplate.update(sql, id);

    }

    @Override
    public Company get(int id) {
        String sql = "SELECT * FROM company WHERE id=" + id;
        return jdbcTemplate.query(sql, new ResultSetExtractor<Company>() {

            @Override
            public Company extractData(ResultSet rs) throws SQLException,
                    DataAccessException {
                if (rs.next()) {
                    Company company = new Company();
                    company.setId(rs.getInt("id"));
                    company.setCode(rs.getString("code"));
                    company.setName(rs.getString("name"));
                    company.setEmail(rs.getString("email"));
                    company.setWebAddress(rs.getString("web_address"));
                    company.setPhone(rs.getString("phone"));
                    company.setEstablishDate(new SimpleDateFormat("dd/MM/yyyy").format(rs.getDate("establish_date")));
                    company.setOrganizationIndustry(rs.getInt("organization_industry"));
                    company.setOrganizationType(rs.getInt("organization_type"));

                    return company;
                }

                return null;
            }

        });
    }

    @Override
    public List<Company> list() {
        String sql = "SELECT * FROM company";
        List<Company> companyList = jdbcTemplate.query(sql, new RowMapper<Company>() {

            @Override
            public Company mapRow(ResultSet rs, int rowNum) throws SQLException {
                Company company = new Company();
                company.setId(rs.getInt("id"));
                company.setCode(rs.getString("code"));
                company.setName(rs.getString("name"));
                company.setEmail(rs.getString("email"));
                company.setWebAddress(rs.getString("web_address"));
                company.setPhone(rs.getString("phone"));
                company.setEstablishDate(new SimpleDateFormat("dd/MM/yyyy").format(rs.getDate("establish_date")));
                company.setOrganizationIndustry(rs.getInt("organization_industry"));
                company.setOrganizationType(rs.getInt("organization_type"));

                return company;
            }

        });

        return companyList;
    }
}
