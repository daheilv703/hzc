package cn.vrgv.pojo;

import java.sql.Timestamp;
import java.time.LocalDateTime;

public class xssjb1 {
	String chkbox;
	String id;
	String bianhao;
	String xiangmu;
	String hangye;
	String hetongfang;
	String quyu;
	String chengshi;
	// 创建时间：日期类型
	Timestamp chuangjianshijian = Timestamp.valueOf(LocalDateTime.now());
	String laiyuan;
	// 机率:1-最高；10-最低
	String jilv;
	// 产品类型
	String chanpinleixing;
	String cankaoxiangmu;
	String yingjian;
	String xiaoshouleixing;
	Timestamp caigoujiedian = Timestamp.valueOf(LocalDateTime.now());
	String jine;
	String jieduan;
	String beijingmiaoshu;
	String fuzeren;
	// 时间戳
	Timestamp updatetime = Timestamp.valueOf(LocalDateTime.now());
	Timestamp createtime = Timestamp.valueOf(LocalDateTime.now());
	String createuser;
	String updateuser;

	public String getChkbox() {
		return chkbox;
	}

	public void setChkbox(String chkbox) {
		this.chkbox = chkbox;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getBianhao() {
		return bianhao;
	}

	public void setBianhao(String bianhao) {
		this.bianhao = bianhao;
	}

	public String getXiangmu() {
		return xiangmu;
	}

	public void setXiangmu(String xiangmu) {
		this.xiangmu = xiangmu;
	}

	public String getHangye() {
		return hangye;
	}

	public void setHangye(String hangye) {
		this.hangye = hangye;
	}

	public String getHetongfang() {
		return hetongfang;
	}

	public void setHetongfang(String hetongfang) {
		this.hetongfang = hetongfang;
	}

	public String getQuyu() {
		return quyu;
	}

	public void setQuyu(String quyu) {
		this.quyu = quyu;
	}

	public String getChengshi() {
		return chengshi;
	}

	public void setChengshi(String chengshi) {
		this.chengshi = chengshi;
	}

	public Timestamp getChuangjianshijian() {
		return chuangjianshijian;
	}

	public void setChuangjianshijian(Timestamp chuangjianshijian) {
		this.chuangjianshijian = chuangjianshijian;
	}

	public String getLaiyuan() {
		return laiyuan;
	}

	public void setLaiyuan(String laiyuan) {
		this.laiyuan = laiyuan;
	}

	public String getJilv() {
		return jilv;
	}

	public void setJilv(String jilv) {
		this.jilv = jilv;
	}

	public String getChanpinleixing() {
		return chanpinleixing;
	}

	public void setChanpinleixing(String chanpinleixing) {
		this.chanpinleixing = chanpinleixing;
	}

	public String getCankaoxiangmu() {
		return cankaoxiangmu;
	}

	public void setCankaoxiangmu(String cankaoxiangmu) {
		this.cankaoxiangmu = cankaoxiangmu;
	}

	public String getYingjian() {
		return yingjian;
	}

	public void setYingjian(String yingjian) {
		this.yingjian = yingjian;
	}

	public String getXiaoshouleixing() {
		return xiaoshouleixing;
	}

	public void setXiaoshouleixing(String xiaoshouleixing) {
		this.xiaoshouleixing = xiaoshouleixing;
	}

	public Timestamp getCaigoujiedian() {
		return caigoujiedian;
	}

	public void setCaigoujiedian(Timestamp caigoujiedian) {
		this.caigoujiedian = caigoujiedian;
	}

	public String getJine() {
		return jine;
	}

	public void setJine(String jine) {
		this.jine = jine;
	}

	public String getJieduan() {
		return jieduan;
	}

	public void setJieduan(String jieduan) {
		this.jieduan = jieduan;
	}

	public String getBeijingmiaoshu() {
		return beijingmiaoshu;
	}

	public void setBeijingmiaoshu(String beijingmiaoshu) {
		this.beijingmiaoshu = beijingmiaoshu;
	}

	public String getFuzeren() {
		return fuzeren;
	}

	public void setFuzeren(String fuzeren) {
		this.fuzeren = fuzeren;
	}

	public Timestamp getUpdatetime() {
		return updatetime;
	}

	public void setUpdatetime(Timestamp updatetime) {
		this.updatetime = updatetime;
	}

	public Timestamp getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Timestamp createtime) {
		this.createtime = createtime;
	}

	public String getCreateuser() {
		return createuser;
	}

	public void setCreateuser(String createuser) {
		this.createuser = createuser;
	}

	public String getUpdateuser() {
		return updateuser;
	}

	public void setUpdateuser(String updateuser) {
		this.updateuser = updateuser;
	}
}
