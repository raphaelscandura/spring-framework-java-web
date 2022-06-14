package br.com.scandura.store.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "total_price")
    private BigDecimal totalPrice = BigDecimal.ZERO;

    private LocalDateTime date = LocalDateTime.now();

    @ManyToOne
    private Customer customer;

    @OneToMany(mappedBy = "product",cascade = CascadeType.ALL)
    private List<ProductOrder> products = new ArrayList<>();

    public Order(Customer customer) {
        this.customer = customer;
    }

    public Order() {
    }

    public void addProduct(ProductOrder product){
        product.setOrder(this);
        this.products.add(product);
        this.totalPrice = this.totalPrice.add(product.getValue());
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalTrice) {
        this.totalPrice = totalTrice;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
