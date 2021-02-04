package com.example.applicant.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import com.example.applicant.vo.HoldingSkill;
import com.example.applicant.vo.Skill;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;

@Repository
public class SkillDaoJdbcImpl implements SkillDao {

    private NamedParameterJdbcTemplate jdbcTemplate;
    
    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }

    private static final String SELECT_ALL_SKILLS = "select * from applicant_skills order by id asc";
    private static final String INSERT_HOLDING_SKILL = "insert into applicant_holding_skills(id, app_id, skill_id, created_date) values(null, :appId, :skillId, :createdDate)";
    private static final String SELECT_HOLDING_SKILLS_APPLICANT_ID = "select A.id, A.app_id, A.created_date, A.skill_id, B.skill_name, B.skill_label from applicant_holding_skills A, applicant_skills B where A.skill_id = B.id and app_id = :appId";
    private static final String DELETE_HOLDING_SKILLS_APPLICANT_ID = "delete from applicant_holding_skills where app_id = :appId";

    @Override
    public List<Skill> selectAllSkills() {
        return jdbcTemplate.query(SkillDaoJdbcImpl.SELECT_ALL_SKILLS, new RowMapper<Skill>() {
            public Skill mapRow(ResultSet rs, int rownum) throws SQLException {
                return new Skill(rs.getInt("id"), rs.getString("skill_name"), rs.getString("skill_label"));
            }
        });
    }

    @Override
    public HoldingSkill insertHoldingSkill(HoldingSkill holdingSkill) {
        GeneratedKeyHolder holder = new GeneratedKeyHolder();

        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("appId", holdingSkill.getAppId());
        params.addValue("skillId", holdingSkill.getSkillId());
        params.addValue("createdDate", holdingSkill.getCreatedDate());
        jdbcTemplate.update(SkillDaoJdbcImpl.INSERT_HOLDING_SKILL, params, holder);

        return new HoldingSkill(holder.getKey().intValue(), holdingSkill.getAppId(), holdingSkill.getSkillId(), holdingSkill.getCreatedDate());
    }

    @Override
    public List<HoldingSkill> selectHoldingSkillsByApplicantId(int applicantId) {
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("appId", applicantId);
        
        return jdbcTemplate.query(SkillDaoJdbcImpl.SELECT_HOLDING_SKILLS_APPLICANT_ID, params, new RowMapper<HoldingSkill>() {
            public HoldingSkill mapRow(ResultSet rs, int rowNum) throws SQLException {
                return new HoldingSkill(rs.getInt("id"), rs.getInt("app_id"), rs.getInt("skill_id"), rs.getString("skill_name"), rs.getString("skill_label"), rs.getDate("created_date"));                
            }
        });
    }

    @Override
    public void deleteHoldingSkillsByApplicantId(int applicantId) {
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("appId", applicantId);
        jdbcTemplate.update(SkillDaoJdbcImpl.DELETE_HOLDING_SKILLS_APPLICANT_ID, params);
    }

}