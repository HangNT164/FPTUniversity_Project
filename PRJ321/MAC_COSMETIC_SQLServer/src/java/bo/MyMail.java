/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bo;

import entity.MailMessage;
import entity.SMTPServer;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author HangNT
 */
public class MyMail {

    public Session getMailSession(SMTPServer mailServer, String from, String password) {
        Properties props = new Properties();
        props.put("mail.smtp.host", mailServer.getServer());
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.socketFactory.port", mailServer.getPort());
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        // get the session object
        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
            @Override
            protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
                return new javax.mail.PasswordAuthentication(from, password);
            }

        });
        return session;
    }

    // send a mail message
    public boolean sendMail(MailMessage mm, Session session) throws Exception {
        //create a defailt mimemessage object
        Message message = new MimeMessage(session);
        
        // set from : header field of the header
        message.setFrom(new InternetAddress(mm.getFrom()));
        
        // set to: header field of the header
        message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(mm.getTo()));

        // set subject:header field
        message.setSubject(mm.getSubject());

        // now set the actual message
        message.setText(mm.getMessage());

        // send message 
        Transport.send(message);
        return true;
    }
}
