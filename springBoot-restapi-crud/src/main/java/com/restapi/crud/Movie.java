package com.restapi.crud;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document( collection = "MovieDB")
public class Movie{
    @Id 
    private long id;

    @NotBlank
    @Size(max = 100)
    @Indexed(unique = true)
    private String name;
    @Size(max = 500) // Added validation for description
    private String description;

    public long getId(){
        return id;
    }   

    public void setId(long id){
        this.id = id;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getDescription(){
        return description;
    }

    public void setDescription( String description ){
        this.description = description;
    }

}