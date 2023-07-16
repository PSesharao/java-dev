
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta http-equiv="x-ua-compatible" content="ie=edge">
<title>Login</title>
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.8.2/css/all.css">
<!-- Bootstrap core CSS -->
<link rel="stylesheet" href="../../css/bootstrap.min.css">
<!-- Material Design Bootstrap -->
<link rel="stylesheet" href="../../css/mdb.min.css">
<link rel="stylesheet"
	href="../../css/modules/animations-extended.min.css">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700&display=swap">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<!-- Your custom styles (optional) -->
<style>
.navbar {
	z-index: 1;
}

body, html {
	height: 100%;
}

.view {
	width: 100%;
	height: 100%;
}
</style>
</head>

<body class="fixed-sn white-skin">
	<div class="view jarallax" data-jarallax='{"speed": 0.2}'
		style="background-image: url('https://images5.alphacoders.com/728/728126.jpg'); background-repeat: no-repeat; background-size: cover; background-position: center center;">
		<!-- Main Navigation -->
		<header> </header>
		<!-- Main Navigation -->

		<!-- Main layout -->
		<main>

			<section class="section team-section">
				<div class="row text-center">
					<div class="col-md-3 mb-4"></div>
					<div class="col-md-6 mb-4">
						<!-- Card -->
						<div class="card card-cascade cascading-admin-card user-card">

							<!-- Card Data -->
							<div class="admin-up d-flex justify-content-start">
								<i class="fas fa-users info-color py-4 mr-3 z-depth-2"></i>
								<div class="data">
									<h5 class="font-weight-bold dark-grey-text">
										Login- <span class="text-muted">Login User</span>
									</h5>
								</div>
							</div>
							<!-- Card Data -->
							<div class="card-body card-body-cascade">
								<c:if test="${not empty errorMessge}">
									<div class="alert alert-primary alert-dismissible fade show"
										role="alert">
										<strong>${errorMessge}</strong>
										<button type="button" class="close" data-dismiss="alert"
											aria-label="Close">
											<span aria-hidden="true">&times;</span>
										</button>
									</div>
								</c:if>
								<%-- <c:if test="${not empty errorMessge}"><div style="color:red; font-weight: bold; margin: 30px 0px;">${errorMessge}</div></c:if> --%>
								<form name='login' action="/login" method='POST'>
									<div class="md-form form-sm">

										<input type='email' name='email' value=''
											class="form-control form-control-sm"> <label
											for="form2">Your Email</label>
									</div>

									<div class="md-form form-sm">

										<input type='password' name='password'
											class="form-control form-control-sm"> <label
											for="form3">Your password</label>
									</div>
									<div class="text-center mt-2">
										<button type="submit" class="btn btn-info">
											Log in <i class="fas fa-sign-in-alt ml-1"></i>
										</button>
									</div>
									<input type="hidden" name="${_csrf.parameterName}"
										value="${_csrf.token}" />
								</form>
								<form action="/register" method='POST'>
									<div class="text-center form-sm mt-2">
										<button type="submit" class="btn btn-info">
											Sign up <i class="fas fa-sign-in-alt ml-1"></i>
										</button>
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
			$(document).ready(function() {
				// SideNav Initialization
				new WOW().init();
				$(".button-collapse").sideNav();

			});
		</script>
	</div>
</body>

</html>