function validateForm() {
	var userName = document.forms["regform"]["username"].value;
	var password = document.forms["regform"]["password"].value;
	if (!validateUserName(userName)) {return false;}
	if (!validatePassword(password)) {return false;}
	return true;
}
function validateUserName(userName)
{
	if(userName.length<8 )
	{
		alert("Username length should be atleast 8 ");
			return false;
	}
	for (var i = 0; i < userName.length; i++) {
		if(!((userName[i]>='a'&&userName[i]<='z')||(userName[i]>='A'&&userName[i]<='Z')))
		{
			alert("Username should be aplpanumeric ");
			return false;
		}
	}
	return true;
}
function validatePassword(password)
{
	if(password.length<8 )
	{
		alert("Password length should be atleast 8 ");
			return false;
	}
	
	var exists = false ;
	for(var i=0 ; i<password.length;i++ )
		if(password[i] == '!' || password[i] == '@' || password[i] == '#' || password[i] == '$' || password[i] == '%')
		{
			exists = true;
			break;
		}
	if(!exists)
	{
		alert("Password should have atleast 1 Special case among [!,@,#,$,%]");
			return false;
	}
	return true;

}