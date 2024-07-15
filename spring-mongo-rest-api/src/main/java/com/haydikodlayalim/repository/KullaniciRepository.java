package com.haydikodlayalim.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.haydikodlayalim.entity.Kullanici;


@Repository
public interface KullaniciRepository extends MongoRepository<Kullanici, String>{

}
