package design.menucreate;

import java.util.ArrayList;
import java.util.List;

import util.FastJsonUtil;

/**
 * 生成菜单json
 * 其他见html
 * @author Administrator
 *
 */
public class Menu {
	String id;
	String name;
	String url;
	List<Menu> subMenuList = new ArrayList<Menu>();
	
	public static void main(String[] args) {
		Menu menu = new Menu();
		menu.setName("菜单管理");
		menu.setId("1");
		Menu menu1 = new Menu();
		menu1.setName("用户管理1");
		menu1.setId("11");
		Menu menu2 = new Menu();
		menu2.setName("用户管理2");
		menu2.setId("12");
		
		Menu menu11 = new Menu();
		menu11.setName("用户管理11");
		menu11.setId("111");
		Menu menu12 = new Menu();
		menu12.setName("用户管理12");
		menu12.setId("112");
		
		menu1.getSubMenuList().add(menu11);
		menu1.getSubMenuList().add(menu12);
		
		menu.getSubMenuList().add(menu1);
		menu.getSubMenuList().add(menu2);
		
		String strByObject = FastJsonUtil.getStrByObject(menu);
		System.out.println(strByObject);
		
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public List<Menu> getSubMenuList() {
		return subMenuList;
	}
	public void setSubMenuList(List<Menu> subMenuList) {
		this.subMenuList = subMenuList;
	}
	
}
