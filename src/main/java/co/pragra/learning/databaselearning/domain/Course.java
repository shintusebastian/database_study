package co.pragra.learning.databaselearning.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Course {
    private int id;
    private String courseName;
    private double courseFee;
    private Instant createDate;
    private Instant updateDate;

}
