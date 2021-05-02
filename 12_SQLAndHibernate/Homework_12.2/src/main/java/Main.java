import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().
                configure("hibernate.cfg.xml").build();
        Metadata metadata = new MetadataSources(registry).getMetadataBuilder().build();
        SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();
        Session session = sessionFactory.openSession();
        String query = "From PurchaseList";
        @SuppressWarnings("unchecked")
        List<PurchaseList> purchaseList = session.createQuery(query).list();
        for (PurchaseList purchase: purchaseList) {
            Transaction transaction = session.beginTransaction();
            String studentName = purchase.getStudentName();
            String courseName = purchase.getCourseName();
            Student student = (Student) session.createQuery("From " + Student.class.getSimpleName() + " where name = '" + studentName + "'").getSingleResult();
            Course course = (Course) session.createQuery("From " + Course.class.getSimpleName() + " where name = '" + courseName + "'").getSingleResult();
            LinkedPurchaseList linkedPurchase = new LinkedPurchaseList();
            linkedPurchase.getId().setStudent(student);
            linkedPurchase.getId().setCourse(course);
            linkedPurchase.setStudentId(student.getId());
            linkedPurchase.setCourseId(course.getId());
            session.save(linkedPurchase);
            transaction.commit();
    }

        @SuppressWarnings("unchecked")
        List<Subscription> subscriptions = session.createQuery("From Subscription").setMaxResults(5).list();
        for (Subscription subscription: subscriptions){
            System.out.println(subscription.getPrimaryKey().getStudent().getName() + " купил курс \"" + subscription.getPrimaryKey().getCourse().getName() + "\" " + subscription.getSubscriptionDate());
        }

        @SuppressWarnings("unchecked")
        List<PurchaseList> purchases = session.createQuery("From PurchaseList").setMaxResults(5).list();
        for(PurchaseList purchase: purchases){
            System.out.println(purchase.getCourseName() + ": " + purchase.getPrice() + " руб." + purchase.getSubscriptionDate());
        }
        session.close();
        sessionFactory.close();
    }
}
