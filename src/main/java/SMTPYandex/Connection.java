package SMTPYandex;

import lombok.Getter;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;

public class Connection {

    @Getter
    private String user;

    @Getter
    private String password;

    @Getter
    private String host;

    @Getter
    private String hostSMTP = "smtp.yandex.ru";

    @Getter
    private Integer port = 465;

    public Connection(String sendTo) throws IOException, MessagingException {
        FileInputStream fileInputStream = new FileInputStream("config.properties");
        Properties properties = new Properties();
        properties.load(fileInputStream);

        this.user = properties.getProperty("mail.user");
        this.password = properties.getProperty("mail.password");
        this.host = properties.getProperty("mail.host");


        Properties prop = new Properties();
        prop.put("mail.smtp.host", hostSMTP);
        prop.put("mail.smtp.ssl.enable", "true");
        prop.put("mail.smot.port", port);
        prop.put("mail.smtp.auth", "true");

        Session session = Session.getDefaultInstance(prop, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(user, password);
            }
        });

        Message message = new MimeMessage(session);

        message.setFrom(new InternetAddress(user));

        InternetAddress internetAddress = new InternetAddress(sendTo);

        message.setRecipient(Message.RecipientType.TO, internetAddress);

        message.setSubject("Try to work");
        message.setSentDate(new Date());
        message.setText("Again try to work");

        Transport.send(message);
    }
}
