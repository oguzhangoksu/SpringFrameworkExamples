package com.haydikodlayalim.entity;
import java.io.Serializable;


import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.ManyToOne;




@Entity
@Table(name = "user_address")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = {"id"})
@ToString

public class Address implements Serializable{

    @Id
   
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //@SequenceGenerator(name = "address_id_seq",allocationSize=1 )
    private Long id;
    
    @Column(length = 500,name="address")
    private String address;

    @Enumerated
    private addressType addressType;
    public enum addressType{
        HOME_ADDRESS,
        WORK_ADDRESS,
        OTHER
    }


    @Column(name = "is_active")
    private Boolean isActive;
    

    @ManyToOne
    @JoinColumn(name = "user_address_id")
    private User user;
}