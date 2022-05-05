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
public class Student {
private int id;
private String firstName;
private String lastName;
private Instant createDate;
private Instant updateDate;
}
