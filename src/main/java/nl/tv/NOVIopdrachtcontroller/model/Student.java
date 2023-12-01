package nl.tv.NOVIopdrachtcontroller.model;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

@Table(name="students")
@Entity
@Data
@Builder
public class Student {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)

    private int id;

    private  String fullName;

    private  int age;


}
