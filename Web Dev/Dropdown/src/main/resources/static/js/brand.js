$('document')
		.ready(
				function() {
					$("#username_error_message").hide();

					var error_username = false;

					$("#inputName").focusout(function() {

						check_username();

					});

					function check_username() {

						var userName = $("#inputName").val();
						var checklen = true;
						var checkchar = true;
						for (var i = 0; i < userName.length; i++) {
							if (!((userName[i] >= 'a' && userName[i] <= 'z')
									|| (userName[i] >= 'A' && userName[i] <= 'Z') || (userName[i] >= '0' && userName[i] <= '9'))) {
								$("#username_error_message")
										.html(
												"**Brand name should be aplpanumeric**");
								$("#username_error_message").show();
								error_username = true;
								checkchar = false;
								break;
							}

						}

						if (userName.length < 3) {

							$("#username_error_message")
									.html(
											"**Brand name length should be atleast 3**");
							$("#username_error_message").show();
							error_username = true;
							checklen = false;
						}

						if (checklen && checkchar) {
							$("#username_error_message").hide();
							error_username = false;
						}
					}

					$('#button1').click(
							function() {

								check_username();
								if (error_username) {
									$("#username_error_message").html(
											"**Please fill name details**");
									$("#username_error_message").show();
								}

								if (!error_username)
									return true;
								else
									return false;
							});

				});