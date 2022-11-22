package com.example.springbackend.Model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;


@Data
@Entity
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String jobName;
    private Double salary;
}
