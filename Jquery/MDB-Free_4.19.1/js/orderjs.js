$(document).ready(function () {
    				// order card begin

                    $('#placeorderlink').click(function () {
                        $("#customerhistorycard").hide();
                        $("#productform").hide();
                        $("#categorycard").hide();
                        $("#customercard").hide();
                        $("#ordercard").show();
    
                        $("#customer_error_message").hide();
    
    
    
                        var error_customer = false;
    
                        $.ajax({
                            type: 'GET',
                            url: '${pageContext.request.contextPath }/getCustomers',
                            success: function (result) {
    
                                var customersInfo = '<option value="" disabled="" selected="">Choose Customer</option>';
                                for (var i = 0; i < result.length; i++) {
                                    customersInfo += '<option value =' + result[i].id + '>' + result[i].name + '</option>';
                                }
                                $('#customerDropdown').html(customersInfo);
    
                            }
                        });
    
                        $.ajax({
                            type: 'GET',
                            url: '${pageContext.request.contextPath }/getCategories',
                            success: function (result) {
    
                                var categoryInfo = '<option value="" disabled="" selected="">Choose Category</option>';
                                for (var i = 0; i < result.length; i++) {
                                    categoryInfo += '<option value =' + result[i].name + '>' + result[i].name + '</option>';
                                }
                                $('#catageoryDropdown1').html(categoryInfo);
    
                            }
                        });
    
    
                        $("#catageoryDropdown1").change(function () {
    
                            generateTable();
    
                        });
    
                        function generateTable() {
    
    
                            var catagoryName = $("#catageoryDropdown1 option:selected").val();
    
                            $.ajax({
                                type: 'GET',
                                url: '${pageContext.request.contextPath }/getProducts/' + catagoryName,
                                success: function (products) {
    
                                    var producttableInfo = '';
    
                                    producttableInfo += '<thead>' +
                                        '<tr>' +
                                        '<th scope="col">Id</th>' +
                                        '<th scope="col">Name</th>' +
                                        '<th scope="col">Price</th>' +
                                        '<th scope="col">Image</th>' +
                                        '<th scope="col">Choose</th>' +
                                        '</tr>' +
                                        '</thead>' +
                                        '<tbody>';
    
                                    for (var i = 0; i < products.length; i++) {
    
    
                                        producttableInfo += '<tr>' + '<th scope="row">' + products[i].id + ' </th>';
                                        producttableInfo += '<td>' + products[i].name + '</td>';
                                        producttableInfo += '<td>' + products[i].price + '</td>';
                                        //producttableInfo += '<td>' + players[i].skill +'</td>';
    
                                        producttableInfo += '<td><img src=' + "/uploads/" + products[i].image + ' width="100" height="100" /> </td>';
                                        producttableInfo += '<td>' + '<input type ="checkbox" class = "productList" name="productList"  value="' + products[i].id + '" >' + '</td>';
    
    
    
                                        //producttableInfo += '<td>' +'<input type ="radio" class = "playerId" name="playerId"  value="'+players[i].id+'" >'+'<button type="submit"  class="btn btn-primary">Update</button>'+'</td>'+'</tr>';                	  
                                        //playertableInfo += '<td>' +'<button type="submit"  value="'+players[i].id+'" name="playerId"  class="btn btn-primary playerId">Update</button>'+'</td>'+'</tr>'; 
                                    }
                                    producttableInfo += '</tbody>';
                                    $("#producttable").html(producttableInfo);
                                    $("#producttable").show();
    
                                }
                            });
    
                        }
    
                        cartList = [];
                        $("#addToCart").click(function (){
    
                            var cartCategeory = [];
                            //$.each($("input[name='productList']:checked"), function () {
                            $.each($(".productList:checked"), function () {
                                cartCategeory.push($(this).val());
                            });
                            cartList = cartList.concat(cartCategeory); 
                            console.log(cartList);
    
                        });
    
    
                        $("#orderform").submit(function (event) {
                            event.preventDefault();
                            $('#submitOrder').val(cartList);
                            console.log($('#submitOrder').val());
                            var form = $('#orderform')[0];
    
                            var orderData = new FormData(form);
                            
    
                            
                                                    $.ajax({
                                                        type: "POST",
                                                        enctype: 'multipart/form-data',
                                                        //contentType: "application/json",
                                                        url: '${pageContext.request.contextPath}/placeOrder',
                                                        //data: JSON.stringify(productData),
                                                        data: orderData,
                                                        //dataType: 'json',
                                                        processData: false,
                                                        contentType: false,
                                                        cache: false,
                                                        success: function (result) {
                                                            $("#postOrder").html("<p style='background-color: #79c276; color:white; padding:20px 20px 20px 20px'>" +
                                                                "Post Successfully! <br>" +
                                                                "---> Orders's Info: OrderId = " +
                                                                result.id + "</p>");
                            
                                                        }
                                                        ,
                                                        error: function (e) {
                                                            alert("Error!")
                                                            console.log("ERROR: ", e);
                                                        }
                                                    }); 
    
    
                        });
    
    
    
                    });
    
                    // order card end 
});