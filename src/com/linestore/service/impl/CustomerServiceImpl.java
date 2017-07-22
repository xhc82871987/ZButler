package com.linestore.service.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.transaction.annotation.Transactional;

import com.linestore.dao.CustomerDao;
import com.linestore.service.CustomerService;
import com.linestore.util.QrCodeUtil;
import com.linestore.util.QrExistsUtil;
import com.linestore.vo.Customer;


@Transactional
public class CustomerServiceImpl implements CustomerService {
	
	private CustomerDao customerDao;

	public CustomerDao getCustomerDao() {
		return customerDao;
	}

	public void setCustomerDao(CustomerDao customerDao) {
		this.customerDao = customerDao;
	}

	@Override
	public void addCustomer(Customer customer) {
		customerDao.addCustomer(customer);
	}

	@Override
	public void updateCustomer(Customer customer) {
		customerDao.updateCustomer(customer);
	}

	@Override
	public void delCustomer(int cusId) {
		customerDao.delCustomer(cusId);
	}

	@Override
	public Customer findById(int cusId) {
		return customerDao.findById(cusId);
	}

	@Override
	public List<Customer> findByPhone(String phone) {
		return customerDao.findByPhone(phone);
	}

	@Override
	public List<Customer> queryAll(int offset, int length) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean checkCustomer(Customer customer) {
		return customerDao.checkCustomer(customer);
	}

	@Override
	public void updateField(String field, String value, int id) {
		customerDao.updateField(field, value, id);
	}
	
	
	@Override
	public Customer select(Customer customer) {
		Customer customerResult = null;
		// 获取数据库中用户二维码信息
		customer = customerDao.select(customer);
		// 判断二维码信息是否存在
		if (customer.getCusTdCode() != null && !"".equals(customer.getCusTdCode())) {
			boolean isQrExists = QrExistsUtil.qrExists(customer.getCusTdCode());
			// 如果数据库二维码信息存在，判断二维码图片文件是否存在
			if (isQrExists == false) {
				customerResult = QrExistsUtil.qrCreate(customer);
				customer.setCusShareUrl(customerResult.getCusShareUrl());
				customer.setCusTdCode(customerResult.getCusTdCode());
			}
		} else {

			customerResult = QrExistsUtil.qrCreate(customer);
			customerDao.updateCustomer(customerResult);
			customer=customerDao.select(customer);
		}

		return customer;
	}
}