package cn.vrgv.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import cn.vrgv.dao.userInfoMapper;
import cn.vrgv.pojo.userInfo;
import cn.vrgv.service.UserService;

@Service
@ComponentScan("cn.vrgv.dao")
public class UserServiceImpl implements UserService {

	@Autowired
	private userInfoMapper userDao;
	
	@Override
	public List<userInfo> findAllUser(userInfo uin) {
		/*ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		userDao = (UserDao)context.getBean("userDao");*/
		List<userInfo> list = new ArrayList<userInfo>();
		list = userDao.selectAll(uin);
		System.out.println("查询结果:" + list.size());
		return list;
	}
	@Override
	public int insert(userInfo ui) {
		int res = userDao.insert(ui);
		System.out.println("插入结果:" + res);
		return res;
	}
}

