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
			<strong>Player</strong>
		</h5>

		<!--Card content-->
		<div class="card-body px-lg-5 ">

			<!-- Form -->
			<form class="text-center" style="color: #757575;" action="addplayer">

				<p>please enter the player details</p>
			<div class="parallax">
				<!-- Name -->
				<div class="row">

					<div class="col-sm-5"></div>
					<div class="md-form mt-3">
						<div class="invalid-tooltip" id="username_error_message"></div>
						<input type="text" id="inputName" class="form-control "
							name="name"> <label for="inputName">Name</label>
					</div>

				</div>

				<!-- age -->
				<div class="row">
					<div class="col-sm-5"></div>
					<div class="md-form mt-3">
						<div class="invalid-tooltip" id="age_error_message"></div>
						<input type="text" id="age" class="form-control " name="age">
						<label for="age">Age</label>
					</div>
				</div>


				<!-- skill -->

				<div class="row">
					<div class="col-sm-3"></div>
					<div class="col-sm-6">Skill</div>
				</div>
				<br>


				<div class="form-check">

					<input type="radio" class="form-check-input skill" id="skill"
						name="skill" value="batsman"> <label
						class="form-check-label" for="skill">Batsman</label>
				</div>


				<div class="form-check">
					<input type="radio" class="form-check-input skill" id="skill"
						name="skill" value="bowler"> <label
						class="form-check-label" for="skill">Bowler</label>
				</div>


				<div class="form-check">
					<input type="radio" class="form-check-input skill" id="skill"
						name="skill" value="allrounder"> <label
						class="form-check-label" for="skill">Allrounder</label> <br>

				</div>

				<div class="row">
					<div class="col-sm-5"></div>
					<div class="col-sm-6">
						<div class="invalid-tooltip" id="skill_error_message"></div>
					</div>
				</div>

				<br> <br>
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

				<!-- budget -->
				<div class="row">
					<div class="col-sm-5"></div>
					<div class="md-form mt-3">
						<div class="invalid-tooltip" id="budget_error_message"></div>
						<input type="text" id="budget" class="form-control "
							name="purchasePrice"> <label for="budget">Purchase
							Price</label>
					</div>
				</div>

				<!-- Submit button -->
				<div class="row">
					<div class="col-sm-5"></div>
					<button
						class="btn btn-outline-info btn-rounded btn-block z-depth-0 my-4 waves-effect col-sm-2"
						type="submit" id="button">Submit</button>
				</div>
				</div>
			</form>
			<!-- Form -->
			 
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

        $("#username_error_message").hide();
        $("#age_error_message").hide();
        $("#skill_error_message").hide();
        $("#team_error_message").hide();
        $("#budget_error_message").hide();
        
        
        var error_username = false;
        var error_age = false;
        var error_skill = false;
        var error_team = false;
        var error_budget = false;

        $("#inputName").keyup(function () {

            check_username();

        });

        function check_username() {

            var userName = $("#inputName").val();
            // alert("Hello " + userName);
            var checklen = true;
            var checkchar = true;
            for (var i = 0; i < userName.length; i++) {
                if (!((userName[i] >= 'a' && userName[i] <= 'z')
                    || (userName[i] >= 'A' && userName[i] <= 'Z') || (userName[i] >= '0' && userName[i] <= '9'))) {
                    $("#username_error_message")
                        .html(
                            "**Player name should be aplpanumeric**");
                    $("#username_error_message").show();
                    error_username = true;
                    checkchar = false;
                    break;
                }

            }

            if (userName.length < 3) {

                $("#username_error_message")
                    .html(
                        "**Player name length should be atleast 3**");
                $("#username_error_message").show();
                error_username = true;
                checklen = false;
            }

            if (checklen && checkchar) {
                $("#username_error_message").hide();
                error_username = false;
            }
        }

        $("#age").keyup(function () {

            check_age();

        });

        function check_age() {
            check_username();
            if (error_username) {
                $("#username_error_message")
                    .html(
                        "**Please fill name details**");
                $("#username_error_message").show();
            }
            var age = $("#age").val();

            var agelen = true;
            if (age.length == 0) {
                $("#age_error_message")
                    .html(
                        "**Please fill age details**");
                $("#age_error_message").show();
                error_age = true;
                agelen = false;
            }

            if (agelen) {
                $("#age_error_message").hide();
                error_age = false;
            }

        }


        $(".skill").change(function () {

            validateSkill();

        });

        function validateSkill() {
            check_username();
            if (error_username) {
                $("#username_error_message")
                    .html(
                        "**Please fill name details**");
                $("#username_error_message").show();
            }

            check_age();

            if (error_age) {
                $("#age_error_message")
                    .html(
                        "**Please fill age details**");
                $("#age_error_message").show();
            }


            var skill = $(".skill:checked");
           
            if (skill.length == 0) {
                $("#skill_error_message").html(
                    "**Please choose skill**");
                $("#skill_error_message").show();
                error_skill = true;
            } else {
                $("#skill_error_message").hide();
                error_skill = false;
            }
        }


        $("#team").change(function () {

            validateTeam();

        });

        function validateTeam() {
            check_username();
            if (error_username) {
                $("#username_error_message")
                    .html(
                        "**Please fill name details**");
                $("#username_error_message").show();
            }

            check_age();

            if (error_age) {
                $("#age_error_message")
                    .html(
                        "**Please fill age details**");
                $("#age_error_message").show();
            }

            validateSkill();
            if (error_skill) {
                $("#skill_error_message").html(
                    "**Please choose skill**");
                $("#skill_error_message").show();
            }

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
        
        
       
        $("#budget").keyup(function () {

            check_budget();

        });
        

        function check_budget() {
            check_username();
            if (error_username) {
                $("#username_error_message")
                    .html(
                        "**Please fill name details**");
                $("#username_error_message").show();
            }
            
            check_age();

            if (error_age) {
                $("#age_error_message")
                    .html(
                        "**Please fill age details**");
                $("#age_error_message").show();
            }

            validateSkill();
            if (error_skill) {
                $("#skill_error_message").html(
                    "**Please choose skill**");
                $("#skill_error_message").show();
            }

            validateTeam();
            if (error_team) {
                $("#team_error_message").html(
                    "**Please choose a team**");
                $("#team_error_message").show();
            }
            
            var budget = $("#budget").val();

            var budgetlen = true;
            if (budget.length == 0) {
                $("#budget_error_message")
                    .html(
                        "**Please fill budget details**");
                $("#budget_error_message").show();
                error_budget = true;
                budgetlen = false;
            }

            if (budgetlen) {
                $("#budget_error_message").hide();
                error_budget = false;
            }

        }


        
        $('#button').click(function () {
            check_username();
            if (error_username) {
                $("#username_error_message")
                    .html(
                        "**Please fill name details**");
                $("#username_error_message").show();
            }

            check_age();

            if (error_age) {
                $("#age_error_message")
                    .html(
                        "**Please fill age details**");
                $("#age_error_message").show();
            }

            validateSkill();
            if (error_skill) {
                $("#skill_error_message").html(
                    "**Please choose skill**");
                $("#skill_error_message").show();
            }

            validateTeam();
            if (error_team) {
                $("#team_error_message").html(
                    "**Please choose a team**");
                $("#team_error_message").show();
            }
            
            check_budget();
            
            if(error_budget){
            $("#budget_error_message")
            .html(
                "**Please fill budget details**");
           $("#budget_error_message").show();
            }
            
            if(!error_team && !error_username && !error_age && !error_skill && !error_budget)
                return true;
            return false;


        });


    });
    </script>
</body>

</html>