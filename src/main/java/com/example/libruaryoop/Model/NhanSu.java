package com.example.libruaryoop.Model;


import com.example.libruaryoop.Email.ValidEmail;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

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
    @ValidEmail
    @Length(min = 5, message = "*Your user name must have at least 5 characters")
    @Email(message = "*Please provide a valid Username")
    @NotEmpty(message = "*Please provide an username")
    @Column(nullable = false)
    private String Username;
    @NotEmpty(message = "*Please provide your password")
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


