package com.example.Repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.example.domain.Member;

@Repository
public class MemberRepository {
	@Autowired
	private NamedParameterJdbcTemplate template;

	private static final RowMapper<Member> MEMBER_ROW_MAPPER = (rs, i) -> {
		Member member = new Member();
		member.setId(rs.getInt("id"));
		member.setName(rs.getString("name"));
		member.setAge(rs.getInt("age"));
		member.setDepId(rs.getInt("id"));
		return member;
	};

	public List<Member> findByAmName(String amName) {
		String sql = "select id, name, age, dep_id from members where name like :amName";
		SqlParameterSource param = new MapSqlParameterSource().addValue("amName", "%"+amName+"%");
		return template.query(sql, param, MEMBER_ROW_MAPPER);
	}

}
