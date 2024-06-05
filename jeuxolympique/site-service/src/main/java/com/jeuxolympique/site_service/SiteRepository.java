package com.jeuxolympique.site_service;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
public interface SiteRepository extends MongoRepository<Site, String>{
	
	
}
