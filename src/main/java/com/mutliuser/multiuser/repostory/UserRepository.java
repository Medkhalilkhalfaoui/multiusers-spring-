package com.mutliuser.multiuser.repostory;


import org.springframework.data.jpa.repository.JpaRepository;

import com.mutliuser.multiuser.models.User;

public interface UserRepository extends JpaRepository<User, java.lang.String> {

	

}
