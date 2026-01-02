package com.example.crud_operations.controller;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.crud_operations.bean.NotificationRequestDTO;
import com.example.crud_operations.entity.NotificationEntity;
import com.example.crud_operations.service.NotificationsService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/v1/notifications")
public class NotificationController {

	@Autowired
	NotificationsService notifServ;

	@ResponseBody
	@PostMapping("/")
	//public ResponseEntity<NotificationEntity> sendNotification(@Valid @RequestBody NotificationRequestDTO notifRequest, @RequestPart MultipartFile attachmentFile) {
	public ResponseEntity<NotificationEntity> sendNotification(@Valid @RequestBody NotificationRequestDTO notifRequest) {
				
		try {
			//return new ResponseEntity<>(notifServ.sendNotification(notifRequest, attachmentFile), HttpStatus.CREATED);
			return new ResponseEntity<>(notifServ.sendNotification(notifRequest), HttpStatus.CREATED);
		} catch (IOException e) {
			e.printStackTrace();
			return new ResponseEntity<>(new NotificationEntity() , HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@ResponseBody
	@GetMapping("/")
	public ResponseEntity<List<NotificationEntity>> getAllNotification() {
		return new ResponseEntity<>(notifServ.getAllNotification(), HttpStatus.OK);
	}
	
	
	
	
	
	
	@ResponseBody
	@GetMapping("/{id}")
	public String getNotification(@PathVariable UUID id) {
		return notifServ.getNotification(id);
	}

	@ResponseBody
	@DeleteMapping("/{id}")
	public String deleteNotification(@PathVariable UUID id) {
		return notifServ.deleteNotification(id);
	}

}
