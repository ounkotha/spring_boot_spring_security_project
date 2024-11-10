package entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

/**
 * @author Oli-Un-Nahar Asha
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "order")
public class Coupon extends CommonColumn{

    @Column(name = "coupon_code")
    private String couponCode;
    @Column(name = "coupon_name")
    private String couponName;
    @Column(name = "reason")
    private String reason;
    @Column(name = "start_date")
    private Date startDate;
    @Column(name = "end_date")
    private Date endDate;
    @Column(name = "limit")
    private Long limit;

}
