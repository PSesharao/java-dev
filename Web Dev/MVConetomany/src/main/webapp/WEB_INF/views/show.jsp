<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!doctype html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
    
    <style>
        .container {
            background-color: rgb(248, 244, 240);
        }

        .jumbotron {
            background-color: rgb(248, 244, 240);
            text-align: center;
        }
    </style>

    <title>show</title>
</head>

<body>
    <div class="container">
        <div class="jumbotron">
            <div class="form">
                <form action="/showstudent">
                    <table align="center" , width="50%" cellpadding="20%">
                        <tr>
                            <td><b>Select Department :<b></td>
                            <td>
                                <select class="mdb-select md-form" searchable="Search here.." name="deptId" id="deptId">
                                    <option value="" disabled selected>Choose Department</option>
                                    <c:forEach var="department" items="${departmentList}">
                                        <option value="${department.id}"> ${department.getName()}
                                        </option>
                                    </c:forEach>
                                </select>

                            </td>
                        </tr>
                        <tr>
                            <td>
    
                            </td>
                            <td>
                            	<!-- <input type="submit" value="Submit"> -->
                                <button type="submit" class="btn btn-primary" id="button1">Check</button> <br><br>
                            </td>
                        </tr>
                    </table>
                </form>
            </div>
            
            <div id="stdtable">
            <form action="/updatestudent">
             <table align="center" , width="50%" cellpadding="20%" class="table table-striped" >
                <tr>
                    <th>RollNumber</th>
                    <th>Name</th>
                    <th>Age</th>
                    <th>Gender</th>
                    <th>Hobbies</th>
               </tr>
            <c:forEach var="student" items="${students}">
                <tr>
                    <td> ${student.id}</td>
                    <td> ${student.name}</td>
                    <td> ${student.age} </td>
                    <td> ${student.gender}  </td>
                    <td> <c:forEach var="hobby" items="${student.hobbies}"> ${hobby} <br> </c:forEach> </td>
                    <td> <button type="submit" name="studId" id="studId" value="${student.id}" class="btn btn-primary" >Update</button> </td>
               </tr>   
            </c:forEach>
            </table>
            </form>
            </div>
            <div>
               <p>
				   <a href="/home" class="btn btn-primary btn-lg" >Home</a>
			   </p>
            </div>
        </div>
    </div>
</body>

</html>