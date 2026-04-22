package spring_boot.session13bt04.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import spring_boot.session13bt04.model.entity.Medicine;

import java.time.LocalDate;
import java.util.List;

@Repository
public class MedicineRepository {
    @Autowired
    private SessionFactory sessionFactory;

    public List<Medicine> findMedicines(LocalDate day) {
        Session session = sessionFactory.getCurrentSession();
        try {
            return session.createQuery("FROM Medicine m WHERE m.expiryDate < :today")
                    .setParameter("day", day)
                    .getResultList();
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            session.close();
        }
        return null;
    }
}

