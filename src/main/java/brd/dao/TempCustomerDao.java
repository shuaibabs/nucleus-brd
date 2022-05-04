package brd.dao;

import brd.model.TempCustomer;

import java.util.List;

public interface TempCustomerDao {
    public  void insertTempCustomer(TempCustomer temp);
    public  void updateTempCustomer(TempCustomer temp);
    public  void deleteTempCustomer(String customer_code);
    public TempCustomer getTempCustomerById(String customer_code);
    public  List<TempCustomer> getAllTempCustomers();
}
