
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta http-equiv="x-ua-compatible" content="ie=edge">
  <title>Material Design Bootstrap</title>
  <!-- Font Awesome -->
  <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.2/css/all.css">
  <!-- Bootstrap core CSS -->
  <link rel="stylesheet" href="../../css/bootstrap.min.css">
  <!-- Material Design Bootstrap -->
  <link rel="stylesheet" href="../../css/mdb.min.css">
  <link rel="stylesheet" href="../../css/modules/animations-extended.min.css">

  <!-- Your custom styles (optional) -->
  <style>
    .navbar {
      z-index: 1;
    }

    .view {
      width: 100%;
      height: 100%;
    }
  </style>
</head>

<body class="fixed-sn white-skin">
  <div class="view jarallax" data-jarallax='{"speed": 0.2}'
    style="background-image: url('https://mdbootstrap.com/img/Photos/Others/img%20%2848%29.jpg'); background-repeat: no-repeat; background-size: cover; background-position: center center;">
    <!-- Main Navigation -->
    <header>

      <!-- Navbar -->
      <nav class="navbar fixed-top navbar-expand-lg navbar-dark indigo">
        <a class="navbar-brand" href="#"><strong>Player Auction
            Application</strong></a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
          aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
          <ul class="navbar-nav mr-auto">
            <li class="nav-item "><a class="nav-link" href="#home" id="homelink">Home </a></li>
            <li class="nav-item"><a class="nav-link" href="#teamform" id="teamlink">Add Team</a></li>
            <li class="nav-item"><a class="nav-link" href="#playerform" id="playerlink">Add Player</a></li>
            <li class="nav-item"><a class="nav-link" href="#showpage" id="showlink">Show</a></li>
          </ul>
        </div>
      </nav>
      <!-- Navbar -->

    </header>
    <!-- Main Navigation -->

    <!-- Main layout -->
    <main>

      <section class="section team-section">
        <div class="row text-center">
          <div class="col-md-12 mb-4">
            <!-- Card -->
            <div class="card card-cascade cascading-admin-card user-card">

              <!-- Card Data -->
              <div class="admin-up d-flex justify-content-start">
                <i class="fas fa-users info-color py-4 mr-3 z-depth-2"></i>
                <div class="data">
                  <h5 class="font-weight-bold dark-grey-text">Login- <span class="text-muted">Login
                      Customer</span>
                  </h5>
                </div>
              </div>
              <!-- Card Data -->
              <div class="card-body card-body-cascade">
                <c:if test="${not empty errorMessge}"><div style="color:red; font-weight: bold; margin: 30px 0px;">${errorMessge}</div></c:if>
                <form name='login' action="/login" method='POST'> 
                  <div class="md-form form-sm">
                   
                    <input type='text' name='username' value='' class="form-control form-control-sm">
                    <label for="form2">Your email</label>
                  </div>

                  <div class="md-form form-sm">
                   
                    <input type='password' name='password'  class="form-control form-control-sm">
                    <label for="form3">Your password</label>
                  </div>
                  <div class="text-center mt-2">
                    <button type="submit" class="btn btn-info">Log in <i class="fas fa-sign-in-alt ml-1"></i></button>
                  </div>
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
                </form>
                <form action="/register" method='POST'>
                <div class="text-center form-sm mt-2">
                  <button type="submit" class="btn btn-info">Sign up <i class="fas fa-sign-in-alt ml-1"></i></button>
                </div>
              </form> 
              </div>
            </div>
          </div>
        </div>
      </section>

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
      $(document).ready(function () {
        // SideNav Initialization
        new WOW().init();
        $(".button-collapse").sideNav();
        
      });


    </script>
  </div>
</body>

</html>