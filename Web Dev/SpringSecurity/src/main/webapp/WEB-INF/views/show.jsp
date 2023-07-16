<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta http-equiv="x-ua-compatible" content="ie=edge">
    <title>MDB5</title>

    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

    <!-- MDB icon -->
    <link rel="icon" href="img/mdb-favicon.ico" type="image/x-icon">
    <!-- Font Awesome -->
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.11.2/css/all.css">
    <!-- Google Fonts Roboto -->
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700&display=swap">
    <!-- Bootstrap core CSS -->
    <link rel="stylesheet" href="/css/bootstrap.min.css">
    <!-- Material Design Bootstrap -->
    <link rel="stylesheet" href="/css/mdb.min.css">
    <!-- Your custom styles (optional) -->
    <link rel="stylesheet" href="/css/style.css">
    <style>

  /* Required for full background image */

  html,
  body,
  header,
  .view {
    height: 100%;
  }

  @media (max-width: 740px) {
    html,
    body,
    header,
    .view {
      height: 100vh;
    }
  }

  .top-nav-collapse {
    background-color: #78909c !important;
  }

  .navbar:not(.top-nav-collapse) {
    background: transparent !important;
  }

  @media (max-width: 991px) {
    .navbar:not(.top-nav-collapse) {
      background: #78909c !important;
    }
  }

  h1 {
    letter-spacing: 8px;
  }

  h5 {
    letter-spacing: 3px;
  }

  .hr-light {
    border-top: 3px solid #fff;
    width: 80px;
  }
  </style>
    
</head>

<body>
	
	  <!-- Main navigation -->
	  <header>
		<!--Navbar-->
		<nav class="navbar navbar-expand-lg navbar-dark fixed-top scrolling-navbar">
		  <div class="container">
			<a class="navbar-brand" href="#"><strong>SECURITY</strong></a>
			<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent-7" aria-controls="navbarSupportedContent-7" aria-expanded="false" aria-label="Toggle navigation">
			  <span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarSupportedContent-7">
			  <ul class="navbar-nav mr-auto">
				<li class="nav-item active">
				  <a class="nav-link" href="/secure/">Home <span class="sr-only">(current)</span></a>
				</li>
				<li class="nav-item">
				  <a class="nav-link" href="/secure/user">User</a>
				</li>
				<li class="nav-item">
				  <a class="nav-link" href="/secure/admin">Admin</a>
        </li>
        <li class="nav-item">
				  <a class="nav-link" href="/secure/guest">Guest</a>
        </li>
        </ul>
        <ul>
          <li class="nav-item">
            <a class="nav-link" href="/login?logout=true">Logout</a>
          </li>
        </ul>
			
			</div>
		  </div>
		</nav>
		<!-- Navbar -->
		<!-- Full Page Intro -->
		<div class="view jarallax" data-jarallax='{"speed": 0.2}' style="background-image: url('https://mdbootstrap.com/img/Photos/Others/img%20%2848%29.jpg'); background-repeat: no-repeat; background-size: cover; background-position: center center;">
		  <!-- Mask & flexbox options-->
		  <div class="mask rgba-black-light d-flex justify-content-center align-items-center">
			<!-- Content -->
			<div class="container">
			  <!--Grid row-->
			  <div class="row">
				<!--Grid column-->
				<div class="col-md-12 mb-4 white-text text-center">
				  <h1 class="h1-reponsive white-text text-uppercase font-weight-bold mb-0 pt-md-5 pt-5 wow fadeInDown" data-wow-delay="0.3s"><strong>Spring Security Intro</strong></h1>
				  <hr class="hr-light my-4 wow fadeInDown" data-wow-delay="0.4s">
				  <h5 class="text-uppercase mb-4 white-text wow fadeInDown" data-wow-delay="0.4s"><strong>Welcome</strong></h5>
				  
				</div>
				<!--Grid column-->
			  </div>
			  <!--Grid row-->
			</div>
			<!-- Content -->
		  </div>
		  <!-- Mask & flexbox options-->
		</div>
		<!-- Full Page Intro -->
	  </header>
	  <!-- Main navigation -->

    <!-- jQuery -->
    <script type="text/javascript" src="/js/jquery.min.js"></script>
    <!-- Bootstrap tooltips -->
    <script type="text/javascript" src="/js/popper.min.js"></script>
    <!-- Bootstrap core JavaScript -->
    <script type="text/javascript" src="/js/bootstrap.min.js"></script>
    <!-- MDB core JavaScript -->
    <script type="text/javascript" src="/js/mdb.min.js"></script>
    <!-- Your custom scripts (optional) -->
    <script type="text/javascript">
		//new WOW().init();
    </script>

</body>

</html>