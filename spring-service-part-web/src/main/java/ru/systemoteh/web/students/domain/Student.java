package ru.systemoteh.web.students.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    private Long id;
    private String firstName;
    private String middleName;
    private String lastName;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthDate;
    private String email;
}
