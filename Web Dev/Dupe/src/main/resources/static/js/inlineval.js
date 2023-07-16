$('document')
		.ready(
				function() {
					$("#username_error_message").hide();
					$("#age_error_message").hide();
					$("#gender_error_message").hide();
					$("#hobby_error_message").hide();
					$("#dept_error_message").hide();
					$("#validate_error_message").hide();
					
					
					var error_username = false;
					var error_age = false;
					var error_gender = false;
					var error_hobby = false;
					var error_dept = false;

					$("#name").focusout(function() {

						check_username();

					});

					function check_username() {

						var userName = $("#name").val();
						var checklen = true;
						var checkchar = true;
						for (var i = 0; i < userName.length; i++) {
							if (!((userName[i] >= 'a' && userName[i] <= 'z')
									|| (userName[i] >= 'A' && userName[i] <= 'Z') || (userName[i] >= '0' && userName[i] <= '9'))) {
								$("#username_error_message").html(
										"**Name should be Alphanumeric**");
								$("#username_error_message").show();
								error_username = true;
								checkchar = false;
								break;
							}

						}

						if (userName.length < 3) {

							$("#username_error_message")
									.html(
											"**Name should have 3 characters atleast**");
							$("#username_error_message").show();
							error_username = true;
							checklen = false;
						}

						if (checklen && checkchar) {
							$("#username_error_message").hide();
							error_username = false;
						}

					}

					$("#age").focusout(function() {

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

					$(".gender").focusout(function() {

						validateGender();

					});

					function validateGender() {
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

						// var checfood = false;
						var gender = $(".gender:checked");
						// for (var i = 0; i < food.length; i++) {
						// if(food[i].checked )
						// {
						// checfood = true;
						// break;
						// }
						// }
						// if(food!=null)
						// checfood = true;
						if (gender.length == 0) {
							$("#gender_error_message").html(
									"**Please choose your gender**");
							$("#gender_error_message").show();
							error_gender = true;
						} else {
							$("#gender_error_message").hide();
							error_gender = false;
						}
					}

					$(".hobbies").focusout(function() {

						validateHobby();

					});

					function validateHobby() {

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
						validateGender();

						if (error_gender) {
							$("#gender_error_message")
									.html(
											"**Please choose your gender**");
							$("#gender_error_message").show();
						}
						
						var hobby = $(".hobbies:checked");

						var noOfhobbies = hobby.length;

						// var noOfhobbies = 0;
						// for (var i = 0; i < hobby.length; i++) {
						// if(hobby[i].checked)
						// noOfhobbies++;
						// }

						if (noOfhobbies < 2) {
							error_hobby = true;
							$("#hobby_error_message").html(
									"**Please choose atleast 2 hobbies**");
							$("#hobby_error_message").show();

						} else {
							$("#hobby_error_message").hide();
							error_hobby = false;
						}

					}

					$("#deptId").focusout(function() {

						validateDept();

					});

					function validateDept() {
						
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
						validateGender();

						if (error_gender) {
							$("#gender_error_message")
									.html(
											"**Please choose your gender**");
							$("#gender_error_message").show();
						}
					
						validateHobby();

						if (error_hobby) {
							$("#hobby_error_message").html(
									"**Please choose atleast 2 hobbies**");
							$("#hobby_error_message").show();
						}

						var dept = $("#deptId option:selected").val();
						// alert(dept);
						if (dept == "") {
							error_dept = true;
							$("#dept_error_message").html(
									"**Please choose a department**");
							$("#dept_error_message").show();
						} else {
							$("#dept_error_message").hide();
							error_dept = false;
						}

					}

					$('#button1')
							.click(
									function() {
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
										validateGender();

										if (error_gender) {
											$("#gender_error_message")
													.html(
															"**Please choose your gender**");
											$("#gender_error_message").show();
										}

										validateHobby();

										if (error_hobby) {
											$("#hobby_error_message")
													.html(
															"**Please choose atleast 2 hobbies**");
											$("#hobby_error_message").show();
										}

										validateDept();
										if (error_dept) {
											$("#dept_error_message")
													.html(
															"**Please choose a department**");
											$("#dept_error_message").show();
										}

										if (!error_username && !error_age
												&& !error_gender
												&& !error_hobby && !error_dept){
											$("#validate_error_message").html('<p class="text-success">Validation Success!!</p>');
										    $("#validate_error_message").show();
										    $("#subbutton").html('<button type="submit" class="btn btn-primary" > Submit </button>');
										}
									});

				});