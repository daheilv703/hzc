package cn.vrgv.service;

import java.util.List;

import cn.vrgv.pojo.xssjb1;

public interface Xssjb1Service {
	// 查询所有商机
	public List<xssjb1> findAll(xssjb1 sjb);

	// 查询所有商机
	public int updateOne(xssjb1 sjb);

	// 查询所有商机
	public int insertOne(xssjb1 sjb);

	// 查询所有商机
	public int deleteOne(String id);
}
