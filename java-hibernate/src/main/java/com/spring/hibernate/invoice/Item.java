package com.spring.hibernate.invoice;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Entity
@Table(name = "ITEMS")
public class Item {
    private int id;
    private String name;
    private BigDecimal price;
    private int quantity;
    private BigDecimal value;
    private Product product;
    private Invoice invoice;

    public Item(String name, BigDecimal price, int quantity, BigDecimal value) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.value = value;
    }

    public Item() {

    }

    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "ITEM_ID", unique = true)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @NotNull
    @Column(name = "ITEM_NAME")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @NotNull
    @Column(name = "ITEM_PRICE")
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @NotNull
    @Column(name = "ITEM_QUANTITY")
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @NotNull
    @Column(name = "ITEM_VALUE")
    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "PRODUCT_ID", referencedColumnName = "PRODUCT_ID")
    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @ManyToOne
    @JoinColumn(name = "INVOICE_ID", nullable = false)
    public Invoice getInvoice() {
        return invoice;
    }

    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                ", value=" + value +
                ", product=" + product +
                '}';
    }
}
