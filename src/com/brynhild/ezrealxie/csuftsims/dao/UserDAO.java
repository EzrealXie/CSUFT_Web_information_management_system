package com.brynhild.ezrealxie.csuftsims.dao;

import com.brynhild.ezrealxie.csuftsims.domain.User;

public interface UserDAO {

	User find(String usernameString, String passwordString);

	void add(User user);

	boolean find(String usernameString);

}