package com.xworkz.myfirstproject.dao;

public interface ForgotDAO {

	public int validateLoginEmail(String email);

	public boolean updatePassword(String email, String password);
}
