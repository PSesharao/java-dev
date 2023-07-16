var addToDoButton = document.getElementById('addToDo');
var toDoContainer = document.getElementById('toDoContainer');
var inputField = document.getElementById('inputField');
var listItems = document.createElement('ul');
addToDoButton.addEventListener('click', function(){
   
    var li = document.createElement("li");
    var inputValue = inputField.value;
    console.log(inputValue)
    var t = document.createTextNode(inputValue);
    li.appendChild(t);
    listItems.appendChild(li);
    toDoContainer.appendChild(listItems);
    inputField.value = "";
    li.addEventListener('click' , function()
    {
      li.style.textDecoration = "line-through";
    })

     //var paragraph = document.createElement('p');
     //paragraph.classList.add('paragraph-styling');
     // paragraph.innerText = inputField.value;
    //toDoContainer.appendChild(paragraph);
    //  paragraph.addEventListener('click', function(){
    //      paragraph.style.textDecoration = "line-through";
    //  })
    //  paragraph.addEventListener('dblclick', function(){
    //      toDoContainer.removeChild(paragraph);
    // })

    li.addEventListener('dblclick' , function()
    {
      listItems.removeChild(li);
    })
})

