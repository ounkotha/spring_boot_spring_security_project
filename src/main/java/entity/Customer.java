package entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

/**
 * @author Oli-Un-Nahar Asha
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "customer")
public class Customer extends CommonColumn{

    @Column(name = "pin")
    private String pin;

    @Column(name = "name")
    private String name;

    @Column(name = "member_ship_code")
    private String memberShipCode;
    @OneToMany(mappedBy = "customer", fetch = FetchType.LAZY)
    private List<Order> orderList;


}
