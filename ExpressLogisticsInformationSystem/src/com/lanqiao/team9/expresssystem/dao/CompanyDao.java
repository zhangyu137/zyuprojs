package com.lanqiao.team9.expresssystem.dao;

import com.lanqiao.team9.expresssystem.entity.Company;
import com.lanqiao.team9.expresssystem.util.ConnectUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CompanyDao {//用于快递公司对自己资料操作的DAO
 

    public boolean Cadd(Company copay) {/** 添加快递公司信息*/
    	   Connection connection = ConnectUtil.getConnection();
        try {
            PreparedStatement pstmt = connection.prepareStatement("insert into COMPANY(COMPANYNAME,PHONE,CORPORATION,PWD,REGTIME) values(?,?,?,?,?)");
            pstmt.setString(1, copay.getCompanyname());
            pstmt.setString(2, copay.getPhone());
            pstmt.setString(3, copay.getCorporation());
            pstmt.setString(4, copay.getPwd());
            pstmt.setString(5, copay.getRegtime());

            int ret = pstmt.executeUpdate();
            ConnectUtil.closeConnection(connection);
            return ret > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    

    public boolean Cdelete(String companyname) {/** 删除快递公司*/
    	   Connection connection = ConnectUtil.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM COMPANY WHERE COMPANYNAME=?");
            preparedStatement.setString(1,companyname);
            int ret = preparedStatement.executeUpdate();
            ConnectUtil.closeConnection(connection);
            return ret > 0;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    public boolean Cupdate(Company copay) {/** 更新公司表,把更新过的新的打包成一个对象传参修改（修改手机号和密码）*/
    	   Connection connection = ConnectUtil.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("update COMPANY set PWD=?,PHONE=?,CORPORATION=? where COMPANYNAME=?");
            preparedStatement.setString(1, copay.getPwd());
            preparedStatement.setString(2, copay.getPhone());
            preparedStatement.setString(3,copay.getCorporation());
            preparedStatement.setString(4, copay.getCompanyname());
            int ret = preparedStatement.executeUpdate();
            ConnectUtil.closeConnection(connection);
            return ret > 0;
        } catch (SQLException e) {
            e.printStackTrace();
//           System.out.println("修改失败");
        }
        return false;
    }
    
    public Company isCompany(String phone,String pwd) {/** 通过手机号，密码查询能否登录并得到公司*/
    	   Connection connection = ConnectUtil.getConnection();
    	Company company = null;
    	try {
    		PreparedStatement preparedStatement = connection.prepareStatement("SELECT COMPANYNAME ,CORPORATION,REGTIME FROM COMPANY WHERE phone=? and pwd=?");
    		preparedStatement.setString(1, phone);
    		preparedStatement.setString(2, pwd);
    		ResultSet resultSet = preparedStatement.executeQuery();
    		if(resultSet.next()) {
    			String companyname = resultSet.getString("COMPANYNAME");
    			String corporation = resultSet.getString("CORPORATION");
    			String regtime = resultSet.getString("REGTIME");
    			company = new Company(companyname, phone, corporation, pwd, regtime);
    			return company;
    		}
    	} catch (SQLException e) {
    		e.printStackTrace();
    	}finally {
    		ConnectUtil.closeConnection(connection);
    	}
    	return company;
    }
    
    public Company ClistMyself(String companyName) {/** 查看自己公司的信息，通过公司名*/
    	   Connection connection = ConnectUtil.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT COMPANYNAME,PHONE,CORPORATION,PWD,REGTIME FROM COMPANY WHERE COMPANYNAME=?");
            preparedStatement.setString(1, companyName);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                String CompanyName = resultSet.getString("COMPANYNAME");
                String Phone = resultSet.getString("PHONE");
                String Corporation = resultSet.getString("CORPORATION");
                String Pwd = resultSet.getString("PWD");
                String RegTime = resultSet.getString("REGTIME");

                Company copay = new Company(CompanyName, Phone, Corporation, Pwd, RegTime);
                return copay;
            }
            ConnectUtil.closeConnection(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<Company> ClistAll() {/** 查询所有快递公司,供管理员查看*/
        ArrayList<Company> Clist = new ArrayList<Company>();
        Connection connection = ConnectUtil.getConnection();
        try {
            PreparedStatement preparedStatement =
                    connection.prepareStatement("SELECT COMPANYNAME,PHONE,CORPORATION,PWD,REGTIME FROM COMPANY");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String CompanyName = resultSet.getString("COMPANYNAME");
                String Phone = resultSet.getString("PHONE");
                String Corporation = resultSet.getString("CORPORATION");
                String Pwd = resultSet.getString("PWD");
                String RegTime = resultSet.getString("REGTIME");

                Company copay = new Company(CompanyName, Phone, Corporation, Pwd, RegTime);
                Clist.add(copay);
            }
            ConnectUtil.closeConnection(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Clist;
    }
    public ArrayList<Company> ClistForAdmin(String companyName,String phone,String corporation) {/** 模糊查询快递公司,供管理员查看*/
    	ArrayList<Company> Clist = new ArrayList<Company>();
    	Connection connection = ConnectUtil.getConnection();
    	try {
    		PreparedStatement preparedStatement =
    				connection.prepareStatement("SELECT COMPANYNAME,PHONE,CORPORATION,PWD,REGTIME FROM COMPANY WHERE COMPANYNAME LIKE ? AND PHONE LIKE ? AND CORPORATION LIKE ?");
    		preparedStatement.setString(1, "%"+companyName+"%");
    		preparedStatement.setString(2, "%"+phone+"%");
    		preparedStatement.setString(3, "%"+corporation+"%");
    		ResultSet resultSet = preparedStatement.executeQuery();
    		while (resultSet.next()) {
    			String CompanyName = resultSet.getString("COMPANYNAME");
    			String Phone = resultSet.getString("PHONE");
    			String Corporation = resultSet.getString("CORPORATION");
    			String Pwd = resultSet.getString("PWD");
    			String RegTime = resultSet.getString("REGTIME");
    			
    			Company copay = new Company(CompanyName, Phone, Corporation, Pwd, RegTime);
    			Clist.add(copay);
    		}
    		ConnectUtil.closeConnection(connection);
    	} catch (SQLException e) {
    		e.printStackTrace();
    	}
    	return Clist;
    }
}
