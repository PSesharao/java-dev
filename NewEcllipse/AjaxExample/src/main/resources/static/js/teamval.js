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
		
		$value.change(() => {
			$valueSpan.html($value.val());
		});


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
			if (!error_username)
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
				contentType: "application/json",
				url: '${pageContext.request.contextPath}/addteam',
				data: JSON.stringify(teamData),
				dataType: 'json',
				success: function(result) {
					alert("success");
					//$("#postResultDiv").html("success");
					$("#postResultDiv").html("<p style='background-color:#7FA7B0; color:white; padding:20px 20px 20px 20px'>" +
						"Post Successfully! <br>" +
						"---> Team's Info: TeamName = " +
						result.name + " , MaxBudget = " + result.maxBudget + "</p>");
				},
				error: function(e) {
					alert("Error!")
					console.log("ERROR: ", e);
				}
			});

			// Reset FormData after Posting
			//resetData();

		}


	});


});