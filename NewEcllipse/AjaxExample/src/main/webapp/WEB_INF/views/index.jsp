<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>


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
<link rel="icon" href="/resources/img/mdb-favicon.ico"
	type="image/x-icon">
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
.intro-2 {
	background:
		/* url("https://mdbootstrap.com/img/Photos/Others/img (51).jpg") */
		url("https://previews.123rf.com/images/stockshoppe/stockshoppe1803/stockshoppe180300032/97521163-cricket-championship-tournament-poster-with-equipment-design-.jpg")
		no-repeat center center;
	background-size: cover;
}

.view {
	margin-top: -56px;
}

.navbar {
	z-index: 1;
}

html, body, header, .view {
	height: 100%;
}
</style>
</head>

<body>

	<!-- Start your project here-->
	<!--Main Navigation-->
	<header id='home'>

		<nav class="navbar fixed-top navbar-expand-lg navbar-dark indigo">
			<a class="navbar-brand" href="#"><strong>Player Auction
					Application</strong></a>
			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav mr-auto">
					<li class="nav-item "><a class="nav-link" href="#home"
						id="homelink">Home </a></li>
					<li class="nav-item"><a class="nav-link" href="#playerform"
						id="playerlink">Add Player</a></li>
					<li class="nav-item"><a class="nav-link" href="#showpage"
						id="showlink">Show</a></li>
				</ul>
			</div>
		</nav>

		<div class="view intro-2">
			<div class="full-bg-img">
				<div class="mask rgba-black-light flex-center">
					<div class="container text-center white-text">
						<div class="white-text text-center wow fadeInUp">
							<h2>Player Auction Application</h2>
							<h5> Register yourself for the tournament
								</h5>
							<br>
							<p>Play well and win amazing rewards
								</p>


						</div>
					</div>
				</div>
			</div>
		</div>

	</header>

	<!--Main Navigation-->

	<!--Main Layout-->
	<main class="text-center py-5">

		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<!-- player form start -->
					<div id="playerform">
						<div class="card ">
							<h5 class="card-header info-color white-text text-center py-4">
								<strong>Player</strong>
							</h5>

							<!--Card content-->
							<div class="card-body px-lg-5 ">

								<!-- Form -->
								<form class="text-center" style="color: #757575;"
									id="palyerformapp">

									<table align="center" , width="50%" cellpadding="20%">
										<tr>
											<td>
												<!-- Name -->
												<div class="row">

													<div class="col-sm-5"></div>
													<div class="md-form mt-3">
														<div class="invalid-tooltip" id="username_error_message"></div>
														<input type="text" id="inputName" class="form-control "
															name="name"> <label for="inputName">Name</label>
													</div>

												</div>
											</td>
										</tr>
										<tr>
											<td>
												<!-- age -->
												<div class="row">
													<div class="col-sm-5"></div>
													<div class="md-form mt-3">
														<div class="invalid-tooltip" id="age_error_message"></div>
														<input type="text" id="age" class="form-control "
															name="age"> <label for="age">Age</label>
													</div>
												</div>
											</td>

										</tr>
										<tr>
											<td>
												<!-- skill -->

												<div class="row">
													<div class="col-sm-5"></div>
													<div class="col-sm-0">Skill</div>
												</div>
											</td>
										</tr>
										<tr>
											<td>
												<div class="row">
													<div class="col-sm-5"></div>
													<div class="form-check">

														<input type="radio" class="form-check-input skill"
															id="skill" name="skill" value="batsman"> <label
															class="form-check-label" for="skill">Batsman</label>
													</div>
												</div>

												<div class="row">
													<div class="col-sm-5"></div>
													<div class="form-check">
														<input type="radio" class="form-check-input skill"
															id="skill" name="skill" value="bowler"> <label
															class="form-check-label" for="skill">Bowler</label>
													</div>
												</div>


												<div class="row">
													<div class="col-sm-5"></div>
													<div class="form-check">
														<input type="radio" class="form-check-input skill"
															id="skill" name="skill" value="allrounder"> <label
															class="form-check-label" for="skill">Allrounder</label> <br>

													</div>
												</div>


												<div class="row">
													<div class="col-sm-5"></div>
													<div class="col-sm-6">
														<div class="invalid-tooltip" id="skill_error_message"></div>
													</div>
												</div>
											</td>
										</tr>
										<tr>
											<td>
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
											</td>
										</tr>

										<tr>
											<td>
												<!-- Submit button -->
												<div class="row">
													<div class="col-sm-5"></div>
													<button
														class="btn btn-outline-info btn-rounded btn-block z-depth-1 my-4 waves-effect col-sm-4"
														type="button" id="button1">Submit</button>
												</div>
											</td>
										</tr>
									</table>
								</form>
								<!-- Form -->

								<div id="postResultDiv1"></div>
							</div>

						</div>

					</div>
					<!-- playerform end -->
					<br> <br> <br>

					<!-- show page -->
					<div id="showpage">
						<div class="card ">

							<h5 class="card-header info-color white-text text-center py-4">
								<strong>Player Info</strong>
							</h5>

							<!--Card content-->
							<div class="card-body px-lg-5 ">
								<!-- update table -->
								<form class="text-center" style="color: #757575;"
									id="updatetableapp">
									<table
										class="table table-striped table-hover table-bordered border-primary"
										id="playertable">

									</table>

								</form>
								<!-- update table end -->
							</div>

						</div>
					</div>
					<!-- show page end  -->
					<br> <br> <br>
					<!-- update player page  -->
					<div id="updateplayer">
						<div class="card ">

							<h5 class="card-header info-color white-text text-center py-4">
								<strong>Update Player</strong>
							</h5>

							<!--Card content-->
							<div class="card-body px-lg-5 ">

								<!-- Form -->
								<form class="text-center" style="color: #757575;" id ="updateplayerinfo">
									


									<table align="center" , width="50%" cellpadding="20%">
										<tr>
											<td>
												<!-- Name -->
												<div class="row">

													<div class="col-sm-5"></div>
													<div class="md-form mt-3">
														<div class="invalid-tooltip" id="username_error_message3"></div>
														<input type="text" id="inputName3" class="form-control "
															name="name" > <label
															for="inputName">Name</label>
													</div>

												</div>
											</td>
										</tr>

										<tr>
											<td>
												<!-- age -->
												<div class="row">
													<div class="col-sm-5"></div>
													<div class="md-form mt-3">
														<div class="invalid-tooltip" id="age_error_message3"></div>
														<input type="text" id="age3" class="form-control "
															name="age" > <label
															for="age">Age</label>
													</div>
												</div>
											</td>

										</tr>

										<tr>
											<td>
												<!-- skill -->

												<div class="row">
													<div class="col-sm-5"></div>
													<div class="col-sm-0">Skill</div>
												</div>
											</td>
										</tr>


										<tr>
											<td>
												<div class="row">
													<div class="col-sm-5"></div>
													<div class="form-check">

														<input type="radio" class="form-check-input skill3"
															id="skill3" name="skill" value="batsman"> <label
															class="form-check-label" for="skill">Batsman</label>
													</div>
												</div>

												<div class="row">
													<div class="col-sm-5"></div>
													<div class="form-check">
														<input type="radio" class="form-check-input skill3"
															id="skill3" name="skill" value="bowler"> <label
															class="form-check-label" for="skill">Bowler</label>
													</div>
												</div>


												<div class="row">
													<div class="col-sm-5"></div>
													<div class="form-check">
														<input type="radio" class="form-check-input skill3"
															id="skill3" name="skill" value="allrounder"> <label
															class="form-check-label" for="skill">Allrounder</label> <br>

													</div>
												</div>


												<div class="row">
													<div class="col-sm-5"></div>
													<div class="col-sm-6">
														<div class="invalid-tooltip" id="skill_error_message3"></div>
													</div>
												</div>
											</td>
										</tr>


										<tr>
											<td>
												<!-- budget -->
												<div class="row">
													<div class="col-sm-5"></div>
													<div class="md-form mt-3">
														<div class="invalid-tooltip" id="budget_error_message3"></div>
														<input type="text" id="budget3" class="form-control "
															name="purchasePrice"> <label for="budget">Purchase
															Price</label>
													</div>
												</div>
											</td>
										</tr>

										<tr>
											<td>
												<!-- Submit button -->
												<div class="row">
													<div class="col-sm-5"></div>
													<button
														class="btn btn-outline-info btn-rounded btn-block z-depth-1 my-4 waves-effect col-sm-4"
														type="submit" id="button4">Submit</button>
												</div>
											</td>
										</tr>

									</table>
								</form>
								<div id="postResultDiv2"></div>
							</div>
						</div>
					</div>

					<!-- update form end -->
				</div>
			</div>
		</div>

	</main>
	<!--Main Layout-->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<!-- jQuery -->
	<script type="text/javascript" src="/resources/js/jquery.min.js"></script>
	<!-- Bootstrap tooltips -->
	<script type="text/javascript" src="/resources/js/popper.min.js"></script>
	<!-- Bootstrap core JavaScript -->
	<script type="text/javascript" src="/resources/js/bootstrap.min.js"></script>
	<!-- MDB core JavaScript -->
	<script type="text/javascript" src="/resources/js/mdb.min.js"></script>
	<script type="text/javascript">
    $(document).ready(function () {
		
    	$("#playerform").hide();
    	$("#showpage").hide();
    	$("#updateplayer").hide();
    	// home link
    	$('#homelink').click(function() {
    		//$("#home").show();
    		$("#playerform").hide();
    		$("#teamform").hide();
    		$("#showpage").hide();
    		$("#updateplayer").hide();
    	}
    	);
    	
        // player form 
    	 $('#playerlink').click(function () {
    	      $("#playerform").show();
    	      $("#showpage").hide();
    	      $("#updateplayer").hide();
    	     
    	      $("#username_error_message").hide();
    	      $("#age_error_message").hide();
    	      $("#skill_error_message").hide();
    	     
    	      $("#budget_error_message").hide();
			  
  
    	      var error_username = false;
    	      var error_age = false;
    	      var error_skill = false;
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

          $("#button1").click(function()
          {
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

    	       

    	        check_budget();

    	        if (error_budget) {
    	          $("#budget_error_message")
    	            .html(
    	              "**Please fill budget details**");
    	          $("#budget_error_message").show();
    	        }

    	        if (!error_username && !error_age && !error_skill && !error_budget)
    	        	ajaxPost();
    	        else
    	        	return false;

    		});


    		function ajaxPost() {
    			console.log("ajax entered");
    			// PREPARE FORM DATA
    			var playerData = {};
    			playerData["name"] = $("#inputName").val();
    			playerData["age"] = $("#age").val();
    			playerData["skill"] = $(".skill:checked").val();
    			playerData["purchasePrice"] = $("#budget").val();
    			
    			// DO POST
    			$.ajax({
    				type: "POST",
    				contentType: "application/json",
    				url : '${pageContext.request.contextPath}/addplayer',
    				data: JSON.stringify(playerData),
    				dataType: 'json',
    				success: function(result) {
    					alert("success");
    					//$("#postResultDiv").html("success");
    					$("#postResultDiv1").html("<p style='background-color:#7FA7B0; color:white; padding:20px 20px 20px 20px'>" + 
    							"Post Successfully! <br>" +
    							"---> Player's Info: PlayerName = " + 
    							result.name + " , PlayerAge = " + result.age + " , PlayerSkill = " + result.skill + " , PlayerPrice = " + result.purchasePrice + "</p>");
    				},
    				error: function(e) {
    					alert("Error!")
    					console.log("ERROR: ", e);
    				}
    			});

    			// Reset FormData after Posting
    			resetData();

    		}
    		
    		 function resetData(){
    			 $("#inputName").val("");
    			 $("#age").val("");
    			 $("#budget").val("");
    		 }
    	      
    	        

    	    });

        // player form end
        
    	 // show link

    	    $('#showlink').click(function () {
    	      $("#showpage").show();
    	      $("#updateplayer").hide();
    	      $("#playerform").hide();
    	     
    	    
      	        generateTable();


      	      function generateTable() {
      	    	 
      	       
      	        $.ajax({
				      	type: 'GET',
					    url: '${pageContext.request.contextPath }/getplayers',
					    success: function(players) {
						  
			      	       var playertableInfo = '';
			                
			      	       playertableInfo += '<thead>' +
			                '<tr>' +
			                '<th scope="col">Id</th>' +
			                 '<th scope="col">Name</th>'+ 
			                 '<th scope="col">Age</th>'+
			                  '<th scope="col">Skill</th>'+
			                  '<th scope="col">PurchasePrice</th>'+
			                  '</tr>'+
			                  '</thead>' +  
			                  '<tbody>';
			                
			                  for(var i =0 ;i< players.length ; i++)
			                  {
			                	  
			                	  
			                	  playertableInfo += '<tr>' + '<th scope="row">' + players[i].id + ' </th>' ;
			                	  playertableInfo += '<td>' + players[i].name +'</td>';
			                	  playertableInfo += '<td>' + players[i].age +'</td>';
			                	  playertableInfo += '<td>' + players[i].skill +'</td>';
			                	  playertableInfo += '<td>' + players[i].purchasePrice +'</td>';
//playertableInfo += '<td>' + '<form class="text-center" style="color: #757575;"id="updatetableapp">'+'<button type="submit" name="playerId" value="'+players[i].id+'" class="btn btn-primary playerId">Update</button>'+'</form>'+'</td>'+'</tr>';
			                	  playertableInfo += '<td>' +'<input type ="radio" class = "playerId" name="playerId"  value="'+players[i].id+'" >'+'<button type="submit"  class="btn btn-primary">Update</button>'+'</td>'+'</tr>';                	  
			                	  //playertableInfo += '<td>' +'<button type="submit"  value="'+players[i].id+'" name="playerId"  class="btn btn-primary playerId">Update</button>'+'</td>'+'</tr>'; 
			                  }
			                  	  playertableInfo += '</tbody>'; 
			                  	  $("#playertable").html(playertableInfo);
			                  	  $("#playertable").show();
				
					}
				});
      	        
      	      }
    	      
    	      
    	    });
        
        // show link end 
        
          
          $("#updatetableapp").submit(function(event) {
    			
    	  event.preventDefault();
    	  
    	  console.log(event);
    	
    	  var pid = $(".playerId:checked").val();
    	  console.log(pid);
         
          $("#updateplayer").show();
          $("#playertable").hide();
    	  $("#showpage").hide();
          $("#teamform").hide();
          $("#playerform").hide();
    	  fillForm();
    	  	
         }); 
        
        function fillForm()
        {
        	var playerId =  $(".playerId:checked").val();
        	//var playerId = $("button[name='playerId']").val();
        	console.log(playerId);
        	$.ajax({
				type: 'GET',
				url: '${pageContext.request.contextPath }/getPlayer/'+playerId,
				success: function(result) {
					//var result = JSON.parse(result);
					$("#inputName3").val(result.name);
					$("#age3").val(result.age);
					$("#budget3").val(result.purchasePrice);
				},
				error: function(e) {
					alert("Error!")
					console.log("ERROR: ", e);
				}
			});
        	validateUpdateForm();
        }
        
        function validateUpdateForm()
        { 
        	$("#username_error_message3").hide();
			$("#age_error_message3").hide();
			$("#skill_error_message3").hide();
			$("#budget_error_message3").hide();


			var error_username = false;
			var error_age = false;
			var error_skill = false;
			var error_budget = false;

			$("#inputName3").keyup(function () {

				check_username();

			});

			function check_username() {

				var userName = $("#inputName3").val();
				// alert("Hello " + userName);
				var checklen = true;
				var checkchar = true;
				for (var i = 0; i < userName.length; i++) {
					if (!((userName[i] >= 'a' && userName[i] <= 'z')
						|| (userName[i] >= 'A' && userName[i] <= 'Z') || (userName[i] >= '0' && userName[i] <= '9'))) {
						$("#username_error_message3")
							.html(
								"**Player name should be aplpanumeric**");
						$("#username_error_message3").show();
						error_username = true;
						checkchar = false;
						break;
					}

				}

				if (userName.length < 3) {

					$("#username_error_message3")
						.html(
							"**Player name length should be atleast 3**");
					$("#username_error_message").show();
					error_username = true;
					checklen = false;
				}

				if (checklen && checkchar) {
					$("#username_error_message3").hide();
					error_username = false;
				}
			}

			$("#age3").keyup(function () {

				check_age();

			});

			function check_age() {
				check_username();
				if (error_username) {
					$("#username_error_message3")
						.html(
							"**Please fill name details**");
					$("#username_error_message3").show();
				}
				var age = $("#age3").val();

				var agelen = true;
				if (age.length == 0) {
					$("#age_error_message3")
						.html(
							"**Please fill age details**");
					$("#age_error_message3").show();
					error_age = true;
					agelen = false;
				}

				if (agelen) {
					$("#age_error_message3").hide();
					error_age = false;
				}

			}


			$(".skill3").change(function () {

				validateSkill();

			});

			function validateSkill() {
				check_username();
				if (error_username) {
					$("#username_error_message3")
						.html(
							"**Please fill name details**");
					$("#username_error_message3").show();
				}

				check_age();

				if (error_age) {
					$("#age_error_message3")
						.html(
							"**Please fill age details**");
					$("#age_error_message3").show();
				}


				var skill = $(".skill3:checked");

				if (skill.length == 0) {
					$("#skill_error_message3").html(
						"**Please choose skill**");
					$("#skill_error_message3").show();
					error_skill = true;
				} else {
					$("#skill_error_message3").hide();
					error_skill = false;
				}
			}

			$("#budget3").keyup(function () {

				check_budget();

			});


			function check_budget() {
				check_username();
				if (error_username) {
					$("#username_error_message3")
						.html(
							"**Please fill name details**");
					$("#username_error_message3").show();
				}

				check_age();

				if (error_age) {
					$("#age_error_message3")
						.html(
							"**Please fill age details**");
					$("#age_error_message3").show();
				}

				validateSkill();
				if (error_skill) {
					$("#skill_error_message3").html(
						"**Please choose skill**");
					$("#skill_error_message3").show();
				}

				var budget = $("#budget3").val();

				var budgetlen = true;
				if (budget.length == 0) {
					$("#budget_error_message3")
						.html(
							"**Please fill budget details**");
					$("#budget_error_message3").show();
					error_budget = true;
					budgetlen = false;
				}

				if (budgetlen) {
					$("#budget_error_message3").hide();
					error_budget = false;
				}

			}



			 $("#updateplayerinfo").submit(function(event) {
	    			// Prevent the form from submitting via the browser.
	          event.preventDefault();
				check_username();
				if (error_username) {
					$("#username_error_message3")
						.html(
							"**Please fill name details**");
					$("#username_error_message3").show();
				}

				check_age();

				if (error_age) {
					$("#age_error_message3")
						.html(
							"**Please fill age details**");
					$("#age_error_message3").show();
				}

				validateSkill();
				if (error_skill) {
					$("#skill_error_message3").html(
						"**Please choose skill**");
					$("#skill_error_message3").show();
				}
				
				check_budget();

				if (error_budget) {
					$("#budget_error_message3")
						.html(
							"**Please fill budget details**");
					$("#budget_error_message3").show();
				}

				if (!error_username && !error_age && !error_skill && !error_budget)
					ajaxPost();
				return false;


			});
			 
			 function ajaxPost() {
	    			console.log("ajax entered");
	    			// PREPARE FORM DATA
	    			var playerData = {};
	    			var playerId =  $(".playerId:checked").val();
	    			playerData["name"] = $("#inputName3").val();
	    			playerData["age"] = $("#age3").val();
	    			playerData["skill"] = $(".skill3:checked").val();
	    			playerData["purchasePrice"] = $("#budget3").val();
	    			
	    			// DO POST
	    			$.ajax({
	    				type: "POST",
	    				contentType: "application/json",
	    				url : '${pageContext.request.contextPath}/updateplayer/'+playerId,
	    				data: JSON.stringify(playerData),
	    				dataType: 'json',
	    				success: function(result) {
	    					alert("success");
	    					//$("#postResultDiv").html("success");
	    					$("#postResultDiv2").html("<p style='background-color:#7FA7B0; color:white; padding:20px 20px 20px 20px'>" + 
	    							"Update Successfully! <br>" +
	    							"---> Player's Info: PlayerName = " + 
	    							result.name + " , PlayerAge = " + result.age + " , PlayerSkill = " + result.skill + " , PlayerPrice = " + result.purchasePrice + "</p>");
	    				},
	    				error: function(e) {
	    					alert("Error!")
	    					console.log("ERROR: ", e);
	    				}
	    			});

	    			// Reset FormData after Posting
	    			
	    		}
			 
        }
        
        // update form end
        
    });

    </script>
</body>

</html>