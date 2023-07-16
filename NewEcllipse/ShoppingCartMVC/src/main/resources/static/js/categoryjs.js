$(document).ready(function () {
    				// category card start
                    $('#categorylink').click(function () {
                        $("#customerhistorycard").hide();
                        $("#ordercard").hide();
                        $("#customercard").hide();
                        $("#productform").hide();
                        $("#categorycard").show();
						$("#postCategory").hide();
    					
                        $("#categoryname_error_message").hide();
    
                        var error_categoryname = false;
    
                        $("#categoryname").keyup(function () {
    
                            check_categoryname();
    
                        });
    
                        function check_categoryname() {
    
                            var categoryname = $("#categoryname").val();
    
                            var checklen = true;
                            var checkchar = true;
                            for (var i = 0; i < categoryname.length; i++) {
                                if (!((categoryname[i] >= 'a' && categoryname[i] <= 'z')
                                    || (categoryname[i] >= 'A' && categoryname[i] <= 'Z') || (categoryname[i] >= '0' && categoryname[i] <= '9') || (categoryname[i] == ' '))) {
                                    $("#categoryname_error_message")
                                        .html(
                                            "**Category name should be aplpanumeric**");
                                    $("#categoryname_error_message").show();
                                    error_categoryname = true;
                                    checkchar = false;
                                    break;
                                }
    
                            }
    
                            if (categoryname.length < 3) {
    
                                $("#categoryname_error_message")
                                    .html(
                                        "**Category name should have atleast length 3**");
                                $("#categoryname_error_message").show();
                                error_categoryname = true;
                                checklen = false;
                            }
    
                            if (checklen && checkchar) {
                                $("#categoryname_error_message").hide();
                                error_categoryname = false;
                            }
                        }
    
    
                        $("#categoryform").submit(function (event) {
                            event.preventDefault();
                            //$("#submitCategory").prop("disabled", true);
                            check_categoryname();
                            if (error_categoryname) {
                                $("#categoryname_error_message")
                                    .html(
                                        "**Please fill Category name details**");
                                $("#categoryname_error_message").show();
                            }
    
                            if (!error_categoryname)
                                ajaxPost();
                            else
                                return false;
    
                        });
    
    
                        function ajaxPost() {
                            // Get form
                            var form = $('#categoryform')[0];
    
                            var categoryData = new FormData(form);
    
    
                            $.ajax({
                                type: "POST",
                                enctype: 'multipart/form-data',
                                //contentType: "application/json",
                                //url: '${pageContext.request.contextPath}/createcategory',
								url : "http://localhost:8080/"+ "createcategory",
                                //data: JSON.stringify(productData),
                                data: categoryData,
                                //dataType: 'json',
                                processData: false,
                                contentType: false,
                                cache: false,
                                success: function (result) {
                                    //alert("success");
                                    $("#postCategory").html("<p>" +
                                        "Post Successfully! <br>" +
                                        "---> Category's Info: CategoryName = " +
                                        result.name + "</p>");
									$("#postCategory").show();
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
                            $("#categoryname").val("");
    
                        }
                    });
                    // category card end
});