package sol.backend.domain;

import java.sql.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Address {
    private long seq;
    private String name;
    private String addr;
    @DateTimeFormat(pattern="yyyy")
    private Date rdate;
}
