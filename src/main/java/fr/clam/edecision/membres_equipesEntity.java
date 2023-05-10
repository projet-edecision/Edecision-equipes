package fr.clam.edecision;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "membres_equipes")
public class membres_equipesEntity {
    @Id
    private UUID id;
    private UUID uuidEquipe;
    private UUID uuidMembre;

    public membres_equipesEntity(){
        this.id = UUID.randomUUID();
    }

    public membres_equipesEntity(UUID uuidEquipe, UUID uuidMembre){
        this.id = UUID.randomUUID();
        this.uuidEquipe = uuidEquipe;
        this.uuidMembre = uuidMembre;
    }

    public UUID getUuidEquipe() {
        return uuidEquipe;
    }

    public void setUuidEquipe(UUID uuidEquipe) {
        this.uuidEquipe = uuidEquipe;
    }

    public UUID getUuidMembre() {
        return uuidMembre;
    }

    public void setUuidMembre(UUID uuidMembre) {
        this.uuidMembre = uuidMembre;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }
}
