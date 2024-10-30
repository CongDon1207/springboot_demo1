package vn.iotstar.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Products")
public class Product implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;

    @Column(name = "product_name", length = 200, columnDefinition = "nvarchar(200) not null")
    @NotEmpty(message = "Product name is required")
    private String name;

    @Column(name = "price")
    @NotNull(message = "Price is required")
    private Double price;

    @Column(columnDefinition = "nvarchar(500)")
    private String description;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "image", columnDefinition = "nvarchar(500)")
    private String image;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
    
    @Transient
    private boolean isEdit = false;
}
