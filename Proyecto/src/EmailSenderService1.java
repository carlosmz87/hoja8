import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class EmailSenderService1 {
	private final Properties properties = new Properties();
	
	private String password;
 
	private Session session;
 
	private void init() {
 
		properties.put("mail.smtp.host", "smtp.googlemail.com");
		properties.put("mail.smtp.starttls.enable", "true");
		properties.put("mail.smtp.port","local_port");
		properties.put("mail.smtp.mail.sender","carlosmartz1995@gmail.com");
		properties.put("mail.smtp.user", "carlosmartz1995@gmail.com");
		properties.put("mail.smtp.auth", "true");
 
		session = Session.getDefaultInstance(properties);
	}
 
	public void sendEmail(String sugerencias, String advertencias){
 
		init();
		try{
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress((String)properties.get("mail.smtp.mail.sender")));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress("carlosmartz1995@gmail.com"));
			message.setSubject("HUERTO HIDROPONICO @@ SISTEMA DE CONTROL DE LA PLANTA");
			message.setText("Sugerencias:"+ sugerencias , "ADVERTENCIAS:"+ advertencias);
			Transport t = session.getTransport("smtp");
			t.connect((String)properties.get("mail.smtp.user"), "cmar1995");
			t.sendMessage(message, message.getAllRecipients());
			t.close();
		}catch (MessagingException me){
                        me.printStackTrace();
		}
		
	}
    }

