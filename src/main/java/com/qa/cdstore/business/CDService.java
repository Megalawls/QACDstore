package com.qa.cdstore.business;

public interface CDService {
	String getAllCDs();

	String getCD(Long id);
  
    String createCD(String cd);

	String updateCD(Long id, String cd);

	String deleteCD(Long id);

	String deleteAll();
}
