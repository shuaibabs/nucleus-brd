package brd.service.implementation;

import brd.dao.TempCustomerDao;
import brd.model.TempCustomer;
import brd.service.TempCustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service("TempCustomerService")
public class TempCustomerServiceImpl implements TempCustomerService {

    @Autowired
    private TempCustomerDao tempCustomerDAO;

    private String msg;
    public TempCustomerServiceImpl() {
        // TODO Auto-generated constructor stub

    }


    @Transactional
    @Override
    public void insertTempCustomer(TempCustomer temp) {
        tempCustomerDAO.insertTempCustomer(temp);
    }



    @Transactional
    @Override
    public void updateTempCustomer(TempCustomer temp) {
        tempCustomerDAO.updateTempCustomer(temp);
    }

    @Transactional
    @Override
    public void deleteTempCustomer(TempCustomer temp) {
        tempCustomerDAO.deleteTempCustomer(temp.getCustomer_code());
    }

    @Override
    public TempCustomer getTempCustomerById(String customer_code) {
        // TODO Auto-generated method stub
        return tempCustomerDAO.getTempCustomerById(customer_code);
    }
    @Override
    public List<TempCustomer> getAllTempCustomers() {
        // TODO Auto-generated method stub
        return tempCustomerDAO.getAllTempCustomers();
    }
}
