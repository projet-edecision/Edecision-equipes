package fr.clam.edecision;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface membres_equipesRepository extends CrudRepository<membres_equipesEntity, UUID> {
    List<membres_equipesEntity> findByUuidMembre(UUID uuidMembre);
    List<membres_equipesEntity> findByUuidEquipe(UUID uuidEquipe);
}