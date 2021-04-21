import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private int age;

    @Column(name = "registration_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date registrationDate;

    @OneToMany(mappedBy = "primaryKey.course",
            cascade = CascadeType.ALL)
    @ElementCollection(targetClass=Subscription.class)
    private Set<Subscription> subscriptions = new HashSet<>();

    public void addCourse (Subscription course){
        this.subscriptions.add(course);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Temporal(TemporalType.TIMESTAMP)
    public Date getDate() {
        return registrationDate;
    }

    public void setDate(Date date) {
        this.registrationDate = date;
    }

    public Set<Subscription> getSubscriptions() {
        return subscriptions;
    }

    public void setSubscriptions(Set<Subscription> subscriptions) {
        this.subscriptions = subscriptions;
    }

    public void addSubscription (Subscription subscription){
        this.subscriptions.add(subscription);
    }
}
