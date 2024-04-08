package com.myapp.userapp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.Data;

import java.time.Duration;
import java.util.List;

//@Entity
@Data
public class Project {
    @Id
    private int projectId;
    private String projectName;

    private int projectDuration;
    

}
