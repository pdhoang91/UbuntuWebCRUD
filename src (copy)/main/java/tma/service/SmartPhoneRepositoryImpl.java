package tma.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import tma.model.SmartPhone;


@Service("smartPhoneRepository")
public class SmartPhoneRepositoryImpl implements SmartPhoneRepository{


	
	   final String COLLECTIONSP = "smartphone";
	@Autowired
	private MongoTemplate mongoTemplate;
	
	@Override
	public void putSmartPhone(SmartPhone smartPhone) {
		mongoTemplate.insert(smartPhone);
	}

	@Override
	public void updateSmartPhone(SmartPhone smartPhoneUpdate) {
		mongoTemplate.save(smartPhoneUpdate);
		
	}
	
	@Override
	public Object deleteSmartPhoneById(Query queryId) {
		return mongoTemplate.remove(queryId,SmartPhone.class);
		
	}
	
	public void deleteAllSmartPhones(){
		 mongoTemplate.remove(new Query(),COLLECTIONSP);	  
	}
	
	@Override
	public SmartPhone getSmartPhoneById(Query QueryGetId) {
		return mongoTemplate.findOne(QueryGetId,SmartPhone.class);
	}
	
	public List<SmartPhone> getAllSmartPhones(){
		return mongoTemplate.findAll(SmartPhone.class);	  
	}

}
