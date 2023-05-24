/**
 *  ��� ���� javascript ó��
 */

$(document).ready(function(){	// jquery �غ�...
	// �Լ� ȣ��
	// detail.jsp�� ���۵��ڸ��� bno���� �����÷��� $(document).ready �Ʒ��� ����
	var uidValue=$("input[name='uid']").val();
	var pageValue=1;
	// detail.jsp�� ���۵��ڸ��� ��۸�ϸ���Ʈ(list) �Լ��� ȣ��
	list({uid:uidValue,page:pageValue});
	
	// ��� �����ư�� Ŭ���ϸ� 
	$("#add").on("click",function(){
		// ��۾��� ��ư�� Ŭ������ ��ÿ� ��۳����� �����÷��� $("#add").on("click",function(){ �Ʒ��� ����
		var replyValue=$("#reply").val();
		var idValue="abcd1";
		// ��۾��⸦ �ϱ� ���� �Լ� ȣ��
		add({uid:uidValue,reply:replyValue,id:idValue});
	})
	// ��� ������ư�� Ŭ���ϸ�
	// �̹� �����ϴ� �±׿� �̺�Ʈ�� ó���ϰ�
	// ���߿� �������� ����� �±׵鿡 ���ؼ� �Ķ���� �������� ����(�̺�Ʈ ��������Ʈ)
	$("#chat").on("click",".update",function(){
		// ��۹�ȣ�� ��۳����� �����ؼ� 
		var rno=$(this).data("rno");
		var reply=$("#replycontent"+rno).val();
		
		
		// ��ۼ����� �ϱ� ���� �Լ� ȣ��(��۹�ȣ, ��۳���)
		modify({rno:rno,reply:reply});
	})
	
	// ��� ������ư�� Ŭ���ϸ�
	$("#chat").on("click",".remove",function(){
		// ��۹�ȣ�� �����ؼ�
		var rno=$(this).data("rno");
		alert(uidValue)
		// ��ۻ����� �ϱ� ���� �Լ� ȣ��(��۹�ȣ)
		remove({rno:rno,uid:uidValue})
		//remove(rno)
		
	})
	$("#replyPage").on("click","li a",function(e){
		alert("aaa")
		e.preventDefault();
		var uidValue=$("input[name='uid']").val();
		var pageValue = $(this).attr("href");
		console.log(uidValue)
		console.log(pageValue)
		list({uid:uidValue,page:pageValue});
	})


})	// jquery ��...
// �Լ� ����
// ��� ������ �ϱ� ���� �Լ� ����
function remove(reply){
	console.log(reply);
	$.ajax({
		type:"delete",
		url:"/replies/remove/",
		data:JSON.stringify(reply),
		contentType:"application/json; charset=utf-8",
		success:function(result){
			if(result=="success"){
				alert("��ۻ��� ����")
				list(reply.uid)
			}
		}
	})
}


// ��� ������ �ϱ� ���� �Լ� ����
function modify(reply){
	console.log(reply);
	$.ajax({
		type:"put",	// method���(get, post, put, delete)
		url:"/replies/modify",
		data:JSON.stringify(reply),
		// contentType : ajax -> controller�� ������ ���� �� Ÿ��
		// (contentType�� �����ϸ� web Brower���� ����)
		contentType:"application/json; charset=utf-8",
		success:function(result){
			if(result=="success"){
				alert("��ۼ��� ����")
			}
		}
	})
}
function list(param){// list�Լ� ���� ����
	//alert(bno);
	var uid = param.uid;
	var page = param.page;
	
	console.log(uid)
	console.log(page)
	
	$.getJSON("/replies/"+uid+"/"+page+".json",function(data){
		console.log(data.replycnt)
		console.log(data.list)
		
		var str="";
		
		for(var i=0;i<data.list.length;i++){
			str+="<li>"+data.list[i].id+"</li>"
			str+="<li><textarea id='replycontent"+data.list[i].rno+"'>"+data.list[i].reply+"</textarea></li>"
			str+="<li>"
			str+="<input class='update' type='button' value='����' data-rno="+data.list[i].rno+">"
			str+="<input class='remove' type='button' value='����' data-rno="+data.list[i].rno+">"
			str+="</li>"
		}
		
		$("#replyUL").html(str);
		
		showReplyPage(data.replycnt,page);
	});
}// list�Լ� ���� ��
//var pageNum = 1;
function showReplyPage(replycnt,pageNum){
	
	var endNum = Math.ceil(pageNum/10.0)*10;
	var startNum = endNum-9
	
	var prev=startNum !=1;
	var next=false;
	
	if(endNum * 10 >= replycnt){
		endNum = Math.ceil(replycnt/10.0)
	}
	if(endNum * 10 < replycnt){
		next=true;
	}
	console.log(pageNum)
	console.log(startNum)
	console.log(endNum)
	var str="<ul>";
	
	if(prev){
		str+="<li><a href='"+(startNum-1)+"'>Previous</a></li>";
	}
	
	for(var i=startNum ; i<=endNum ; i++){
		str+="<li><a href='"+i+"'>"+i+"</a></li>"
	}
	
	if(next){
		str+="<li><a href='"+(endNum+1)+"'>Next</a></li>";
	}
	str+="</ul><div>"
	console.log(str);
	$("#replyPage").html(str);
		
}

// ��� ���⸦ �ϱ� ���� �Լ� ����
function add(reply){	// add�Լ� ���� ����
	console.log(reply);
	$.ajax({
		type:"post",	// method���(get, post, put, delete)
		url:"/replies/new",
		data:JSON.stringify(reply),
		// contentType : ajax -> controller�� ������ ���� �� Ÿ��
		// (contentType�� �����ϸ� web Brower���� ����)
		contentType:"application/json; charset=utf-8",
		success:function(result){
			if(result=="success"){
				alert("��۾��� ����")
				list(reply.uid)
			}
		}
	})
}	// add�Լ� ���� ��