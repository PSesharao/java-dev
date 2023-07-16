
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta http-equiv="x-ua-compatible" content="ie=edge">
<title>Login</title>
<!-- Font Awesome -->
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.8.2/css/all.css">
<!-- Bootstrap core CSS -->
<link rel="stylesheet" href="../../css/bootstrap.min.css">
<!-- Material Design Bootstrap -->
<link rel="stylesheet" href="../../css/mdb.min.css">
<link rel="stylesheet"
	href="../../css/modules/animations-extended.min.css">

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
		style="background-image: url('https://autopilothq.com/uploads/2017/03/20170329-shopping-1-large.png'); background-repeat: no-repeat; background-size: cover; background-position: center center;">
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
										Login- <span class="text-muted">Login Customer</span>
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

										<input type='text' name='username' value=''
											class="form-control form-control-sm"> <label
											for="form2">Your username</label>
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