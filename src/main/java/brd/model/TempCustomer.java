package brd.model;

import javax.persistence.*;
import java.util.Date;


@Entity
public class TempCustomer {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "customer_id", updatable = false, nullable = false)
    private int customer_id;
    @Id
    @Column(name="customer_code")
    private String customer_code;

    @Column(name="customer_name")
    private String customer_name;

    @Column(name="customer_address_1")
    private String customer_address_1;

    @Column(name="customer_address_2")
    private String customer_address_2;

    @Column(name="customer_pincode")
    private int customer_pincode;

    @Column(name="email_address")
    private String email_address;

    @Column(name="contact_number")
    private long contact_number;

    @Column(name="primary_contact_person")
    private String primary_contact_person;

    @Column(name="record_status")
    private String record_status;

    @Column(name="active_inactive_flag")
    private String active_inactive_flag;

    @Column(name="create_date")
    private Date create_date;

    @Column(name="created_by")
    private String created_by;

    @Column(name="modified_date")
    private Date modified_date;

    @Column(name="modified_by")
    private String modified_by;


    public TempCustomer() {
        // TODO Auto-generated constructor stub
    }

    public TempCustomer(int customer_id, String customer_code, String customer_name, String customer_address_1, String customer_address_2, int customer_pincode, String email_address, int contact_number, String primary_contact_person, String record_status, String active_inactive_flag, Date create_date, String created_by, Date modified_date, String modified_by) {
        this.customer_id = customer_id;
        this.customer_code = customer_code;
        this.customer_name = customer_name;
        this.customer_address_1 = customer_address_1;
        this.customer_address_2 = customer_address_2;
        this.customer_pincode = customer_pincode;
        this.email_address = email_address;
        this.contact_number = contact_number;
        this.primary_contact_person = primary_contact_person;
        this.record_status = record_status;
        this.active_inactive_flag = active_inactive_flag;
        this.create_date = create_date;
        this.created_by = created_by;
        this.modified_date = modified_date;
        this.modified_by = modified_by;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public String getCustomer_code() {
        return customer_code;
    }

    public void setCustomer_code(String customer_code) {
        this.customer_code = customer_code;
    }

    public String getCustomer_name() {
        return customer_name;
    }

    public void setCustomer_name(String customer_name) {
        this.customer_name = customer_name;
    }

    public String getCustomer_address_1() {
        return customer_address_1;
    }

    public void setCustomer_address_1(String customer_address_1) {
        this.customer_address_1 = customer_address_1;
    }

    public String getCustomer_address_2() {
        return customer_address_2;
    }

    public void setCustomer_address_2(String customer_address_2) {
        this.customer_address_2 = customer_address_2;
    }

    public int getCustomer_pincode() {
        return customer_pincode;
    }

    public void setCustomer_pincode(int customer_pincode) {
        this.customer_pincode = customer_pincode;
    }

    public String getEmail_address() {
        return email_address;
    }

    public void setEmail_address(String email_address) {
        this.email_address = email_address;
    }

    public long getContact_number() {
        return contact_number;
    }

    public void setContact_number(long contact_number) {
        this.contact_number = contact_number;
    }

    public String getPrimary_contact_person() {
        return primary_contact_person;
    }

    public void setPrimary_contact_person(String primary_contact_person) {
        this.primary_contact_person = primary_contact_person;
    }

    public String getRecord_status() {
        return record_status;
    }

    public void setRecord_status(String record_status) {
        this.record_status = record_status;
    }

    public String getActive_inactive_flag() {
        return active_inactive_flag;
    }

    public void setActive_inactive_flag(String active_inactive_flag) {
        this.active_inactive_flag = active_inactive_flag;
    }

    public Date getCreate_date() {
        return create_date;
    }

    public void setCreate_date(Date create_date) {
        this.create_date = create_date;
    }

    public String getCreated_by() {
        return created_by;
    }

    public void setCreated_by(String created_by) {
        this.created_by = created_by;
    }

    public Date getModified_date() {
        return modified_date;
    }

    public void setModified_date(Date modified_date) {
        this.modified_date = modified_date;
    }

    public String getModified_by() {
        return modified_by;
    }

    public void setModified_by(String modified_by) {
        this.modified_by = modified_by;
    }

    @Override
    public String toString() {
        return "Temp{" +
                "customer_id='" + customer_id + '\'' +
                ", customer_code='" + customer_code + '\'' +
                ", customer_name='" + customer_name + '\'' +
                ", customer_address_1='" + customer_address_1 + '\'' +
                ", customer_address_2='" + customer_address_2 + '\'' +
                ", customer_pincode=" + customer_pincode +
                ", email_address='" + email_address + '\'' +
                ", contact_number=" + contact_number +
                ", primary_contact_person='" + primary_contact_person + '\'' +
                ", record_status='" + record_status + '\'' +
                ", active_inactive_flag='" + active_inactive_flag + '\'' +
                ", create_date=" + create_date +
                ", created_by='" + created_by + '\'' +
                ", modified_date=" + modified_date +
                ", modified_by='" + modified_by + '\'' +
                '}';
    }
}
