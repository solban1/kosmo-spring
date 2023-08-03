package sol.backend.domain;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Board {
    private long seq;
    private String writer;
    private String email;
    private String subject;
    private String content;
    private Date rdate;
}
