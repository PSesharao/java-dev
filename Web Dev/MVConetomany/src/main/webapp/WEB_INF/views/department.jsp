<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!doctype html>
<html lang="en">

<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">


<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

<!-- MDB icon -->
<link rel="icon" href="/resources/img/mdb-favicon.ico" type="image/x-icon">
<!-- Font Awesome -->
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.11.2/css/all.css">
<!-- Google Fonts Roboto -->
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700&display=swap">
<!-- Bootstrap core CSS -->
<link rel="stylesheet" href="/resources/css/bootstrap.min.css">
<!-- Material Design Bootstrap -->
<link rel="stylesheet" href="/resources/css/mdb.min.css">
<!-- Your custom styles (optional) -->
<link rel="stylesheet" href="/resources/css/style.css">
<style>
.container {
	background-color: rgb(248, 244, 240);
}

.jumbotron {
	background-color: rgb(248, 244, 240);
	text-align: center;
}
</style>
<title>Department</title>
</head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {

		
		$("#depformid").submit(function(event) {
			// Prevent the form from submitting via the browser.
			
			event.preventDefault();
		
			ajaxPost();
		});

		function ajaxPost() {
			
			// PREPARE FORM DATA
			var developerData = {};
			developerData["name"] = $("#name").val();
			developerData["strength"] = $("#strength").val();

			// DO POST
			$.ajax({
				type : "POST",
				contentType : "application/json",
				url : '${pageContext.request.contextPath }/adddepartment',
				data : JSON.stringify(developerData),
				dataType : 'json',
				success : function(result) {
					alert("Success");
					//var result = JSON.parse(result);
					alert(result);
					$('#divResult').html("successfully posted "+result.name);
					$('#divResult').show();
					
				},
				error : function(e) {
					alert("Error!")
					console.log("ERROR: ", e);
				}
			});

			/* $('#button').click(function() {
				//alert("Hello");
				var developerData = {};
				developerData["name"] = $("#name").val();
				developerData["strength"] = $("#strength").val();
				//developerData["salary"] = "25000";
				$.ajax({
					type : "POST",
					contentType : "application/json",
					url : '${pageContext.request.contextPath }/adddepartment',
					data : JSON.stringify(developerData),
					dataType : 'json',
					success : function(result) {
						// Code to display the response.
						$('#divResult').html("Hello");
						$('#divResult').show();
						//alert(data);
					}
				});
			}); */

		}
	});
</script>
<body>
	<div class="container">
		<div class="jumbotron">
			<div class="form">
				<form id="depformid">
					<!-- action="/adddepartment1" -->
					<table align="center" , width="50%" cellpadding="20%"
						class="table table-hover ">

						<tr>
							<td><b>Department Name :</b></td>

							<td><input type="text" name="name" id="name"></td>
						</tr>
						<tr>
						<tr>
							<td><b>Strength :</b></td>

							<td><input type="text" name="strength" id="strength">
							</td>
						</tr>
						<tr>
							<td></td>
							<td>
								<button type="submit" id="button" class="btn btn-primary">Submit</button>
							</td>

						</tr>
						
					</table>
				</form>
				<div id="divResult"> </div>
			</div>
		</div>
	</div>

</body>

</html>