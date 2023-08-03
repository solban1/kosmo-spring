package sol.backend.controller;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class ToDo {
    private String subject;

    @DateTimeFormat(iso=DateTimeFormat.ISO.DATE_TIME)
    private Date cdate;
}
