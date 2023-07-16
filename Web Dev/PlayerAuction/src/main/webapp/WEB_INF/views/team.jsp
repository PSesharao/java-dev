<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta http-equiv="x-ua-compatible" content="ie=edge">
    <title>Team</title>

    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

    <!-- MDB icon -->
    <link rel="icon" href="img/mdb-favicon.ico" type="image/x-icon">
    <!-- Font Awesome -->
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.11.2/css/all.css">
    <!-- Google Fonts Roboto -->
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700&display=swap">
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
            <strong>Team</strong>
        </h5>

        <!--Card content-->
        <div class="card-body px-lg-5 ">

            <!-- Form -->
            <form class="text-center" style="color: #757575;" action="addteam">

                <p>please enter the team details</p>
			<div class="parallax">
                <!-- Name -->
                <div class="row">

                    <div class="col-sm-5"> </div>
                    <div class="md-form mt-3">
                        <div class="invalid-tooltip" id="username_error_message"> </div>
                        <input type="text" id="inputName" class="form-control " name="name">
                        <label for="inputName">Name</label>
                    </div>

                </div>

                  <!-- slider -->
                 <div class="row">
                    <div class="col-sm-3"> </div>
                    <div class="col-sm-6">Max Budget </div>
                </div>

                <div class="d-flex justify-content-center my-4">
                    <div class="w-30">
                        <input type="range" class="custom-range" id="customRange11" min="0" max="200" value="50" name="maxBudget">
                    </div>
                    <span class="font-weight-bold text-primary ml-2 valueSpan2"></span>
                </div>

                <!-- Submit button -->
                <div class="row">
                    <div class="col-sm-5"> </div>
                    <button class="btn btn-outline-info btn-rounded btn-block z-depth-0 my-4 waves-effect col-sm-2"
                        type="submit" id="button">Submit</button>
                </div>
                <br>
                <br> <br> <br> <br>  <br>  <br> <br> <br>  <br>
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

            $("#username_error_message1").hide();
           
           

            var error_username = false;
            
           

            $("#inputName1").keyup(function () {

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

          
            
            $('#button1').click(function () {
                check_username();
                if (error_username) {
                    $("#username_error_message1")
                        .html(
                            "**Please fill name details**");
                    $("#username_error_message1").show();
                }

               
                if(!error_username )
                    return true;
                return false;


            });


        });
    </script>
</body>

</html>