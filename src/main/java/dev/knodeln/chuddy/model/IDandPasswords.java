package dev.knodeln.chuddy.model;
import java.util.HashMap;

public class IDandPasswords {

	HashMap<String,String> logininfo = new HashMap<String,String>();
	
	IDandPasswords(){
		
		logininfo.put("Hejhå","pizza");
		logininfo.put("Bye","PASSWORD");
		logininfo.put("Plzhelp","abc123");
	}
	
	public HashMap getLoginInfo(){
		return logininfo;
	}
}
