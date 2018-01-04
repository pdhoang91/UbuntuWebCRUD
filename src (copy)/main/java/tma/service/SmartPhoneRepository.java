package tma.service;

import java.util.List;

import org.springframework.data.mongodb.core.query.Query;

import tma.model.SmartPhone;

public interface SmartPhoneRepository {
	

	public void putSmartPhone(SmartPhone smartPhone);
	
	public SmartPhone getSmartPhoneById(Query queryGetId);
	
	public void updateSmartPhone(SmartPhone smartPhoneUpdate);
	
	public Object deleteSmartPhoneById(Query queryId);
	
	public void deleteAllSmartPhones();
	
	public List<SmartPhone> getAllSmartPhones();
	

	
	
}
