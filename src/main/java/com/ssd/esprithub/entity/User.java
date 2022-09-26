package com.ssd.esprithub.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.Set;

import javax.persistence.*;

@Entity
@Data
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "email")
    private String email;
    @Column(name = "password")
    private String password;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    @Column(name = "address")
    private String address;
    @Column(name = "phone")
    private Long phone;
    @Column(name = "locked")
    private Boolean locked = false;
    @Column(name = "enabled")
    private Boolean enabled = false;
    @Column(name = "aboutme")
    private String aboutMe;
    @Column (name="photo")
    private String image;
    @Column(name="createdAt")
    private LocalDateTime createdat;
    @Enumerated(EnumType.STRING)
    private  Role role;
    @Enumerated(EnumType.STRING)
    private  Niveau niveau; 

    
    @OneToMany(mappedBy = "sender")
    private Set<Chat> chatsender;
    @OneToMany(mappedBy = "receiver")
    private Set<Chat> chatreceiver;

    @ManyToOne
    private Options option_id;

    @OneToMany(mappedBy = "userbadges")
    private Set<Badge> badges;

    @OneToMany(mappedBy = "userpoest")
    private Set<Post> posts;



    @OneToMany(mappedBy = "userquestions")
    private Set<Question> questions;


    public User(String firstName, String lastName, String email, String password, Gender gender, String address, Long phone, Role role,LocalDateTime createdAt ) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.gender = gender;
        this.address = address;
        this.phone = phone;
        this.role = role;
        this.createdat=createdAt;

    }

    @Override
    @JsonDeserialize(using = CustomAuthorityDeserializer.class)

    public Collection<? extends GrantedAuthority> getAuthorities() {
        SimpleGrantedAuthority authority = new SimpleGrantedAuthority(role.name());
        return Collections.singletonList(authority) ;
    }

    @Override
    public String getUsername() {
        return email;
    }
    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return !locked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }
}
