package sol.backend.repository;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import sol.backend.domain.Board;

@SpringBootTest
public class JdbcBoardRepositoryTest {
    @Autowired
    private JdbcBoardRepository repository;
    
    @Test
    void testGetList() {
        List<Board> list = repository.getList();
        System.out.println(list);
        assertNotNull(list);
    }
    
    @Test
    void testGetContent() {
        
    }

    @Test
    void testInsert() {
        
    }
    
    @Test
    void testUpdate() {
        
    }
    
    @Test
    void testDelete() {

    }
}
