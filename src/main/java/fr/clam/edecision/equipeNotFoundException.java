package fr.clam.edecision;

import java.util.UUID;

public class equipeNotFoundException extends RuntimeException {
    equipeNotFoundException(UUID id) {
        super("Could not find equipe " + id.toString());
    }
}

