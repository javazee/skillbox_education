import javax.persistence.*;
import java.util.Date;

@Entity
@AssociationOverrides({
        @AssociationOverride(name = "primaryKey.course",
                joinColumns = @JoinColumn(name = "course_id" )),
        @AssociationOverride(name = "primaryKey.student",
                joinColumns = @JoinColumn(name = "student_id"))})
@Table(name = "subscriptions")
public class Subscription {

    private SubscriptionId primaryKey = new SubscriptionId();

    @Column(name = "subscription_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date subscription_date;

    public Subscription(){
    }

    @EmbeddedId
    public SubscriptionId getPrimaryKey() {
        return primaryKey;
    }

    public void setPrimaryKey(SubscriptionId primaryKey) {
        this.primaryKey = primaryKey;
    }

    @Transient
    public Course getCourse(){
        return primaryKey.getCourse();
    }

    public void setCourse(Course course){
        getPrimaryKey().setCourse(course);
    }

    @Transient
    public Student getStudent(){
        return primaryKey.getStudent();
    }

    public void setStudent(Student student){
        getPrimaryKey().setStudent(student);
    }

    @Temporal(TemporalType.TIMESTAMP)
    public Date getSubscription_date() {
        return subscription_date;
    }

    public void setSubscription_date(Date subscription_date) {
        this.subscription_date = subscription_date;
    }
}
