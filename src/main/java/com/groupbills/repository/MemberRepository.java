package com.groupbills.repository;

import com.groupbills.model.Member;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class MemberRepository {
    private final NamedParameterJdbcTemplate template;

    public void save(Member member) {
        String sql = """
                insert into member(login_id, password, name)
                values(:loginId, :password, :name)
                """;
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(member);
        template.update(sql, param);
    }

    public List<Member> findAll() {
        String sql = "select * from member";
        return template.query(sql, memberRowMapper());
    }

    private RowMapper<Member> memberRowMapper() {
        return ((rs, rowNum) -> Member.builder()
                .id(rs.getLong("id"))
                .loginId(rs.getString("login_id"))
                .name(rs.getString("name"))
                .password(rs.getString("password"))
                .build());
    }

    public Optional<Member> findByLoginId(String loginId) {
        String sql = "select * from member where login_id = :loginId";
        List<Member> result = template.query(sql, Map.of("loginId", loginId), memberRowMapper());
        return result.stream().findAny();
    }
}
