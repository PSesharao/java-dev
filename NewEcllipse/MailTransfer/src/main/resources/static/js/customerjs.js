$(document).ready(function () {             
                
                // Customer Card Start
				$('#customerlink').click(function () {
					$("#customerhistorycard").hide();
					$("#ordercard").hide();
					$("#productform").hide();
					$("#categorycard").hide();
					$("#customercard").show();
					$("#postCustomer").hide();


					$("#customername_error_message").hide();
					$("#gender_error_message").hide();
					$("#address_error_message").hide();
					$("#hobby_error_message").hide();

					var error_customername = false;
					var error_gender = false;
					var error_address = false;
					var error_hobby = false;

					$("#customername").keyup(function () {

						check_customername();

					});

					function check_customername() {

						var customername = $("#customername").val();

						var checklen = true;
						var checkchar = true;
						for (var i = 0; i < customername.length; i++) {
							if (!((customername[i] >= 'a' && customername[i] <= 'z')
								|| (customername[i] >= 'A' && customername[i] <= 'Z') || (customername[i] >= '0' && customername[i] <= '9') || (customername[i] == ' '))) {
								$("#customername_error_message")
									.html(
										"**Customer name should be aplpanumeric**");
								$("#customername_error_message").show();
								error_customername = true;
								checkchar = false;
								break;
							}

						}

						if (customername.length < 3) {

							$("#customername_error_message")
								.html(
									"**Customer name should have atleast length 3**");
							$("#customername_error_message").show();
							error_customername = true;
							checklen = false;
						}

						if (checklen && checkchar) {
							$("#customername_error_message").hide();
							error_customername = false;
						}
					}

					$(".gender").change(function () {
						check_gender();
					});

					function check_gender() {
						check_customername();
						if (error_customername) {
							$("#customername_error_message")
								.html(
									"**Please fill Customer name details**");
							$("#customername_error_message").show();
						}

						var gender = $(".gender:checked");
						if (gender.length == 0) {
							error_gender = true;
							$("#gender_error_message")
								.html(
									"**Please fill Customer gender details**");
							$("#gender_error_message").show();
						}
						else {
							error_gender = false;
							$("#gender_error_message").hide();
						}

					}


					$("#address").keyup(function () {

						check_address();

					});

					function check_address() {
						check_customername();
						if (error_customername) {
							$("#customername_error_message")
								.html(
									"**Please fill Customer name details**");
							$("#customername_error_message").show();
						}
						check_gender();
						if (error_gender) {
							$("#gender_error_message")
								.html(
									"**Please fill Customer gender details**");
							$("#gender_error_message").show();

						}

						var address = $("#address").val();
						if (address.length == 0) {
							error_address = true;
							$("#address_error_message")
								.html(
									"**Please fill Customer address details**");
							$("#address_error_message").show();
						}
						else {
							error_address = false;
							$("#address_error_message").hide();
						}

					}

					$(".hobbyList").change(function () {

						check_hobbies();
					});

					function check_hobbies() {
						check_customername();
						if (error_customername) {
							$("#customername_error_message")
								.html(
									"**Please fill Customer name details**");
							$("#customername_error_message").show();
						}
						check_gender();
						if (error_gender) {
							$("#gender_error_message")
								.html(
									"**Please fill Customer gender details**");
							$("#gender_error_message").show();

						}
						check_address();

						if (error_address) {
							$("#address_error_message")
								.html(
									"**Please fill Customer address details**");
							$("#address_error_message").show();
						}

						var hobbies = $(".hobbyList:checked");



						if (hobbies.length < 2) {
							error_hobby = true;
							$("#hobby_error_message")
								.html(
									"**Customer should have atleast 2 hobbies**");
							$("#hobby_error_message").show();
						}
						else {
							$("#hobby_error_message").hide();
							error_hobby = false;
						}


					}



					$("#customerform").submit(function (event) {
						event.preventDefault();
						//$("#submitCategory").prop("disabled", true);
						check_customername();
						if (error_customername) {
							$("#customername_error_message")
								.html(
									"**Please fill Customer name details**");
							$("#customername_error_message").show();
						}
						check_gender();
						if (error_gender) {
							$("#gender_error_message")
								.html(
									"**Please fill Customer gender details**");
							$("#gender_error_message").show();

						}
						check_address();

						if (error_address) {
							$("#address_error_message")
								.html(
									"**Please fill Customer address details**");
							$("#address_error_message").show();
						}
						check_hobbies();
						if (error_hobby) {
							$("#hobby_error_message")
								.html(
									"**Customer should have atleast 2 hobbies**");
							$("#hobby_error_message").show();
						}


						if (!error_customername && !error_gender && !error_hobby && !error_address)
							ajaxPost();
						else
							return false;

					});


					function ajaxPost() {
						// Get form
						var form = $('#customerform')[0];

						var customerData = new FormData(form);


						$.ajax({
							type: "POST",
							enctype: 'multipart/form-data',
							//contentType: "application/json",
							//url: '${pageContext.request.contextPath}/createCustomer',
							
							url : "http://localhost:8080/"+ "createCustomer",
							
							//data: JSON.stringify(productData),
							data: customerData,
							//dataType: 'json',
							processData: false,
							contentType: false,
							cache: false,
							success: function (result) {

								$("#postCustomer").html("<p>" +
									"Post Successfully! <br>" +
									"---> Customer's Info: CustomerName = " +
									result.name + ", CustomerGender =" + result.gender + " ,CustomerAddress =" + result.address + ", Customer's hobbyList =" + result.hobbyList + "</p>");
								$("#postCustomer").show();
							}
							,
							error: function (e) {
								alert("Error!")
								console.log("ERROR: ", e);
							}
						});

						// Reset FormData after Posting
						resetData();
					}
					function resetData() {
						$("#customername").val("");
						$("#address").val("");

					}
				});
				//Customer Card end

            });