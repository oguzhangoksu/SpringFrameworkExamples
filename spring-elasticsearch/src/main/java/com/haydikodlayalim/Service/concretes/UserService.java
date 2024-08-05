package com.haydikodlayalim.Service.concretes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.haydikodlayalim.Service.abstracts.IUserService;
import com.haydikodlayalim.entity.User;
import com.haydikodlayalim.repository.UserRepository;


import java.util.List;

@Service
public class UserService implements IUserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> getByCustomQuery(String search) {
        
        return userRepository.getByCustomQuery(search);
    }
    @Override
    public User save(User user) {
        return userRepository.save(user);
    }
    @Override
    public void deleteById(String id) {
        userRepository.deleteById(id);
    }
    @Override
    public List<User> findByNameLikeOrSurnameLike(String search) {
        return userRepository.findByNameLikeOrSurnameLike(search, search);
    }


}
