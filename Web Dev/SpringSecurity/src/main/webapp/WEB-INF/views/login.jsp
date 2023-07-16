<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<body onload='document.loginForm.username.focus();'>
    <h1>Spring Security 5 - Login Form</h1>
 
    <c:if test="${not empty errorMessge}"><div style="color:red; font-weight: bold; margin: 30px 0px;">${errorMessge}</div></c:if>
 
    <form name='login' action="/login" method='POST'>
        <table>
            <tr>
                <td>UserName:</td>
                <td><input type='text' name='username' value=''></td>
            </tr>
            <tr>
                <td>Password:</td>
                <td><input type='password' name='password' /></td>
            </tr>
            <tr>
                <td colspan='2'><input name="submit" type="submit" value="submit" /></td>
            </tr>
        </table>
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
    </form>
    
    <form name='registeruser' action="/registeruser" method='POST'>
        <table>
            <tr>
                <td>UserName:</td>
                <td><input type='text' name='name' value=''></td>
            </tr>
            <tr>
                <td>Password:</td>
                <td><input type='password' name='password' /></td>
            </tr>
            <tr>
            	<td>Role</td>
            </tr>
            <tr>
            	<td>
            		<input type="checkbox"  name="roles" value="ADMIN"> Admin <br>
            		<input type="checkbox"  name="roles" value="USER"> User <br>
            		<input type="checkbox"  name="roles" value="GUEST"> Guest
            	</td>
            	
            </tr>
            <tr>
                <td colspan='2'><input name="submit" type="submit" value="submit" /></td>
            </tr>
        </table>
        
    </form>
    
</body>
</html>