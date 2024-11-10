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
@Table(name = "features")
public class Features extends CommonColumn{
    @Column(name = "feature_name")
    private String featureName;

    @Column(name = "display_name")
    private String displayName;

    @Column(name = "feature_type")
    private String featureType;

    @Column(name = "route")
    private String route;

    @Column(name = "display_order")
    private Integer displayOrder;

    @Column(name = "isActive", columnDefinition = "Boolean default false")
    private Boolean active;

    @Column(name = "controller_name")
    private String controllerName;

    @Column(name = "feature_group_name")
    private String featureGroupName;

}
