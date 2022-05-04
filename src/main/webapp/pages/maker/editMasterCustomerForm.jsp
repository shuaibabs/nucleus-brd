<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
          <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>

<head>
  <meta charset="ISO-8859-1">
  <title>Edit Customer</title>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous" />
  <style>
  * {
              margin: 0px;
              padding: 0;
              font-family: Arial, Helvetica, sans-serif;
          }
   .heading
        {
            display: flex;
            background-color: #232f3e;
            box-shadow: 0px 1px 2px #232f3e;
        }
        h1
        {
            color: coral;
            font-weight: bold;
            background: transparent;
            padding: 7px;
        }
        form
              {
                  width: 50%;
                  margin-left : 25%
              }
  </style>
</head>

<body>
  <div class="heading">
    <h1>Edit Master Customer</h1>
  </div>
  <br>
  <form:form method="post" action="editMasterSave" modelAttribute="masterCustomer">
    <table>
      <tr>
        <td>Customer Code :</td>
        <td>
          <form:input path="customer_code" />
        </td>
        <td>
          <form:errors path="customer_code" cssStyle="color:red" />
        </td>
      </tr>
      <tr>
        <td>Customer Name :</td>
        <td>
          <form:input path="customer_name" />
        </td>
        <td>
          <form:errors path="customer_name" cssStyle="color:red" />
        </td>
      </tr>
      <tr>
        <td>Address-1 :</td>
        <td>
          <form:input path="customer_address_1" />
        </td>
        <td>
          <form:errors path="customer_address_1" cssStyle="color:red" />
        </td>
      </tr>
      <tr>
        <td>Address-2 :</td>
        <td>
          <form:input path="customer_address_2" />
        </td>
        <td>
          <form:errors path="customer_address_2" cssStyle="color:red" />
        </td>
      </tr>
      <tr>
        <td>Pin-Code :</td>
        <td>
          <form:input path="customer_pincode" />
        </td>
        <td>
          <form:errors path="customer_pincode" cssStyle="color:red" />
        </td>
      </tr>
      <tr>
        <td>E-Mail Address :</td>
        <td>
          <form:input path="email_address" />
        </td>
        <td>
          <form:errors path="email_address" cssStyle="color:red" />
        </td>
      </tr>
      <tr>
        <td>Contact Number :</td>
        <td>
          <form:input path="contact_number" />
        </td>
        <td>
          <form:errors path="contact_number" cssStyle="color:red" />
        </td>
      </tr>
      <tr>
        <td>Primary Contact Person :</td>
        <td>
          <form:input path="primary_contact_person" />
        </td>
        <td>
          <form:errors path="primary_contact_person" cssStyle="color:red" />
        </td>
      </tr>
      <tr>
        <td>Record Status :</td>
        <td>
          <form:input path="record_status" readOnly="true" />
        </td>
        <td>
          <form:errors path="record_status" cssStyle="color:red" />
        </td>
      </tr>
      <tr>
        <td>Created By :</td>
        <td>
          <form:input path="created_by" readOnly="true" />
        </td>
        <td>
          <form:errors path="created_by" cssStyle="color:red" />
        </td>
      </tr>
      <tr>
        <td>Modified By :</td>
        <td>
          <form:input path="modified_by"/>
        </td>
        <td>
          <form:errors path="modified_by" cssStyle="color:red" />
        </td>
      </tr>
      <br>
      <tr>
        <td colspan="3">
          <input type="submit" value="Save" />
        </td>
      </tr>
    </table>
  </form:form>
</body>

</html>