package tma.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import tma.model.SmartPhone;

@Service("smartPhoneSerVice")
public class SmartPhoneServiceImpl implements SmartPhoneService{

	@Autowired
	SmartPhoneRepository smartPhoneRepository;
	
	
	@Override
	public void sendSmartPhone(SmartPhone smartPhone) {
		smartPhoneRepository.putSmartPhone(smartPhone);
	}
	
	@Override
	public void updateSmartPhone(SmartPhone smartPhoneUpdate) {
		smartPhoneRepository.updateSmartPhone(smartPhoneUpdate);
	}
	
	@Override
	public void deleteById(String idSmartPhone) {
		Query queryId = new Query(Criteria.where("_id").is(idSmartPhone));
		smartPhoneRepository.deleteSmartPhoneById(queryId);
	}
	
	
	public List<SmartPhone> getAllSmartPhone(){
		return smartPhoneRepository.getAllSmartPhones();
	}
	
	@Override
	public SmartPhone getSmartPhoneById(String idSmartPhone) {		
		Query QueryGetId = new Query(Criteria.where("_id").is(idSmartPhone));
		return smartPhoneRepository.getSmartPhoneById(QueryGetId);
	}
	
	@Override
	public void deleteAllSmartPhones() {		
		smartPhoneRepository.deleteAllSmartPhones();
	}
	
}
