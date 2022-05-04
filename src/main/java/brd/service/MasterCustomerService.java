package brd.service;

import brd.model.MasterCustomer;

import java.util.List;

public interface MasterCustomerService {
    public void insertMasterCustomer(MasterCustomer temp);
    public void updateMasterCustomer(MasterCustomer temp);
    public void deleteMasterCustomer (MasterCustomer temp);
    public MasterCustomer getMasterCustomerById(String customer_code);
    public List<MasterCustomer> getAllMasterCustomers();

}