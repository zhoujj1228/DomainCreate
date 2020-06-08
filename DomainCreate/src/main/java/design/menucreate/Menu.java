package design.menucreate;

import java.util.ArrayList;
import java.util.List;

import design.util.FastJsonUtil;

/**
 * 菜单实体类
 * 其他见html
 * @author Administrator
 *
 */
public class Menu {
	String id;
	String name;
	String clickEvent;
	List<Menu> subMenuList = new ArrayList<Menu>();
	
	public String getClickEvent() {
		return clickEvent;
	}
	public void setClickEvent(String clickEvent) {
		this.clickEvent = clickEvent;
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
	public List<Menu> getSubMenuList() {
		return subMenuList;
	}
	public void setSubMenuList(List<Menu> subMenuList) {
		this.subMenuList = subMenuList;
	}
	
}
