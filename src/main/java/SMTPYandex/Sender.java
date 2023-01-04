package SMTPYandex;

import org.springframework.beans.factory.annotation.Autowired;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Date;
import java.util.Properties;

public abstract class Sender {

    @Autowired
    Connection connection;

    public void sendQRCodeTo(String address) throws MessagingException {

        InternetAddress internetAddress = new InternetAddress(address);

        Properties properties = new Properties();
        properties.put("mail.smtp.host", connection.getHostSMTP());
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.port", connection.getPort());
        properties.put("mail.smtp.auth", "true");

        Session session = Session.getDefaultInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(connection.getUser(), connection.getPassword());
            }
        });
        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress(connection.getUser()));
        message.setRecipient(Message.RecipientType.TO, internetAddress);
        message.setSubject("Try to work");
        message.setSentDate(new Date());
        message.setText("Again try to work");
        Transport.send(message);
    }
}
