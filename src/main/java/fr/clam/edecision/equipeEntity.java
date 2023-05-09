package fr.clam.edecision;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.UUID;
import java.io.Serializable;

@Entity
@Table(name = "equipes")
public class equipeEntity implements Serializable {
    private String uuid;
    private String name;

    private String projectId;

    public equipeEntity() {
        this.uuid = UUID.randomUUID().toString();
    }

    public equipeEntity(String name, String projectId){
        this.uuid = UUID.randomUUID().toString();
        this.name = name;
        this.projectId = projectId;
    }

    @Id
    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getProjectId() {
        return projectId;
    }
    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

}
