package com.ngbs.company.models;


import jakarta.persistence.*;
import lombok.Data;

@Data // Lombok annotation to generate getters, setters, equals, hashcode, and toString
@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Auto-generated ID

    private String code;
    private String name;
    private String description;
    private String image;
    private String category;
    private Double price;
    private Integer quantity;
    private String internalReference;
    private Integer shellId;

    @Enumerated(EnumType.STRING)
    private InventoryStatus inventoryStatus; // Enum for product status

    private Double rating;

    private Long createdAt; // Timestamp
    private Long updatedAt; // Timestamp

    // Enum for Inventory Status
    public enum InventoryStatus {
        INSTOCK,
        LOWSTOCK,
        OUTOFSTOCK
    }
}
