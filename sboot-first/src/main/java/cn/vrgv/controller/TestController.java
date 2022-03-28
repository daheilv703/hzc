 package cn.vrgv.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import cn.vrgv.pojo.Result;
import cn.vrgv.pojo.User;
import cn.vrgv.pojo.xssjb1;
import cn.vrgv.pojo.userInfo;
import cn.vrgv.service.UserService;
import cn.vrgv.service.Xssjb1Service;

@Controller
@ComponentScan("cn.vrgv.service")
public class TestController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private Xssjb1Service xssjb1Service;
	

	@RequestMapping(value = "toTest", method = RequestMethod.GET)
	public String toTest() {
		System.out.println("toTest");
		userInfo ui = new userInfo();
		ui.setId("222");
		ui.setName("inserttest");
		ui.setPassword("2211111");
		ui.setInfo("fffffffffff");
//		int res = userService.insert(ui);
//		System.out.println(res);
		return "myvue";
	}

	@CrossOrigin
	@PostMapping(value = "api/login")
	@ResponseBody
	public Result test(@RequestBody User user) {

		List<userInfo> list = new ArrayList<userInfo>();
		userInfo ui = new userInfo();
		ui.setName(user.getUsername());
		ui.setPassword(user.getPassword());
		list = userService.findAllUser(ui);
		if (list.size() > 0) {
			return new Result(200);
		} else {
			return new Result(400);
		}
	}

	@CrossOrigin
	@PostMapping(value = "api/xs1")
	@ResponseBody
	public Result xs1() {
		System.out.println("333333");
		List<xssjb1> list = new ArrayList<xssjb1>();
		list = xssjb1Service.findAll(new xssjb1());

		if (list.size() > 0) {
			return new Result(200, list);
		} else {
			return new Result(400);
		}
	}
	
	@CrossOrigin
	@PostMapping(value = "api/updateSjb1")
	@ResponseBody
	public Result updateSjb1(xssjb1 params) {
		System.out.println("update begin!");
		int res = xssjb1Service.updateOne(params);
		System.out.println("更新完成 = "+res + "条");
		if (res > 0) {
			List<xssjb1> list = xssjb1Service.findAll(new xssjb1());
			if (list.size() > 0) {
				return new Result(200, list);
			} else {
				return new Result(400);
			}
		} else {
			return new Result(400);
		}
	}
	@CrossOrigin
	@PostMapping(value = "api/deleteOne")
	@ResponseBody
	public Result deleteOne(xssjb1 params) {
		System.out.println("id" + params.getId());
		int res = xssjb1Service.deleteOne(params.getId());
		System.out.println("删除完成 = "+res + "条");
		if (res > 0) {
			List<xssjb1> list = xssjb1Service.findAll(new xssjb1());
			if (list.size() > 0) {
				return new Result(200, list);
			} else {
				return new Result(400);
			}
		} else {
			return new Result(400);
		}
	}
}