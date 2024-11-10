package entity;

import com.securitygateway.loginandsignup.configuration.AppDate;
import com.securitygateway.loginandsignup.configuration.SpringSecurityUtil;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Oli-Un-Nahar Asha
 */
public class AuditEntityListener {
    private static final Logger log = (Logger) LoggerFactory.getLogger(AuditEntityListener.class);

    @Autowired
    private SpringSecurityUtil springSecurityUtil;

    @PrePersist
    public void prePersist(CommonColumn e) {
        try {
            if (e.getCreatedBy() == null) {
                e.setCreatedBy(springSecurityUtil.getLoggedInUserId());
                e.setUpdatedBy(springSecurityUtil.getLoggedInUserId());
            }
            if (e.getCreatedAt() == null) {
                e.setCreatedAt(AppDate.now());
                e.setUpdatedAt(AppDate.now());
            }
        } catch (Exception ex) {
            log.error("Exception in Audit Entity Listener", ex);
        }
    }


    @PreUpdate
    public void preUpdate(CommonColumn e) {
        try {
            if (e.getUpdatedBy() == null) {
              //  e.setUpdatedBy(springSecurityUtil.getLoggedInUserId());
            }
            if (e.getUpdatedAt() == null) {
              //  e.setUpdatedAt(AppDate.now());
            }
        } catch (Exception ex) {
            log.error("Exception in Audit Entity Listener", ex);
        }
    }
}
