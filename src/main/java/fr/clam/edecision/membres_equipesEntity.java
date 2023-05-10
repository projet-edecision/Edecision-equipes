package fr.clam.edecision;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "membres_equipes")
public class membres_equipesEntity {
    private String uuidEquipe;
    private String uuidMembre;
    @Id
    @GeneratedValue
    private Long id;

    public membres_equipesEntity(){}

    public membres_equipesEntity(String uuidEquipe, String uuidMembre){
        this.uuidEquipe = uuidEquipe;
        this.uuidMembre = uuidMembre;
    }
    public String getUuidEquipe() {
        return uuidEquipe;
    }

    public void setUuidEquipe(String uuidEquipe) {
        this.uuidEquipe = uuidEquipe;
    }

    public String getUuidMembre() {
        return uuidMembre;
    }

    public void setUuidMembre(String uuidMembre) {
        this.uuidMembre = uuidMembre;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
