<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false" %>
      <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
   <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
   <%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="ISO-8859-1" />
        <title>Home</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous" />
        <style>
        .button {
          background-color: #4CAF50; /* Green */
          border: none;
          color: white;
          padding: 15px 32px;
          text-align: center;
          text-decoration: none;
          display: inline-block;
          font-size: 16px;
        }
        * {
            margin: 0px;
            padding: 0;
            font-family: Arial, Helvetica, sans-serif;
        }
        .heading {
            display: flex;
            background-color: #232f3e;
            box-shadow: 0px 1px 2px #232f3e;

        }
        h1 {
            color: coral;
            font-weight: bold;

            background: transparent;
            padding: 7px;

        }
        .outer-wrapper {
            margin: 10px;
            margin-left: 20px;
            margin-right: 20px;
            border: 1px solid black;
            border-radius: 4px;
            box-shadow: 0px 0px 3px rgba(0, 0, 0, 0.9);
            max-width: fit-content;
            max-height: fit-content;
        }
        .table-wrapper {
            overflow-y: scroll;
            overflow-x: scroll;
            height: fit-content;
            max-height: 66.4vh;
            margin-top: 22px;
            margin: 15px;
            padding-bottom: 20px;
        }
        table {
            min-width: max-content;
            border-collapse: separate;
            border-spacing: 0px;
        }
        table th{
            position: sticky;
            top: 0px;
            background-color: #133b5c;
            color: rgb(241, 245, 179);
            text-align: center;
            font-weight: normal;
            font-size: 18px;
            outline: 0.7px solid black;
            border: 1.5px solid black;
        }
        table th, table td {
            padding: 15px;
            padding-top: 10px;
            padding-bottom: 10px;
        }
        table td {
            text-align: left;
            font-size: 15px;
            border: 1px solid rgb(177, 177, 177);
            padding-left: 20px;
        }
        </style>
    </head>
    <body>
        <security:authorize access="hasRole('MAKER')">
            <div class="heading">
                    <h1>MAKER</h1>
                </div>
        </security:authorize>
        <security:authorize access="hasRole('CHECKER')">
            <div class="heading">
                               <h1>CHECKER</h1>
                           </div>
        </security:authorize>
        <br />
        &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
        <security:authorize access="hasRole('CHECKER')">
            <a href="showTempCustomers">Show Temporary Data</a>
            &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
            <a href="showMasterCustomers">Show Permanent Data</a>
        </security:authorize>
         <security:authorize access="hasRole('MAKER')">
                    <a href="addCustomerForm">Add New Account</a>
                    &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
                    <a href="showMasterCustomersToEdit">Show Permanent Data</a>
                </security:authorize>
        <div class="outer-wrapper">
            <div class="table-wrapper">
        <table>
            <tr>
                <th>Customer Code</th>
                <th>Customer Name</th>
                <th>Customer Address 1</th>
                <th>Customer Address 2</th>
                <th>Customer Pincode</th>
                <th>Email Address</th>
                <th>Contact Number</th>
                <th>Create Date</th>
                <th>Created By</th>
                <th>Modify Date</th>
                <th>Modified By</th>
                <th>Record Status</th>
                <security:authorize access="hasRole('MAKER')">
                     <th>Edit</th>
                     <th>Delete<th>
                </security:authorize>
               <security:authorize access="hasRole('CHECKER')">
                    <th>Approve</th>
                    <th>Reject<th>
               </security:authorize>
            </tr>
            <c:forEach var="customer" items="${list}">
                <tr>
                    <td>${customer.customer_code}</td>
                    <td>${customer.customer_name}</td>
                    <td>${customer.customer_address_1}</td>
                    <td>${customer.customer_address_2}</td>
                    <td>${customer.customer_pincode}</td>
                    <td>${customer.email_address}</td>
                    <td>${customer.contact_number}</td>
                    <td>${customer.create_date}</td>
                    <td>${customer.created_by}</td>
                    <td>${customer.modified_date}</td>
                    <td>${customer.modified_by}</td>
                    <td>${customer.record_status}</td>
                    <security:authorize access="hasRole('MAKER')">
                        <td><a href="editCustomer.obj?id=${customer.customer_code}">Edit</a></td>
                        <td><a href="deleteCustomer.obj?id=${customer.customer_code}">Delete</a></td>
                    </security:authorize>
                    <security:authorize access="hasRole('CHECKER')">
                        <td><a href="approve.obj?id=${customer.customer_code}">Approve</a></td>
                        <td><a href="reject.obj?id=${customer.customer_code}">Reject</a></td>
                    </security:authorize>
                </tr>
            </c:forEach>
        </table>
        </div>
        </div>
        <br />
        <hr />
        <a href="logout"> LOGOUT </a>
    </body>
</html>