package com.haydikodlayalim.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.haydikodlayalim.dto.UserDto;

public interface UserService {
    UserDto save(UserDto userDto);
    void delete(Long id);
    List<UserDto> getAll();
    Page<UserDto> getAll(Pageable pageable);
}
