package com.company.gamestore.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "console")
public class Console implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "console_id")
    private int id;

    @NotEmpty(message = "You must supply a value for model.")
    @Size(max = 50, message = "You must supply a value less than 50 characters.")
    private String model;
    @NotEmpty(message = "You must supply a value for manufacturer.")
    @Size(max = 50, message = "You must supply a value less than 50 characters.")
    private String manufacturer;
    @Size(max = 20, message = "You must supply a value less than 20 characters.")
    private String memory_amount;
    @Size(max = 20, message = "You must supply a value less than 20 characters.")
    private String processor;
    @Column(precision = 5, scale = 2)
    private BigDecimal price;

    @Min(value = 0, message = "Quantity cannot be negative.")
    private int quantity;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getMemory_amount() {
        return memory_amount;
    }

    public void setMemory_amount(String memory_amount) {
        this.memory_amount = memory_amount;
    }

    public String getProcessor() {
        return processor;
    }

    public void setProcessor(String processor) {
        this.processor = processor;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Console console = (Console) o;
        return id == console.id && quantity == console.quantity && Objects.equals(model, console.model) && Objects.equals(manufacturer, console.manufacturer) && Objects.equals(memory_amount, console.memory_amount) && Objects.equals(processor, console.processor) && Objects.equals(price, console.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, model, manufacturer, memory_amount, processor, price, quantity);
    }

    @Override
    public String toString() {
        return "Console{" +
                "id=" + id +
                ", model='" + model + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                ", memory_amount='" + memory_amount + '\'' +
                ", processor='" + processor + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                '}';
    }
}
