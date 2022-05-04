package brd.controller;

import java.util.List;
import brd.model.MasterCustomer;
import brd.model.TempCustomer;
import brd.service.MasterCustomerService;
import brd.service.TempCustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
@Controller
public class MasterCustomerController {
    @Autowired
    MasterCustomerService masterCustomerService;
    @Autowired
    TempCustomerService tempCustomerService;
    @RequestMapping("/showMasterCustomers")
    public String showAllLogAcc(Model m)
    {
        List<MasterCustomer> masterList = masterCustomerService.getAllMasterCustomers();
        m.addAttribute("masterList", masterList);
        return "pages/checker/showMasterCustomers";
    }
    @RequestMapping(value="/reject",method = RequestMethod.GET)
    public String reject(@RequestParam String id){
        TempCustomer ac= tempCustomerService.getTempCustomerById(id);
        if(ac.getRecord_status().equals("N")) {
            ac.setRecord_status("NR");
            tempCustomerService.updateTempCustomer(ac);
        }
        else if(ac.getRecord_status().equals("M"))
        {
            ac.setRecord_status("MR");
            tempCustomerService.updateTempCustomer(ac);
        }
        return "redirect:/home";
    }
    @RequestMapping(value="/approve",method = RequestMethod.GET)
    public String approve(@RequestParam String id){
        TempCustomer tc= tempCustomerService.getTempCustomerById(id);
        if(tc.getRecord_status().equals("N") || tc.getRecord_status().equals("M"))
        {
            MasterCustomer mc = new MasterCustomer();
            mc.setCustomer_code(tc.getCustomer_code());
            mc.setCustomer_id(tc.getCustomer_id());
            mc.setCustomer_name(tc.getCustomer_name());
            mc.setCustomer_address_1(tc.getCustomer_address_1());
            mc.setCustomer_address_2(tc.getCustomer_address_2());
            mc.setCustomer_pincode(tc.getCustomer_pincode());
            mc.setEmail_address(tc.getEmail_address());
            mc.setContact_number(tc.getContact_number());
            mc.setPrimary_contact_person(tc.getPrimary_contact_person());
            mc.setRecord_status("A");
            mc.setActive_inactive_flag(tc.getActive_inactive_flag());
            mc.setCreate_date(tc.getCreate_date());
            mc.setCreated_by(tc.getCreated_by());
            mc.setModified_date(tc.getModified_date());
            mc.setModified_by(tc.getModified_by());
            tempCustomerService.deleteTempCustomer(tc);
            System.out.println();
            masterCustomerService.insertMasterCustomer(mc);
        }
        else if(tc.getRecord_status().equals("AM"))
        {
            MasterCustomer mc = new MasterCustomer();
            mc.setCustomer_code(tc.getCustomer_code());
            mc.setCustomer_id(tc.getCustomer_id());
            mc.setCustomer_name(tc.getCustomer_name());
            mc.setCustomer_address_1(tc.getCustomer_address_1());
            mc.setCustomer_address_2(tc.getCustomer_address_2());
            mc.setCustomer_pincode(tc.getCustomer_pincode());
            mc.setEmail_address(tc.getEmail_address());
            mc.setContact_number(tc.getContact_number());
            mc.setPrimary_contact_person(tc.getPrimary_contact_person());
            mc.setRecord_status("A");
            mc.setActive_inactive_flag(tc.getActive_inactive_flag());
            mc.setCreate_date(tc.getCreate_date());
            mc.setCreated_by(tc.getCreated_by());
            mc.setModified_date(tc.getModified_date());
            mc.setModified_by(tc.getModified_by());
            tempCustomerService.deleteTempCustomer(tc);
            masterCustomerService.updateMasterCustomer(mc);
        }
        return "redirect:/home";
    }
}
