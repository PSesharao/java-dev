$('document').ready(function () {    // ready function work after loading                                                  
  $('#button1').click(function () {   // alternative is you can write script after html 
    var username = $('#username').val();
    var password = $('#password').val();
    //alert('Welcome ' + username);
    var validateUname = validateUserName(username);
    var validatePwd = validatePassword(password);
    if (validateUname && validatePwd) {
      alert("Success!! " + username);
    }
  });
  function validateUserName(userName) {
    if (userName.length < 8 || userName.length > 16) {
      alert("Username length should be atleast 8 and atmost 16 ");
      return false;
    }
    for (var i = 0; i < userName.length; i++) {
      if (!((userName[i] >= 'a' && userName[i] <= 'z') || (userName[i] >= 'A' && userName[i] <= 'Z') || (userName[i] >= '0' && userName[i] <= '9'))) {
        alert("Username should be alphanumeric ");
        return false;
      }
    }

    var exists = false;
    for (var i = 0; i < userName.length; i++)
      if ((userName[i] >= '0' && userName[i] <= '9')) {
        exists = true;
        break;
      }
    if (!exists) {
      alert("Username should have atleast one numeric character");
      return false;
    }

    exists = false;
    for (var i = 0; i < userName.length; i++)
      if ((userName[i] >= 'a' && userName[i] <= 'z') || (userName[i] >= 'A' && userName[i] <= 'Z')) {
        exists = true;
        break;
      }
    if (!exists) {
      alert("Username should have atleast one alpha character");
      return false;
    }

    return true;
  }

  function validatePassword(password) {
    if (password.length < 7 || password.length > 15) {
      alert("Password length should be atleast 7 and atmost 15 ");
      return false;
    }

    var exists = false;
    for (var i = 0; i < password.length; i++)
      if (password[i] >= 'A' && password[i] <= 'Z') {
        exists = true;
        break;
      }
    if (!exists) {
      alert("Password should have atleast 1 Upper case");
      return false;
    }

    exists = false;
    for (var i = 0; i < password.length; i++)
      if ((password[i] >= '0' && password[i] <= '9')) {
        exists = true;
        break;
      }
    if (!exists) {
      alert("Password should have atleast 1 numeric case");
      return false;
    }


    exists = false;
    for (var i = 0; i < password.length; i++)
      if (!(password[i] >= 'A' && password[i] <= 'Z') && !(password[i] >= 'a' && password[i] <= 'z') && !(password[i] >= '0' && password[i] <= '9')) {
        exists = true;
        break;
      }
    if (!exists) {
      alert("Password should have atleast 1 Special case");
      return false;
    }
    return true;

  }
});
