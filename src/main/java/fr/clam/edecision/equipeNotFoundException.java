package fr.clam.edecision;

public class equipeNotFoundException extends RuntimeException {
    equipeNotFoundException(String id) {
        super("Could not find employee " + id);
    }
}

