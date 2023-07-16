function validateForm() {
	var userName = document.forms["dataform"]["username"].value;
	var password = document.forms["dataform"]["password"].value;
	var food = document.forms["dataform"]["food"].value;
    var hobby = document.forms["dataform"]["hobby"].value;
	if (!validateUserName(userName)) {return false;}
	if (!validatePassword(password)) {return false;}
	if (!validateFood(food)) {return false;}
	if (!validateHobby(hobby)) {return false;}
	return true;
}
function validateUserName(userName)
{
	if(userName.length<8 || userName.length>16)
	{
		alert("Username length should be atleast 8 and atmost 16 ");
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
	if(password.length<7 || password.length>15)
	{
		alert("Password length should be atleast 7 and atmost 15 ");
			return false;
	}
	
	var exists = false ;
	for(var i=0 ; i<password.length;i++ )
		if(password[i]>='A' && password[i]<='Z')
		{
			exists = true;
			break;
		}
	if(!exists)
	{
		alert("Password should have atleast 1 Upper case");
			return false;
	}
	exists = false ;
	for(var i=0 ; i<password.length;i++ )
		if(!(password[i]>='A' && password[i]<='Z') && !(password[i]>='a' && password[i]<='z') && !(password[i]>='0' && password[i]<='9'))
		{
			exists = true;
			break;
		}
	if(!exists)
	{
		alert("Password should have atleast 1 Special case");
			return false;
	}
	return true;

}

function validateFood(food)
{
	for (var i = 0; i < food.length; i++) {
		if(food[i])
		 	return true;
	}
		alert("Please choose your favourite food ");
		return false;
	
}

function validateHobby(hobby)
{
	var noOfhobbies = 0;
	for (var i = 0; i < hobby.length; i++) {
		if(hobby[i])
			noOfhobbies++;
	}
	if(noOfhobbies<2)
	{
		alert("Please choose atleast 2 hobbies ");
		return false;
	}
	
    return true;
}