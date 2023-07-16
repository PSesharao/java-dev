<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta http-equiv="x-ua-compatible" content="ie=edge">
  <title>Access Denied</title>
  <!-- Font Awesome -->
  <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.2/css/all.css">
  <!-- Bootstrap core CSS -->
  <link rel="stylesheet" href="../../css/bootstrap.min.css">
  <!-- Material Design Bootstrap -->
  <link rel="stylesheet" href="../../css/mdb.min.css">

  <!-- Your custom styles (optional) -->
  <style>
     
.navbar {
	z-index: 1;
}

.view {
  width: 100%;
	height: 100%;
}
h2 {
    text-align: center;
}
  </style>
</head>

<body class="fixed-sn white-skin">
  <div class="view jarallax" data-jarallax='{"speed": 0.2}'
  style="background-image: url('https://autopilothq.com/uploads/2017/03/20170329-shopping-1-large.png'); background-repeat: no-repeat; background-size: cover; background-position: center center;">
  <!-- Main Navigation -->
  <header>

    <!-- Navbar -->
    <nav class="navbar fixed-top navbar-expand-lg navbar-dark indigo">
			<a class="navbar-brand" href="#"><strong>Shopping Mall</strong></a>
			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav mr-auto">
					<li class="nav-item "><a class="nav-link" href="/home"
            id="homelink">Home </a></li>
          <li class="nav-item"><a class="nav-link" href="/category"
              id="playerlink">Add Category</a></li>
					<li class="nav-item"><a class="nav-link" href="/product"
						id="teamlink">Add Product</a></li>
					<li class="nav-item"><a class="nav-link" href="/shop"
						id="showlink">Shop Now</a></li>
					<li class="nav-item"><a class="nav-link" href="/myorders"
							id="showlink">My Orders</a></li>
				</ul>
			</div>
		</nav>
    <!-- Navbar -->

  </header>
  <!-- Main Navigation -->

  <!-- Main layout -->
  <main>

    		<h2 class="text-danger"><strong>${msg}</strong></h2>
        
      <!-- Section: Team v.1 -->
      <section class="section team-section">

        <!-- Grid row -->
        <div class="row text-center">

          <!-- Grid column -->
          <div class="col-md-8 mb-4"> 

          </div>
          <!-- Grid column -->

          <!-- Grid column -->
          <div class="col-md-4 mb-4">

            <!-- Card -->
            <div class="card profile-card">

              <!-- Avatar -->
              <div class="avatar z-depth-1-half mb-4">
                <img src="/uploads/${image}" class="rounded-circle" alt="First sample avatar image">
              </div>

              <div class="card-body pt-0 mt-0">

                <!-- Name -->
                <h3 class="mb-3 font-weight-bold"><strong>${name}</strong></h3>
                <h6 class="font-weight-bold cyan-text mb-4">${email}</h6>

                <p class="mt-4 text-muted">
                	${address}
                </p>

               <!--  <form action="/login?logout=true" method='POST'>
									<div class="text-center form-sm mt-2">
										<button type="submit" class="btn btn-info">
											Log Out <i class="fas fa-sign-in-alt ml-1"></i>
										</button>
									</div>
				</form> -->
                <a href="/login?logout=true" class="btn btn-info btn-rounded" ><i class="fas fa-sign-in-alt ml-1"></i> Logout </a>
              </div>

            </div>
            <!-- Card -->

          </div>
          <!-- Grid column -->

        </div>
        <!-- Grid row -->

      </section>
      <!-- Section: Team v.1 -->
  </main>
  <!-- Main layout -->


  <!-- SCRIPTS -->
  <!-- JQuery -->
  <script src="../../js/jquery-3.4.1.min.js"></script>
  <!-- Bootstrap tooltips -->
  <script type="text/javascript" src="../../js/popper.min.js"></script>
  <!-- Bootstrap core JavaScript -->
  <script type="text/javascript" src="../../js/bootstrap.js"></script>
  <!-- MDB core JavaScript -->
  <script type="text/javascript" src="../../js/mdb.min.js"></script>
  <!-- Custom scripts -->
  <script>
    $(document).ready(function(){
         // SideNav Initialization
    $(".button-collapse").sideNav();
    
  
 
    
    });
   

  </script>
  </div>
</body>

</html>
