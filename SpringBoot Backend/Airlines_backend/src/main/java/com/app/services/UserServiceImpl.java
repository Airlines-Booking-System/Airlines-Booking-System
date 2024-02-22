package com.app.services;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.daos.UserDao;
import com.app.dtos.Signup;
import com.app.entities.UserDetailsEntity;

@Service
@Transactional
public class UserServiceImpl implements UserService {
	//dep : dao layer i/f
	@Autowired
	private UserDao userDao;
	//dep
	@Autowired
	private ModelMapper mapper;
	//dep 
	@Autowired
	private PasswordEncoder encoder;

	@Override
	public Signup userRegistration(Signup reqDTO) {
		//dto --> entity
		System.out.println("dtooooooo "+reqDTO.getPassword());
		UserDetailsEntity user=new UserDetailsEntity();
		user.setEmail(reqDTO.getEmail());
		user.setName(reqDTO.getFirstName());
		user.setRole(reqDTO.getRole());
		user.setCpass(encoder.encode(reqDTO.getPassword()));//pwd : encrypted using SHA
		System.out.println("in service---------"+user.getCpass());
		UserDetailsEntity u=userDao.save(user);
		return new Signup(u.getName(),u.getEmail(), u.getCpass(), u.getRole());
	}

}
