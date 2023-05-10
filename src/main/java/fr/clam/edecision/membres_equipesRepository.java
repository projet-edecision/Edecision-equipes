package fr.clam.edecision;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface membres_equipesRepository extends CrudRepository<membres_equipesEntity, String> {
    membres_equipesRepository findByuuidMembre(String uuidMembre);
    membres_equipesRepository deleteByuuidMembre(String uuidMembre);

}