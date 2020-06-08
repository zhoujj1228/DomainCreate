package design.menucreate;

import design.util.FastJsonUtil;

/**
 * 将json字符串导入menuController.js
 * @author Administrator
 *
 */
public class MenuCreateExample {
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
}
