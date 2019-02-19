package it.xpug.kata.birthday_greetings.domain;

public class Email {
    private String recipient;
    private String body;
    private String subject;

    public Email(String recipient, String body, String subject) {
        this.recipient = recipient;
        this.body = body;
        this.subject = subject;
    }

    public String getRecipient() {
        return recipient;
    }

    public String getBody() {
        return body;
    }

    public String getSubject() {
        return subject;
    }
}
