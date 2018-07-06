package com.brynhild.ezrealxie.csuftsims.test;

import com.brynhild.ezrealxie.csuftsims.dao.UserDAO;
import com.brynhild.ezrealxie.csuftsims.daoimpl.UserDAOimpl;
import com.brynhild.ezrealxie.csuftsims.domain.User;

public class UserDAOTest {

	public void testAdd() {
		
		User user = new User();
		user.setID("123");
		user.setUsername("testuser");
		user.setPassword("password");
		
		UserDAO dao = new UserDAOimpl();
		dao.add(user);
		
	}
	
}
