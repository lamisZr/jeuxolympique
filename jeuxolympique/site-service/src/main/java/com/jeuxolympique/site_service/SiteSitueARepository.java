package com.jeuxolympique.site_service;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SiteSitueARepository extends MongoRepository<SiteSitueA, String>{
	
	
}
