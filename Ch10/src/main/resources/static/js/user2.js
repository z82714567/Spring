/**
 * 
 */
		$(function(){
			
			//User2 목록
			$('#btnUser2s').click(function(){
				
				$.ajax({
					type: 'GET',
					url: '/Ch10/user2',
					dataType: 'json',
					success: function(data){
						console.log(data);
					}
				});
			});
			
			//User2 조회(id)			
			$('#btnUser2').click(function(){
				
				$.ajax({
					type: 'GET',
					url: '/Ch10/user2/A102',
					dataType: 'json',
					success: function(data){
						console.log(data);
					}
				});
			});
			
			//User2 등록			
			$('#btnUser2Register').click(function(){
				
				const jsonData = {
					id: 's101',
					name: '홍길동',
					hp: '010-1111-1111',
					age: 11
				};
				
				$.ajax({
					type: 'POST',
					url: '/Ch10/user2',
					data: jsonData,
					dataType: 'json',
					success: function(data){
						console.log(data);
					}
				});
			});
			
			//User2 수정			
			$('#btnUser2Modify').click(function(){
				
				const jsonData = {
					id: 's101',
					name: '홍길동',
					hp: '010-8888-1111',
					age: 88
				};
				
				$.ajax({
					type: 'PUT',
					url: '/Ch10/user2',
					data: jsonData,
					dataType: 'json',
					success: function(data){
						console.log(data);
					}
				});
			});
			
			//User2 삭제(id)			
			$('#btnUser2Delete').click(function(){
				
				$.ajax({
					type: 'DELETE',
					url: '/Ch10/user2/s101',
					dataType: 'json',
					success: function(data){
						console.log(data);
					}
				});
			});			
		});
		
