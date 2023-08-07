package sol.backend.domain;

import java.util.Date;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Board {
    @Id
    @SequenceGenerator(name = "BOARD_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "BOARD_SEQ")
    private long seq;
    private String writer;
    private String email;
    private String subject;
    private String content;
    //@DateTimeFormat(pattern="yyyy")
    @CreationTimestamp
    private Date rdate;
}
