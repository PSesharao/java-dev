$(document).ready(function () {

				// product card start
				$('#productlink').click(function () {
					$("#productform").show();

					$("#categorycard").hide();

					$("#customercard").hide();
					$("#ordercard").hide();
					$("#customerhistorycard").hide();
					$("#productname_error_message").hide();

					$("#catageory_error_message").hide();

					$("#price_error_message").hide();

					$("#image_error_message").hide();

					$.ajax({
						type: 'GET',
						url: '${pageContext.request.contextPath }/getCategories',
						success: function (result) {

							var categoryInfo = '<option value="" disabled="" selected="">Choose Category</option>';
							for (var i = 0; i < result.length; i++) {
								categoryInfo += '<option value =' + result[i].name + '>' + result[i].name + '</option>';
							}
							$('#catageoryDropdown').html(categoryInfo);

						}
					});

					var error_productname = false;

					var error_catageory = false;
					var error_price = false;
					var error_image = false;

					$("#productname").keyup(function () {

						check_productname();

					});

					function check_productname() {

						var productName = $("#productname").val();
						// alert("Hello " + userName);
						var checklen = true;
						var checkchar = true;
						for (var i = 0; i < productName.length; i++) {
							if (!((productName[i] >= 'a' && productName[i] <= 'z')
								|| (productName[i] >= 'A' && productName[i] <= 'Z') || (productName[i] >= '0' && productName[i] <= '9') || (productName[i] == ' '))) {
								$("#productname_error_message")
									.html(
										"**Product name should be aplpanumeric**");
								$("#productname_error_message").show();
								error_productname = true;
								checkchar = false;
								break;
							}

						}

						if (productName.length < 3) {

							$("#productname_error_message")
								.html(
									"**Product name should have atleast length 3**");
							$("#productname_error_message").show();
							error_productname = true;
							checklen = false;
						}

						if (checklen && checkchar) {
							$("#productname_error_message").hide();
							error_productname = false;
						}
					}



					$("#catageoryDropdown").change(function () {

						validateCatageory();

					});

					function validateCatageory() {
						check_productname();
						if (error_productname) {
							$("#productname_error_message")
								.html(
									"**Please fill Product name details**");
							$("#productname_error_message").show();
						}



						var catageory = $("#catageoryDropdown option:selected").val();

						if (catageory == "") {
							$("#catageory_error_message").html(
								"**Please choose catageory**");
							$("#catageory_error_message").show();
							error_catageory = true;
						} else {
							$("#catageory_error_message").hide();
							error_catageory = false;
						}
					}



					$("#productprice").keyup(function () {

						check_price();

					});


					function check_price() {


						check_productname();
						if (error_productname) {
							$("#productname_error_message")
								.html(
									"**Please fill Product name details**");
							$("#productname_error_message").show();
						}

						validateCatageory();

						if (error_catageory) {
							$("#catageory_error_message").html(
								"**Please choose catageory**");
							$("#catageory_error_message").show();
						}



						var price = $("#productprice").val();

						var checklen = true;
						var checkchar = true;

						for (var i = 0; i < price.length; i++) {
							if (!((price[i] >= '0' && price[i] <= '9') || (price[i] == '.'))) {
								$("#price_error_message")
									.html(
										"**Price should be numeric**");
								$("#price_error_message").show();
								error_productname = true;
								checkchar = false;
								break;
							}

						}
						if (price.length == 0) {
							$("#price_error_message")
								.html(
									"**Please fill price details**");
							$("#price_error_message").show();
							error_price = true;
							checklen = false;
						}

						if (checklen && checkchar) {
							$("#price_error_message").hide();
							error_price = false;
						}

					}


                    $("#image").focusout(function () {

						check_image();

                    });
                    
                    function check_image() {
                        check_productname();
						if (error_productname) {
							$("#productname_error_message")
								.html(
									"**Please fill Product name details**");
							$("#productname_error_message").show();
						}

						validateCatageory();

						if (error_catageory) {
							$("#catageory_error_message").html(
								"**Please choose catageory**");
							$("#catageory_error_message").show();
                        }
                        

                        check_price();
						if (error_price) {
							$("#price_error_message")
								.html(
									"**Please fill price details**");
							$("#price_error_message").show();
                        }
                        

                        //console.log($("#image"));
                        if ($("#image").val().length == 0) {
                            $("#image_error_message")
                                .html(
                                    "**Please upload product image**");
                            $("#image_error_message").show();
                            error_image = true;

                        }
                        else {
                            error_image = false;
                            $("#image_error_message").hide();
                        }

                    }



					$("#productFormId").submit(function (event) {
						event.preventDefault();
						//$("#submitProduct").prop("disabled", true);
						check_productname();
						if (error_productname) {
							$("#productname_error_message")
								.html(
									"**Please fill Product name details**");
							$("#productname_error_message").show();
						}

						validateCatageory();

						if (error_catageory) {
							$("#catageory_error_message").html(
								"**Please choose catageory**");
							$("#catageory_error_message").show();
						}

						check_price();
						if (error_price) {
							$("#price_error_message")
								.html(
									"**Please fill price details**");
							$("#price_error_message").show();
						}


						check_image();
                        if(error_image)
                        {
                            $("#image_error_message")
                            .html(
                                "**Please upload product image**");
                            $("#image_error_message").show();
                        }

						
						if (!error_productname && !error_catageory && !error_price && !error_image)
							ajaxPost();
						else
							return false;

					});


					function ajaxPost() {
						// Get form
						var form = $('#productFormId')[0];

						var productData = new FormData(form);

						/* var productData = {};
						productData["name"] = $("#productname").val();
						
						productData["catageory"] = $(".catageory:checked").val();
						productData["price"] = $("#productprice").val();
						productData["imageFile"] = $("#image").val();
						//prop("files")[0];
						// DO POST */

						$.ajax({
							type: "POST",
							enctype: 'multipart/form-data',
							//contentType: "application/json",
							url: '${pageContext.request.contextPath}/createproduct',
							//data: JSON.stringify(productData),
							data: productData,
							//dataType: 'json',
							processData: false,
							contentType: false,
							cache: false,
							success: function (result) {
								//alert("success");
								$("#postResultDiv1").html("<p style='background-color: #79c276; color:white; padding:20px 20px 20px 20px'>" +
									"Post Successfully! <br>" +
									"---> Product's Info: ProductName = " +
									result.name + " , ProductPrice = " + result.price + " , ProductImage = " + result.image + "</p>");
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
						$("#productname").val("");
						$("#productprice").val("");

					}
				});

				// product card end 
});