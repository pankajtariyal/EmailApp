package com.email;

import jakarta.mail.*;
import jakarta.mail.internet.*;

import java.io.File;
import java.util.Properties;
import java.util.logging.Logger;

public class EmailConfig {

    public static String getPassword(){
        return "{email password}";  //example:: dglj tqhq wsfn ujrn
    }

    public static boolean message(String emailFrom,String emailTo, String messsage){
        try{
            Message message = new MimeMessage(getSession(emailFrom,getPassword()));
            message.setFrom(new InternetAddress(emailFrom));
            message.setRecipients(Message.RecipientType.TO,InternetAddress.parse(emailTo));
            message.setSubject("Java Mail Test");
            message.setText(messsage);
            Transport.send(message);
            return true;
        }catch (MessagingException e){
            Logger.getLogger("Exception " + e);
            return false;
        }
    }

    public static Session getSession(String user,String pass){
        return Session.getInstance(setProperties(), new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(user,pass);
            }
        });
    }

    public static Properties setProperties(){
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        return props;
    }

    public static boolean sendFile(String sender, String reciever, String message, String path)  {
        try {
            Message sendReq = new MimeMessage(getSession(sender,getPassword()));
            sendReq.setFrom(new InternetAddress(sender));
            sendReq.addRecipients(Message.RecipientType.TO,InternetAddress.parse(reciever));
            sendReq.setSubject("This is just a testing");

            MimeBodyPart text = new MimeBodyPart();
            text.setText(message);

            MimeBodyPart file = new MimeBodyPart();
            file.attachFile(new File(path));

            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(text);
            multipart.addBodyPart(file);

            sendReq.setContent(multipart);
            Transport.send(sendReq);
            return true;
        }catch (Exception e){
            Logger.getLogger("Exception "+ e);
            e.printStackTrace();
            return false;

        }
    }
}
