package sol.backend.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;

import sol.backend.domain.Board;

@Mapper
public interface BoardMapper {
    @Select("SELECT * FROM BOARD ORDER BY SEQ DESC")
    public List<Board> getList();

    @Select("SELECT * FROM BOARD WHERE SEQ=#{seq}")
    public Board getContent(long seq);

    @SelectKey(statement = "SELECT BOARD_SEQ.nextval from dual", keyProperty = "seq", before = true, resultType = long.class)
    @Insert("INSERT INTO BOARD VALUES (#{seq}, #{writer}, #{email}, #{subject}, #{content}, SYSDATE, SYSDATE)")
    public void insert(Board board);
    
    @Update("UPDATE BOARD SET EMAIL=#{email}, SUBJECT=#{subject}, CONTENT=#{content} WHERE SEQ=#{seq}")
    public void update(Board board);

    @Delete("DELETE FROM BOARD WHERE SEQ=#{seq}")
    public void delete(long seq);
}
