package sol.backend;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.web.config.EnableSpringDataWebSupport;

import sol.backend.repository.BoardRepository;
import sol.backend.repository.JdbcBoardRepository;
import sol.backend.service.BoardService;
import sol.backend.service.JdbcBoardService;

@Configuration
@EnableSpringDataWebSupport
public class BackendConfig {
    // @Autowired
    // DataSource dataSource;

    // @Bean
    // BoardRepository boardRepository() {
    //     return new JdbcBoardRepository(dataSource);
    // }

    // @Bean
    // BoardService boardService() {
    //     return new JdbcBoardService(boardRepository());
    // }
}
