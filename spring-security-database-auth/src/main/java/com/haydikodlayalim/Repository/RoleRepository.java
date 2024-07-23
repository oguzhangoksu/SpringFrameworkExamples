package com.haydikodlayalim.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.haydikodlayalim.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
    public Role findByRoleName(String roleName);

}
