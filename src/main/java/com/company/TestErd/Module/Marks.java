package com.company.TestErd.Module;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "marks")
@Entity
public class Marks {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer markId;
    private Integer studentId;
    private Integer subjectId;
    private Integer mark;
    private LocalDateTime date;
}
