package brd.service.implementation;

import brd.dao.MasterCustomerDao;
import brd.model.MasterCustomer;
import brd.service.MasterCustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service("MasterCustomerService")
public class MasterCustomerServiceImpl implements MasterCustomerService {

    @Autowired
    MasterCustomerDao masterCustomerDao;

    @Transactional
    @Override
    public void insertMasterCustomer(MasterCustomer master) {
        masterCustomerDao.insertMasterCustomer(master);
    }


    @javax.transaction.Transactional
    @Override
    public void updateMasterCustomer(MasterCustomer master) {
        masterCustomerDao.updateMasterCustomer(master);
    }

    @javax.transaction.Transactional
    @Override
    public void deleteMasterCustomer(MasterCustomer master) {
        masterCustomerDao.deleteMasterCustomer(master.getCustomer_code());
    }

    @Override
    public MasterCustomer getMasterCustomerById(String customer_code) {
        // TODO Auto-generated method stub
        return masterCustomerDao.getMasterCustomerById(customer_code);
    }


    @Override
    public List<MasterCustomer> getAllMasterCustomers() {
        // TODO Auto-generated method stub
        return masterCustomerDao.getAllMasterCustomers();
    }
}
