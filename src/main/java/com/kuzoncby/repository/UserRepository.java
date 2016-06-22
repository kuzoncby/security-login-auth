package com.kuzoncby.repository;

import com.kuzoncby.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

/**
 * Created by Kuzon on 2016/6/23.
 */
public interface UserRepository extends CrudRepository<User, Long> {

    User findByEmail(String email);

}
