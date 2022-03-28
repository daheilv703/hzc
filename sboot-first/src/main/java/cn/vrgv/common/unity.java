package cn.vrgv.common;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import cn.vrgv.pojo.xssjb1;


public class unity {
	public List<String> getA11FromExce1(){
		List<xssjb1> peoList=new ArrayList<xssjb1>();
		File excelFile=new File("D：\\people.xlsx");
		FileInputStream fis;
		xssjb1 excel = null;
		try{
			fis = new FileInputStream(excelFile);
			XSSFWorkbook xfb = new XSSFWorkbook(fis);
			
			for (int numSheet = 0; numSheet <= xfb.getNumberOfSheets(); numSheet++) {
				XSSFSheet xs = xfb.getSheetAt(numSheet);
				//获取每个Sheet
				if (xs == null) {
					continue;
				}
				System.out.println(xs.getLastRowNum());
				for (int numRow = 1; numRow <= xs.getLastRowNum(); numRow++) {
					XSSFRow xr = xs.getRow(numRow);
					//从第一行开始获取每一行
					if (xr != null) {
						excel = new xssjb1();
						excel.setId(xr.getCell(0).getStringCellValue()); 
						excel.setBianhao(xr.getCell(1).getStringCellValue()); 
						excel.setXiangmu(xr.getCell(2).getStringCellValue()); 
						excel.setHangye(xr.getCell(3).getStringCellValue()); 
						excel.setHetongfang(xr.getCell(4).getStringCellValue()); 
						excel.setQuyu(xr.getCell(5).getStringCellValue()); 
						excel.setChengshi(xr.getCell(6).getStringCellValue()); 
						excel.setChuangjianshijian(Timestamp.valueOf(xr.getCell(7).getStringCellValue())); 
						excel.setLaiyuan(xr.getCell(8).getStringCellValue()); 
						excel.setJilv(xr.getCell(9).getStringCellValue()); 
						excel.setChanpinleixing(xr.getCell(10).getStringCellValue()); 
						excel.setCankaoxiangmu(xr.getCell(11).getStringCellValue()); 
						excel.setYingjian(xr.getCell(12).getStringCellValue()); 
						excel.setXiaoshouleixing(xr.getCell(13).getStringCellValue()); 
						excel.setCaigoujiedian(Timestamp.valueOf(xr.getCell(14).getStringCellValue())); 
						excel.setJine(xr.getCell(15).getStringCellValue()); 
						excel.setJieduan(xr.getCell(16).getStringCellValue()); 
						excel.setBeijingmiaoshu(xr.getCell(17).getStringCellValue()); 
						excel.setFuzeren(xr.getCell(18).getStringCellValue()); 
						peoList.add(excel);
					}
				}
			}
			xfb.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
