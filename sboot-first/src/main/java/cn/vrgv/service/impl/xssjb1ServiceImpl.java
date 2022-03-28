package cn.vrgv.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import cn.vrgv.dao.xssjb1Mapper;
import cn.vrgv.pojo.xssjb1;
import cn.vrgv.service.Xssjb1Service;

@Service
@ComponentScan("cn.vrgv.dao")
public class xssjb1ServiceImpl implements Xssjb1Service {

	@Autowired
	private xssjb1Mapper xDao;

	@Override
	public List<xssjb1> findAll(xssjb1 sjb) {
		/*
		 * ApplicationContext context = new
		 * ClassPathXmlApplicationContext("applicationContext.xml");
		 * userDao = (UserDao)context.getBean("userDao");
		 */
		List<xssjb1> list = new ArrayList<xssjb1>();
		list = xDao.selectAll(sjb);
		System.out.println("查询结果:" + list.size());
		return list;
	}

	@Override
	public int updateOne(xssjb1 sjb) {
		return xDao.updateOne(sjb);
	}

	@Override
	public int insertOne(xssjb1 sjb) {
		return xDao.insertOne(sjb);
	}

	@Override
	public int deleteOne(String id) {
		return xDao.deleteOne(id);
	}
}
