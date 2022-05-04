package brd.service;

import brd.model.TempCustomer;
import java.util.List;

public interface TempCustomerService {
    public void insertTempCustomer(TempCustomer temp);
    public void updateTempCustomer(TempCustomer temp);
    public void deleteTempCustomer (TempCustomer temp);
    public TempCustomer getTempCustomerById(String customer_code);
    public List<TempCustomer> getAllTempCustomers();

}