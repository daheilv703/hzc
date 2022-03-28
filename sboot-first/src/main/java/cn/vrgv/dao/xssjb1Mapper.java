package cn.vrgv.dao;

import java.util.List;

import cn.vrgv.pojo.xssjb1;


public interface xssjb1Mapper {
	List<xssjb1> selectAll(xssjb1 xssjb );
	int updateOne(xssjb1 sjb);
	int insertOne(xssjb1 sjb);
	int deleteOne(String id);
    
}