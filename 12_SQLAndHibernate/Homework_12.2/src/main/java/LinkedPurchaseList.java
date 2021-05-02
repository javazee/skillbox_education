import javax.persistence.*;

@Entity
@Table(name = "linkedpurchaselist")
public class LinkedPurchaseList {

    private PurchaseListId id = new PurchaseListId();

    @Column(name = "student_id")
    private int studentId;

    @Column(name = "course_id")
    private int courseId;

    @EmbeddedId
    public PurchaseListId getId() {
        return id;
    }

    public void setId(PurchaseListId id) {
        this.id = id;
    }

    @Transient
    public int getCourseId(){
        return id.getCourse().getId();
    }

    public void setCourseId(int id){
        this.courseId = id;
    }

    @Transient
    public int getStudentId(){
        return id.getStudent().getId();
    }

    public void setStudentId(int id){
        this.studentId = id;
    }

}
