package lk.ijse.Spring;/*@author:Dilshan Rajika Withanachchi*/

import lk.ijse.Spring.db.CrudUtil;
import lk.ijse.Spring.dto.CustomerDto;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet(urlPatterns = "/Customer")
public class CustomerForm extends HttpServlet {


    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp){
      System.out.println("Calling do get");

         try {
           final ResultSet rst = CrudUtil.execute("Select * from Customer");
           req.getServletContext().setAttribute("rst",rst);
           resp.sendRedirect("index.html");
         }catch (Exception e){
         e.printStackTrace();
           }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String CustID=req.getParameter("CustID");
        String CustFirstName=req.getParameter("CustFirstName");
        String CustLastName= req.getParameter("CustLastName");
        String CustAddress=req.getParameter("CustAddress");
        String CustContactNumber=req.getParameter("CustContactNumber");
        String CustCountry= req.getParameter("CustCountry");
        String CustCity=req.getParameter("CustCity");
       String  CustZipCode=req.getParameter("CustZipCode");
        try {
    boolean val= CrudUtil.execute("Insert into Customer values(?,?,?,?,?,?,?,?)", CustID, CustFirstName,
            CustLastName, CustAddress
            , CustContactNumber, CustCountry, CustCity, CustZipCode);

        }catch (Exception E){
    E.printStackTrace();
}

       doGet(req,resp);

    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("doPut");

    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("doDelete");
    }
}
