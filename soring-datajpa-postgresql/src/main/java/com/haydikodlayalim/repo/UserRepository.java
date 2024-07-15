package com.haydikodlayalim.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.haydikodlayalim.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
