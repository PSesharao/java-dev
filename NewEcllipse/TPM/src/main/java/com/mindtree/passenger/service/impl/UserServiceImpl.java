package com.mindtree.passenger.service.impl;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.mindtree.passenger.converter.UserConverter;
import com.mindtree.passenger.dto.UserDto;
import com.mindtree.passenger.entity.UserRegister;
import com.mindtree.passenger.repository.UserRepository;
import com.mindtree.passenger.service.UserService;
@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private UserConverter userConverter;
	public static String uploadDirectory = System.getProperty("user.dir") + "/uploads";
	
	@Override
	public UserRegister registerUser(UserDto userDto) {
		UserRegister user = userConverter.dtoToEntity(userDto);
		MultipartFile imageFile = userDto.getImageFile();
		String fileName = imageFile.getOriginalFilename();
		String filePath = Paths.get(uploadDirectory, fileName).toString();
		try {
			BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File(filePath)));
			stream.write(imageFile.getBytes());
			stream.close();
		} catch (IOException e) {

			e.printStackTrace();
		}
		user.setImage(fileName);
		return userRepository.save(user);
	}

}
