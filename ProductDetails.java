package com;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ProductDetails
 */
public class ProductDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductDetails() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/product","root","nishatomar20!");
		    
		    Statement stm=con.createStatement();
		    PrintWriter pw=response.getWriter();
		    response.setContentType("text/html");
		    String sea=request.getParameter("sea");
		    
		    if(sea.isEmpty()) {
		    pw.print("Give correct id to search!!<br> Try Again!!");
		    pw.print("<br><a href='home.html'?Go to Home Page!</a>");
		    }else {
		    	String sql="select *from Productdetails where id="+sea;
		    	ResultSet rs=stm.executeQuery(sql);
		    	if(rs.next()) {
		    		pw.println("ID is "+rs.getInt("id")+" <br>Product is-"+rs.getString("name")+" <br> Price of a product is "+rs.getInt("price"));
		    	}else {
		    		pw.print("There is no any product with a product id : "+sea+" <br> Try Again");
		    }
		    pw.print("<br><a href='home.html'? Go to Home Page!</a>");
		  
		}
		    }catch(Exception e) {
			System.out.println(e);
		}}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
