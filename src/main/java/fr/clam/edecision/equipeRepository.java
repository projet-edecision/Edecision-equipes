package fr.clam.edecision;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface equipeRepository extends CrudRepository<equipeEntity, UUID> {

    equipeEntity findByName(String name);

}
