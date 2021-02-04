package com.example.applicant.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import com.example.applicant.vo.Applicant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;

@Repository
public class ApplicantDaoJdbcImpl implements ApplicantDao {

    private NamedParameterJdbcTemplate jdbcTemplate;
    
    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }

    private static final String INSERT_APPLICANT_SQL = "INSERT INTO APPLICANTS (ID, NAME, EMAIL, AGREEMENT, CAREER, DESCRIPTION, created_date) VALUES(NULL, :name, :email, :agreement, :career, :description, :createdDate)";
    private static final String DELETE_APPLICANT_SQL = "DELETE FROM APPLICANTS WHERE ID = :id";
    private static final String UPDATE_APPLICANT_SQL = "UPDATE APPLICANTS SET NAME = :name, EMAIL=:email, AGREEMENT=:agreement, CAREER=:career, DESCRIPTION=:description WHERE ID=:id";
    private static final String SELECT_ALL_APPLICANTS_SQL = "SELECT * FROM APPLICANTS ORDER BY ID DESC";
    private static final String SELECT_APPLICANT_SQL = "SELECT * FROM APPLICANTS WHERE ID = :id";

    @Override
    public Applicant insertApplicant(Applicant applicant) {
        GeneratedKeyHolder holder = new GeneratedKeyHolder();

        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("name", applicant.getName());
        params.addValue("email", applicant.getEmail());
        params.addValue("agreement", applicant.isAgreement());
        params.addValue("career", applicant.getCareer());
        params.addValue("description", applicant.getDescription());
        params.addValue("createdDate", applicant.getCreatedDate());
        jdbcTemplate.update(ApplicantDaoJdbcImpl.INSERT_APPLICANT_SQL, params, holder);

        return new Applicant(holder.getKey().intValue(), applicant.getName(), applicant.getEmail(), applicant.isAgreement(), applicant.getCareer(), applicant.getDescription(), applicant.getCreatedDate());
    }

    @Override
    public void deleteApplicant(Integer id) {
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("id", id);
        jdbcTemplate.update(ApplicantDaoJdbcImpl.DELETE_APPLICANT_SQL, params);
    }

    @Override
    public void updateApplicant(Applicant applicant) {
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("name", applicant.getName());
        params.addValue("email", applicant.getEmail());
        params.addValue("agreement", applicant.isAgreement());
        params.addValue("career", applicant.getCareer());
        params.addValue("description", applicant.getDescription());
        params.addValue("id", applicant.getId());
        jdbcTemplate.update(ApplicantDaoJdbcImpl.UPDATE_APPLICANT_SQL, params);
    }

    @Override
    public List<Applicant> selectAllApplicants() {
        return jdbcTemplate.query(ApplicantDaoJdbcImpl.SELECT_ALL_APPLICANTS_SQL, new RowMapper<Applicant>() {
            public Applicant mapRow(ResultSet rs, int rownum) throws SQLException {

                Applicant applicant = new Applicant();
                applicant.setId(rs.getInt("id"));
                applicant.setName(rs.getString("name"));
                applicant.setEmail(rs.getString("email"));
                applicant.setAgreement(rs.getBoolean("agreement"));
                applicant.setCareer(rs.getInt("career"));
                applicant.setDescription(rs.getString("description"));
                applicant.setCreatedDate(rs.getDate("created_date"));
    
                return applicant;
            }
        });

    }

    @Override
    public List<Applicant> selectApplicant(Integer id) {
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("id", id);
        return jdbcTemplate.query(ApplicantDaoJdbcImpl.SELECT_APPLICANT_SQL,params, new RowMapper<Applicant>() {
            public Applicant mapRow(ResultSet rs, int rownum) throws SQLException {

                Applicant applicant = new Applicant();
                applicant.setId(rs.getInt("id"));
                applicant.setName(rs.getString("name"));
                applicant.setEmail(rs.getString("email"));
                applicant.setAgreement(rs.getBoolean("agreement"));
                applicant.setCareer(rs.getInt("career"));
                applicant.setDescription(rs.getString("description"));
                applicant.setCreatedDate(rs.getDate("created_date"));
    
                return applicant;
            }
        });
    }


}