package brd.dao.implementation;

import java.util.List;

import brd.dao.TempCustomerDao;
import brd.model.TempCustomer;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
@Repository("TempCustomerDao")
public class TempCustomerDaoImpl implements TempCustomerDao {
    @Autowired
    private SessionFactory sessionFactory;
    @Override
    public void insertTempCustomer(TempCustomer temp) {
        Session session = sessionFactory.getCurrentSession();
        String id = (String) session.save(temp);
    }
    @Override
    public void updateTempCustomer(TempCustomer temp) {
        Session session = sessionFactory.getCurrentSession();
        session.update(temp);
    }
    @Override
    public void deleteTempCustomer(String customer_code) {
        TempCustomer ob =  getTempCustomerById(customer_code);
        Session session = sessionFactory.getCurrentSession();
        session.delete(ob);
    }
    @Override
    public TempCustomer getTempCustomerById(String customer_code) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        TempCustomer ac=session.get(TempCustomer.class,customer_code);
        session.getTransaction().commit();
        return ac;
    }
    @Override
    public List<TempCustomer> getAllTempCustomers() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Query<TempCustomer> query = session.createQuery("FROM  TempCustomer", TempCustomer.class);
        List<TempCustomer> list = query.getResultList();
        session.getTransaction().commit();
        return list;
    }
}
