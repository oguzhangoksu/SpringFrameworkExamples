package com.haydikodlayalim.dto;

import java.util.List;

import lombok.Data;


@Data
public class UserDto {
    private Long id;
    private String name;
    private String sirname;
    private List<String> addressList;
}
