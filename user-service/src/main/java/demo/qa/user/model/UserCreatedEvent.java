package demo.qa.user.model;

public record UserCreatedEvent(
        String name,
        String email
) {}
