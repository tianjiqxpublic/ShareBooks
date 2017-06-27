
//文档准备完毕
// $(document).ready(function() {
//
//
//
// //条件查询按钮绑定处理函数
//
//
//
// }


function addBook()
{
	var str = "";
	str+='<form id="modal-form" role="form">'+
	 '<div class="container-fluid">'+
	 '<div class="form-group col-md-10">'+
	 '<label for="bookName"> 书籍名： </label> <input type="text"'+
	 ' class="form-control" name="bookName" id="bookName" />'+
	 '</div>'+
	 '<div class="form-group col-md-10">'+
	 '<label for="author"> 作者名：</label> <input type="text"'+
	 'class="form-control" name="author" id="author"  />'+
	 '</div>'+
	 '<div class="form-group col-md-10">'+
	 '<label for="description"> 描述：</label> <input type="text"'+
	 'class="form-control" name="description" id="description"  />'+
	 '</div>'+
	 '<div class="form-group col-md-10">'+
	 '<label for="publishDate"> 出版日期：</label> <input type="text"'+
	 'class="form-control" name="publishDate" id="publishDate"  />'+
	 '</div>'+
	 '</div>'+
	 '</form>';

	 //显示模态框
	 $('#modal-title').html('添加书籍');
	 $('#modal-body').html(str);
	 $('#modal').modal('toggle'); //打开模态框
	 $('#modal-btn-submit').html('添加');

	 $('#modal-btn-submit').unbind('click').click(function() {  //解除绑定，重新设置click处理函数
	 	/* Act on the event */

	 	$('#modal').modal('hide'); //隐藏模态框
	 	
	 	var jsr=$("#modal-form").serializeJson();	 	
	 	jsr=JSON.stringify(jsr);

	 	var pathurl = "/book/book/add/?";

	 	var bookName = "bookName="+jsr.bookName;
	 	var author = "author="+jsr.author;
	 	var description = "description"+jsr.description;
	 	var publishDate = "publishDate"+jsr.publishDate;
		
		pathurl +=bookName+"&"+author+"&"+description+"&"
				+publishDate;

	 	$.ajax({
	 		url: pathurl,
	 		type: 'post',
	 		dataType: 'json',
	 		data: {"jsonstr": jsr},
	 	})
	 	.done(function() {
	 		console.log("add success");
	 		// if(result!= null)
	 		// {
	 		// 	alert("添加成功!");
	 		// }else{
	 		// 	alert("添加失败！")
	 		// }
			

		})
	 	.fail(function() {
	 		console.log(" error");
	 	})
	 	.always(function() {
	 		console.log(" complete");
	 	});
	 	
	 });

}


function modifyBook()
{
	var str = "";
	str+='<form id="modal-form" role="form">'+
	 '<div class="container-fluid">'+
	 '<div class="form-group col-md-10">'+
	 '<label for="id"> 书籍ID： </label> <input type="text"'+
	 ' class="form-control" name="id" id="id" />'+
	 '</div>'+
	 '<div class="form-group col-md-10">'+
	 '<label for="bookName"> 书籍名： </label> <input type="text"'+
	 ' class="form-control" name="bookName" id="bookName" />'+
	 '</div>'+
	 '<div class="form-group col-md-10">'+
	 '<label for="author"> 作者名：</label> <input type="text"'+
	 'class="form-control" name="author" id="author"  />'+
	 '</div>'+
	 '<div class="form-group col-md-10">'+
	 '<label for="description"> 描述：</label> <input type="text"'+
	 'class="form-control" name="description" id="description"  />'+
	 '</div>'+
	 '<div class="form-group col-md-10">'+
	 '<label for="publishDate"> 出版日期：</label> <input type="text"'+
	 'class="form-control" name="publishDate" id="publishDate"  />'+
	 '</div>'+
	 '</div>'+
	 '</form>';

	  //显示模态框
	 $('#modal-title').html('修改书籍');
	 $('#modal-body').html(str);
	 $('#modal').modal('toggle'); //打开模态框
	 $('#modal-btn-submit').html('修改');

	 $('#modal-btn-submit').unbind('click').click(function() {  //解除绑定，重新设置click处理函数
	 	/* Act on the event */

	 	$('#modal').modal('hide'); //隐藏模态框
	 	
	 	var jsr=$("#modal-form").serializeJson();	 	
	 	jsr=JSON.stringify(jsr);

	 	var pathurl = "/book/book/update/?";

	 	var id = "id=" +jsr.id;
	 	var bookName = "bookName="+jsr.bookName;
	 	var author = "author="+jsr.author;
	 	var description = "description"+jsr.description;
	 	var publishDate = "publishDate"+jsr.publishDate;
		
		pathurl +=id+"&"+bookName+"&"+author+"&"+description+"&"
				+publishDate;

	 	$.ajax({
	 		url: pathurl,
	 		type: 'put',
	 		dataType: 'json',
	 		data: {"jsonstr": jsr},
	 	})
	 	.done(function() {
	 		console.log("modify success");
	 		// if(result!= null)
	 		// {
	 		// 	alert("修改成功!");
	 		// }else{
	 		// 	alert("修改失败！")
	 		// }
			

		})
	 	.fail(function() {
	 		console.log(" error");
	 	})
	 	.always(function() {
	 		console.log(" complete");
	 	});
	 	
	 });
}

function deleteBook()
{
		var str = "";
	str+='<form id="modal-form" role="form">'+
	 '<div class="container-fluid">'+
	 '<div class="form-group col-md-10">'+
	 '<label for="id"> 书籍ID： </label> <input type="text"'+
	 ' class="form-control" name="id" id="id" />'+
	 '</div>'+
	 '</div>'+
	 '</form>';

	  //显示模态框
	 $('#modal-title').html('删除书籍');
	 $('#modal-body').html(str);
	 $('#modal').modal('toggle'); //打开模态框
	 $('#modal-btn-submit').html('删除');


	 $('#modal-btn-submit').unbind('click').click(function() {  //解除绑定，重新设置click处理函数
	 	/* Act on the event */

	 	$('#modal').modal('hide'); //隐藏模态框
	 	
	 	var jsr=$("#modal-form").serializeJson();	 	
	 	jsr=JSON.stringify(jsr);

	 	var pathurl = "/book/book/delete/";
	 	var id = jsr.id;
	 	pathurl +=id;

	 	$.ajax({
	 		url: pathurl,
	 		type: 'delete',
	 		dataType: 'json',
	 		data: {"jsonstr": jsr},
	 	})
	 	.done(function() {
	 		console.log("delete success");
	 		if(true)
	 		{
	 			alert("删除成功!");
	 		}else{
	 			alert("删除失败！")
	 		}
		})
	 	.fail(function() {
	 		console.log(" error");
	 	})
	 	.always(function() {
	 		console.log(" complete");
	 	});
	 	
	 });



}