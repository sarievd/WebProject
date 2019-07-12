package com.dnr.apiservice.repository;

import com.dnr.apiservice.model.PersonBlackList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlackListRepository  extends JpaRepository<PersonBlackList, Long> {
}
