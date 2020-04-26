package com.xworkz.myfirstproject.dao;

import com.xworkz.myfirstproject.entity.SignUpEntity;

public interface SignUpDAO {

	public boolean validateUserName(String username);

	public boolean validateEmail(String email);

	public boolean saveUser(SignUpEntity dto);
}
