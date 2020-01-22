package ru.systemoteh.web.students.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    private Long id;
    private String firstName;
    private String middleName;
    private String lastName;
    private String birthDate;
    private String email;
}
