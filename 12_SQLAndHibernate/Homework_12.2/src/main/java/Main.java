import org.hibernate.Session;
import org.hibernate.SessionFactory;
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
        String query = "From Course where studentsCount is not null";

        @SuppressWarnings("unchecked")
        List<Course> courses = session.createQuery(query).list();
        for (Course course: courses){
            System.out.println(course.getName() + " - " + course.getStudentsCount() + " студентов");
        }
        sessionFactory.close();
    }
}
