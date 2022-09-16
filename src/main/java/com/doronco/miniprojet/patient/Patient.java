package com.doronco.miniprojet.patient;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Entity
@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class Patient {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    @Size(min = 5, max = 30)
    private String nom ;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateNaissance ;
    private boolean malade ;
    @DecimalMin("10")
    private int score ;
}
