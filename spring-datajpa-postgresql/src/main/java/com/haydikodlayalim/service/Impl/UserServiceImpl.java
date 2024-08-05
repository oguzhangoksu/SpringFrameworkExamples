package com.haydikodlayalim.service.Impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.haydikodlayalim.dto.UserDto;
import com.haydikodlayalim.entity.Address;
import com.haydikodlayalim.entity.User;
import com.haydikodlayalim.repo.AddressRepository;
import com.haydikodlayalim.repo.UserRepository;
import com.haydikodlayalim.service.UserService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{
    
    
    private final UserRepository userRepository;
    private final AddressRepository addressRepository;



    @Override
    @Transactional // Bu işlemi bir transaction içinde yapar. Eğer bir hata olursa geri alır.
    public UserDto save(UserDto userDto) {
        //Assert.isNull(userDto.getName(), "Name is required");

        User user = new User();
        user.setName(userDto.getName());
        user.setSirname(userDto.getSirname());
        final User userdb =userRepository.save(user);
        java.util.List<Address> addressList = new ArrayList<>();
        userDto.getAddressList().forEach(item ->{
            Address address = new Address();
            address.setAddress(item);
            address.setAddressType(Address.addressType.OTHER);;
            address.setIsActive(true);
            address.setUser(userdb);
            addressList.add(address);
        });
        addressRepository.saveAll(addressList);
        userDto.setId(user.getId());
        return userDto;
    }
    
    @Override
    public void delete(Long id) {
        
    }
    @Override
    public Page<UserDto> getAll(Pageable pageable) {
        return null;
    }
    @Override
    public List<UserDto> getAll() {
        List<User> users=userRepository.findAll();
        List<UserDto> userDtos = new ArrayList<>(); 
        users.forEach(item ->{
            UserDto userDto = new UserDto();
            userDto.setId(item.getId());
            userDto.setName(item.getName());
            userDto.setSirname(item.getSirname());
            List<String> addressList = new ArrayList<>();
            item.getAddressList().forEach(address ->{
                addressList.add(address.getAddress());
            });
            userDto.setAddressList(addressList);
            userDtos.add(userDto);
        });
        return userDtos;
    }

    
}
