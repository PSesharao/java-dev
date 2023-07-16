$('document').ready(function () {
    $("#username_error_message").hide();
    $("#pwd_error_message").hide();
    $("#food_error_message").hide();
    $("#hobby_error_message").hide();

    var error_username = false;
    var error_password = false;
    var error_food = false;
    var error_hobby = false;

    $("#username").keyup(function () {

        check_username();

    });

    function check_username() {

        var userName = $("#username").val();
        var checklen = true;
        var checkchar = true;
        for (var i = 0; i < userName.length; i++) {
            if (!((userName[i] >= 'a' && userName[i] <= 'z') || (userName[i] >= 'A' && userName[i] <= 'Z') || (userName[i] >= '0' && userName[i] <= '9'))) {
                $("#username_error_message").html("**Username should be aplpanumeric**");
                $("#username_error_message").show();
                error_username = true;
                checkchar = false;
                break;
            }

        }

        var num = false;
    for (var i = 0; i < userName.length; i++)
      if ((userName[i] >= '0' && userName[i] <= '9')) {
       num = true;
        break;
      }
    if (!num) {
        $("#username_error_message").html("**Username should have atleast one numeric character**");
        $("#username_error_message").show();
        error_username = true;
    }

    var alpha = false;
    for (var i = 0; i < userName.length; i++)
      if ((userName[i] >= 'a' && userName[i] <= 'z') || (userName[i] >= 'A' && userName[i] <= 'Z')) {
        alpha = true;
        break;
      }
    if (!alpha) {
        $("#username_error_message").html("**Username should have atleast one alpha character**");
        $("#username_error_message").show();
        error_username = true;
    }

    if (userName.length < 8 || userName.length > 16) {

        $("#username_error_message").html("**Username length should be atleast 8 and atmost 16**");
        $("#username_error_message").show();
        error_username = true;
        checklen = false;
    }

        if (checklen && checkchar && num && alpha) {
            $("#username_error_message").hide();
            error_username = false;
        }

    }


    $("#password").keyup(function () {

        check_password();

    });

    function check_password() {
        check_username();
        if (error_username) {
            $("#username_error_message").html("**Please fill Username details**");
            $("#username_error_message").show();
        }
        var password = $("#password").val();
        
        
          var cap = false;
          for (var i = 0; i < password.length; i++)
            if (password[i] >= 'A' && password[i] <= 'Z') {
              cap = true;
              break;
            }
          if (!cap) {
            $("#pwd_error_message").html("**Password should have atleast 1 Upper case**");
            $("#pwd_error_message").show();
            error_password = true;
          }
      
          var num = false;
          for (var i = 0; i < password.length; i++)
            if ((password[i] >= '0' && password[i] <= '9')) {
              num = true;
              break;
            }
          if (!num) {
            $("#pwd_error_message").html("**Password should have atleast 1 numeric case**");
            $("#pwd_error_message").show();
            error_password = true;
          }
      
      
          var spec = false;
          for (var i = 0; i < password.length; i++)
            if (!(password[i] >= 'A' && password[i] <= 'Z') && !(password[i] >= 'a' && password[i] <= 'z') && !(password[i] >= '0' && password[i] <= '9')) {
                spec = true;
              break;
            }
          if (!spec) {
            $("#pwd_error_message").html("**Password should have atleast 1 Special case**");
            $("#pwd_error_message").show();
            error_password = true;
          }
          var pwdlen = true;
          if (password.length < 7 || password.length > 15) {
              $("#pwd_error_message").html("**Password length should be atleast 7 and atmost 15**");
              $("#pwd_error_message").show();
              error_password = true;
              pwdlen = false;
            }

          if(pwdlen && num && spec && cap)
          {
            $("#pwd_error_message").hide();
            error_password = false;
          }

    }

    $(".food").change(function () {

        validateFood();

    });

    function validateFood() {
        check_username();
        if (error_username) {
            $("#username_error_message").html("**Please fill Username details**");
            $("#username_error_message").show();
        }

        check_password();

        if (error_password) {
            $("#pwd_error_message").html("**Please fill password details**");
            $("#pwd_error_message").show();
        }

        //var checfood = false;
        var food = $(".food:checked");
        // for (var i = 0; i < food.length; i++) {
        //         if(food[i].checked )
        //         {
        //             checfood = true;
        //             break;
        //         }
        // }
        //if(food!=null)
        //checfood = true;
        if (food.length == 0) {
            $("#food_error_message").html("**Please choose your favourite food**");
            $("#food_error_message").show();
            error_food = true;
        }
        else {
            $("#food_error_message").hide();
            error_food = false;
        }
    }

    $(".hobby").change(function () {

        validateHobby();

    });

    function validateHobby() {

        check_username();
        if (error_username) {
            $("#username_error_message").html("**Please fill Username details**");
            $("#username_error_message").show();
        }

        check_password();

        if (error_password) {
            $("#pwd_error_message").html("**Please fill password details**");
            $("#pwd_error_message").show();
        }
        validateFood();

        if (error_food) {
            $("#food_error_message").html("**Please choose your favourite food**");
            $("#food_error_message").show();
        }
        var hobby = $(".hobby:checked");

        var noOfhobbies = hobby.length;

        //var noOfhobbies = 0;
        // for (var i = 0; i < hobby.length; i++) {
        //     if(hobby[i].checked)
        // 	    noOfhobbies++;
        //     }

        if (noOfhobbies < 2) {
            error_hobby = true;
            $("#hobby_error_message").html("**Please choose atleast 2 hobbies**");
            $("#hobby_error_message").show();

        }
        else {
            $("#hobby_error_message").hide();
            error_hobby = false;
        }

    }

    $('#button1').click(function () {
        check_username();
        if (error_username) {
            $("#username_error_message").html("**Please fill Username details**");
            $("#username_error_message").show();
        }

        check_password();

        if (error_password) {
            $("#pwd_error_message").html("**Please fill password details**");
            $("#pwd_error_message").show();
        }
        validateFood();

        if (error_food) {
            $("#food_error_message").html("**Please choose your favourite food**");
            $("#food_error_message").show();
        }

        validateHobby();

        if(error_hobby)
        {
            $("#hobby_error_message").html("**Please choose atleast 2 hobbies**");
            $("#hobby_error_message").show();
        }

        if(!error_username && !error_password && !error_food && !error_hobby)
            alert("SuccessFully Submitted!!")
    });

});