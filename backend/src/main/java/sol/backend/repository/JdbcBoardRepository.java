package sol.backend.repository;

import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import sol.backend.domain.Board;

//@Repository
public class JdbcBoardRepository implements BoardRepository {
    // @Autowired
    // private JdbcTemplate jdbcTemplate;
    private JdbcTemplate jdbcTemplate;

    public JdbcBoardRepository(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    private RowMapper<Board> boardMapper = (rs, i) -> new Board(rs.getLong(1), rs.getString(2), rs.getString(3),
            rs.getString(4), rs.getString(5), rs.getDate(6));

    @Override
    public List<Board> getList() {
        return jdbcTemplate.query("SELECT * FROM BOARD ORDER BY SEQ DESC", boardMapper);
    }

    @Override
    public Board getContent(long seq) {
        return jdbcTemplate.queryForObject("SELECT * FROM BOARD WHERE SEQ=?", boardMapper, seq);
    }

    @Override
    public void insert(Board board) {
        // jdbcTemplate.update("INSERT INTO BOARD VALUES (BOARD_SEQ.nextval, ?, ?, ?, ?,
        // SYSDATE, SYSDATE)",
        // board.getWriter(), board.getEmail(), board.getSubject(), board.getContent());
        board.setSeq(jdbcTemplate.queryForObject("select BOARD_SEQ.nextval from dual", Long.class));
        board.setRdate(new Date());
        new SimpleJdbcInsert(jdbcTemplate).withTableName("BOARD").execute(new BeanPropertySqlParameterSource(board));
    }

    @Override
    public void update(Board board) {
        jdbcTemplate.update("UPDATE BOARD SET EMAIL=?, SUBJECT=?, CONTENT=? WHERE SEQ=?", board.getEmail(),
                board.getSubject(), board.getContent(), board.getSeq());
    }

    @Override
    public void delete(long seq) {
        jdbcTemplate.update("DELETE FROM BOARD WHERE SEQ=?", seq);
    }

}
