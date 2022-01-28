package com.pmb.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.pmb.model.UserProfile;

@Repository
public interface UserProfileRepository  extends CrudRepository<UserProfile, Integer> {

}
