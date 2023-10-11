/**
 * 
 */
		$(function(){
			
			//User2 목록
			$('#btnUser3s').click(function(){
				
				$.ajax({
					type: 'GET',
					url: '/Ch10/user3',
					dataType: 'json',
					success: function(data){
						console.log(data);
					}
				});
			});
			
			//User2 조회(id)			
			$('#btnUser3').click(function(){
				
				$.ajax({
					type: 'GET',
					url: '/Ch10/user3/s101',
					dataType: 'json',
					success: function(data){
						console.log(data);
					}
				});
			});
			
			//User2 등록			
			$('#btnUser3Register').click(function(){
				
				const jsonData = {
					id: 's101',
					name: '홍길동',
					hp: '010-1111-1111',
					age: 11
				};
				
				$.ajax({
					type: 'POST',
					url: '/Ch10/user3',
					data: jsonData,
					dataType: 'json',
					success: function(data){
						console.log(data);
					}
				});
			});
			
			//User2 수정			
			$('#btnUser3Modify').click(function(){
				
				const jsonData = {
					id: 's105',
					name: '홍길동',
					hp: '010-8888-1111',
					age: 88
				};
				
				$.ajax({
					type: 'PUT',
					url: '/Ch10/user3',
					data: jsonData,
					dataType: 'json',
					success: function(data){
						console.log(data);
					}
				});
			});
			
			//User2 삭제(id)			
			$('#btnUser3Delete').click(function(){
				
				$.ajax({
					type: 'DELETE',
					url: '/Ch10/user3/s101',
					dataType: 'json',
					success: function(data){
						console.log(data);
					}
				});
			});			
		});
		
