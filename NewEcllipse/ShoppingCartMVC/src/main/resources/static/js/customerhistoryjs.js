$(document).ready(function () {

    				// customer history start

                    $('#customerhistorylink').click(function () {

                        $("#productform").hide();
                        $("#categorycard").hide();
                        $("#customercard").hide();
                        $("#ordercard").hide();
                        $("#customerhistorycard").show();
                        $.ajax({
                            type: 'GET',
                            //url: '${pageContext.request.contextPath }/getCustomers',
							url : "http://localhost:8080/"+ "getCustomers",
                            success: function (result) {
    
                                var customersInfo = '<option value="" disabled="" selected="">Choose Customer</option>';
                                for (var i = 0; i < result.length; i++) {
                                    customersInfo += '<option value =' + result[i].id + '>' + result[i].name + '</option>';
                                }
                                $('#customerDropdown1').html(customersInfo);
    
                            }
                        });
    
    
                        $("#customerDropdown1").change(function () {
    
                            generateCustomerTable();
                            generateOrderTable();
    
                        });
    
                        function generateCustomerTable() {
    
    
                            var customerId = $("#customerDropdown1 option:selected").val();
    
                            $.ajax({
                                type: 'GET',
                                //url: '${pageContext.request.contextPath }/getCustomer/' + customerId,
								url : "http://localhost:8080/"+ "getCustomer/"+customerId,
                                success: function (customer) {
    
                                    var customertableInfo = '';
    
                                    customertableInfo += '<thead>' +
                                        '<tr>' +
                                        '<th scope="col">Id</th>' +
                                        '<th scope="col">Name</th>' +
                                        '<th scope="col">Gender</th>' +
                                        '<th scope="col">Address</th>' +
                                        '<th scope="col">Hobbies</th>' +
                                        '</tr>' +
                                        '</thead>' +
                                        '<tbody>';
                                    customertableInfo += '<tr>' + '<th scope="row">' + customer.id + ' </th>';
                                    customertableInfo += '<td>' + customer.name + '</td>';
                                    customertableInfo += '<td>' + customer.gender + '</td>';
                                    customertableInfo += '<td>' + customer.address + '</td>';
                                    customertableInfo += '<td>' + customer.hobbyList + '</td></tr>';
                                    /* for(var h=0;h<customer.hobbyList.length;h++)
                                    {
                                        customertableInfo += '<tr><td>' + customer.hobbyList[h] + '</tr></td>';
                                    }
                                    customertableInfo += '</td></tr>'; */
                                    customertableInfo += '</tbody>';
                                    $("#customerInfotable").html(customertableInfo);
                                    $("#customerInfotable").show();
                                }
                            });
    
                        }
    
    
    
                        function generateOrderTable() {
    
    
                            var customerId = $("#customerDropdown1 option:selected").val();
    
                            $.ajax({
                                type: 'GET',
                                //url: '${pageContext.request.contextPath }/getCustomerOrders/' + customerId,
								url : "http://localhost:8080/"+ "getCustomerOrders/"+customerId,
                                success: function (orders) {
    
                                    var ordertableInfo = '';
    
                                    ordertableInfo += '<thead>' +
                                        '<tr>' +
                                        '<th scope="col">OrderId</th>' +
                                        '<th scope="col">Products</th>' +
                                        '<th scope="col">OrderCost</th>' +
										'<th scope="col">DateOfOrder</th>' +
                                        '</tr>' +
                                        '</thead>' +
                                        '<tbody>';
                                    for (var i = 0; i < orders.length; i++) {
                                        ordertableInfo += '<tr>' + '<th scope="row">' + orders[i].id + ' </th>';
                                        //ordertableInfo += '<td>' +orders[i].productList + '</td>';
                                        //ordertableInfo += '<td>' +orders[i].ordercost + '</td></tr>';
                                        ordertableInfo += '<td>';
                                        for (var h = 0; h < orders[i].productList.length; h++) {
                                            ordertableInfo += orders[i].productList[h].name + ' : ' + 'Rs.' + orders[i].productList[h].price + '<br> <img src=' + "/uploads/" + orders[i].productList[h].image + ' width="100" height="100" />' + '<br>';
                                        }
                                        ordertableInfo += '</td>';
                                        //ordertableInfo += '<td>' +orders[i].productList + '</td>';
                                        ordertableInfo += '<td>' + orders[i].ordercost + '</td>';
										 ordertableInfo += '<td>' + orders[i].orderDate + '</td></tr>';
                                    }
    
                                    ordertableInfo += '</tbody>';
                                    $("#ordertable").html(ordertableInfo);
                                    $("#ordertable").show();
                                }
                            });
    
                        }
    
    
    
    
                    });
                    // customer history end
});