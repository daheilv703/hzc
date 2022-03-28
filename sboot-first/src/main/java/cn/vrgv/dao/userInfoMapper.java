package cn.vrgv.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import cn.vrgv.pojo.userInfo;
import cn.vrgv.pojo.userInfoExample;

public interface userInfoMapper {
    long countByExample(userInfoExample example);

    int deleteByExample(userInfoExample example);

    int insert(userInfo record);

    int insertSelective(userInfo record);

    List<userInfo> selectByExample(userInfoExample example);
    
    List<userInfo> selectAll(userInfo userInfo);
    

    int updateByExampleSelective(@Param("record") userInfo record, @Param("example") userInfoExample example);

    int updateByExample(@Param("record") userInfo record, @Param("example") userInfoExample example);
}