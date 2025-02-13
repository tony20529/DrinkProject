package service;

import java.util.List;

import model.Porder;

public interface PorderService {
		//create
		void addPorder(Porder porder);//增加表單
		
		//read-->列印報表
		String AllPorder();//列印報表
		List<Porder> findAllPorder();//訂單陣列
		Porder findById(int id);//透過ID找訂單
		
		//update
		void updatePorder(int pearlmilktea,int duoduogreentea,int milkcoveredgreentea,int coffee,int pearlmilk,int id);//更改訂單
		void updatePorder(String username,int id);//更改客戶帳號
		void updateSeller(String seller,int id);//更改服務員姓名
		
		
		//delete
		void deletePorderById(int id);//刪除訂單

}
