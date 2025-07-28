package com.restJob.restJob.model;

import java.util.List;

import org.springframework.stereotype.Component;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data // Lombok allows to automatically generate getters or setters or constructors by just annotations
@NoArgsConstructor
@AllArgsConstructor
@Component
@Entity
public class JobPost
{
    @Id
    private int postId;
    private String postProfile;
    private String postDesc;
    private int reqExperience;
    private List<String> postTechStack;
}