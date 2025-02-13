package service.impl;

import java.util.List;

import dao.impl.MemberDaoImpl;
import dao.impl.PorderDaoImpl;
import model.Member;
import model.Porder;
import service.PorderService;

public class PorderServiceImpl implements PorderService {
	private static MemberServiceImpl memberserviceimpl=new MemberServiceImpl();
	private static PorderDaoImpl porderdaoimpl=new PorderDaoImpl();
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addPorder(Porder porder) {
		if(porder.getPearlmilktea()>=0 && porder.getDuoduogreentea()>=0 && porder.getMilkcoveredgreentea()>=0 && porder.getCoffee()>=0 && porder.getPearlmilk()>=0)
		{
			porderdaoimpl.add(porder);
		}
		
	}

	@Override
	public String AllPorder() {
		List<Porder> l=porderdaoimpl.selectAll();
		String show="";
		for(Porder p:l) 
		{	
			int sum=(p.getPearlmilktea()+p.getDuoduogreentea()+p.getMilkcoveredgreentea()+p.getCoffee()+p.getPearlmilk())*50;
			Member m=memberserviceimpl.findByUsername(p.getUsername());
			if(memberserviceimpl.findByMemberId(m.getId())!=null) {}
			else if(memberserviceimpl.findByVipMemberId(m.getId())!=null){sum=(int)(sum*0.9);}
			else {sum=(int)(sum*0.8);}
			show+="訂單編號:"+p.getId()+
					"\t客戶名:"+p.getName()+
					"\t客戶帳號:"+p.getUsername()+
					"\t珍珠奶茶:"+p.getPearlmilktea()+
					"\t多多綠茶:"+p.getDuoduogreentea()+
					"\t奶蓋綠茶:"+p.getMilkcoveredgreentea()+
					"\t咖啡:"+p.getCoffee()+
					"\t珍珠鮮奶:"+p.getPearlmilk()+
					"\t訂單總金額:"+sum+
					"\t\t購買時間:"+p.getTime()+
					"\t服務員:"+p.getSeller()+"\n";
		}
		return show;
	}

	@Override
	public List<Porder> findAllPorder() {
		return porderdaoimpl.selectAll();
	}

	@Override
	public Porder findById(int id) {
		Porder porder=null;
		if(id>0)
		{
			List<Porder> l=porderdaoimpl.selectById(id);
			if(l.size()>0)
			{
				porder=l.get(0);
			}
		}	
		return porder;
	}

	@Override
	public void updatePorder(int pearlmilktea,int duoduogreentea,int milkcoveredgreentea,int coffee,int pearlmilk,int id) {
		Porder p=findById(id);
		p.setPearlmilktea(pearlmilktea);
		p.setDuoduogreentea(duoduogreentea);
		p.setMilkcoveredgreentea(milkcoveredgreentea);
		p.setCoffee(coffee);
		p.setPearlmilk(pearlmilk);
		porderdaoimpl.update(p);
		
	}

	@Override
	public void updatePorder(String username,int id) {
		Member m=memberserviceimpl.findByUsername(username);
		Porder p=findById(id);
		p.setUsername(username);
		p.setName(m.getName());
		porderdaoimpl.update(p);
		
	}

	@Override
	public void updateSeller(String seller, int id) {
		Porder p=findById(id);
		p.setSeller(seller);
		porderdaoimpl.update(p);
	}

	@Override
	public void deletePorderById(int id) {
		if(id>0)
		{
			porderdaoimpl.delete(id);
		}
		
	}

}
