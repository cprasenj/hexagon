package it.xpug.kata.birthday_greetings.service;

import it.xpug.kata.birthday_greetings.domain.Email;
import it.xpug.kata.birthday_greetings.domain.Employee;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.List;

public class EmailService {
    private String smtpHost;
    private int smtpPort;
    private String sender = "sender@here.com";

    public EmailService(String smtpHost, int smtpPort) {
        this.smtpHost = smtpHost;
        this.smtpPort = smtpPort;
    }

    private Email createEmail(Employee employee) {
        String recipient = employee.getEmail();
        String body = "Happy Birthday, dear %NAME%!".replace("%NAME%", employee.getFirstName());
        String subject = "Happy Birthday!";
        return new Email(recipient, body, subject);
    }

    public void sendMessage(List<Employee> employees) throws MessagingException {
        // Create a mail session

        for(Employee e: employees) {

            Email email = createEmail(e);
            java.util.Properties props = new java.util.Properties();
            props.put("mail.smtp.host", smtpHost);
            props.put("mail.smtp.port", "" + smtpPort);
            Session session = Session.getInstance(props, null);

            // Construct the message
            Message msg = new MimeMessage(session);
            msg.setFrom(new InternetAddress(sender));
            msg.setRecipient(Message.RecipientType.TO, new InternetAddress(email.getRecipient()));
            msg.setSubject(email.getSubject());
            msg.setText(email.getBody());

            // Send the message
            Transport.send(msg);
        }
    }
}