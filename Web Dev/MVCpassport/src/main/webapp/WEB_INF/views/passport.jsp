<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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

    <title>Passport</title>
  </head>
  <body>
        <div class="container" >
          <div class="form">
            <form action="/addpassport">
              <table align="center" , width="50%" cellpadding="20%">
                <tr>
                  <td><b>Passport Number :</b></td>
        
                  <td><input type="text" name="passNum" id="passNum"></td>
                </tr>
                <tr>
                  <td><b>Place of issue:</b></td>
        
                  <td><input type="text" name="issuedPlace" id="issuedPlace">
                  </td>
                </tr>
                
                <tr>
                  <td><b>Select Person :<b></td>
                  <td>
                    <select class="mdb-select md-form" searchable="Search here.." name="personId">
                      <option value="" disabled selected>Choose Name</option>
                      <c:forEach var="person" items="${personList}">
                            <option value = "${person.id}" > ${person.getName()}
                            </option>
                      </c:forEach>
                    </select>
                        
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