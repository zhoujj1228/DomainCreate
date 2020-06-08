package design.datafieldcreate;

import java.util.ArrayList;
import java.util.List;

import design.util.FastJsonUtil;


public class DataFieldCreateExample {
	public static void main(String[] args) {
		DataField df1 = new DataField();
		df1.cnName = "姓名";
		df1.enName = "name";
		df1.type = "String";
		DataField df2 = new DataField();
		df2.cnName = "电话";
		df2.enName = "mobile";
		df2.type = "String";
		
		List<DataField> list = new ArrayList<DataField>();
		list.add(df1);
		list.add(df2);
		
		String strByObject = FastJsonUtil.getStrByObject(list);
		System.out.println(strByObject);
	}
}
