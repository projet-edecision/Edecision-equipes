package fr.clam.edecision;

import java.util.List;

import org.springframework.web.bind.annotation.*;

@RestController
public class equipeController {
    private final equipeRepository repositoryEquipe;
    private final membres_equipesRepository repositoryMembresEquipes;

    equipeController(equipeRepository repository, membres_equipesRepository repository1) {
        this.repositoryEquipe = repository;
        this.repositoryMembresEquipes = repository1;
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
    equipeEntity oneEquipe(@PathVariable String id) {

        return repositoryEquipe.findById(id)
                .orElseThrow(() -> new equipeNotFoundException(id));
    }

    @PutMapping("/equipe/{id}")
    equipeEntity editEquipe(@RequestBody equipeEntity newEquipe, @PathVariable String id) {

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

    @GetMapping("/membresEquipes/{id}")
    membres_equipesEntity oneMembreEquipe(@PathVariable String uuidMember) {

        return (membres_equipesEntity) repositoryMembresEquipes.findByuuidMember(uuidMember);
    }

    @PostMapping("/membresEquipes")
    membres_equipesEntity newMembreEquipe(@RequestBody membres_equipesEntity newMembreEquipe) {
        return repositoryMembresEquipes.save(newMembreEquipe);
    }

    @DeleteMapping("/membresEquipes/{id}")
    void deleteEmployee(@PathVariable String uuidMember) {
        repositoryMembresEquipes.deleteByuuidMember(uuidMember);
    }


}
