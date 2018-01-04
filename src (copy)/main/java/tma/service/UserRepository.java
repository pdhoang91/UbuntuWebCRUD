package tma.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import tma.model.UserModelDetails;

@Service("userRepositoryDao")
public class UserRepository{
	
	@Autowired
	private MongoTemplate mongoTemplate;

	public UserModelDetails getUserByUsername(String username) {
		Query QueryGetUsername = new Query(Criteria.where("username").is(username));
		return mongoTemplate.findOne(QueryGetUsername,UserModelDetails.class);
	}

}