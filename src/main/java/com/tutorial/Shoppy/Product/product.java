package com.tutorial.Shoppy.Product;

import jakarta.persistence.*;

@Entity
@Table
public class product {
    @Id
//    @SequenceGenerator(
//            name = "product_sequence",
//            sequenceName = "product_sequence",
//            allocationSize = 1
//    )
    @Column(name = "id", length = 45)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "user_email", length = 255)
    private String email;
    @Column(name = "product_name", length = 255)
    private String name;
    @Column(name = "product_description", length = 255)
    private String description;

    public product(Long id, String email, String name, String description) {
        this.id = id;
        this.email = email;
        this.name = name;
        this.description = description;
    }

    public product(String email, String name, String description) {
        this.email = email;
        this.name = name;
        this.description = description;
    }

    public product(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "product{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
