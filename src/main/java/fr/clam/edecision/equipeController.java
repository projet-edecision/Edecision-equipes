package fr.clam.edecision;

import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.*;

@RestController
public class equipeController {
    private final equipeRepository repositoryEquipe;
    private final membres_equipesRepository repositoryMembresEquipes;

    equipeController(equipeRepository repositoryEquipe, membres_equipesRepository repositoryMembresEquipes) {
        this.repositoryEquipe = repositoryEquipe;
        this.repositoryMembresEquipes = repositoryMembresEquipes;
    }



    @GetMapping("/equipes")
    List<equipeEntity> allEquipes() {
        return (List<equipeEntity>) repositoryEquipe.findAll();
    }

    @PostMapping("/equipe")
    equipeEntity newEquipe(@RequestBody equipeEntity newEquipe) {
        return repositoryEquipe.save(newEquipe);
    }


    @GetMapping("/equipe/{id}")
    equipeEntity oneEquipe(@PathVariable UUID id) {

        return repositoryEquipe.findById(id)
                .orElseThrow(() -> new equipeNotFoundException(id));
    }

    @PutMapping("/equipe/{id}")
    equipeEntity editEquipe(@RequestBody equipeEntity newEquipe, @PathVariable UUID id) {

        return repositoryEquipe.findById(id)
                .map(equipe -> {
                    equipe.setUuid(newEquipe.getUuid());
                    equipe.setName(newEquipe.getName());
                    equipe.setProjectId(newEquipe.getProjectId());
                    return repositoryEquipe.save(equipe);
                })
                .orElseGet(() -> {
                    newEquipe.setUuid(id);
                    return repositoryEquipe.save(newEquipe);
                });
    }


    @GetMapping("/membresEquipes")
    List<membres_equipesEntity> allMembresEquipes() {
        return (List<membres_equipesEntity>) repositoryMembresEquipes.findAll();
    }

    @GetMapping("/membresListEquipes/{uuidMembre}")
    List<membres_equipesEntity> filterMembresEquipes(@PathVariable("uuidMembre") UUID uuidMembre) {


        return repositoryMembresEquipes.findByUuidMembre(uuidMembre);
    }

    @GetMapping("/equipesListMembres/{uuidEquipe}")
    List<membres_equipesEntity> filterEquipesMembres(@PathVariable("uuidEquipe") UUID uuidEquipe) {


        return repositoryMembresEquipes.findByUuidEquipe(uuidEquipe);
    }

    @PostMapping("/membresEquipes")
    membres_equipesEntity newMembreEquipe(@RequestBody membres_equipesEntity newMembreEquipe) {
        return repositoryMembresEquipes.save(newMembreEquipe);
    }

    @DeleteMapping("/membresEquipes/{id}")
    void deleteMembreEquipe(@PathVariable("id") UUID id) {
        repositoryMembresEquipes.deleteById(id);
    }


}
