package com.example.javapart1.Email;

import io.github.cdimascio.dotenv.Dotenv;
import lombok.AllArgsConstructor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

@Service
@AllArgsConstructor
public class EmailService implements EmailSender{

    @Override
    @Async
    public void send(String to, String email) {
        Dotenv dotenv = Dotenv.load();
        final String username = dotenv.get("EMAIL_USER");

        // change accordingly
        final String password = dotenv.get("EMAIL_PASSWORD");

        Properties prop = new Properties();

        // enable authentication
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true");

        // creating Session instance referenced to
        // Authenticator object to pass in
        // Session.getInstance argument
        Session session = Session.getInstance(prop,
                new javax.mail.Authenticator() {

                    //override the getPasswordAuthentication method
                    protected PasswordAuthentication
                    getPasswordAuthentication() {

                        return new PasswordAuthentication(username,
                                password);
                    }
                });
        try {

            // compose the message
            // javax.mail.internet.MimeMessage class is
            // mostly used for abstraction.
            Message message = new MimeMessage(session);

            // header field of the header.
            message.setFrom(new InternetAddress("jhonv.v1@gmail.com"));

            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(to));
            message.setSubject("Confirm your email");
            message.setContent(email,"text/html");

            Transport.send(message);         //send Message

            System.out.println("Done");

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}
