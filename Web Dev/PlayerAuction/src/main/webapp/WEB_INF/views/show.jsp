<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta http-equiv="x-ua-compatible" content="ie=edge">
<title>Team</title>

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
<link rel="icon" href="img/mdb-favicon.ico" type="image/x-icon">
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
body {
	background-color: #2e2e2e;
}

.text-poppy-red {
	color: #ef5350 !important;
}

.btn-poppy-red {
	background-color: #ef5350 !important;
}

.bg-poppy-red {
	background-color: #ef5350 !important;
}

</style>
</head>

<body>

	<!-- Start your project here-->
	<div class="card ">

		<h5 class="card-header info-color white-text text-center py-4">
			<strong>Player Info</strong>
		</h5>

		<!--Card content-->
		<div class="card-body px-lg-5 ">
		    <div class="parallax">
			<!-- Form -->
			<form class="text-center" style="color: #757575;" action="showplayer">
			
				<p>please select team</p>

				<!-- select team-->
				<label for="team"></label> <select
					class="browser-default custom-select mb-1 col-sm-2" id="team"
					name="team">
					<option value="" disabled="" selected="">Choose Team</option>
					<c:forEach var="team" items="${teamList}">
						<option value="${team.name}">${team.getName()}</option>
					</c:forEach>
				</select>

				<div class="row">
					<div class="col-sm-5"></div>
					<div class="col-sm-6">
						<div class="invalid-tooltip" id="team_error_message"></div>
					</div>
				</div>

				<br> <br>


				<!-- Submit button -->
				<div class="row">
					<div class="col-sm-5"></div>
					<button
						class="btn btn-outline-info btn-rounded btn-block z-depth-0 my-4 waves-effect col-sm-2"
						type="submit" id="button">Submit</button>
				</div>
			</form>
			<!-- Form -->
			<!-- update form -->
			<form class="text-center" style="color: #757575;" action="update">
				<table
					class="table table-striped table-hover table-bordered border-primary">
					<thead>
						<tr>
							<th scope="col">Id</th>
							<th scope="col">Name</th>
							<th scope="col">Age</th>
							<th scope="col">Skill</th>
							<th scope="col">PurchasePrice</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="player" items="${playerList}">
							<tr>
								<th scope="row">${player.id}</th>
								<td>${player.name}</td>
								<td>${player.age}</td>
								<td>${player.skill}</td>
								<td>${player.purchasePrice}</td>
								<td>
									<button type="submit" name="playerId" id="playerId"
										value="${player.id}" class="btn btn-primary">Update</button>
								</td>
							</tr>
						</c:forEach>

					</tbody>
				</table>
				
			</form>
			</div>
		</div>

	</div>

	<!-- End your project here-->

	<!-- jQuery -->
	<script type="text/javascript" src="/resources/js/jquery.min.js"></script>
	<!-- Bootstrap tooltips -->
	<script type="text/javascript" src="/resources/js/popper.min.js"></script>
	<!-- Bootstrap core JavaScript -->
	<script type="text/javascript" src="/resources/js/bootstrap.min.js"></script>
	<!-- MDB core JavaScript -->
	<script type="text/javascript" src="/resources/js/mdb.min.js"></script>
	<!-- Your custom scripts (optional) -->
	<script type="text/javascript">
    $(document).ready(function () {

       
        $("#team_error_message").hide();

       
        var error_team = false;

       

        $("#team").change(function () {

            validateTeam();

        });

        function validateTeam() {
           

            var team = $("#team option:selected").val();

            if (team == "") {
                error_team = true;
                $("#team_error_message").html(
                    "**Please choose a team**");
                $("#team_error_message").show();
            } else {
            	
            	
                $("#team_error_message").hide();
                error_team = false;
            }

        }
       

        $('#button').click(function () {
           

            validateTeam();
            if (error_team) {
                $("#team_error_message").html(
                    "**Please choose a team**");
                $("#team_error_message").show();
            }
            if(!error_team )
                return true;
            return false;


        });


    });
    </script>

</body>

</html>