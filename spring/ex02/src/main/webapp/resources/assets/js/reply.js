/*
function f(){
	function insert(reply,callback){
		$.ajax({
			type:"POST",
			url:cp+"/reply/regist",
			data:JSON.stringify(reply),
			contentType:"application/json; charset=utf-8",
			success:function(result){
				callback();
			}
		})
	}
	return {add:insert,getList,remove,modify,displayTime}
}
const replyService = f();
*/

const replyService = (function(){
	function insert(reply,callback){
		$.ajax({
			type:"POST",
			url:cp+"/reply/regist",
			data:JSON.stringify(reply),
			contentType:"application/json; charset=utf-8",
			success:function(result,status,xhr){
				callback(result)
			}
		})
	}
	
	function selectAll(data,callback){
		let boardnum = data.boardnum;
		let pagenum = data.pagenum;
		
		$.getJSON(
			cp+"/reply/pages/"+boardnum+"/"+pagenum+".json",
			function(data){
				//data : {replyCnt:댓글개수, list:[ReplyDTO,...]}
				callback(data.replyCnt,data.list)
			}
		)
	}
	
	function drop(replynum,callback,error){
		$.ajax({
			type:"DELETE",
			url:cp+"/reply/"+replynum,
			success:function(result,status,xhr){
				if(callback){
					callback(result);
				}
			},
			error:function(xhr,status,err){
				if(error){
					error(err);
				}
			}
		})
	}
	
	function update(reply,callback){
		$.ajax({
			type:"PUT",
			url:cp+"/reply/"+reply.replynum,
			data:JSON.stringify(reply),
			contentType:"application/json;charset=utf-8",
			success:function(result){
				if(callback){
					callback(result);
				}
			},
			error:function(err){
				alert("에러발생 : "+err)
			}
		})
	}
	
	function fmtTime(reply){
		const regdate = reply.regdate;
		const updatedate = reply.updatedate;
		
		const now = new Date();
		const check = regdate == updatedate;
		
		const dateObj = new Date(check?regdate:updatedate)
		//date객체.getTime() : date객체가 가지고 있는 시간 정보를 밀리초 단위로 추출
		let gap = now.getTime() - dateObj.getTime();
		
		let str = "";
		if(gap < 1000*60*60*24){
			let hh = dateObj.getHours();
			let mi = dateObj.getMinutes();
			let ss = dateObj.getSeconds();
			
			str = (hh>9?'':'0')+hh+":"+(mi>9?'':'0')+mi+":"+(ss>9?'':'0')+ss;
		}
		else{
			let yy = dateObj.getFullYear();
			let mm = dateObj.getMonth()+1;
			let dd = dateObj.getDate();
			
			str = (yy>9?'':'0')+yy+"/"+(mm>9?'':'0')+mm+"/"+(dd>9?'':'0')+dd;
		}
		
		return (check?'':'(수정됨) ')+str
	}
	
	//{프로퍼티:값,메소드명:함수(){}}
	return {add:insert,getList:selectAll,remove:drop,modify:update,displayTime:fmtTime}
})()






