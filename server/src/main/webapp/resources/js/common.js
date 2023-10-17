function ajaxCall(actionUrl,paramData,funName){
	console.log("123123123");
	$.ajax({
		async : false,
		type : "POST",
		url : actionUrl,
		contentType : "application/json",
		data : paramData,
		dataType : "json",
		success : function(data) {
			window[funName](data);
		},
		error : function(data, status, error) {
			console.log("실패");
		}
	});
	
}

function selectMenuLink(url){
	$('#mainForm').attr("action", url);
	$('#mainForm').submit();
}

function drawTableGrid(arrWidth, arrHeader, arrAlign, arrVoId, jsonListObj){
	var htmlTag = "";
	var colTag = "";
	var headerTag = "";
	var bodyTag = "";
	
	
	colTag+= "<colgroup>"
	for(var i=0; i<arrWidth.length; i++) {
		if(arrWidth[i] == "*") {
			colTag += "        <col />";
		}
		else {
			colTag += "        <col style='width:" + arrWidth[i] + ";'>";
		}
	}
	colTag+= "</colgroup>";
	
	for(var i=0; i<arrHeader.length; i++) {
		// 체크박스 여부...
		if(arrHeader[i] == "checkbox") {
// 			htmlTag += "            <th><label class='chkBox01 single'><input type='checkbox' title='리스트 전체선택' id='chkAll' name='chkAll' onclick='javascript:checkAll()' /><span class='c_name'></span></label></th>";
			headerTag += "            <th><label class=\"chkBox01 single\"><input type=\"checkbox\" title=\"리스트 전체선택\" id=\"chkAll\"  name=\"chkAll\" onclick=\"javascript:checkAll()\" /><span class=\"c_name\"></span></label></th>";
		}
		else {
			headerTag += "            <th>" + arrHeader[i] + "</th>";
		}
	}
	
	for(var l=0; l<jsonListObj.length; l++) {
		
		var jsonObj = jsonListObj[l];
		var jsonData = JSON.stringify(jsonObj);
//		console.log(jsonObj);
		
		bodyTag += "        <tr>";
		
		for(var i=0; i<arrVoId.length; i++) {
			var arrTypeChk = arrVoId[i].split(":");
			var keyValue = arrTypeChk[1];
			if(arrTypeChk[0] == "checkbox"){
				bodyTag += "<td style=\"cursor: default\" onclick=\"event.cancelBubble=true;\"><input type=\"checkbox\" id=\"chk"+l+"\" name=\"chk\" value='" + jsonObj[arrTypeChk[1]] + "' onclick=\"javascript:chkValue(this.value)\"></td>";
			} else if(arrTypeChk[0] == "onclick"){
				bodyTag += "<td ><div class='ellipsis01' onclick='view("+ jsonData +")'>" +  jsonObj[arrTypeChk[1]]  + "</div></td>";
			}  else {
				bodyTag += "<td ><div class='ellipsis01'>" +  jsonObj[arrVoId[i]]  + "</div></td>";
			}
			
		}
		
		
		bodyTag += "        </tr>";
	}
	
	htmlTag += "<table style='width:1600px;'>";
	htmlTag += colTag;
	htmlTag += "    <thead>";
	htmlTag += "        <tr>";
	htmlTag += 				headerTag;
	htmlTag += "    	</tr>";
	htmlTag += "    </thead>";
	htmlTag += "    <tbody>";
	htmlTag += 			bodyTag
	htmlTag += "    </tbody>";
	htmlTag += "</table>";
	
	
	
	$("#tableContents").html(htmlTag);
	
}