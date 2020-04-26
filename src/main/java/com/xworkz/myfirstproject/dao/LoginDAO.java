package com.xworkz.myfirstproject.dao;

import com.xworkz.myfirstproject.entity.SignUpEntity;

public interface LoginDAO {

	public int validateLoginEmail(String email);

	public SignUpEntity getUserData(String email);

	public boolean updateLoginCount(String email, int value);
}
