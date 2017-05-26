package com.technobangla.spring.dao;

import com.technobangla.spring.model.AccountInfo;
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
public class AccountInfoDAOImpl implements AccountInfoDAO {

    private JdbcTemplate jdbcTemplate;
    @Autowired
    OrganizationTypeDAO organizationTypeDAO ;

    @Autowired
    OrganizationIndustryDAO organizationIndustryDAO;

    Date getDate(String st){
        try {
            return new SimpleDateFormat("dd/MM/yyyy").parse(st);
        } catch (ParseException e) {
           return null;
        }
    }


    public AccountInfoDAOImpl(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    /*String code, String name, String email, String webAddress, String phone,
    Date establishDate, OrganizationType organizationType, OrganizationIndustry organizationIndustry*/

    @Override
    public void saveOrUpdate(AccountInfo company) {
        if (company.getId() > 0) {
            // update
            String sql = "UPDATE account_info SET code=?, name=?, email=?, web_address=?, phone=?, establish_date=? " +
                    ", organization_type=?, organization_industry=?     WHERE id=?";
            jdbcTemplate.update(sql, company.getCode(),company.getName(),company.getEmail(),company.getWebAddress(),
                    company.getPhone(),getDate(company.getEstablishDate()),company.getOrganizationType(),
                    company.getOrganizationIndustry() ,company.getId());
        } else {
            // insert
            String sql = "INSERT INTO account_info (code, name, email, web_address, phone, establish_date" +
                    ", organization_type, organization_industry ) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            jdbcTemplate.update(sql, company.getCode(), company.getName(),company.getEmail(),company.getWebAddress(),
                    company.getPhone(),getDate(company.getEstablishDate()),company.getOrganizationType(),
                    company.getOrganizationIndustry());
        }

    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM account_info WHERE id=?";
        jdbcTemplate.update(sql, id);

    }

    @Override
    public AccountInfo get(int id) {
        String sql = "SELECT * FROM account_info WHERE id=" + id;
        return jdbcTemplate.query(sql, new ResultSetExtractor<AccountInfo>() {

            @Override
            public AccountInfo extractData(ResultSet rs) throws SQLException,
                    DataAccessException {
                if (rs.next()) {
                    AccountInfo company = new AccountInfo();
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
    public List<AccountInfo> list() {
        String sql = "SELECT * FROM account_info";
        List<AccountInfo> companyList = jdbcTemplate.query(sql, new RowMapper<AccountInfo>() {

            @Override
            public AccountInfo mapRow(ResultSet rs, int rowNum) throws SQLException {
                AccountInfo company = new AccountInfo();
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
