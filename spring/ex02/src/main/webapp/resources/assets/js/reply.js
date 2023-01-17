
// 자바스크립트를 선언한 동시에 생성. function(){} 에 담긴 값을 return 한다.
//const replService = (function(){
//	return {}
//})()

const replService = (function(){
	function insert(reply, callback){
		$.ajax({
			type:"POST",
			url:cp+"/reply/regist",
			data:JSON.stringify(reply), // reply 객체를 기반으로 json 객체로 만들어줌.
			contentType:"application/join; charset=utf-8", // 보내고 있는 데이터의 형태
			success:function(result,status,xhr){
				callback(result);
			}
		})
	}
	
	return {add:insert, getList:"", remove:"", modify:"", displayTime:""};
})()