package com.brynhild.ezrealxie.csuftsims.daoimpl;


import com.brynhild.ezrealxie.csuftsims.dao.UserDAO;
import org.dom4j.*;
import com.brynhild.ezrealxie.csuftsims.utils.XmlUtils;

import com.brynhild.ezrealxie.csuftsims.domain.User;

public class UserDAOimpl implements UserDAO{

	@Override
	public User find(String usernameString, String passwordString) {
		// TODO Auto-generated method stub
		
		try {
			
			org.dom4j.Document document = XmlUtils.getDocument();
			Element element = (Element) document.selectSingleNode("//uesr[@usernameString='" + usernameString + "'and @passwordString'" + passwordString + "']");
			
			if (element == null) {
				
				return null;
				
			}
			
			User user = new User();
			
			user.setID(element.attributeValue("uid"));
			user.setUsername(element.attributeValue("usernameString"));
			user.setPassword(element.attributeValue("passwordString"));
			
			return user;
			
		} catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException(e);
		}
	}

	@Override
	public void add(User user) {
		// TODO Auto-generated method stub
		
		try {
			org.dom4j.Document document = XmlUtils.getDocument();
			Element root = document.getRootElement();
			
			root.addElement("user").addAttribute("uidString", user.getID())
            .addAttribute("usernameString", user.getUsername())
            .addAttribute("passwordString", user.getPassword());
			
			XmlUtils.write2Xml(document);
		} catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException(e);
		}
		
	}

	@Override
	public boolean find(String usernameString) {
		// TODO Auto-generated method stub
		
		try {
			
			org.dom4j.Document document = XmlUtils.getDocument();
			Element element = (Element) document.selectSingleNode("//user[@usernameString='" + usernameString + "']");
			
			if (element == null) {
				
				return false;
				
			}
			
			return true;
			
		} catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException(e);
		}
	}
	
	

}
