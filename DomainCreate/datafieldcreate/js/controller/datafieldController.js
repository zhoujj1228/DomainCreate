/**
 * 
 */

function initDataField() {
	alert("initDataField()");
}


function submitDatafield() {
	var jsonStr = datafieldService.itorElementToJson();
	datafieldService.addDatafield(jsonStr);
}



