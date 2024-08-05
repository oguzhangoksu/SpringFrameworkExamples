package com.haydikodlayalim.Service.abstracts;
import java.util.List;

import com.haydikodlayalim.entity.User;

public interface IUserService {

    public List<User> getByCustomQuery(String search);
    public User save(User user);
    public void deleteById(String id);
    public List<User> findByNameLikeOrSurnameLike(String search);
}
