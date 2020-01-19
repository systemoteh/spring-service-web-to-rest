package ru.systemoteh.rest.students.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "student")
public class Student {
    @Id
    @SequenceGenerator(name = "STUDENT_ID_GENERATOR", sequenceName = "STUDENT_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "STUDENT_ID_GENERATOR")
    @Column(unique = true, nullable = false)
    private Long id;
    @Column(name = "first_name", length = 250, nullable = false)
    private String firstName;
    @Column(name = "middle_name", length = 250)
    private String middleName;
    @Column(name = "last_name", length = 250, nullable = false)
    private String lastName;
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "birth_date", nullable = false)
    private Date birthDate;
    @Column(name = "email", length = 250)
    private String email;
}
