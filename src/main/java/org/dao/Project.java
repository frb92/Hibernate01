package org.dao;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="project")
public class Project implements Serializable {
    public Project() {
    }

    @Id
    @GeneratedValue
    @Column (name="id")
    private int id;

    private String name;
    private Date creationDate;

    public Project(String name, Date creationDate) {
        this.name = name;
        this.creationDate = creationDate;
    }

    @Override
    public String toString() {
        return "Project{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", creationDate=" + creationDate +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }
}
