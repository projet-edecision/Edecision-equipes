package fr.clam.edecision;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class equipeController {
    private final equipeRepository repository;

    equipeController(equipeRepository repository) {
        this.repository = repository;
    }



    @GetMapping("/equipes")
    List<equipeEntity> all() {
        return (List<equipeEntity>) repository.findAll();
    }

    @PostMapping("/equipe")
    equipeEntity newEmployee(@RequestBody equipeEntity newEquipe) {
        return repository.save(newEquipe);
    }


    @GetMapping("/equipe/{id}")
    equipeEntity one(@PathVariable String id) {

        return repository.findById(id)
                .orElseThrow(() -> new equipeNotFoundException(id));
    }

    @PutMapping("/equipe/{id}")
    equipeEntity replaceEmployee(@RequestBody equipeEntity newEquipe, @PathVariable String id) {

        return repository.findById(id)
                .map(equipe -> {
                    equipe.setUuid(newEquipe.getUuid());
                    equipe.setName(newEquipe.getName());
                    equipe.setProjectId(newEquipe.getProjectId());
                    return repository.save(equipe);
                })
                .orElseGet(() -> {
                    newEquipe.setUuid(id);
                    return repository.save(newEquipe);
                });
    }
}
