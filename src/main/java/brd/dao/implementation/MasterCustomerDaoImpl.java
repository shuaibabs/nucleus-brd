package brd.dao.implementation;
import brd.dao.MasterCustomerDao;
import brd.model.MasterCustomer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("MasterCustomerDao")
public class MasterCustomerDaoImpl implements MasterCustomerDao {
    @Autowired
    SessionFactory sessionFactory;
    @Override
    public void insertMasterCustomer(MasterCustomer master) {
        Session session=sessionFactory.getCurrentSession();
        String id = (String) session.save(master);
    }
    @Override
    public void updateMasterCustomer(MasterCustomer ac) {
        Session session = sessionFactory.getCurrentSession();
        session.update(ac);
    }
    @Override
    public void deleteMasterCustomer(String customer_code) {
        MasterCustomer ob =  getMasterCustomerById(customer_code);
        Session session = sessionFactory.getCurrentSession();
        session.delete(ob);
    }
    @Override
    public MasterCustomer getMasterCustomerById(String customer_code) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        MasterCustomer ac=session.get(MasterCustomer.class,customer_code);
        session.getTransaction().commit();
        return ac;
    }
    @Override
    public List<MasterCustomer> getAllMasterCustomers() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Query<MasterCustomer> query = session.createQuery("FROM  MasterCustomer", MasterCustomer.class);
        List<MasterCustomer> list = query.getResultList();
        session.getTransaction().commit();
        return list;
    }
}
