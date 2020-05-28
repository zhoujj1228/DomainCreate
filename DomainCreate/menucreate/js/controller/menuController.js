/**
 * 
 */

function initMenu() {
	var jsonStr = '{"subMenuList":[{"subMenuList":[{"subMenuList":[],"name":"用户管理11","id":"111","url":""},{"subMenuList":[],"name":"用户管理12","id":"112","url":""}],"name":"用户管理1","id":"11","url":""},{"subMenuList":[],"name":"用户管理2","id":"12","url":""}],"name":"菜单管理","id":"1","url":""}'
	var jsonObj = $.parseJSON(jsonStr);
	itorCreateMenu(jsonObj, $("#my-menu").get(0));
}





