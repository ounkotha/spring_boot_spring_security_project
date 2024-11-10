package entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Oli-Un-Nahar Asha
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "product")
public class Product extends CommonColumn{

    @Column(name = "product_code")
    private String productCode;
    @Column(name = "product_name")
    private String product_name;
    @Column(name = "product_category")
    private String productCategory;
    @Column(name = "product_sub_category")
    private String productSubCategory;
    @Column(name = "price")
    private Double price;
    @Column(name = "discount")
    private Double discount;
    @Column(name = "available_stock")
    private Long availableStock;

}
