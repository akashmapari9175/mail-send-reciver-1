package com.mail.service;

import java.io.File;

import org.springframework.web.multipart.MultipartFile;

public interface MailService {
	
	//send mail to the one person 
	void mailSend(String to,String sub,String text);
	
	//send mail to multiple person
	void mailSend(String []to,String sub,String text);
	
	void mailSendWithFile(String to, String sub, String text, MultipartFile file);
	
}
