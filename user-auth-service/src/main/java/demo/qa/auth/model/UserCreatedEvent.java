package demo.qa.auth.model;

public record UserCreatedEvent(
        String name,
        String email
) {}
