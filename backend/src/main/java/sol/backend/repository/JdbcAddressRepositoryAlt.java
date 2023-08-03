package sol.backend.repository;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import sol.backend.domain.Address;

@Repository
public class JdbcAddressRepositoryAlt {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    public Address insert(Address address) {
        long seq = jdbcTemplate.queryForObject("select ADDRESS_SEQ.nextval from dual", Long.class);
        address.setSeq(seq);
        address.setRdate(new Date(new java.util.Date().getTime()));
        new SimpleJdbcInsert(jdbcTemplate).withTableName("ADDRESS").execute(new BeanPropertySqlParameterSource(address));

        return address;
    }
}
