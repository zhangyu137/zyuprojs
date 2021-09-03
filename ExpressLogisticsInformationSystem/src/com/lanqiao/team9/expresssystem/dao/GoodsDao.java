package com.lanqiao.team9.expresssystem.dao;

import com.lanqiao.team9.expresssystem.entity.Goods;
import com.lanqiao.team9.expresssystem.util.ConnectUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class GoodsDao {
    /**
     * 前面第一个大写字母代表不同的Dao方法避免混乱
     */
    

    public boolean Gadd(Goods goods) {/** 添加货物信息*/
    	Connection connection = ConnectUtil.getConnection();
    	try {
    		PreparedStatement pstmt = connection.prepareStatement("INSERT INTO GOODS(GOODSID,COMPANYNAME,CARGO,SENDERADD,RECEIVEIDCARD,RECEIVEADD,STATUS,CREATIONTIME,CUSTOMERID,PAY,MONEY,RECEIVENAME,RECEIVEPHONE) values(?,?,?,?,?,?,?,?,?,?,?,?,?)");
    		pstmt.setString(1, goods.getGoodsid());
    		pstmt.setString(2, goods.getCompanyname());
    		pstmt.setString(3, goods.getCargo());
    		pstmt.setString(4, goods.getSenderadd());
    		pstmt.setString(5, goods.getReceiveidcard());
    		pstmt.setString(6, goods.getReceiveadd());
    		pstmt.setString(7, goods.getStatus());
    		pstmt.setString(8, goods.getCreationtime());
    		pstmt.setString(9, goods.getCustomerid());
    		pstmt.setString(10, goods.getPay());
    		pstmt.setString(11, goods.getMoney());
    		pstmt.setString(12, goods.getReceivename());
    		pstmt.setString(13, goods.getReceivephone());
    		
    		int ret = pstmt.executeUpdate();
    		
    		return ret > 0;
    	} catch (SQLException e) {
    		e.printStackTrace();
    	}finally{
    		ConnectUtil.closeConnection(connection);
    	}
    	return false;
    }
    
    public ArrayList<Goods> FuzzyQueryForAdmin(String goodsid,String companyName){		//通过订单编号和快递公司模糊查询出订单信息
    	Connection connection = ConnectUtil.getConnection();
    	ArrayList<Goods> Glist = new ArrayList<Goods>();
    	try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT GOODSID,COMPANYNAME,CARGO,SENDERADD,RECEIVENAME,RECEIVEPHONE,RECEIVEIDCARD,RECEIVEADD,STATUS,CREATIONTIME,GOODS.CUSTOMERID,PAY,MONEY,NAME,PHONE,IDCARD FROM GOODS,CUSTOMER WHERE GOODSID LIKE ? AND COMPANYNAME LIKE ? AND GOODS.CUSTOMERID=CUSTOMER.CUSTOMERID");
            preparedStatement.setString(1, "%"+goodsid+"%");
            preparedStatement.setString(2, "%"+companyName+"%");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
            	String Goodsid = resultSet.getString("GOODSID");
    			String CompanyName = resultSet.getString("COMPANYNAME");
    			String Cargo = resultSet.getString("CARGO");
    			String senderName = resultSet.getString("NAME");
    			String senderPhone = resultSet.getString("PHONE");
    			String senderIdcard = resultSet.getString("IDCARD");
    			String SenderAdd = resultSet.getString("SENDERADD");
    			String ReceiveName = resultSet.getString("RECEIVENAME");
    			String ReceivePhone = resultSet.getString("RECEIVEPHONE");
    			String ReceiveIdcard = resultSet.getString("RECEIVEIDCARD");
    			String ReceiveAdd = resultSet.getString("RECEIVEADD");
    			String Staus = resultSet.getString("STATUS");
    			String CustomeRid = resultSet.getString("CUSTOMERID");
    			String Pay = resultSet.getString("PAY");
    			String Money = resultSet.getString("MONEY");
    			String CreationTime = resultSet.getString("CREATIONTIME");
    			
    			Goods goods2 = new Goods(Goodsid, CompanyName, Cargo, CustomeRid, senderName, senderPhone, senderIdcard, SenderAdd,ReceiveName, ReceivePhone, ReceiveIdcard, ReceiveAdd, Pay, Money, Staus, CreationTime);
    			Glist.add(goods2);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
        	ConnectUtil.closeConnection(connection);
        }
        return Glist;
    	
    }
    
    public boolean GupdateForTransport(String goodId,String status) {  /**对货物运输状态的更改,通过订单编号和状态传参更改 */
    	Connection connection = ConnectUtil.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("update GOODS set STATUS=? WHERE GOODSID=?");
            preparedStatement.setString(2, goodId);
            preparedStatement.setString(1, status);
            int ret = preparedStatement.executeUpdate();
            return ret > 0;
        } catch (SQLException e) {
            e.printStackTrace();
//           System.out.println("修改失败");
        }finally {
        	ConnectUtil.closeConnection(connection);
        }
        return false;
    }
    public boolean GupdateGoodsInfoForCompany(Goods good){/** 货品信息更改*/
			Connection connection=ConnectUtil.getConnection();
    try {
			PreparedStatement preparedStatement=connection.prepareStatement("update goods set cargo=?,receivename=?,receivephone=?,receiveidcard=?,receiveadd=?,pay=?,money=?,status=? where goodsid=?");
			preparedStatement.setString(1,good.getCargo());
			preparedStatement.setString(2,good.getReceivename());
			preparedStatement.setString(3,good.getReceivephone());
			preparedStatement.setString(4,good.getReceiveidcard());
			preparedStatement.setString(5,good.getReceiveadd());
			preparedStatement.setString(6,good.getPay());
			preparedStatement.setString(7,good.getMoney());
			preparedStatement.setString(8,good.getStatus());
			preparedStatement.setString(9,good.getGoodsid());
			int ret=preparedStatement.executeUpdate();
			return ret>0;
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}finally {
			ConnectUtil.closeConnection(connection);
		}
		return false;
	}
    public boolean GupdateGoodsInfoForAdmin(Goods good){/** 货品信息更改*/
    	Connection connection=ConnectUtil.getConnection();
    	try {
    		PreparedStatement preparedStatement=connection.prepareStatement("update goods set companyname=?,cargo=?,receivename=?,receivephone=?,receiveidcard=?,receiveadd=?,pay=?,money=?,status=? where goodsid=?");
    		preparedStatement.setString(1,good.getCompanyname());
    		preparedStatement.setString(2,good.getCargo());
    		preparedStatement.setString(3,good.getReceivename());
    		preparedStatement.setString(4,good.getReceivephone());
    		preparedStatement.setString(5,good.getReceiveidcard());
    		preparedStatement.setString(6,good.getReceiveadd());
    		preparedStatement.setString(7,good.getPay());
    		preparedStatement.setString(8,good.getMoney());
    		preparedStatement.setString(9,good.getStatus());
    		preparedStatement.setString(10,good.getGoodsid());
    		int ret=preparedStatement.executeUpdate();
    		return ret>0;
    	} catch (SQLException throwables) {
    		throwables.printStackTrace();
    	}finally {
    		ConnectUtil.closeConnection(connection);
    	}
    	return false;
    }

    public ArrayList<Goods> GlistForCompanyS0(String companyName) {/**以下是公司专用查询的方法*/ //快递公司查询待接收的订单
    	Connection connection = ConnectUtil.getConnection();
        ArrayList<Goods> Glist = new ArrayList<Goods>();
        
        try {
        	PreparedStatement preparedStatement = connection.prepareStatement("SELECT GOODSID,COMPANYNAME,CARGO,SENDERADD,RECEIVENAME,RECEIVEPHONE,RECEIVEIDCARD,RECEIVEADD,STATUS,CREATIONTIME,GOODS.CUSTOMERID,PAY,MONEY,NAME,PHONE,IDCARD FROM GOODS,CUSTOMER WHERE STATUS='0' AND COMPANYNAME=? AND GOODS.CUSTOMERID=CUSTOMER.CUSTOMERID");
            preparedStatement.setString(1, companyName);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
    			String Goodsid = resultSet.getString("GOODSID");
    			String CompanyName = resultSet.getString("COMPANYNAME");
    			String Cargo = resultSet.getString("CARGO");
    			String SenderAdd = resultSet.getString("SENDERADD");
    			String ReceiveName = resultSet.getString("RECEIVENAME");
    			String ReceivePhone = resultSet.getString("RECEIVEPHONE");
    			String ReceiveIdcard = resultSet.getString("RECEIVEIDCARD");
    			String senderName = resultSet.getString("NAME");
    			String senderPhone = resultSet.getString("PHONE");
    			String senderIdcard = resultSet.getString("IDCARD");
    			String ReceiveAdd = resultSet.getString("RECEIVEADD");
    			String Staus = resultSet.getString("STATUS");
    			String CustomeRid = resultSet.getString("CUSTOMERID");
    			String Pay = resultSet.getString("PAY");
    			String Money = resultSet.getString("MONEY");
    			String CreationTime = resultSet.getString("CREATIONTIME");
    			
    			Goods goods2 = new Goods(Goodsid, CompanyName, Cargo, CustomeRid, senderName, senderPhone, senderIdcard, SenderAdd,ReceiveName, ReceivePhone, ReceiveIdcard, ReceiveAdd, Pay, Money, Staus, CreationTime);
    			Glist.add(goods2);
    			
    		}
            ConnectUtil.closeConnection(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
        	ConnectUtil.closeConnection(connection);
        }
        return Glist;
    }

    public ArrayList<Goods> GlistForCompanyS1(String companyName) {  //快递公司查询待发货订单
    	Connection connection = ConnectUtil.getConnection();
        ArrayList<Goods> Glist = new ArrayList<Goods>();

        try {
        	PreparedStatement preparedStatement = connection.prepareStatement("SELECT GOODSID,COMPANYNAME,CARGO,SENDERADD,RECEIVENAME,RECEIVEPHONE,RECEIVEIDCARD,RECEIVEADD,STATUS,CREATIONTIME,GOODS.CUSTOMERID,PAY,MONEY,NAME,PHONE,IDCARD FROM GOODS,CUSTOMER WHERE STATUS='1' AND COMPANYNAME=? AND GOODS.CUSTOMERID=CUSTOMER.CUSTOMERID");
            preparedStatement.setString(1, companyName);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
    			String Goodsid = resultSet.getString("GOODSID");
    			String CompanyName = resultSet.getString("COMPANYNAME");
    			String Cargo = resultSet.getString("CARGO");
    			String SenderAdd = resultSet.getString("SENDERADD");
    			String ReceiveName = resultSet.getString("RECEIVENAME");
    			String ReceivePhone = resultSet.getString("RECEIVEPHONE");
    			String ReceiveIdcard = resultSet.getString("RECEIVEIDCARD");
    			String senderName = resultSet.getString("NAME");
    			String senderPhone = resultSet.getString("PHONE");
    			String senderIdcard = resultSet.getString("IDCARD");
    			String ReceiveAdd = resultSet.getString("RECEIVEADD");
    			String Staus = resultSet.getString("STATUS");
    			String CustomeRid = resultSet.getString("CUSTOMERID");
    			String Pay = resultSet.getString("PAY");
    			String Money = resultSet.getString("MONEY");
    			String CreationTime = resultSet.getString("CREATIONTIME");
    			
    			Goods goods2 = new Goods(Goodsid, CompanyName, Cargo, CustomeRid, senderName, senderPhone, senderIdcard, SenderAdd,ReceiveName, ReceivePhone, ReceiveIdcard, ReceiveAdd, Pay, Money, Staus, CreationTime);
    			Glist.add(goods2);
    			
    		}
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
        	ConnectUtil.closeConnection(connection);
        }
        return Glist;
    }

    public ArrayList<Goods> GlistForCompanyS2(String companyName) {  //快递公司查询运途中的订单
    	Connection connection = ConnectUtil.getConnection();
        ArrayList<Goods> Glist = new ArrayList<Goods>();


        try {
        	PreparedStatement preparedStatement = connection.prepareStatement("SELECT GOODSID,COMPANYNAME,CARGO,SENDERADD,RECEIVENAME,RECEIVEPHONE,RECEIVEIDCARD,RECEIVEADD,STATUS,CREATIONTIME,GOODS.CUSTOMERID,PAY,MONEY,NAME,PHONE,IDCARD FROM GOODS,CUSTOMER WHERE STATUS='2' AND COMPANYNAME=? AND GOODS.CUSTOMERID=CUSTOMER.CUSTOMERID");
            preparedStatement.setString(1, companyName);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
    			String Goodsid = resultSet.getString("GOODSID");
    			String CompanyName = resultSet.getString("COMPANYNAME");
    			String Cargo = resultSet.getString("CARGO");
    			String SenderAdd = resultSet.getString("SENDERADD");
    			String ReceiveName = resultSet.getString("RECEIVENAME");
    			String ReceivePhone = resultSet.getString("RECEIVEPHONE");
    			String ReceiveIdcard = resultSet.getString("RECEIVEIDCARD");
    			String senderName = resultSet.getString("NAME");
    			String senderPhone = resultSet.getString("PHONE");
    			String senderIdcard = resultSet.getString("IDCARD");
    			String ReceiveAdd = resultSet.getString("RECEIVEADD");
    			String Staus = resultSet.getString("STATUS");
    			String CustomeRid = resultSet.getString("CUSTOMERID");
    			String Pay = resultSet.getString("PAY");
    			String Money = resultSet.getString("MONEY");
    			String CreationTime = resultSet.getString("CREATIONTIME");
    			
    			Goods goods2 = new Goods(Goodsid, CompanyName, Cargo, CustomeRid, senderName, senderPhone, senderIdcard, SenderAdd,ReceiveName, ReceivePhone, ReceiveIdcard, ReceiveAdd, Pay, Money, Staus, CreationTime);
    			Glist.add(goods2);
    			
    		}
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
        	ConnectUtil.closeConnection(connection);
        }
        return Glist;
    }

    public ArrayList<Goods> GlistForCompanyS3(String companyName) {	//快递公司查询待收货的订单
    	Connection connection = ConnectUtil.getConnection();
        ArrayList<Goods> Glist = new ArrayList<Goods>();


        try {
        	PreparedStatement preparedStatement = connection.prepareStatement("SELECT GOODSID,COMPANYNAME,CARGO,SENDERADD,RECEIVENAME,RECEIVEPHONE,RECEIVEIDCARD,RECEIVEADD,STATUS,CREATIONTIME,GOODS.CUSTOMERID,PAY,MONEY,NAME,PHONE,IDCARD FROM GOODS,CUSTOMER WHERE STATUS='3' AND COMPANYNAME=? AND GOODS.CUSTOMERID=CUSTOMER.CUSTOMERID");
            preparedStatement.setString(1, companyName);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
    			String Goodsid = resultSet.getString("GOODSID");
    			String CompanyName = resultSet.getString("COMPANYNAME");
    			String Cargo = resultSet.getString("CARGO");
    			String SenderAdd = resultSet.getString("SENDERADD");
    			String ReceiveName = resultSet.getString("RECEIVENAME");
    			String ReceivePhone = resultSet.getString("RECEIVEPHONE");
    			String ReceiveIdcard = resultSet.getString("RECEIVEIDCARD");
    			String senderName = resultSet.getString("NAME");
    			String senderPhone = resultSet.getString("PHONE");
    			String senderIdcard = resultSet.getString("IDCARD");
    			String ReceiveAdd = resultSet.getString("RECEIVEADD");
    			String Staus = resultSet.getString("STATUS");
    			String CustomeRid = resultSet.getString("CUSTOMERID");
    			String Pay = resultSet.getString("PAY");
    			String Money = resultSet.getString("MONEY");
    			String CreationTime = resultSet.getString("CREATIONTIME");
    			
    			Goods goods2 = new Goods(Goodsid, CompanyName, Cargo, CustomeRid, senderName, senderPhone, senderIdcard, SenderAdd,ReceiveName, ReceivePhone, ReceiveIdcard, ReceiveAdd, Pay, Money, Staus, CreationTime);
    			Glist.add(goods2);
    			
    		}
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
        	ConnectUtil.closeConnection(connection);
        }
        return Glist;
    }

    public ArrayList<Goods> GlistForCompanyS4(String companyName) {	//快递公司查询收货完成的订单
    	Connection connection = ConnectUtil.getConnection();
        ArrayList<Goods> Glist = new ArrayList<Goods>();


        try {

            PreparedStatement preparedStatement = connection.prepareStatement("SELECT GOODSID,COMPANYNAME,CARGO,SENDERADD,RECEIVENAME,RECEIVEPHONE,RECEIVEIDCARD,RECEIVEADD,STATUS,CREATIONTIME,GOODS.CUSTOMERID,PAY,MONEY,NAME,PHONE,IDCARD FROM GOODS,CUSTOMER WHERE STATUS='4' AND COMPANYNAME=? AND GOODS.CUSTOMERID=CUSTOMER.CUSTOMERID");
            preparedStatement.setString(1, companyName);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
    			String Goodsid = resultSet.getString("GOODSID");
    			String CompanyName = resultSet.getString("COMPANYNAME");
    			String Cargo = resultSet.getString("CARGO");
    			String SenderAdd = resultSet.getString("SENDERADD");
    			String ReceiveName = resultSet.getString("RECEIVENAME");
    			String ReceivePhone = resultSet.getString("RECEIVEPHONE");
    			String ReceiveIdcard = resultSet.getString("RECEIVEIDCARD");
    			String senderName = resultSet.getString("NAME");
    			String senderPhone = resultSet.getString("PHONE");
    			String senderIdcard = resultSet.getString("IDCARD");
    			String ReceiveAdd = resultSet.getString("RECEIVEADD");
    			String Staus = resultSet.getString("STATUS");
    			String CustomeRid = resultSet.getString("CUSTOMERID");
    			String Pay = resultSet.getString("PAY");
    			String Money = resultSet.getString("MONEY");
    			String CreationTime = resultSet.getString("CREATIONTIME");
    			
    			Goods goods2 = new Goods(Goodsid, CompanyName, Cargo, CustomeRid, senderName, senderPhone, senderIdcard, SenderAdd,ReceiveName, ReceivePhone, ReceiveIdcard, ReceiveAdd, Pay, Money, Staus, CreationTime);
    			Glist.add(goods2);
    			
    		}
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
        	ConnectUtil.closeConnection(connection);
        }
        return Glist;
    }

    public ArrayList<Goods> GlistForCompanyS5(String companyName) {	//快递公司查询被截胡的订单
    	Connection connection = ConnectUtil.getConnection();
        ArrayList<Goods> Glist = new ArrayList<Goods>();


        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT GOODSID,COMPANYNAME,CARGO,SENDERADD,RECEIVENAME,RECEIVEPHONE,RECEIVEIDCARD,RECEIVEADD,STATUS,CREATIONTIME,GOODS.CUSTOMERID,PAY,MONEY,NAME,PHONE,IDCARD FROM GOODS,CUSTOMER WHERE STATUS='5' AND COMPANYNAME=? AND GOODS.CUSTOMERID=CUSTOMER.CUSTOMERID");
            preparedStatement.setString(1, companyName);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
    			String Goodsid = resultSet.getString("GOODSID");
    			String CompanyName = resultSet.getString("COMPANYNAME");
    			String Cargo = resultSet.getString("CARGO");
    			String SenderAdd = resultSet.getString("SENDERADD");
    			String ReceiveName = resultSet.getString("RECEIVENAME");
    			String ReceivePhone = resultSet.getString("RECEIVEPHONE");
    			String ReceiveIdcard = resultSet.getString("RECEIVEIDCARD");
    			String senderName = resultSet.getString("NAME");
    			String senderPhone = resultSet.getString("PHONE");
    			String senderIdcard = resultSet.getString("IDCARD");
    			String ReceiveAdd = resultSet.getString("RECEIVEADD");
    			String Staus = resultSet.getString("STATUS");
    			String CustomeRid = resultSet.getString("CUSTOMERID");
    			String Pay = resultSet.getString("PAY");
    			String Money = resultSet.getString("MONEY");
    			String CreationTime = resultSet.getString("CREATIONTIME");
    			
    			Goods goods2 = new Goods(Goodsid, CompanyName, Cargo, CustomeRid, senderName, senderPhone, senderIdcard, SenderAdd,ReceiveName, ReceivePhone, ReceiveIdcard, ReceiveAdd, Pay, Money, Staus, CreationTime);
    			Glist.add(goods2);
    			
    		}
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
        	ConnectUtil.closeConnection(connection);
        }
        return Glist;
    }

    /**
     * 以下是对用户货物状态的方法分类
     */
    public ArrayList<Goods> GlistNotAtivityForUser(String customerId) {//寄件人的快递公司待接收的订单，通过用户id查询
    	Connection connection = ConnectUtil.getConnection();
    	ArrayList<Goods> NotFinsh = new ArrayList<Goods>();
    	
    	try {
    		PreparedStatement preparedStatement = connection.prepareStatement("SELECT GOODSID,COMPANYNAME,CARGO,SENDERADD,RECEIVENAME,RECEIVEPHONE,RECEIVEIDCARD,RECEIVEADD,STATUS,CREATIONTIME,GOODS.CUSTOMERID,PAY,MONEY,NAME,PHONE,IDCARD FROM GOODS,CUSTOMER WHERE STATUS='0' AND GOODS.CUSTOMERID=? AND GOODS.CUSTOMERID=CUSTOMER.CUSTOMERID");
    		preparedStatement.setString(1, customerId);
    		ResultSet resultSet = preparedStatement.executeQuery();
    		while (resultSet.next()) {
    			String Goodsid = resultSet.getString("GOODSID");
    			String CompanyName = resultSet.getString("COMPANYNAME");
    			String Cargo = resultSet.getString("CARGO");
    			String SenderAdd = resultSet.getString("SENDERADD");
    			String ReceiveName = resultSet.getString("RECEIVENAME");
    			String ReceivePhone = resultSet.getString("RECEIVEPHONE");
    			String ReceiveIdcard = resultSet.getString("RECEIVEIDCARD");
    			String senderName = resultSet.getString("NAME");
    			String senderPhone = resultSet.getString("PHONE");
    			String senderIdcard = resultSet.getString("IDCARD");
    			String ReceiveAdd = resultSet.getString("RECEIVEADD");
    			String Staus = resultSet.getString("STATUS");
    			String CustomeRid = resultSet.getString("CUSTOMERID");
    			String Pay = resultSet.getString("PAY");
    			String Money = resultSet.getString("MONEY");
    			String CreationTime = resultSet.getString("CREATIONTIME");
    			
    			Goods goods2 = new Goods(Goodsid, CompanyName, Cargo, CustomeRid, senderName, senderPhone, senderIdcard, SenderAdd,ReceiveName, ReceivePhone, ReceiveIdcard, ReceiveAdd, Pay, Money, Staus, CreationTime);
    			NotFinsh.add(goods2);
    			
    		}
    		return NotFinsh;
    	} catch (SQLException e) {
    		e.printStackTrace();
    	}finally {
    		ConnectUtil.closeConnection(connection);
    	}
    	return null;
    }
    public ArrayList<Goods> GlistNotFinshForUserFor1(String customerId) {//寄件人的待发货的订单，通过用户id查询
    	Connection connection = ConnectUtil.getConnection();
    	ArrayList<Goods> NotFinsh = new ArrayList<Goods>();
    	
    	try {
    		PreparedStatement preparedStatement = connection.prepareStatement("SELECT GOODSID,COMPANYNAME,CARGO,SENDERADD,RECEIVENAME,RECEIVEPHONE,RECEIVEIDCARD,RECEIVEADD,STATUS,CREATIONTIME,GOODS.CUSTOMERID,PAY,MONEY,NAME,PHONE,IDCARD FROM GOODS,CUSTOMER WHERE STATUS='1' AND GOODS.CUSTOMERID=? AND GOODS.CUSTOMERID=CUSTOMER.CUSTOMERID");
    		preparedStatement.setString(1, customerId);
    		ResultSet resultSet = preparedStatement.executeQuery();
    		while (resultSet.next()) {
    			String Goodsid = resultSet.getString("GOODSID");
    			String CompanyName = resultSet.getString("COMPANYNAME");
    			String Cargo = resultSet.getString("CARGO");
    			String SenderAdd = resultSet.getString("SENDERADD");
    			String ReceiveName = resultSet.getString("RECEIVENAME");
    			String ReceivePhone = resultSet.getString("RECEIVEPHONE");
    			String ReceiveIdcard = resultSet.getString("RECEIVEIDCARD");
    			String senderName = resultSet.getString("NAME");
    			String senderPhone = resultSet.getString("PHONE");
    			String senderIdcard = resultSet.getString("IDCARD");
    			String ReceiveAdd = resultSet.getString("RECEIVEADD");
    			String Staus = resultSet.getString("STATUS");
    			String CustomeRid = resultSet.getString("CUSTOMERID");
    			String Pay = resultSet.getString("PAY");
    			String Money = resultSet.getString("MONEY");
    			String CreationTime = resultSet.getString("CREATIONTIME");
    			
    			Goods goods2 = new Goods(Goodsid, CompanyName, Cargo, CustomeRid, senderName, senderPhone, senderIdcard, SenderAdd,ReceiveName, ReceivePhone, ReceiveIdcard, ReceiveAdd, Pay, Money, Staus, CreationTime);
    			NotFinsh.add(goods2);
    			
    		}
    		return NotFinsh;
    	} catch (SQLException e) {
    		e.printStackTrace();
    	}finally {
    		ConnectUtil.closeConnection(connection);
    	}
    	return null;
    }
    public ArrayList<Goods> GlistNotFinshForUserFor2(String customerId) {//寄件人的运途中的订单，通过用户id查询
    	Connection connection = ConnectUtil.getConnection();
    	ArrayList<Goods> NotFinsh = new ArrayList<Goods>();
    	
    	try {
    		PreparedStatement preparedStatement = connection.prepareStatement("SELECT GOODSID,COMPANYNAME,CARGO,SENDERADD,RECEIVENAME,RECEIVEPHONE,RECEIVEIDCARD,RECEIVEADD,STATUS,CREATIONTIME,GOODS.CUSTOMERID,PAY,MONEY,NAME,PHONE,IDCARD FROM GOODS,CUSTOMER WHERE STATUS='2' AND GOODS.CUSTOMERID=? AND GOODS.CUSTOMERID=CUSTOMER.CUSTOMERID");
    		preparedStatement.setString(1, customerId);
    		ResultSet resultSet = preparedStatement.executeQuery();
    		while (resultSet.next()) {
    			String Goodsid = resultSet.getString("GOODSID");
    			String CompanyName = resultSet.getString("COMPANYNAME");
    			String Cargo = resultSet.getString("CARGO");
    			String SenderAdd = resultSet.getString("SENDERADD");
    			String ReceiveName = resultSet.getString("RECEIVENAME");
    			String ReceivePhone = resultSet.getString("RECEIVEPHONE");
    			String ReceiveIdcard = resultSet.getString("RECEIVEIDCARD");
    			String senderName = resultSet.getString("NAME");
    			String senderPhone = resultSet.getString("PHONE");
    			String senderIdcard = resultSet.getString("IDCARD");
    			String ReceiveAdd = resultSet.getString("RECEIVEADD");
    			String Staus = resultSet.getString("STATUS");
    			String CustomeRid = resultSet.getString("CUSTOMERID");
    			String Pay = resultSet.getString("PAY");
    			String Money = resultSet.getString("MONEY");
    			String CreationTime = resultSet.getString("CREATIONTIME");
    			
    			Goods goods2 = new Goods(Goodsid, CompanyName, Cargo, CustomeRid, senderName, senderPhone, senderIdcard, SenderAdd,ReceiveName, ReceivePhone, ReceiveIdcard, ReceiveAdd, Pay, Money, Staus, CreationTime);
    			NotFinsh.add(goods2);
    			
    		}
    		return NotFinsh;
    	} catch (SQLException e) {
    		e.printStackTrace();
    	}finally {
    		ConnectUtil.closeConnection(connection);
    	}
    	return null;
    }
    public ArrayList<Goods> GlistNotFinshForUserFor3(String customerId) {//寄件人的待收货的订单，通过用户id查询
    	Connection connection = ConnectUtil.getConnection();
    	ArrayList<Goods> NotFinsh = new ArrayList<Goods>();
    	
    	try {
    		PreparedStatement preparedStatement = connection.prepareStatement("SELECT GOODSID,COMPANYNAME,CARGO,SENDERADD,RECEIVENAME,RECEIVEPHONE,RECEIVEIDCARD,RECEIVEADD,STATUS,CREATIONTIME,GOODS.CUSTOMERID,PAY,MONEY,NAME,PHONE,IDCARD FROM GOODS,CUSTOMER WHERE STATUS='3' AND GOODS.CUSTOMERID=? AND GOODS.CUSTOMERID=CUSTOMER.CUSTOMERID");
    		preparedStatement.setString(1, customerId);
    		ResultSet resultSet = preparedStatement.executeQuery();
    		while (resultSet.next()) {
    			String Goodsid = resultSet.getString("GOODSID");
    			String CompanyName = resultSet.getString("COMPANYNAME");
    			String Cargo = resultSet.getString("CARGO");
    			String SenderAdd = resultSet.getString("SENDERADD");
    			String ReceiveName = resultSet.getString("RECEIVENAME");
    			String ReceivePhone = resultSet.getString("RECEIVEPHONE");
    			String ReceiveIdcard = resultSet.getString("RECEIVEIDCARD");
    			String senderName = resultSet.getString("NAME");
    			String senderPhone = resultSet.getString("PHONE");
    			String senderIdcard = resultSet.getString("IDCARD");
    			String ReceiveAdd = resultSet.getString("RECEIVEADD");
    			String Staus = resultSet.getString("STATUS");
    			String CustomeRid = resultSet.getString("CUSTOMERID");
    			String Pay = resultSet.getString("PAY");
    			String Money = resultSet.getString("MONEY");
    			String CreationTime = resultSet.getString("CREATIONTIME");
    			
    			Goods goods2 = new Goods(Goodsid, CompanyName, Cargo, CustomeRid, senderName, senderPhone, senderIdcard, SenderAdd,ReceiveName, ReceivePhone, ReceiveIdcard, ReceiveAdd, Pay, Money, Staus, CreationTime);
    			NotFinsh.add(goods2);
    			
    		}
    		return NotFinsh;
    	} catch (SQLException e) {
    		e.printStackTrace();
    	}finally {
    		ConnectUtil.closeConnection(connection);
    	}
    	return null;
    }
    
    public ArrayList<Goods> GlistNotFinshForUser(String customerId) {//寄件人的还在运输中的订单（包括待发货，运途中，待收货），通过用户id查询
    	Connection connection = ConnectUtil.getConnection();
        ArrayList<Goods> NotFinsh = new ArrayList<Goods>();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT GOODSID,COMPANYNAME,CARGO,SENDERADD,RECEIVENAME,RECEIVEPHONE,RECEIVEIDCARD,RECEIVEADD,STATUS,CREATIONTIME,GOODS.CUSTOMERID,PAY,MONEY,NAME,PHONE,IDCARD FROM GOODS,CUSTOMER WHERE STATUS IN ('1','2','3') AND GOODS.CUSTOMERID=? AND GOODS.CUSTOMERID=CUSTOMER.CUSTOMERID");

            preparedStatement.setString(1, customerId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
    			String Goodsid = resultSet.getString("GOODSID");
    			String CompanyName = resultSet.getString("COMPANYNAME");
    			String Cargo = resultSet.getString("CARGO");
    			String SenderAdd = resultSet.getString("SENDERADD");
    			String ReceiveName = resultSet.getString("RECEIVENAME");
    			String ReceivePhone = resultSet.getString("RECEIVEPHONE");
    			String ReceiveIdcard = resultSet.getString("RECEIVEIDCARD");
    			String senderName = resultSet.getString("NAME");
    			String senderPhone = resultSet.getString("PHONE");
    			String senderIdcard = resultSet.getString("IDCARD");
    			String ReceiveAdd = resultSet.getString("RECEIVEADD");
    			String Staus = resultSet.getString("STATUS");
    			String CustomeRid = resultSet.getString("CUSTOMERID");
    			String Pay = resultSet.getString("PAY");
    			String Money = resultSet.getString("MONEY");
    			String CreationTime = resultSet.getString("CREATIONTIME");
    			
    			Goods goods2 = new Goods(Goodsid, CompanyName, Cargo, CustomeRid, senderName, senderPhone, senderIdcard, SenderAdd,ReceiveName, ReceivePhone, ReceiveIdcard, ReceiveAdd, Pay, Money, Staus, CreationTime);
    			NotFinsh.add(goods2);
    			
    		}
            return NotFinsh;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
        	ConnectUtil.closeConnection(connection);
        }
        return null;
    }
    
    public ArrayList<Goods> GlistNotFinshForUserForReceive(String phone) {//顾客是收件人的还在运输中的订单（包括待发货，运途中，待收货），通过用户手机号查询
    	Connection connection = ConnectUtil.getConnection();
    	ArrayList<Goods> NotFinsh = new ArrayList<Goods>();
    	
    	try {
    		PreparedStatement preparedStatement = connection.prepareStatement("SELECT GOODSID,COMPANYNAME,CARGO,SENDERADD,RECEIVENAME,RECEIVEPHONE,RECEIVEIDCARD,RECEIVEADD,STATUS,CREATIONTIME,GOODS.CUSTOMERID,PAY,MONEY,NAME,PHONE,IDCARD FROM GOODS,CUSTOMER WHERE STATUS IN ('1','2','3') AND GOODS.RECEIVEPHONE=? AND GOODS.CUSTOMERID=CUSTOMER.CUSTOMERID");
    		preparedStatement.setString(1, phone);
    		
    		ResultSet resultSet = preparedStatement.executeQuery();
    		while (resultSet.next()) {
    			String Goodsid = resultSet.getString("GOODSID");
    			String CompanyName = resultSet.getString("COMPANYNAME");
    			String Cargo = resultSet.getString("CARGO");
    			String SenderAdd = resultSet.getString("SENDERADD");
    			String ReceiveName = resultSet.getString("RECEIVENAME");
    			String ReceivePhone = resultSet.getString("RECEIVEPHONE");
    			String ReceiveIdcard = resultSet.getString("RECEIVEIDCARD");
    			String senderName = resultSet.getString("NAME");
    			String senderPhone = resultSet.getString("PHONE");
    			String senderIdcard = resultSet.getString("IDCARD");
    			String ReceiveAdd = resultSet.getString("RECEIVEADD");
    			String Staus = resultSet.getString("STATUS");
    			String CustomeRid = resultSet.getString("CUSTOMERID");
    			String Pay = resultSet.getString("PAY");
    			String Money = resultSet.getString("MONEY");
    			String CreationTime = resultSet.getString("CREATIONTIME");
    			
    			Goods goods2 = new Goods(Goodsid, CompanyName, Cargo, CustomeRid, senderName, senderPhone, senderIdcard, SenderAdd,ReceiveName, ReceivePhone, ReceiveIdcard, ReceiveAdd, Pay, Money, Staus, CreationTime);
    			NotFinsh.add(goods2);
    			
    		}
    		return NotFinsh;
    	} catch (SQLException e) {
    		e.printStackTrace();
    	}finally {
    		ConnectUtil.closeConnection(connection);
    	}
    	return null;
    }

    public ArrayList<Goods> GlistFinishForUser(String customerId) {// 顾客完成和截胡的历史订单
    	Connection connection = ConnectUtil.getConnection();
        ArrayList<Goods> Finish = new ArrayList<Goods>();

        try {
        	PreparedStatement preparedStatement = connection.prepareStatement("SELECT GOODSID,COMPANYNAME,CARGO,SENDERADD,RECEIVENAME,RECEIVEPHONE,RECEIVEIDCARD,RECEIVEADD,STATUS,CREATIONTIME,GOODS.CUSTOMERID,PAY,MONEY,NAME,PHONE,IDCARD FROM GOODS,CUSTOMER WHERE STATUS IN ('4','5') AND GOODS.CUSTOMERID=? AND GOODS.CUSTOMERID=CUSTOMER.CUSTOMERID");
    		preparedStatement.setString(1, customerId);
    		
    		ResultSet resultSet = preparedStatement.executeQuery();
    		while (resultSet.next()) {
    			String Goodsid = resultSet.getString("GOODSID");
    			String CompanyName = resultSet.getString("COMPANYNAME");
    			String Cargo = resultSet.getString("CARGO");
    			String SenderAdd = resultSet.getString("SENDERADD");
    			String ReceiveName = resultSet.getString("RECEIVENAME");
    			String ReceivePhone = resultSet.getString("RECEIVEPHONE");
    			String ReceiveIdcard = resultSet.getString("RECEIVEIDCARD");
    			String senderName = resultSet.getString("NAME");
    			String senderPhone = resultSet.getString("PHONE");
    			String senderIdcard = resultSet.getString("IDCARD");
    			String ReceiveAdd = resultSet.getString("RECEIVEADD");
    			String Staus = resultSet.getString("STATUS");
    			String CustomeRid = resultSet.getString("CUSTOMERID");
    			String Pay = resultSet.getString("PAY");
    			String Money = resultSet.getString("MONEY");
    			String CreationTime = resultSet.getString("CREATIONTIME");
    			
    			Goods goods2 = new Goods(Goodsid, CompanyName, Cargo, CustomeRid, senderName, senderPhone, senderIdcard, SenderAdd,ReceiveName, ReceivePhone, ReceiveIdcard, ReceiveAdd, Pay, Money, Staus, CreationTime);
    			Finish.add(goods2);
    			
    		}
    		return Finish;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
        	ConnectUtil.closeConnection(connection);
        }
        return Finish;
    }
    public ArrayList<Goods> GlistReceiveFinishForUser(String phone) {// 顾客收件的历史订单，通过手机号查询
    	Connection connection = ConnectUtil.getConnection();
    	ArrayList<Goods> Finish = new ArrayList<Goods>();
    	
    	try {
    		PreparedStatement preparedStatement = connection.prepareStatement("SELECT GOODSID,COMPANYNAME,CARGO,SENDERADD,RECEIVENAME,RECEIVEPHONE,RECEIVEIDCARD,RECEIVEADD,STATUS,CREATIONTIME,GOODS.CUSTOMERID,PAY,MONEY,NAME,PHONE,IDCARD FROM GOODS,CUSTOMER WHERE STATUS IN ('4','5') AND RECEIVEPHONE=? AND GOODS.CUSTOMERID=CUSTOMER.CUSTOMERID");
    		preparedStatement.setString(1, phone);
    		
    		ResultSet resultSet = preparedStatement.executeQuery();
    		while (resultSet.next()) {
    			String Goodsid = resultSet.getString("GOODSID");
    			String CompanyName = resultSet.getString("COMPANYNAME");
    			String Cargo = resultSet.getString("CARGO");
    			String SenderAdd = resultSet.getString("SENDERADD");
    			String ReceiveName = resultSet.getString("RECEIVENAME");
    			String ReceivePhone = resultSet.getString("RECEIVEPHONE");
    			String ReceiveIdcard = resultSet.getString("RECEIVEIDCARD");
    			String senderName = resultSet.getString("NAME");
    			String senderPhone = resultSet.getString("PHONE");
    			String senderIdcard = resultSet.getString("IDCARD");
    			String ReceiveAdd = resultSet.getString("RECEIVEADD");
    			String Staus = resultSet.getString("STATUS");
    			String CustomeRid = resultSet.getString("CUSTOMERID");
    			String Pay = resultSet.getString("PAY");
    			String Money = resultSet.getString("MONEY");
    			String CreationTime = resultSet.getString("CREATIONTIME");
    			
    			Goods goods2 = new Goods(Goodsid, CompanyName, Cargo, CustomeRid, senderName, senderPhone, senderIdcard, SenderAdd,ReceiveName, ReceivePhone, ReceiveIdcard, ReceiveAdd, Pay, Money, Staus, CreationTime);
    			Finish.add(goods2);
    			
    		}
    		return Finish;
    	} catch (SQLException e) {
    		e.printStackTrace();
    	}finally {
    		ConnectUtil.closeConnection(connection);
    	}
    	return Finish;
    }
    
    public ArrayList<Goods> GlistFinishForAdmin() {// 顾客所有订单，供管理员查看
    	Connection connection = ConnectUtil.getConnection();
    	ArrayList<Goods> Finish = new ArrayList<Goods>();
    	
    	try {
    		PreparedStatement preparedStatement = connection.prepareStatement("SELECT GOODSID,COMPANYNAME,CARGO,SENDERADD,RECEIVENAME,RECEIVEPHONE,RECEIVEIDCARD,RECEIVEADD,STATUS,CREATIONTIME,GOODS.CUSTOMERID,PAY,MONEY,NAME,PHONE,IDCARD FROM GOODS,CUSTOMER WHERE GOODS.CUSTOMERID=CUSTOMER.CUSTOMERID");
    		
    		ResultSet resultSet = preparedStatement.executeQuery();
    		while (resultSet.next()) {
    			String Goodsid = resultSet.getString("GOODSID");
    			String CompanyName = resultSet.getString("COMPANYNAME");
    			String Cargo = resultSet.getString("CARGO");
    			String SenderAdd = resultSet.getString("SENDERADD");
    			String ReceiveName = resultSet.getString("RECEIVENAME");
    			String ReceivePhone = resultSet.getString("RECEIVEPHONE");
    			String ReceiveIdcard = resultSet.getString("RECEIVEIDCARD");
    			String senderName = resultSet.getString("NAME");
    			String senderPhone = resultSet.getString("PHONE");
    			String senderIdcard = resultSet.getString("IDCARD");
    			String ReceiveAdd = resultSet.getString("RECEIVEADD");
    			String Staus = resultSet.getString("STATUS");
    			String CustomeRid = resultSet.getString("CUSTOMERID");
    			String Pay = resultSet.getString("PAY");
    			String Money = resultSet.getString("MONEY");
    			String CreationTime = resultSet.getString("CREATIONTIME");
    			
    			Goods goods2 = new Goods(Goodsid, CompanyName, Cargo, CustomeRid, senderName, senderPhone, senderIdcard, SenderAdd,ReceiveName, ReceivePhone, ReceiveIdcard, ReceiveAdd, Pay, Money, Staus, CreationTime);
    			Finish.add(goods2);
    			
    		}
    		return Finish;
    	} catch (SQLException e) {
    		e.printStackTrace();
    	}finally {
    		ConnectUtil.closeConnection(connection);
    	}
    	return Finish;
    }
	public boolean DeleteGoods(String goodsid){
	    	Connection connection=ConnectUtil.getConnection();
		try {
			PreparedStatement preparedStatement=connection.prepareStatement("DELETE FROM GOODS WHERE GOODSID=?");
			preparedStatement.setString(1,goodsid);
	       int ret=preparedStatement.executeUpdate();
	       System.out.println(ret);
			return  ret>0;
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}
	return false;
	}
}