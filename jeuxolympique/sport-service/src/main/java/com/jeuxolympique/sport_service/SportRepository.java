package com.jeuxolympique.sport_service;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
public interface SportRepository extends CrudRepository<Sport, String>{
}
