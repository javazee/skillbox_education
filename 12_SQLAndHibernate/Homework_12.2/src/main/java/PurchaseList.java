import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "Purchaselist")
@IdClass(PurchaseList.PurchaseId.class)
public class PurchaseList {

    @Id
    @Column(name = "student_name")
    @Getter
    @Setter
    private String studentName;

    @Id
    @Column(name = "course_name")
    @Getter
    @Setter
    private String courseName;

    @Getter
    @Setter
    private int price;

    @Column(name = "subscription_date")
    @Temporal(TemporalType.TIMESTAMP)
    @Getter
    @Setter
    private Date subscriptionDate;

    @EqualsAndHashCode
    @ToString
    public static class PurchaseId implements Serializable{
        @Getter
        @Setter
        private String studentName;

        @Getter
        @Setter
        private String courseName;
    }
}
