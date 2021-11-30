package org.dao;

import java.util.Date;
import java.util.List;
import java.util.Random;

public class DAOUsageExample {
    public static void main(String[] args) {

        ProjectService projectService = new ProjectService(new ProjectDAODB());
        int randId = ( new Random()).nextInt(99);
        Project project = new Project("Project #" + randId, new Date());
        projectService.persist(project);

        List<Project> projects = projectService.finAll();
        projects.stream().forEach(
                p -> System.out.println(p)
        );

        Project projectFromDB = projectService.findById(projects.get(0).getId());
        System.out.println("\nProject from DB: " + projectFromDB);
        projectService.delete( projectFromDB );
        System.out.println("\nProject id: " + projectFromDB.getId() + " deleted");

        System.out.println("\nProjects after delet: ");
        projects = projectService.finAll();
        projects.stream().forEach(
                p -> System.out.println(p)
        );
    }
}
