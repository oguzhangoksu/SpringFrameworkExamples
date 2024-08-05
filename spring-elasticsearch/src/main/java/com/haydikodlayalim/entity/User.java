package com.haydikodlayalim.entity;

import java.util.Date;

import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import org.springframework.data.annotation.Id;

@Document(indexName = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor


public class User {
    @Id
    private String id;

    @Field(name = "name",type = FieldType.Text)
    private String name;
    @Field(name = "surname",type = FieldType.Text)
    private String surname;
    @Field(name = "address",type = FieldType.Text)
    private String address;
    @Field(name = "birth_date",type = FieldType.Date)
    private Date birthDate;

    
}
