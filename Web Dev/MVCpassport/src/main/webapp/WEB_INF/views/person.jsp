<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!doctype html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
     <!-- Optional JavaScript; choose one of the two! -->

    <!-- Option 1: jQuery and Bootstrap Bundle (includes Popper) -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx" crossorigin="anonymous"></script>

    <!-- Option 2: jQuery, Popper.js, and Bootstrap JS
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.min.js" integrity="sha384-w1Q4orYjBQndcko6MimVbzY0tgp4pWB4lZ7lr30WKz0vr/aWKhXdBNmNb5D92v7s" crossorigin="anonymous"></script>
    -->
	 <style>
      .container
      {
          background-color: rgb(248, 244, 240);
      }
    </style>
    <title>Person</title>
  </head>
  <body>
        <div class="container" >
             <div class="form">
              <form action="/addperson" >
                  <table align = "center", width = "50%"  cellpadding = "20%" class="table table-hover table-striped">

              <tr>
                <td> 
                  <b>Person Name :</b>
                </td>
                  
                <td>
                    <input type="text" name="name" id="name">
                </td>
              </tr>
              <tr>
              
              <tr>
                <td> 
                  <b>Age :</b>
                </td>
                  
                <td>
                    <input type="text" name="age" id="age">
                </td>
              </tr>
              <tr>
              
                <td> 
                  <b>Person Gender :</b>
                </td>
                  
                <td>
                    <input type="radio" name="gender" value="male"> Male <br>
                    <input type="radio" name="gender" value="female"> Female
                </td>
              </tr>
              <tr>
                <td>
                  
                </td>
                <td>
                  <input type="submit" value="Submit" >
                </td>
              </tr>
            </table>
              </form>
            </div>
        </div>

  </body>
</html>