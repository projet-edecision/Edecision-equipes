package fr.clam.edecision;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.UUID;
import java.io.Serializable;

@Entity
@Table(name = "equipes")
public class equipeEntity implements Serializable {
    @Id
    private UUID uuid;
    private String name;

    private String projectId;

    public equipeEntity() {
        this.uuid = UUID.randomUUID();
    }

    public equipeEntity(String name, String projectId){
        this.uuid = UUID.randomUUID();
        this.name = name;
        this.projectId = projectId;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
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
