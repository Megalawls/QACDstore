package com.qa.cdstore.business;

public interface CDService {
	String getAllCDs();

	String getCD(Long id);

	String createCD(String movie);

	String updateCD(Long id, String movie);

	String deleteCD(Long id);
}
