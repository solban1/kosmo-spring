package sol.backend.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import sol.backend.domain.Address;

@SpringBootTest
public class JdbcAddressRepositoryAltTest {
    @Autowired
    private JdbcAddressRepositoryAlt repository;
    
    @Test
    void testInsert() {
        Address address = new Address(-1L, "현주", "부산", null);
        Address address2 = repository.insert(address);
        System.out.println("#address2: " + address2);
    }
}
