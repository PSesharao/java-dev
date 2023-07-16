$(document).ready(function() {

	$("#playerform").hide();
	$("#teamform").hide();
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




	// team validations 

	$('#teamlink').click(function() {
		$("#playerform").hide();
		$("#showpage").hide();
		$("#updateplayer").hide();
		$("#teamform").show();
		$("#username_error_message1").hide();



		var error_username = false;



		$("#inputName1").keyup(function() {

			check_username();

		});

		function check_username() {

			var userName = $("#inputName1").val();
			// alert("Hello " + userName);
			var checklen = true;
			var checkchar = true;
			for (var i = 0; i < userName.length; i++) {
				if (!((userName[i] >= 'a' && userName[i] <= 'z')
					|| (userName[i] >= 'A' && userName[i] <= 'Z') || (userName[i] >= '0' && userName[i] <= '9'))) {
					$("#username_error_message1")
						.html(
							"**Team name should be aplpanumeric**");
					$("#username_error_message1").show();
					error_username = true;
					checkchar = false;
					break;
				}

			}

			if (userName.length < 2) {

				$("#username_error_message1")
					.html(
						"**Team name length should be atleast 2**");
				$("#username_error_message1").show();
				error_username = true;
				checklen = false;
			}

			if (checklen && checkchar) {
				$("#username_error_message1").hide();
				error_username = false;
			}
		}

		const $valueSpan = $('.valueSpan2');
		const $value = $('#customRange11');
		$valueSpan.html($value.val());
		// $value.on('input change', () => {
		$value.change(() => {
			$valueSpan.html($value.val());
		});



		/*         $('#button1').click(function () {
					 check_username();
					 if (error_username) {
						 $("#username_error_message1")
							 .html(
								 "**Please fill name details**");
						 $("#username_error_message1").show();
					 }
		
				    
					 if(!error_username ){
						var teamData = {};
						teamData["name"] = $("#inputName1").val();
						teamData["maxBudget"] = $("#customRange11").val();
					   
						$.ajax({
							type : "POST",
							contentType : "application/json",
							url : '${pageContext.request.contextPath }/addteam',
							data : JSON.stringify(teamData),
							dataType : 'json',
							success : function(result) {
							    
							}
						});
						 return true;
					 }
					 return false;
		
		
				 });*/

		$("#appteamform").submit(function(event) {
			// Prevent the form from submitting via the browser.
			event.preventDefault();
			check_username();
			if (error_username) {
				$("#username_error_message1")
					.html(
						"**Please fill name details**");
				$("#username_error_message1").show();
			}
			if(!error_username )
					ajaxPost();
			else
				return false;
		});


		function ajaxPost() {

			// PREPARE FORM DATA
			var teamData = {};
			teamData["name"] = $("#inputName1").val();
			teamData["maxBudget"] = $("#customRange11").val();

			// DO POST
			$.ajax({
				type: "POST",
				contentTyp: "application/json",
				url: '${pageContext.request.contextPath }/addteam',
				data: JSON.stringify(teamData),
				dataType: 'json',
				succes: function(result) {
					/*if (result.status == "Done") {
						$("#postResultDiv").html("<p style='background-color:#7FA7B0; color:white; padding:20px 20px 20px 20px'>" +
							"Post Successfully! <br>" +
							"---> Customer's Info: FirstName = " +
							result.data.firstname + " ,LastName = " + result.data.lastname + "</p>");
					} else {
						$("#postResultDiv").html("<strong>Error</strong>");
					}
					console.log(result);*/
				},
				error: function(e) {
					alert("Error!")
					console.log("ERROR: ", e);
				}
			});

			// Reset FormData after Posting
			//resetData();

		}

		/*function resetData() {
			$("#firstname").val("");
			$("#lastname").val("");
		}*/

	});

	// player validations 

	$('#playerlink').click(function() {
		$("#playerform").show();
		$("#showpage").hide();
		$("#updateplayer").hide();
		$("#teamform").hide();
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

		$("#inputName").keyup(function() {

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

		$("#age").keyup(function() {

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


		$(".skill").change(function() {

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


		$("#team").change(function() {

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



		$("#budget").keyup(function() {

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



		$('#button').click(function() {
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

			if (error_budget) {
				$("#budget_error_message")
					.html(
						"**Please fill budget details**");
				$("#budget_error_message").show();
			}

			if (!error_team && !error_username && !error_age && !error_skill && !error_budget)
				return true;
			return false;


		});

	});


	// show link

	$('#showlink').click(function() {
		$("#showpage").show();
		$("#updateplayer").hide();
		$("#teamform").hide();
		$("#playerform").hide();
	});

});