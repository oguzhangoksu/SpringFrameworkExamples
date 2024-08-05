package com.haydikodlayalim.repository;

import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import com.haydikodlayalim.entity.User;

import java.util.List;

@Repository
public interface UserRepository extends ElasticsearchRepository<User, String> {

    @Query("{\"bool\": {\"must\": [{\"match\": {\"name\": \"?0\"}}]}}")
    List<User> getByCustomQuery(String search);

    void deleteById(String name);

    List<User>findByNameLikeOrSurnameLike(String name, String surname);

}