package com.lanqiao.team9.expresssystem.dao;

import com.lanqiao.team9.expresssystem.entity.Company;
import com.lanqiao.team9.expresssystem.entity.Customer;
import com.lanqiao.team9.expresssystem.util.ConnectUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CustomerDao extends BaseDaoAdapter<Customer> implements IBaseDao<Customer> {//供顾客进行操作的Dao
    

    //这里根据连接加载驱动名进行命名，后续不再说明
    public boolean CustAdd(Customer Cust) {/** 添加顾客*/
    	Connection connection = ConnectUtil.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("insert into CUSTOMER(NAME,PHONE,IDCARD,PWD,REGTIME,CUSTOMERID) VALUES (?,?,?,?,?,?)");
            preparedStatement.setString(1, Cust.getName());
            preparedStatement.setString(2, Cust.getPhone());
            preparedStatement.setString(3, Cust.getIdcard());
            preparedStatement.setString(4, Cust.getPwd());
            preparedStatement.setString(5, Cust.getRegtime());
            preparedStatement.setString(6, Cust.getCustomerid());
            int ret = preparedStatement.executeUpdate();

            ConnectUtil.closeConnection(connection);
            return ret > 0;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }


    public boolean CustUpdate(Customer customer) {/** 更新顾客信息*/
    	Connection connection = ConnectUtil.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE CUSTOMER SET PWD=? ,NAME =?,IDCARD=?,PHONE=? WHERE CUSTOMERID=?");
            preparedStatement.setString(1, customer.getPwd());
            preparedStatement.setString(2, customer.getName());
            preparedStatement.setString(3, customer.getIdcard());
            preparedStatement.setString(4, customer.getPhone());
            preparedStatement.setString(5, customer.getCustomerid());
            int ret = preparedStatement.executeUpdate();
            ConnectUtil.closeConnection(connection);
            return ret > 0;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }


    public Customer ListMyself(String customerid) {/**用户只能看到自己的信息*/
    	Connection connection = ConnectUtil.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT CUSTOMERID,NAME,PHONE,IDCARD,PWD,REGTIME FROM CUSTOMER WHERE CUSTOMERID=?");
            preparedStatement.setString(1, customerid);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                String Customerid = resultSet.getString("CUSTOMERID");
                String Name = resultSet.getString("NAME");
                String Phone = resultSet.getString("PHONE");
                String Pwd = resultSet.getString("PWD");
                String Idcard = resultSet.getString("IDCARD");
                String Regtime = resultSet.getString("REGTIME");
                Customer customer = new Customer(Customerid, Name, Phone, Idcard, Pwd, Regtime);
                return customer;
            }
            ConnectUtil.closeConnection(connection);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return null;
    }

    public ArrayList<Customer> ListAll() {/**所有用户信息，供用户员查看*/
    	Connection connection = ConnectUtil.getConnection();
        ArrayList<Customer> ListMyself = new ArrayList<Customer>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT CUSTOMERID,NAME,PHONE,IDCARD,PWD,REGTIME FROM CUSTOMER");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String Customerid = resultSet.getString("CUSTOMERID");
                String Name = resultSet.getString("NAME");
                String Phone = resultSet.getString("PHONE");
                String Pwd = resultSet.getString("PWD");
                String Idcard = resultSet.getString("IDCARD");
                String Regtime = resultSet.getString("REGTIME");
                Customer customer = new Customer(Customerid, Name, Phone, Idcard, Pwd, Regtime);
                ListMyself.add(customer);
            }
            ConnectUtil.closeConnection(connection);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return ListMyself;
    }

    public boolean CustDelete(String customerid) {
    	Connection connection = ConnectUtil.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE from CUSTOMER WHERE CUSTOMERID=?");
            preparedStatement.setString(1, customerid);
            int ret = preparedStatement.executeUpdate();
            ConnectUtil.closeConnection(connection);
            return ret > 0;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }


	public Customer isCustomer(String phone, String pwd) {
		   Connection connection = ConnectUtil.getConnection();
	    	Customer customer = null;
	    	try {
	    		PreparedStatement preparedStatement = connection.prepareStatement("SELECT NAME,IDCARD,REGTIME,CUSTOMERID FROM CUSTOMER WHERE phone=? and pwd=? ");
	    		preparedStatement.setString(1,phone);
	    		preparedStatement.setString(2, pwd);
	    		ResultSet resultSet = preparedStatement.executeQuery();
	    		if(resultSet.next()) {
	    			String Name = resultSet.getString("NAME");
	    			String Idcard = resultSet.getString("IDCARD");
	    			String Regtime = resultSet.getString("REGTIME");
	    			String Customerid = resultSet.getString("CUSTOMERID");
	    			customer = new Customer(Customerid,Name, phone, Idcard, pwd, Regtime);
	    			return customer;
	    		}
	    	} catch (SQLException e) {
	    		e.printStackTrace();
	    	}finally {
	    		ConnectUtil.closeConnection(connection);
	    	}
	    	return customer;
	}
	public ArrayList<Customer> ListForAdmin(String customerid,String name,String phone) {/**模糊查询用户信息，供管理员查看*/
		Connection connection = ConnectUtil.getConnection();
		ArrayList<Customer> ListMyself = new ArrayList<Customer>();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement("SELECT CUSTOMERID,NAME,PHONE,IDCARD,PWD,REGTIME FROM CUSTOMER WHERE CUSTOMERID LIKE ? AND NAME LIKE ? AND PHONE LIKE ?");
			preparedStatement.setString(1, "%"+customerid+"%");
			preparedStatement.setString(2, "%"+name+"%");
			preparedStatement.setString(3, "%"+phone+"%");
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				String Customerid = resultSet.getString("CUSTOMERID");
				String Name = resultSet.getString("NAME");
				String Phone = resultSet.getString("PHONE");
				String Pwd = resultSet.getString("PWD");
				String Idcard = resultSet.getString("IDCARD");
				String Regtime = resultSet.getString("REGTIME");
				Customer customer = new Customer(Customerid, Name, Phone, Idcard, Pwd, Regtime);
				ListMyself.add(customer);
			}
			ConnectUtil.closeConnection(connection);
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}
		
		return ListMyself;
	}


}