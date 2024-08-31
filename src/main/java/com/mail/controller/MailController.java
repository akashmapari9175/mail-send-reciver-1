package com.mail.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.mail.service.MailService;

@RestController
@RequestMapping("/mail")
public class MailController {

	@Autowired
	private MailService mailService;
	
	@PostMapping("/send/person")
	public ResponseEntity<String> sendMail(@RequestParam String to,@RequestParam String sub,@RequestParam String text){
		mailService.mailSend(to, sub, text);
		return new ResponseEntity<String>("mail send successfully",HttpStatus.CREATED);
	}
	
	@PostMapping("/send/multiple")
	public ResponseEntity<String> sendMail(@RequestParam String[] to,@RequestParam String sub,@RequestParam String text){
		mailService.mailSend(to, sub, text);
		return new ResponseEntity<String>("mail Send to multiple person",HttpStatus.CREATED);
	}
	@PostMapping("/send/file")
	public ResponseEntity<String> sendMail(
	        @RequestParam String to, 
	        @RequestParam String sub, 
	        @RequestParam String text, 
	        @RequestParam MultipartFile file) {
	    mailService.mailSendWithFile(to, sub, text, file);
	    return new ResponseEntity<>("Mail sent successfully with attachment", HttpStatus.CREATED);
	}
	
}
