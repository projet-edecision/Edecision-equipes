package fr.clam.edecision;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.UUID;

@Configuration
public class LoadDatabase {

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(equipeRepository repository, membres_equipesRepository repository2) {

        equipeEntity equipe1 = new equipeEntity("Dev1", "");
        equipeEntity equipe2 = new equipeEntity("DevOps1", "");

        UUID uuid1 = UUID.randomUUID();

        membres_equipesEntity membres_equipesEntity1 = new membres_equipesEntity(equipe1.getUuid(), uuid1);
        membres_equipesEntity membres_equipesEntity2 = new membres_equipesEntity(equipe2.getUuid(), uuid1);

        log.info("UUID USER " + uuid1);
        return args -> {
            log.info("Preloading " + repository.save(equipe1));
            log.info("Preloading " + repository.save(equipe2));
            log.info("Preloading " + repository2.save(membres_equipesEntity1));
            log.info("Preloading " + repository2.save(membres_equipesEntity2));
        };
    }
}
