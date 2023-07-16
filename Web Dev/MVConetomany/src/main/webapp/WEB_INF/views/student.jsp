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
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
        integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
    <!-- Optional JavaScript; choose one of the two! -->

    <!-- Option 1: jQuery and Bootstrap Bundle (includes Popper) -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
        integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
        crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx"
        crossorigin="anonymous"></script>

    <!-- Option 2: jQuery, Popper.js, and Bootstrap JS
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.min.js" integrity="sha384-w1Q4orYjBQndcko6MimVbzY0tgp4pWB4lZ7lr30WKz0vr/aWKhXdBNmNb5D92v7s" crossorigin="anonymous"></script>
    -->
    
    <script type="text/javascript" src="/resources/js/inlineval.js">
			
  	</script>
    <style>
        .container {
            background-color: rgb(248, 244, 240);
        }
        
        span {
      color: #FF0052;
    }
    
    
    </style>

    <title>Student</title>
</head>

<body>
    <div class="container">
        <div class="form" >
            <form  action="/addstudent">
                <table align="center" , width="50%" cellpadding="20%" class ="table-hover ">

                    <tr>
                        <td>
                            <b>Student Name :</b>
                        </td>

                        <td>
                            <input type="text" name="name" id="name">
                        </td>
                        
                        <td>
                <span id="username_error_message"> </span>
                       </td>
                    </tr>
                    <tr>
                        <td>
                            <b>Age :</b>
                        </td>

                        <td>
                            <input type="text" name="age" id="age" >
                        </td>
                        
                            <td>
                <span id="age_error_message"> </span>
                           </td>
                       
                    </tr>
                    <tr>

                        <td>
                            <b>Gender :</b>
                        </td>

                        <td>
                            <input type="radio" name="gender" value="male" class= "gender"> Male <br>
                            <input type="radio" name="gender" value="female" class = "gender"> Female
                        </td>
                        
                         <td>
                <span id="gender_error_message"> </span>
                           </td>
                           
                    </tr>
                    <tr>
                        <td>
                          <b>Hobbies:</b>
                        </td>
          
                        <td>
                          <input type="checkbox" class="hobbies" name="hobbies" value="cricket"> Cricket <br>
                          <input type="checkbox" class="hobbies" name="hobbies" value="book"> Book Reading <br>
                          <input type="checkbox" class="hobbies" name="hobbies" value="music"> Music <br>
                          <input type="checkbox" class="hobbies" name="hobbies" value="chess"> Chess <br>
                          <input type="checkbox" class="hobbies" name="hobbies" value="carroms"> Carroms <br>
                        </td>
                         <td>
                <span id="hobby_error_message"> </span>
                           </td>
                    </tr>
                    <tr>
                        <td><b>Select Department :<b></td>
                        <td>
                            <select class="mdb-select md-form" searchable="Search here.." name="deptId" id = "deptId">
                                <option  value="" disabled selected>Choose Department</option>
                                <c:forEach var="department" items="${departmentList}">
                                    <option value="${department.id}"> ${department.getName()}
                                    </option>
                                </c:forEach>
                            </select>

                        </td>
                         <td>
                <span id="dept_error_message"> </span>
                           </td>
                    </tr>
                    
                    <tr>
                        <td>

                        </td>
                        <td>
                            <input type="button" value="Validate" id="button1">
                        </td>
                        <td>
                        <div id="validate_error_message"> </div>
                        </td>
                    </tr>
                    <tr>
                    	<td>

                        </td>
                        <td>
							  <div  id="subbutton">
							  
							  </div>
                        </td>
                    </tr>
                </table>
            </form>
        </div>
    </div>

</body>

</html>