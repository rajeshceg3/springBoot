package com.user;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@NoArgsConstructor
@RequiredArgsConstructor
@Table(name = "users")
public class user{
    @Id
    @GeneratedValue
    private Long id;

    @NonNull
    private String name;
}