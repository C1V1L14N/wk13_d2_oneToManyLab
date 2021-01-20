package com.example.OneToManyToManyLab.repositories;


import com.example.OneToManyToManyLab.models.project.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {
}
