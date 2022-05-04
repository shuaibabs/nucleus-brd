package brd.dao;

import brd.model.MasterCustomer;
import java.util.List;

public interface MasterCustomerDao {
    public void insertMasterCustomer(MasterCustomer master);
    public  void updateMasterCustomer(MasterCustomer master);
    public  void deleteMasterCustomer(String customer_code);
    public MasterCustomer getMasterCustomerById(String customer_code);
    public List<MasterCustomer> getAllMasterCustomers();
}
