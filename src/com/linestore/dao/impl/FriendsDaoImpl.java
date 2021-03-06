package com.linestore.dao.impl;

import com.linestore.dao.CustomerDao;
import com.linestore.dao.FriendsDao;
import com.linestore.dao.UserDao;
import com.linestore.vo.CusAddress;
import com.linestore.vo.Customer;
import com.linestore.vo.Friends;
import com.linestore.vo.UserModel;

import java.util.List;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

/**
 * 用户管理的实现类
 * 
 * @author AmenWu
 *
 */
public class FriendsDaoImpl extends HibernateDaoSupport implements FriendsDao {

	@Override
	public void save(Friends friends) {
		System.out.println("exec save");
		try {
			this.getHibernateTemplate().save(friends);
			System.out.println("add successful");
		} catch (RuntimeException e) {
			System.out.println("add failed!\n" + e);
			throw e;
		}
	}

	@Override
	public List<Friends> selectAll(Customer customer) {
		System.out.println("DAO中的select方法！");
		// 注意：HQL语句中表名应该是ORM映射的类名，而不是数据库中的表名
		String hql = "from Friends where customer.cusId = ?";
		List<Friends> list = (List<Friends>) this.getHibernateTemplate().find(hql, customer.getCusId());
		return list;
	}

	// 获取用户全部朋友资料A/B/C
	@Override
	public List<Friends> selectType(Friends friends) {
		System.out.println("DAO中的select方法！");
		// 注意：HQL语句中表名应该是ORM映射的类名，而不是数据库中的表名
		String hql = "from Friends where friType = ?";
		List<Friends> list = (List<Friends>) this.getHibernateTemplate().find(hql, friends.getFriType());
		return list;
	}

	@Override
	public Friends select(Friends friends) {
		return null;
	}
	
	public Friends queryByPhone(String phone) {
		List<Friends> fris = (List<Friends>) this.getHibernateTemplate().find("from Friends where friPhone='" + phone + "'");
		if (fris != null&&fris.size()>0) {
			return fris.get(0);
		}
		return null;
	}
	
	public List<Friends> queryType(int cusId, int type) {
		List<Friends> fris = (List<Friends>) this.getHibernateTemplate().find("from Friends where customer.cusId=? and friType=?", cusId, type);
		return fris;
	}

}
