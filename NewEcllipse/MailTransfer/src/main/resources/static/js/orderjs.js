$(document).ready(function () {
    				// order card begin

                    $('#placeorderlink').click(function () {
                        $("#customerhistorycard").hide();
                        $("#productform").hide();
                        $("#categorycard").hide();
                        $("#customercard").hide();
                        $("#ordercard").show();
						$("#postOrder").hide();
    					$("#cart_error_message").hide();
						$("#order_error_message").hide();
                        $("#customer_error_message").hide();
    					$("#date_error_message").hide();
    
    					
                        var error_customer = false;
						
						var error_date = false;
						
						$("#customerDropdown").change(function () {
						
						validateCustomer();

					    });
	
						function validateCustomer()
						{
							var customer = $("#customerDropdown option:selected").val();
							if(customer=="")
							{
								$("#customer_error_message").html("Please Select The Customer");
								$("#customer_error_message").show();
								error_customer = true;
							}
							else
								{
								$("#customer_error_message").hide();
								error_customer = false;
								}
						}
						
						
						$("#orderDate").change(function () {
						
						validateDate();

					    });
	
						function validateDate()
						{
							var date = $("#orderDate").val();
							//console.log(date.length);
							if(date.length==0)
							{
								$("#date_error_message").html("Please Select The Date");
								$("#date_error_message").show();
								error_date = true;
							}
							else
								{
								$("#date_error_message").hide();
								error_date = false;
								}
						}
    
                        $.ajax({
                            type: 'GET',
                            //url: '${pageContext.request.contextPath }/getCustomers',
							url : "http://localhost:8080/"+ "getCustomers",
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
                           // url: '${pageContext.request.contextPath }/getCategories',
							url : "http://localhost:8080/"+ "getCategories" ,
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
                                //url: '${pageContext.request.contextPath }/getProducts/' + catagoryName,
								url : "http://localhost:8080/"+ "getProducts/" +catagoryName,
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
    						if($(".productList:checked").length==0)
							{
								$("#cart_error_message").html("Please add atleast one product from category to cart ");
								$("#cart_error_message").show();
								return false;
							}
							else
								$("#cart_error_message").hide();
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
							validateCustomer();
							if(error_customer)
							{
								$("#customer_error_message").html("Please Select The Customer");
								$("#customer_error_message").show();
								return false;
							}
							else
							
								$("#customer_error_message").hide();
							
							validateDate();
							if(error_date)
							{
								$("#date_error_message").html("Please Select The Date");
								$("#date_error_message").show();
								return false;
							}
							else
								$("#date_error_message").hide();
							
							if(cartList.length==0)
							{
								$("#order_error_message").html("The Cart List is empty.");
								$("#order_error_message").show();
								return false;
							}
							else
							$("#order_error_message").hide();
                            $('#submitOrder').val(cartList);
                            console.log($('#submitOrder').val());
							
                            var form = $('#orderform')[0];
    
                            var orderData = new FormData(form);
                            
    
                            
                                                    $.ajax({
                                                        type: "POST",
                                                        enctype: 'multipart/form-data',
                                                        //contentType: "application/json",
                                                        //url: '${pageContext.request.contextPath}/placeOrder',
														url : "http://localhost:8080/"+ "placeOrder" ,
                                                        //data: JSON.stringify(productData),
                                                        data: orderData,
                                                        //dataType: 'json',
                                                        processData: false,
                                                        contentType: false,
                                                        cache: false,
                                                        success: function (result) {
                                         /*                   $("#postOrder").html("<p>" +
                                                                "Post Successfully! <br>" +
                                                                "---> Orders's Info: OrderId = " +
                                                                result.id + "</p>");*/
															var orderDetails = '';
															orderDetails+= "<p>";
															orderDetails+= "Post Successfully! <br>";
															orderDetails+= "---> Orders's Info: OrderId = ";
															orderDetails+= result.id+'<br>';
															orderDetails+= "OrderDate = ";
															orderDetails+= result.orderDate+'<br>';
															orderDetails+= '<br> Products Ordered : <br>';
															
															for(var i=0 ;i < result.productList.length;i++)
															{
																orderDetails+= result.productList[i].name + '   Rs' + result.productList[i].price+'/-<br>';
															}
															orderDetails+= '</p>';
															 $("#postOrder").html(orderDetails);
                            								$("#postOrder").show();
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