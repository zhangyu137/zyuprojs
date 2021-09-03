package com.lanqiao.team9.expresssystem.service;

import java.util.ArrayList;
import com.lanqiao.team9.expresssystem.dao.GoodsDao;
import com.lanqiao.team9.expresssystem.entity.Goods;
import com.lanqiao.team9.expresssystem.util.DateUtil;
import com.lanqiao.team9.expresssystem.util.UUIDUtil;

public class GoodService extends BaseServiceAdapter<Goods> implements IBaseService<Goods> {

	GoodsDao goodsdao=new GoodsDao();
	@Override
	public boolean add(Goods good) {  //添加订单
		good.setGoodsid(UUIDUtil.getUUID());
		good.setCreationtime(DateUtil.getNow(DateUtil.DATE_YMDHMS2));
		if(goodsdao.Gadd(good)) {
			return true;
		}
		return false;
	}
	
	public ArrayList<Goods> FuzzyQueryForAdmin(String goodsid,String companyName){		//通过订单编号和快递公司模糊查询出订单信息
		ArrayList<Goods> arrayList=goodsdao.FuzzyQueryForAdmin(goodsid, companyName);
		if(arrayList==null) {
			return null;
		}
		for (Goods goods : arrayList) {
			if("0".equals(goods.getPay())) {
				goods.setPay("到付");
			}else {
				goods.setPay("现付");
			}
			switch(goods.getStatus()) {
			case "0":
				goods.setStatus("待接收订单");
				break;
			case "1":
				goods.setStatus("待发货");
				break;
			case "2":
				goods.setStatus("运途中");
				break;
			case "3":
				goods.setStatus("待收货");
				break;
			case "4":
				goods.setStatus("收货成功订单");
				break;
			case "5":
				goods.setStatus("撤销截胡");
				break;
			}
		}
		return arrayList;
	}
	
	public boolean GUpdateGoodsInfo(String receivephone,String receiveidcard ,String receiveadd,String pay,String money,String goodsid){//对货物的一些信息进行更新
		if (GUpdateGoodsInfo(receivephone,receiveidcard,receiveadd,pay,money,goodsid)){
			return true;
		}
		return false;
	}
	
	
	public boolean GupdateForTransport(String goodId,String status) { /**对货物运输状态的更改,通过订单编号和状态传参更改 */
		if(goodsdao.GupdateForTransport(goodId, status)) {
			return true;
		}
		return false;
		
	}

	public boolean DelelteGoods(String goodsid){  //根据订单编号删货
		if (goodsdao.DeleteGoods(goodsid)){
			return  true;
		}
		return false;
	}
	public boolean GupdateGoodsInfoForAdmin(Goods goods){/** 货品信息更改*/
		if("到付".equals(goods.getPay())) {
			goods.setPay("0");
		}else {
			goods.setPay("1");
		}
		switch(goods.getStatus()) {
		case "待接收订单":
			goods.setStatus("0");
			break;
		case "待发货":
			goods.setStatus("1");
			break;
		case "运途中":
			goods.setStatus("2");
			break;
		case "待收货":
			goods.setStatus("3");
			break;
		case "收货成功订单":
			goods.setStatus("4");
			break;
		case "撤销截胡":
			goods.setStatus("5");
			break;
		}
		if(goodsdao.GupdateGoodsInfoForAdmin(goods)) {
			return true;
		}
		return false;
	}
	public boolean GupdateGoodsInfoForCompany(Goods goods){/** 货品信息更改*/
		if("到付".equals(goods.getPay())) {
			goods.setPay("0");
		}else {
			goods.setPay("1");
		}
		switch(goods.getStatus()) {
		case "待接收订单":
			goods.setStatus("0");
			break;
		case "待发货订单":
			goods.setStatus("1");
			break;
		case "运途中订单":
			goods.setStatus("2");
			break;
		case "待收货订单":
			goods.setStatus("3");
			break;
		case "收货成功订单":
			goods.setStatus("4");
			break;
		case "撤销截胡":
			goods.setStatus("5");
			break;
		}
		if(goodsdao.GupdateGoodsInfoForCompany(goods)) {
			return true;
		}
		return false;
	}
	
	public ArrayList<Goods> GlistForCompanyS0(String companyName){  //快递公司查询待接收的订单
		ArrayList<Goods> arrayList=goodsdao.GlistForCompanyS0(companyName);
		
		if(arrayList==null) {
			return null;
		}
		for (Goods goods : arrayList) {
			goods.setCreationtime(DateUtil.getNow(DateUtil.DATE_YMD2));
			if("0".equals(goods.getPay())) {
				goods.setPay("到付");
			}else {
				goods.setPay("现付");
			}
			goods.setStatus("待接收订单");
		}
		return arrayList;
		
	}
	
	public ArrayList<Goods> GlistForCompanyS1(String companyName) {  //快递公司查询待发货订单
		ArrayList<Goods> arrayList=goodsdao.GlistForCompanyS1(companyName);
		if(arrayList==null) {
			return null;
		}
		for (Goods goods : arrayList) {
			goods.setCreationtime(DateUtil.getNow(DateUtil.DATE_YMD2));
			if("0".equals(goods.getPay())) {
				goods.setPay("到付");
			}else {
				goods.setPay("现付");
			}
			goods.setStatus("待发货订单");
		}
		return arrayList;
	}
	
	public ArrayList<Goods> GlistForCompanyS2(String companyName) {  //快递公司查询运途中的订单
		ArrayList<Goods> arrayList=goodsdao.GlistForCompanyS2(companyName);
		if(arrayList==null) {
			return null;
		}
		for (Goods goods : arrayList) {
			goods.setCreationtime(DateUtil.getNow(DateUtil.DATE_YMD2));
			if("0".equals(goods.getPay())) {
				goods.setPay("到付");
			}else {
				goods.setPay("现付");
			}
			goods.setStatus("运途中订单");
		}
		return arrayList;
	}
	
	public ArrayList<Goods> GlistForCompanyS3(String companyName) {	//快递公司查询待收货的订单
		ArrayList<Goods> arrayList=goodsdao.GlistForCompanyS3(companyName);
		if(arrayList==null) {
			return null;
		}
		for (Goods goods : arrayList) {
			goods.setCreationtime(DateUtil.getNow(DateUtil.DATE_YMD2));
			if("0".equals(goods.getPay())) {
				goods.setPay("到付");
			}else {
				goods.setPay("现付");
			}
			goods.setStatus("待收货订单");
		}
		return arrayList;
	}
	
	public ArrayList<Goods> GlistForCompanyS4(String companyName) {	//快递公司查询收货完成的订单
		ArrayList<Goods> arrayList=goodsdao.GlistForCompanyS4(companyName);
		if(arrayList==null) {
			return null;
		}
		for (Goods goods : arrayList) {
			goods.setCreationtime(DateUtil.getNow(DateUtil.DATE_YMD2));
			if("0".equals(goods.getPay())) {
				goods.setPay("到付");
			}else {
				goods.setPay("现付");
			}
			goods.setStatus("收货成功订单");
		}
		return arrayList;
	}
	
	public ArrayList<Goods> GlistForCompanyS5(String companyName) {	//快递公司查询被截胡的订单
		ArrayList<Goods> arrayList=goodsdao.GlistForCompanyS5(companyName);
		if(arrayList==null) {
			return null;
		}
		for (Goods goods : arrayList) {
			goods.setCreationtime(DateUtil.getNow(DateUtil.DATE_YMD2));
			if("0".equals(goods.getPay())) {
				goods.setPay("到付");
			}else {
				goods.setPay("现付");
			}
			goods.setStatus("被截胡订单");
		}
		return arrayList;
	}
	
	public ArrayList<Goods> GlistNotAtivityForUser(String customerId) {//寄件人的快递公司待接收的订单，通过用户id查询
		ArrayList<Goods> arrayList=goodsdao.GlistNotAtivityForUser(customerId);
		for (Goods goods : arrayList) {
			if("0".equals(goods.getPay())) {
				goods.setPay("到付");
			}else {
				goods.setPay("现付");
			}
			goods.setStatus("待接收订单");
		}
		return arrayList;
	}
	public ArrayList<Goods> GlistNotFinshForUserFor1(String customerId) {//寄件人的待发货的订单，通过用户id查询
		ArrayList<Goods> arrayList=goodsdao.GlistNotFinshForUserFor1(customerId);
		for (Goods goods : arrayList) {
			if("0".equals(goods.getPay())) {
				goods.setPay("到付");
			}else {
				goods.setPay("现付");
			}
			goods.setStatus("待发货订单");
		}
		return arrayList;
	}
	public ArrayList<Goods> GlistNotFinshForUserFor2(String customerId) {//寄件人的运途中的订单，通过用户id查询
		ArrayList<Goods> arrayList=goodsdao.GlistNotFinshForUserFor2(customerId);
		for (Goods goods : arrayList) {
			if("0".equals(goods.getPay())) {
				goods.setPay("到付");
			}else {
				goods.setPay("现付");
			}
			goods.setStatus("运途中订单");
		}
		return arrayList;
	}
	public ArrayList<Goods> GlistNotFinshForUserFor3(String customerId) {//寄件人的待收货的订单，通过用户id查询
		ArrayList<Goods> arrayList=goodsdao.GlistNotFinshForUserFor3(customerId);
		for (Goods goods : arrayList) {
			if("0".equals(goods.getPay())) {
				goods.setPay("到付");
			}else {
				goods.setPay("现付");
			}
			goods.setStatus("待收货订单");
		}
		return arrayList;
	}
	
	
	
	public ArrayList<Goods> GlistNotFinshForUser(String customerId) {//寄件人的还在运输中的订单（包括待发货，运途中，待收货），通过用户id查询
		ArrayList<Goods> arrayList=goodsdao.GlistNotFinshForUser(customerId);
		if(arrayList==null) {
			return null;
		}
		for (Goods goods : arrayList) {
			if("0".equals(goods.getPay())) {
				goods.setPay("到付");
			}else {
				goods.setPay("现付");
			}
			switch(goods.getStatus()) {
			case "1":
				goods.setStatus("待发货");
				break;
			case "2":
				goods.setStatus("运途中");
				break;
			case "3":
				goods.setStatus("待收货");
			}
		}
		return arrayList;
	}
	
	public ArrayList<Goods> GlistNotFinshForUserForReceive(String customerId) {//收件人的还在运输中的订单（包括待发货，运途中，待收货），通过用户id查询
		ArrayList<Goods> arrayList=goodsdao.GlistNotFinshForUserForReceive(customerId);
		if(arrayList==null) {
			return null;
		}
		for (Goods goods : arrayList) {
			if("0".equals(goods.getPay())) {
				goods.setPay("到付");
			}else {
				goods.setPay("现付");
			}
			switch(goods.getStatus()) {
			case "1":
				goods.setStatus("待发货");
				break;
			case "2":
				goods.setStatus("运途中");
				break;
			case "3":
				goods.setStatus("待收货");
			}
		}
		return arrayList;
	}
	
	public ArrayList<Goods> GlistFinishForUser(String customerId) {// 顾客完成和截胡的历史订单
		ArrayList<Goods> arrayList=goodsdao.GlistFinishForUser(customerId);
		if(arrayList==null) {
			return null;
		}
		for (Goods goods : arrayList) {
			if("0".equals(goods.getPay())) {
				goods.setPay("到付");
			}else {
				goods.setPay("现付");
			}
			switch(goods.getStatus()) {
			case "4":
				goods.setStatus("收货成功订单");
				break;
			case "5":
				goods.setStatus("撤销截胡");
				break;
			}
		}
		return arrayList;
	}
	public ArrayList<Goods> GlistReceiveFinishForUser(String phone) {// 顾客收件的历史订单，通过手机号查询
		ArrayList<Goods> arrayList=goodsdao.GlistReceiveFinishForUser(phone);
		if(arrayList==null) {
			return null;
		}
		for (Goods goods : arrayList) {
			if("0".equals(goods.getPay())) {
				goods.setPay("到付");
			}else {
				goods.setPay("现付");
			}
			switch(goods.getStatus()) {
			case "4":
				goods.setStatus("收货成功订单");
				break;
			case "5":
				goods.setStatus("撤销截胡");
				break;
			}
		}
		return arrayList;
	}
	public ArrayList<Goods> GlistFinishForAdmin() {// 顾客所有订单，供管理员查看
		ArrayList<Goods> arrayList=goodsdao.GlistFinishForAdmin();
		if(arrayList==null) {
			return null;
		}
		for (Goods goods : arrayList) {
			if("0".equals(goods.getPay())) {
				goods.setPay("到付");
			}else {
				goods.setPay("现付");
			}
			switch(goods.getStatus()) {
			case "0":
				goods.setStatus("待接收订单");
				break;
			case "1":
				goods.setStatus("待发货");
				break;
			case "2":
				goods.setStatus("运途中");
				break;
			case "3":
				goods.setStatus("待收货");
				break;
			case "4":
				goods.setStatus("收货成功订单");
				break;
			case "5":
				goods.setStatus("撤销截胡");
				break;
			}
		}
		return arrayList;
	}
}
