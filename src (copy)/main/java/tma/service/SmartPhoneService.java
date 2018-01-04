package tma.service;

import java.util.List;

import tma.model.SmartPhone;

public interface SmartPhoneService {
	
	public void sendSmartPhone(SmartPhone smartPhone);
	
	public void updateSmartPhone(SmartPhone smartPhoneUpdate);
	
	public void deleteById(String idSmartPhone);
	
	public void deleteAllSmartPhones();
	
	public SmartPhone getSmartPhoneById(String idSmartPhone);
	
	public List<SmartPhone> getAllSmartPhone();
	
}
