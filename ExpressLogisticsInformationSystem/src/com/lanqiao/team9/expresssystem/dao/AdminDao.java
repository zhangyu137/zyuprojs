package com.lanqiao.team9.expresssystem.dao;

import com.lanqiao.team9.expresssystem.entity.Admin;
import com.lanqiao.team9.expresssystem.entity.Company;
import com.lanqiao.team9.expresssystem.entity.Customer;
import com.lanqiao.team9.expresssystem.entity.Goods;
import com.lanqiao.team9.expresssystem.util.ConnectUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AdminDao extends BaseDaoAdapter<Admin> implements IBaseDao<Admin> {//管理员对三个表进行操作的Dao

    /**
     * 管理员权限Dao
     */

    Connection connection = ConnectUtil.getConnection();
    //这里根据连接加载驱动名进行命名，后续s不再说明

    public ArrayList<Goods> GlistForAdmin() {
        ArrayList<Goods> Glist = new ArrayList<Goods>();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT GOODSID,COMPANYNAME,CARGO,SENDERADD,RECEIVENAME,RECEIVEPHONE,RECEIVEIDCARD,RECEIVEADD,STATUS,CREATIONTIME,CUSTOMERID,PAY,MONEY FROM GOODS");

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String Goodsid = resultSet.getString("GOODSID");
                String CompanyName = resultSet.getString("COMPANYNAME");
                String Cargo = resultSet.getString("CARGO");
                String SenderAdd = resultSet.getString("SENDERADD");
                String ReceiveName = resultSet.getString("RECEIVENAME");
                String ReceivePhone = resultSet.getString("RECEIVEPHONE");
                String ReceiveIdcard = resultSet.getString("RECEIVEIDCARD");
                String ReceiveAdd = resultSet.getString("RECEIVEADD");
                String Staus = resultSet.getString("STATUS");
                String CustomerId = resultSet.getString("CUSTOMERID");
                String Pay = resultSet.getString("PAY");
                String Money = resultSet.getString("MONEY");
                String CreationTime = resultSet.getString("CREATIONTIME");
                String Sendername=resultSet.getString("SENDERNAME");
                String SenderIdcard=resultSet.getString("SENDERIDCARD");
                String SenderPhone=resultSet.getString("SENDERPHONE");
                Goods goods = new Goods(Goodsid, CompanyName, Cargo, CustomerId,Sendername,SenderPhone,SenderIdcard,SenderAdd, ReceiveName, ReceivePhone, ReceiveIdcard, ReceiveAdd, Pay, Money, Staus, CreationTime);
                Glist.add(goods);
            }
            ConnectUtil.closeConnection(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Glist;
    }

    public boolean UpdateTheGoods(Goods goods) {/** 管理员更新货物表*/
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("update GOODS set STATUS=? WHERE GOODSID=?");
            preparedStatement.setString(1, goods.getStatus());
            preparedStatement.setString(2, goods.getGoodsid());
            int ret = preparedStatement.executeUpdate();
            ConnectUtil.closeConnection(connection);
            return ret > 0;
        } catch (SQLException e) {
            e.printStackTrace();

        }
        return false;
    }

    public boolean DeleteTheGoods(Goods goods) {/** 管理员删除货物表的货物*/
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("delete from GOODS WHERE GOODSID=?");
            preparedStatement.setString(1, goods.getGoodsid());
            int ret = preparedStatement.executeUpdate();
            ConnectUtil.closeConnection(connection);
            return ret > 0;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    public ArrayList<Company> ClistForAdmin() {/** 管理员查看公司表*/
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
        } catch (SQLException e) {
            e.printStackTrace();
        }
        ConnectUtil.closeConnection(connection);
        return Clist;
    }

    public boolean UpdateTheCompany(Company company) {/** 管理员更新快递公司表*/
        try {

            PreparedStatement preparedStatement = connection.prepareStatement("update COMPANY SET COMPANYNAME=?,PHONE=?,CORPORATION=?,PWD=?,REGTIME=? WHERE COMPANYNAME=?");
            preparedStatement.setString(1, company.getCompanyname());
            preparedStatement.setString(2, company.getPhone());
            preparedStatement.setString(3, company.getCorporation());
            preparedStatement.setString(4, company.getPwd());
            preparedStatement.setString(5, company.getRegtime());
            int ret = preparedStatement.executeUpdate();
            ConnectUtil.closeConnection(connection);
            return ret > 0;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    public boolean DeleteTheCompany(Company company) {/** 管理员删除快递公司表*/
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("delete FROM COMPANY WHERE COMPANYNAME=?");
            preparedStatement.setString(1, company.getCompanyname());
            int ret = preparedStatement.executeUpdate();
            ConnectUtil.closeConnection(connection);
            return ret > 0;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    public ArrayList<Customer> CustomerListForAdmin() {/**对管理员展示顾客表*/
        ArrayList<Customer> CustomerList = new ArrayList<Customer>();
        Connection connection = ConnectUtil.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT CUSTOMERID,NAME,PHONE,IDCARD,PWD,REGTIME FROM CUSTOMER");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String CustomerId = resultSet.getString("CUSTOMERID");
                String Name = resultSet.getString("NAME");
                String Phone = resultSet.getString("PHONE");
                String IdCard = resultSet.getString("IDCARD");
                String Pwd = resultSet.getString("PWD");
                String Regtime = resultSet.getString("REGTIME");
                Customer customer = new Customer(CustomerId, Name, Phone, IdCard, Pwd, Regtime);
                CustomerList.add(customer);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        ConnectUtil.closeConnection(connection);
        return CustomerList;
    }

    public boolean UpdateTheCustomer(Customer customer) {/** 管理员更新顾客表*/
        try {

            PreparedStatement preparedStatement = connection.prepareStatement("update CUSTOMER SET NAME=?,PHONE=?,IDCARD=?,PWD=?,REGTIME=? WHERE PHONE=?");
            preparedStatement.setString(1, customer.getName());
            preparedStatement.setString(2, customer.getPhone());
            preparedStatement.setString(3, customer.getIdcard());
            preparedStatement.setString(4, customer.getPwd());
            preparedStatement.setString(5, customer.getRegtime());
            int ret = preparedStatement.executeUpdate();
            ConnectUtil.closeConnection(connection);
            return ret > 0;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    public boolean DeleteTheCustomer(Customer customer) {/** 管理员注销顾客*/
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM CUSTOMER WHERE CUSTOMERID=?");
            preparedStatement.setString(1, customer.getCustomerid());
            int ret = preparedStatement.executeUpdate();
            ConnectUtil.closeConnection(connection);
            return ret > 0;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }
}



