package com.xyz.service;

import java.io.File;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.xyz.entity.UserMail;

import jakarta.mail.internet.MimeMessage;

@Service
public class UserMailService {
	
	@Autowired
	private JavaMailSender javaMailSender;
	
	public void sendMail(UserMail um) {
		try {
			MimeMessage mess = javaMailSender.createMimeMessage();
			MimeMessageHelper mh = new MimeMessageHelper(mess, true ); // MimeMessageHelper mh = new MimeMessageHelper(mess); here in  MimeMessageHelper method we need to pass extra parameter 'true' that help us to send any multipart attachment
//			mh.setFrom("sagartalukdar0123456789@gmail.com");
			System.out.println(um.getEmail());
			mh.setFrom(um.getEmail());
//			mh.setTo(um.getEmail());
			mh.setTo("sagartalukdar0123456789@gmail.com");
		
			mh.setSubject("Subject :"+um.getSubject());
			mh.setText("Hello ,"
					+ "My Please Read My Message :"
					+um.getMessage());
		  
			FileSystemResource fileSystemResource = new FileSystemResource(new File("C:\\Users\\ADMIN\\Desktop\\sankha-final\\images\\client.jpg"));
			mh.addAttachment(Objects.requireNonNull(fileSystemResource.getFilename()), fileSystemResource);
			
			javaMailSender.send(mess);
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	
	}

}
