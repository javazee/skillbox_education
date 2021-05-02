import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "subscriptions")
public class Subscription {

    private SubscriptionId primaryKey = new SubscriptionId();

    @Column(name = "student_id")
    private int studentId;

    @Column(name = "course_id")
    private int courseId;

    @Column(name = "subscription_date")
    @Temporal(TemporalType.TIMESTAMP)
    @Getter
    @Setter
    private Date subscriptionDate;

    @EmbeddedId
    public SubscriptionId getPrimaryKey() {
        return primaryKey;
    }

    public void setPrimaryKey(SubscriptionId primaryKey) {
        this.primaryKey = primaryKey;
    }

    @Transient
    public int getCourseId() {
        return primaryKey.getCourse().getId();
    }

    public void setCourseId(int id) {
        this.courseId = id;
    }

    @Transient
    public int getStudentId() {
        return primaryKey.getStudent().getId();
    }

    public void setStudentId(int id) {
        this.studentId = id;
    }
}

