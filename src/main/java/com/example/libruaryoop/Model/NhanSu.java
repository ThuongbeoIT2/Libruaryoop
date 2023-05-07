package com.example.libruaryoop.Model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.List;

//To suppress serializing properties with null values
@JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL)
//Ignoring new fields on JSON objects
@JsonIgnoreProperties(ignoreUnknown = true)
@Entity(name = "nhan_su")
@Data
public class NhanSu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long user_id;
    @Column(nullable = false)
    private String Username;
    @Column(nullable = false)
    private String Password;
    @Column(nullable = false)
    private String Role;
    @Column(nullable = false)
    private String hoTen;
    @Column(nullable = false)
    private String soDienThoai;

    @Column(name = "`checkUser`")
    private boolean checkUser;
    /////
}


