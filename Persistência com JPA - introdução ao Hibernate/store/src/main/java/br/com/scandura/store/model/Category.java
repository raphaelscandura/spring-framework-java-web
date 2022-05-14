package br.com.scandura.store.model;

import javax.persistence.*;

@Entity
@Table(name="products")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    public Category(String name) {
        this.name = name;
    }
}
