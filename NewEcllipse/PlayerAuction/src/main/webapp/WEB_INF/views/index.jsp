<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta http-equiv="x-ua-compatible" content="ie=edge">
<title>Index</title>

<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

<!-- MDB icon -->
<link rel="icon" href="resources/img/mdb-favicon.ico"
	type="image/x-icon">
<!-- Font Awesome -->
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.11.2/css/all.css">
<!-- Google Fonts Roboto -->
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700&display=swap">
<!-- Bootstrap core CSS -->
<link rel="stylesheet" href="resources/css/bootstrap.min.css">
<!-- Material Design Bootstrap -->
<link rel="stylesheet" href="resources/css/mdb.min.css">
<!-- Your custom styles (optional) -->
<link rel="stylesheet" href="resources/css/style.css">
<style>
.intro-2 {
	background:
		url("https://mdbootstrap.com/img/Photos/Others/img (51).jpg")
		no-repeat center center;
	background-size: cover;
}

.view {
	margin-top: -56px;
}

.navbar {
	z-index: 1;
}

html, body, header, .view {
	height: 100%;
}
</style>
</head>

<body>

	<!-- Start your project here-->
	<!--Main Navigation-->
	<header id='home'>

		<nav class="navbar fixed-top navbar-expand-lg navbar-dark indigo">
			<a class="navbar-brand" href="#"><strong>Player Auction
					Application</strong></a>
			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav mr-auto">
					<li class="nav-item "><a class="nav-link" href="#home"
						id="homelink">Home </a></li>
					<li class="nav-item"><a class="nav-link" href="#teamform"
						id="teamlink">Add Team</a></li>
					<li class="nav-item"><a class="nav-link" href="#playerform"
						id="playerlink">Add Player</a></li>
					<li class="nav-item"><a class="nav-link" href="#showpage"
						id="showlink">Show</a></li>
				</ul>
			</div>
		</nav>

		<div class="view intro-2">
			<div class="full-bg-img">
				<div class="mask rgba-black-light flex-center">
					<div class="container text-center white-text">
						<div class="white-text text-center wow fadeInUp">
							<h2>This Navbar is fixed</h2>
							<h5>It will always stay visible on the top, even when you
								scroll down</h5>
							<br>
							<p>Full page intro with background image will be always
								displayed in full screen mode, regardless of device</p>


						</div>
					</div>
				</div>
			</div>
		</div>

	</header>
	<!--Main Navigation-->

	<!--Main Layout-->
	<main class="text-center py-5">

		<div class="container">
			<div class="row">
				<div class="col-md-12">

					<!-- player form start -->
					<div id="playerform">
						<div class="card ">

							<h5 class="card-header info-color white-text text-center py-4">
								<strong>Player</strong>
							</h5>

							<!--Card content-->
							<div class="card-body px-lg-5 ">

								<!-- Form -->
								<form class="text-center" style="color: #757575;"
									action="addplayer">

									<table align="center" , width="50%" cellpadding="20%">
										<tr>
											<td>
												<!-- Name -->
												<div class="row">

													<div class="col-sm-5"></div>
													<div class="md-form mt-3">
														<div class="invalid-tooltip" id="username_error_message"></div>
														<input type="text" id="inputName" class="form-control "
															name="name"> <label for="inputName">Name</label>
													</div>

												</div>
											</td>
										</tr>
										<tr>
											<td>
												<!-- age -->
												<div class="row">
													<div class="col-sm-5"></div>
													<div class="md-form mt-3">
														<div class="invalid-tooltip" id="age_error_message"></div>
														<input type="text" id="age" class="form-control "
															name="age"> <label for="age">Age</label>
													</div>
												</div>
											</td>

										</tr>
										<tr>
											<td>
												<!-- skill -->

												<div class="row">
													<div class="col-sm-5"></div>
													<div class="col-sm-0">Skill</div>
												</div>
											</td>
										</tr>
										<tr>
											<td>
												<div class="row">
													<div class="col-sm-5"></div>
													<div class="form-check">

														<input type="radio" class="form-check-input skill"
															id="skill" name="skill" value="batsman"> <label
															class="form-check-label" for="skill">Batsman</label>
													</div>
												</div>

												<div class="row">
													<div class="col-sm-5"></div>
													<div class="form-check">
														<input type="radio" class="form-check-input skill"
															id="skill" name="skill" value="bowler"> <label
															class="form-check-label" for="skill">Bowler</label>
													</div>
												</div>


												<div class="row">
													<div class="col-sm-5"></div>
													<div class="form-check">
														<input type="radio" class="form-check-input skill"
															id="skill" name="skill" value="allrounder"> <label
															class="form-check-label" for="skill">Allrounder</label> <br>

													</div>
												</div>


												<div class="row">
													<div class="col-sm-5"></div>
													<div class="col-sm-6">
														<div class="invalid-tooltip" id="skill_error_message"></div>
													</div>
												</div>
											</td>
										</tr>
										<tr>
											<td>
												<div class="row">
													<div class="col-sm-5"></div>
													<label for="team"></label> <select
														class="browser-default custom-select mb-1 col-sm-5"
														id="team" name="team">
														<option value="" disabled="" selected="">Choose
															Team</option>
														<c:forEach var="team" items="${teamList}">
															<option value="${team.name}">${team.getName()}</option>
														</c:forEach>
													</select>
												</div>

												<div class="row">
													<div class="col-sm-5"></div>
													<div class="col-sm-6">
														<div class="invalid-tooltip" id="team_error_message"></div>
													</div>
												</div>
											</td>
										</tr>

										<tr>
											<td>
												<!-- budget -->
												<div class="row">
													<div class="col-sm-5"></div>
													<div class="md-form mt-3">
														<div class="invalid-tooltip" id="budget_error_message"></div>
														<input type="text" id="budget" class="form-control "
															name="purchasePrice"> <label for="budget">Purchase
															Price</label>
													</div>
												</div>
											</td>
										</tr>

										<tr>
											<td>
												<!-- Submit button -->
												<div class="row">
													<div class="col-sm-5"></div>
													<button
														class="btn btn-outline-info btn-rounded btn-block z-depth-1 my-4 waves-effect col-sm-4"
														type="submit" id="button">Submit</button>
												</div>
											</td>
										</tr>
									</table>
								</form>
								<!-- Form -->

							</div>

						</div>

					</div>
					<!-- playerform end -->
					<br> <br> <br>


					<!-- teamform start  -->
					<div id="teamform">
						<div class="card ">

							<h5 class="card-header info-color white-text text-center py-4">
								<strong>Team</strong>
							</h5>

							<!--Card content-->
							<div class="card-body px-lg-5 ">
								<!-- Form -->
								<form class="text-center" style="color: #757575;"
									id="appteamform">

									<table align="center" , width="50%" cellpadding="20%">
										<tr>
											<td>
												<!-- Name -->
												<div class="row">

													<div class="col-sm-5"></div>
													<div class="md-form mt-3">
														<div class="invalid-tooltip" id="username_error_message1">
														</div>
														<input type="text" id="inputName1" class="form-control "
															name="name"> <label for="inputName">Name</label>
													</div>

												</div>
											</td>
										</tr>
										<tr>
											<td>
												<!-- slider -->
												<div class="row">
													<div class="col-sm-5"></div>
													<div class="col-sm-0">Max Budget</div>
												</div>
											</td>
										</tr>
										<tr>
											<td>


												<div class="row">
													<div class="col-sm-5"></div>
													<div class="w-35">
														<input type="range" class="custom-range"
															id="customRange11" min="0" max="200" value="50"
															name="maxBudget">
													</div>
													<span class="font-weight-bold text-primary ml-2 valueSpan2"></span>
												</div>

											</td>
										</tr>
										<tr>
											<td>
												<!-- Submit button -->
												<div class="row">
													<div class="col-sm-5"></div>
													<button
														class="btn btn-outline-info btn-rounded btn-block z-depth-0 my-4 waves-effect col-sm-4"
														type="submit" id="button1">Submit</button>
												</div>
											</td>
										</tr>

									</table>
								</form>
								<div id="postResultDiv"></div>
							</div>
						</div>
					</div>

					<!-- team form end  -->
					<br> <br> <br>


					<!-- show page -->
					<div id="showpage">
						<div class="card ">

							<h5 class="card-header info-color white-text text-center py-4">
								<strong>Player Info</strong>
							</h5>

							<!--Card content-->
							<div class="card-body px-lg-5 ">

								<!-- Form -->
								<form class="text-center" style="color: #757575;"
									action="showplayer">
									<table align="center" , width="50%" cellpadding="20%">
										<tr>
											<td>
												<div class="row">
													<div class="col-sm-5"></div>
													<label for="team"></label> <select
														class="browser-default custom-select mb-1 col-sm-5"
														id="team3" name="team">
														<option value="" disabled="" selected="">Choose
															Team</option>
														<c:forEach var="team" items="${teamList}">
															<option value="${team.name}">${team.getName()}</option>
														</c:forEach>
													</select>
												</div>

												<div class="row">
													<div class="col-sm-5"></div>
													<div class="col-sm-6">
														<div class="invalid-tooltip" id="team_error_message3"></div>
													</div>
												</div>
											</td>
										</tr>

									</table>
								</form>
								<!-- Form -->
								<!-- update form -->
								<form class="text-center" style="color: #757575;"
									action="update">
									<table
										class="table table-striped table-hover table-bordered border-primary">
										<thead>
											<tr>
												<th scope="col">Id</th>
												<th scope="col">Name</th>
												<th scope="col">Age</th>
												<th scope="col">Skill</th>
												<th scope="col">PurchasePrice</th>
											</tr>
										</thead>
										<tbody>
											<c:forEach var="player" items="${playerList}">
												<tr>
													<th scope="row">${player.id}</th>
													<td>${player.name}</td>
													<td>${player.age}</td>
													<td>${player.skill}</td>
													<td>${player.purchasePrice}</td>
													<td>
														<button type="submit" name="playerId" id="playerId"
															value="${player.id}" class="btn btn-primary">Update</button>
													</td>
												</tr>
											</c:forEach>

										</tbody>
									</table>

								</form>

							</div>

						</div>
					</div>
					<!-- show page end  -->

					<br> <br> <br>
					<!-- update player page  -->
					<div id="updateplayer">
						<div class="card ">

							<h5 class="card-header info-color white-text text-center py-4">
								<strong>Player</strong>
							</h5>

							<!--Card content-->
							<div class="card-body px-lg-5 ">

								<!-- Form -->
								<form class="text-center" style="color: #757575;"
									action="updateplayer">

									<p>please enter the player details</p>
									<div class="parallax">
										<!-- Name -->
										<div class="row">

											<div class="col-sm-5"></div>
											<div class="md-form mt-3">
												<div class="invalid-tooltip" id="username_error_message"></div>
												<input type="text" id="inputName" class="form-control "
													name="name" value="${player.name}"> <label
													for="inputName">Name</label>
											</div>

										</div>

										<!-- age -->
										<div class="row">
											<div class="col-sm-5"></div>
											<div class="md-form mt-3">
												<div class="invalid-tooltip" id="age_error_message"></div>
												<input type="text" id="age" class="form-control " name="age"
													value="${player.age}"> <label for="age">Age</label>
											</div>
										</div>


										<!-- skill -->

										<div class="row">
											<div class="col-sm-3"></div>
											<div class="col-sm-6">Skill</div>
										</div>
										<br>


										<div class="form-check">

											<input type="radio" class="form-check-input skill" id="skill"
												name="skill" value="batsman"> <label
												class="form-check-label" for="skill">Batsman</label>
										</div>


										<div class="form-check">
											<input type="radio" class="form-check-input skill" id="skill"
												name="skill" value="bowler"> <label
												class="form-check-label" for="skill">Bowler</label>
										</div>


										<div class="form-check">
											<input type="radio" class="form-check-input skill" id="skill"
												name="skill" value="allrounder"> <label
												class="form-check-label" for="skill">Allrounder</label> <br>

										</div>

										<div class="row">
											<div class="col-sm-5"></div>
											<div class="col-sm-6">
												<div class="invalid-tooltip" id="skill_error_message"></div>
											</div>
										</div>

										<br> <br>


										<!-- budget -->
										<div class="row">
											<div class="col-sm-5"></div>
											<div class="md-form mt-3">
												<div class="invalid-tooltip" id="budget_error_message"></div>
												<input type="text" id="budget" class="form-control "
													name="purchasePrice" value="${player.purchasePrice}">
												<label for="budget">Purchase Price</label>
											</div>
										</div>


										<!-- Submit button -->
										<div class="row">
											<div class="col-sm-5"></div>
											<button
												class="btn btn-outline-info btn-rounded btn-block z-depth-0 my-4 waves-effect col-sm-2"
												type="submit" id="button" value="${player.id}"
												name="playerId">Update</button>
										</div>
									</div>
								</form>
								<!-- Form -->

							</div>

						</div>

					</div>
					<!-- update player end -->
				</div>
			</div>
		</div>

	</main>
	<!--Main Layout-->
	<!-- End your project here-->

	<!-- jQuery -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<!-- Your custom scripts (optional) -->
	<script type="text/javascript" src="resources/js/playerauctionval.js">
		
	</script>

</body>

</html>