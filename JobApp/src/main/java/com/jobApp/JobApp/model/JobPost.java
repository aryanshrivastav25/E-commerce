package com.jobApp.JobApp.model;

import java.util.List;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data // Lombok allows to automatically generate getters or setters or constructors by just annotations
@NoArgsConstructor
@AllArgsConstructor
@Component
public class JobPost
{
    private int postId;
    private String postProfile;
    private String postDesc;
    private int reqExperience;
    private List<String> postTechStack;
}