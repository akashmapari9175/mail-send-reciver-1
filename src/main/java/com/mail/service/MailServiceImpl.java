package com.mail.service;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Service
public class MailServiceImpl implements MailService {

	@Autowired
	private JavaMailSender javaMailSender;
	
	
	@Override
	public void mailSend(String to, String sub, String text) {
		// TODO Auto-generated method stub
		SimpleMailMessage message = new  SimpleMailMessage();
		message.setTo(to);
		message.setSubject(sub);
		message.setText(text);
		message.setFrom("akashofficial9933@gmail.com");	
		javaMailSender.send(message);
	}

	@Override
	public void mailSend(String[] to, String sub, String text) {
		// TODO Auto-generated method stub
		SimpleMailMessage message = new  SimpleMailMessage();
		message.setTo(to);
		message.setSubject(sub);
		message.setText(text);
		message.setFrom("akashofficial9933@gmail.com");	
		javaMailSender.send(message);
		
	}

	@Override
	public void mailSendWithFile(String to, String sub, String text, MultipartFile file) {
		try {
	        MimeMessage message = javaMailSender.createMimeMessage();
	        MimeMessageHelper helper = new MimeMessageHelper(message, true);

	        helper.setSubject(sub);
	        helper.setText(text, true);
	        helper.setTo(to);
	        helper.setFrom("akashofficial9933@gmail.com");

	        // Attach the uploaded file
	        helper.addAttachment(file.getOriginalFilename(), file);

	        javaMailSender.send(message);
	        System.out.println("Mail sent successfully with attachment to " + to);
	    } catch (MessagingException e) {
	        e.printStackTrace();
	        System.out.println("Error sending mail: " + e.getMessage());
	    }
	}
}
