package me.janah.studentmanagement.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Student {
    @Id
    private String id;
    @NotEmpty
    @Size(max = 20, min = 3)
    private String firstName;

    @NotEmpty
    @Size(max = 20, min = 3)
    private String lastName;

    @NotEmpty
    @Size(max = 100)
    private String email;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateOfBirth;

    @Enumerated(EnumType.STRING)
    private GenderType gender;

    private boolean enRegle;
}
