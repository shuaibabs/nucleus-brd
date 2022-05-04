package brd.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import javax.validation.Valid;

import brd.model.MasterCustomer;
import brd.model.TempCustomer;
import brd.service.MasterCustomerService;
import brd.service.TempCustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
@Controller
public class TempCustomerController {
    @Autowired
    TempCustomerService tempCustomerService;
    @Autowired
    MasterCustomerService masterCustomerService;
    @RequestMapping("/addCustomerForm")
    public String getAccForm(Model m)
    {
        m.addAttribute("addCustomer", new TempCustomer());
        return "pages/maker/addCustomerForm";
    }

    @RequestMapping(value="/save",method = RequestMethod.POST)
    public String save(@Valid @ModelAttribute("addCustomer") TempCustomer temp, BindingResult result){
        if (result.hasErrors())
        {
            return "pages/maker/addCustomerForm";
        }
        temp.setRecord_status("N");
        temp.setCreate_date(new Date());
        tempCustomerService.insertTempCustomer(temp);
        return "redirect:home";
    }

    @RequestMapping("/home")
    public String home(Model m)
    {
        List<TempCustomer> list=tempCustomerService.getAllTempCustomers();
        m.addAttribute("list", list);
        return "pages/home";
    }

    @RequestMapping("/showTempCustomers")
    public String showTempCustomers(Model m)
    {
        List<TempCustomer> tempList=tempCustomerService.getAllTempCustomers();
        m.addAttribute("tempList", tempList);
        return "pages/checker/showTempCustomers";
    }

    @RequestMapping(value="/editCustomer")
    public String edit(@RequestParam("id") String id, Model m){
        TempCustomer customer=tempCustomerService.getTempCustomerById(id);
        m.addAttribute("customer",customer);
        return "pages/maker/editCustomerForm";
    }

    @RequestMapping(value="/editSave",method = RequestMethod.POST)
    public String editSave(@Valid @ModelAttribute("customer") TempCustomer temp, BindingResult result ){
        if (result.hasErrors())
        {
            return "pages/maker/editCustomerForm";
        }
        if(temp.getRecord_status().equals("N") || temp.getRecord_status().equals("MR") || temp.getRecord_status().equals("NR"))
        {
            TempCustomer obj = new TempCustomer();
            obj = tempCustomerService.getTempCustomerById(temp.getCustomer_code());
            temp.setRecord_status("M");
            temp.setCreate_date(obj.getCreate_date());
            temp.setModified_date(new Date());
            tempCustomerService.updateTempCustomer(temp);
        }
        return "redirect:/home";
    }

    @RequestMapping(value="/deleteCustomer",method = RequestMethod.GET)
    public String delete(@RequestParam String id){
        TempCustomer ac= tempCustomerService.getTempCustomerById(id);
        tempCustomerService.deleteTempCustomer(ac);
        return "redirect:/home";
    }

    @RequestMapping("/showMasterCustomersToEdit")
    public String showMasterCustomersToEdit(Model m)
    {
        List<MasterCustomer> masterList=masterCustomerService.getAllMasterCustomers();
        m.addAttribute("masterList", masterList);
        return "pages/maker/showMasterCustomersToEdit";
    }


    @RequestMapping(value="/editMasterCustomerForm")
    public String editMasterCustomer(@RequestParam("id") String id, Model m){
        MasterCustomer masterCustomer=masterCustomerService.getMasterCustomerById(id);
        m.addAttribute("masterCustomer",masterCustomer);
        return "pages/maker/editMasterCustomerForm";
    }

    @RequestMapping(value="/editMasterSave",method = RequestMethod.POST)
    public String editMasterSave(@Valid @ModelAttribute("masterCustomer") MasterCustomer master, BindingResult result ){
        if (result.hasErrors())
        {
            return "pages/maker/editMasterCustomerForm";
        }
        if(master.getRecord_status().equals("A"))
        {
            TempCustomer temp = new TempCustomer();
            MasterCustomer obj = masterCustomerService.getMasterCustomerById(master.getCustomer_code());
            temp.setCustomer_code(master.getCustomer_code());
            temp.setCustomer_id(master.getCustomer_id());
            temp.setCustomer_name(master.getCustomer_name());
            temp.setCustomer_address_1(master.getCustomer_address_1());
            temp.setCustomer_address_2(master.getCustomer_address_2());
            temp.setCustomer_pincode(master.getCustomer_pincode());
            temp.setEmail_address(master.getEmail_address());
            temp.setContact_number(master.getContact_number());
            temp.setPrimary_contact_person(master.getPrimary_contact_person());
            temp.setRecord_status("AM");
            temp.setActive_inactive_flag(master.getActive_inactive_flag());
            temp.setCreate_date(obj.getCreate_date());
            temp.setCreated_by(master.getCreated_by());
            temp.setModified_date(new Date());
            temp.setModified_by(master.getModified_by());
            tempCustomerService.insertTempCustomer(temp);
        }
        return "redirect:/home";
    }

}
