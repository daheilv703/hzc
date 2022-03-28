package cn.vrgv.service;

import java.util.List;

import cn.vrgv.pojo.userInfo;

public interface  UserService {
	//查询所有用户
		public List<userInfo> findAllUser(userInfo uin);
		public int insert(userInfo ui);
}
