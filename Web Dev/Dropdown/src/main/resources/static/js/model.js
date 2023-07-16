$('document')
		.ready(
				function() {
					$("#username_error_message").hide();
					$("#capacity_error_message").hide();
					$("#color_error_message").hide();
					$("#price_error_message").hide();
					$("#brand_error_message").hide();

					var error_username = false;
					var error_capacity = false;
					var error_color = false;
					var error_price = false;
					var error_brand = false;

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
												"**Model name should be aplpanumeric**");
								$("#username_error_message").show();
								error_username = true;
								checkchar = false;
								break;
							}

						}

						if (userName.length < 3) {

							$("#username_error_message")
									.html(
											"**Model name length should be atleast 3**");
							$("#username_error_message").show();
							error_username = true;
							checklen = false;
						}

						if (checklen && checkchar) {
							$("#username_error_message").hide();
							error_username = false;
						}
					}

					$("#inputColor").focusout(function() {

						check_color();

					});

					function check_color() {

						check_username();
						if (error_username) {
							$("#username_error_message").html(
									"**Please fill Model name details**");
							$("#username_error_message").show();
						}

						var color = $("#inputColor").val();
						if (color.length < 3) {
							$("#color_error_message").html(
									"**Color length should be atleast 3**");
							$("#color_error_message").show();
							error_color = true;
						} else {
							error_color = false;
							$("#color_error_message").hide();
						}
					}

					$("#inputPrice").focusout(function() {

						check_price();

					});

					function check_price() {
						check_username();
						if (error_username) {
							$("#username_error_message").html(
									"**Please fill Model name details**");
							$("#username_error_message").show();
						}

						check_color();
						if (error_color) {
							$("#color_error_message").html(
									"**Please fill color details**");
							$("#color_error_message").show();

						}

						var price = $("#inputPrice").val();
						if (price.length == 0) {
							$("#price_error_message").html(
									"**Please fill price details**");
							$("#price_error_message").show();
							error_price = true;
						} else {
							$("#price_error_message").hide();
							error_price = false;
						}
					}

					$("#inputCapacity").focusout(function() {

						check_capacity();

					});

					function check_capacity() {
						check_username();
						if (error_username) {
							$("#username_error_message").html(
									"**Please fill Model name details**");
							$("#username_error_message").show();
						}

						check_color();
						if (error_color) {
							$("#color_error_message").html(
									"**Please fill color details**");
							$("#color_error_message").show();

						}

						check_price();
						if (error_price) {
							$("#price_error_message").html(
									"**Please fill price details**");
							$("#price_error_message").show();

						}

						var capacity = $("#inputCapacity").val();

						var caplen = true;
						if (capacity.length == 0) {
							$("#capacity_error_message").html(
									"**Please fill quantity details**");
							$("#capacity_error_message").show();
							error_capacity = true;
							caplen = false;
						}

						if (caplen) {
							$("#capacity_error_message").hide();
							error_capacity = false;
						}

					}

					$("#brand").focusout(function() {

						check_brand();

					});

					function check_brand() {
						check_username();
						if (error_username) {
							$("#username_error_message").html(
									"**Please fill Model name details**");
							$("#username_error_message").show();
						}

						check_color();
						if (error_color) {
							$("#color_error_message").html(
									"**Please fill color details**");
							$("#color_error_message").show();

						}

						check_price();
						if (error_price) {
							$("#price_error_message").html(
									"**Please fill price details**");
							$("#price_error_message").show();

						}

						check_capacity();

						if (error_capacity) {
							$("#capacity_error_message").html(
									"**Please fill quantity details**");
							$("#capacity_error_message").show();
						}

						var brand = $("#brand option:selected").val();
						if (brand == "") {
							error_brand = true;
							$("#brand_error_message").html(
									"**Please choose a brand**");
							$("#brand_error_message").show();
						} else {
							$("#brand_error_message").hide();
							error_brand = false;
						}

					}

					$('#button1')
							.click(
									function() {

										check_username();
										if (error_username) {
											$("#username_error_message")
													.html(
															"**Please fill Model name details**");
											$("#username_error_message").show();
										}

										check_color();
										if (error_color) {
											$("#color_error_message")
													.html(
															"**Please fill color details**");
											$("#color_error_message").show();

										}

										check_price();
										if (error_price) {
											$("#price_error_message")
													.html(
															"**Please fill price details**");
											$("#price_error_message").show();

										}

										check_capacity();

										if (error_capacity) {
											$("#capacity_error_message")
													.html(
															"**Please fill quantity details**");
											$("#capacity_error_message").show();
										}

										check_brand();

										if (error_brand) {
											$("#brand_error_message")
													.html(
															"**Please choose a brand**");
											$("#brand_error_message").show();

										}

										if (!error_username && !error_capacity
												&& !error_price && !error_color
												&& !error_brand) {

											return true;
										} else
											return false;
									});

				});
