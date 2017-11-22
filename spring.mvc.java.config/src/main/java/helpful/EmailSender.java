package helpful;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class EmailSender {
	public static void send(String to) throws AddressException, MessagingException {

		String from = "sender@abc.com";
		String host = "127.0.0.1"; // mail server host

		Properties properties = System.getProperties();
		properties.setProperty("mail.smtp.host", host);

		Session session = Session.getDefaultInstance(properties); // default session

		MimeMessage message = new MimeMessage(session); // email message

		message.setFrom(new InternetAddress(from)); // setting header fields

		message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

		message.setSubject("Test Mail from Java Program"); // subject line

		// actual mail body
		message.setText("Thanks for registration");

		// Send message
		Transport.send(message);
		System.out.println("Email Sent successfully....");

	}

}
/*
 * for google SSL («mail.smtp.host», «smtp.gmail.com»);
 * («mail.smtp.socketFactory.port», «465»); («mail.smtp.socketFactory.class»,
 * «javax.net.ssl.SSLSocketFactory»); («mail.smtp.auth», «true»)
 * («mail.smtp.port», «465»)
 * 
 * TLS («mail.smtp.auth», «true») («mail.smtp.starttls.enable», «true»)
 * («mail.smtp.host», «smtp.gmail.com») («mail.smtp.port», «587»)
 */
