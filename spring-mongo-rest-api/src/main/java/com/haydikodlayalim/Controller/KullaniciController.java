package com.haydikodlayalim.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.haydikodlayalim.entity.Kullanici;
import com.haydikodlayalim.repository.KullaniciRepository;

import jakarta.annotation.PostConstruct;

@RestController
@RequestMapping("/kullanici")
public class KullaniciController {

    @Autowired
    private KullaniciRepository kullaniciRepository;

    @PostConstruct
    public void init(){
        Kullanici kullanici = new Kullanici();
        kullanici.setAdi("Haydi");
        kullanici.setSoyadi("Kodlayalim");
        kullaniciRepository.save(kullanici);
    }
    
    @PostMapping
    public ResponseEntity<Kullanici> ekle(@RequestBody Kullanici kullanici){
        return ResponseEntity.ok(kullaniciRepository.save(kullanici));

    }

    @GetMapping
    public ResponseEntity<List<Kullanici>> tumunuListele( ){
        return ResponseEntity.ok(kullaniciRepository.findAll());

    }
}
