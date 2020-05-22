/**
 * 
 */

function itorCreateMenu(menuObj, rootElement) {
// alert(menuObj.subMenuList.length);
// alert(menuObj.subMenuList[1].name);
	var len = menuObj.subMenuList.length;
	var name = menuObj.name;
	var id = menuObj.id;
	var url = menuObj.url;
	var attrArray = initAttrArray(len, id);
	var subElementRootElement;
	
	var subElement = createElement("a", attrArray, name);
	rootElement.appendChild(subElement)
	if(len > 0){
		var frameDivAttrArray = [];
		frameDivAttrArray.push({"key" : "id", "value" : "menu-subItem-div-" + id});
		frameDivAttrArray.push({"key" : "class", "value" : "collapse"});
		var subElement2 = createElement("div", frameDivAttrArray, "");
		rootElement.appendChild(subElement2);
		subElementRootElement = subElement2;
	}else{
		subElementRootElement = subElement;
	}
	
	if (len > 0) {
		for (var i = 0; i < len; i++) {
			var subMenuObj = menuObj.subMenuList[i];
			itorCreateMenu(subMenuObj, subElementRootElement);
		}
	}
}


function initAttrArray(subElementlen, id){
	var attrArray = [];
	attrArray.push({"key" : "href", "value" : "#"});
	attrArray.push({"key" : "class", "value" : "list-group-item list-group-item-action"});
	if(subElementlen > 0){
		attrArray.push({"key" : "data-toggle", "value" : "collapse"});
		attrArray.push({"key" : "data-target", "value" : "#menu-subItem-div-" + id});
	}
	return attrArray;
}
