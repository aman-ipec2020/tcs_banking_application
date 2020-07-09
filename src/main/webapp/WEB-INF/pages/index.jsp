<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
	<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	 <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">

	<title>SASH - LOGIN</title>
</head>
<body>

	<div class="container-fluid">
		<div class="row">
			<div class="col">
					<div class="jumbotron alert alert-info">
						
						<h1><center>SASH BANK</center></h1>
						<hr>
						<div class="row">
							<div class="col col-lg-4">
							<div class="jumbotron alert alert-success">
								<h3>LOGIN FORM</h3>
								<hr>
							<form method="post" action="login">
														<!-- Enter Amount -->
								<div class="form-group row">
									<label class="col-sm-3 col-form-label"><b>USERNAME</b></label>
									<div class="col-sm-9">
										<input type="text" name="username" class="form-control">
									</div>
								</div>
								
								<div class="form-group row">
									<label class="col-sm-3 col-form-label"><b>PASSWORD</b></label>
									<div class="col-sm-9">
										<input type="password" name="password" class="form-control">
									</div>
								</div>

								<div class="form-group row">
									<div class="col-sm-10">
										<button type="submit" class="btn btn-primary">LOGIN</button>
									</div>
								</div>
							</form>
							</div>
						</div>
						<div class="col col-lg-7">
								<img src="img/banking-3.jpg" class="rounded mx-auto d-block" height="250" width="700" alt="...">
						</div>
						</div>
					</div>
			</div>	
		</div>		
	</div>
	
	<!-- Footer -->
<footer class="page-footer font-small blue-grey lighten-5">

  <div style="background-color: #21d192;">
    <div class="container">

      <!-- Grid row-->
      <div class="row py-4 d-flex align-items-center">

        <!-- Grid column -->
        <div class="col-md-6 col-lg-5 text-center text-md-left mb-4 mb-md-0">
          <h6 class="mb-0">Get connected with us on social networks!</h6>
        </div>
        <!-- Grid column -->

        <!-- Grid column -->
        <div class="col-md-6 col-lg-7 text-center text-md-right">

          <!-- Facebook -->
          <a class="fb-ic">
            <i class="fab fa-facebook-f white-text mr-4"> </i>
          </a>
          <!-- Twitter -->
          <a class="tw-ic">
            <i class="fab fa-twitter white-text mr-4"> </i>
          </a>
          <!-- Google +-->
          <a class="gplus-ic">
            <i class="fab fa-google-plus-g white-text mr-4"> </i>
          </a>
          <!--Linkedin -->
          <a class="li-ic">
            <i class="fab fa-linkedin-in white-text mr-4"> </i>
          </a>
          <!--Instagram-->
          <a class="ins-ic">
            <i class="fab fa-instagram white-text"> </i>
          </a>

        </div>
        <!-- Grid column -->

      </div>
      <!-- Grid row-->

    </div>
  </div>

  <!-- Footer Links -->
  <div class="container text-center text-md-left mt-5">

    <!-- Grid row -->
    <div class="row mt-3 dark-grey-text">

      <!-- Grid column -->
      <div class="col-md-3 col-lg-4 col-xl-3 mb-4">

        <!-- Content -->
        <h6 class="text-uppercase font-weight-bold">Company name</h6>
        <hr class="teal accent-3 mb-4 mt-0 d-inline-block mx-auto" style="width: 60px;">
        <p>
        	The Bank is actively involved since 1973 in non-profit activity called Community Services Banking. All our branches and administrative offices throughout the country sponsor and participate in large number of welfare activities and social causes. Our business is more than banking because we touch the lives of people anywhere in many ways.
        </p>

      </div>
      <!-- Grid column -->

      <!-- Grid column -->
      <div class="col-md-2 col-lg-2 col-xl-2 mx-auto mb-4">

        <!-- Links -->
        <h6 class="text-uppercase font-weight-bold">Products</h6>
        <hr class="teal accent-3 mb-4 mt-0 d-inline-block mx-auto" style="width: 60px;">

        <p>
          <a class="dark-grey-text" href="#!">Retail and Consumer Banking</a>
        </p>
        <p>
          <a class="dark-grey-text" href="#!">Personal Internet Banking</a>
        </p>
        <p>
          <a class="dark-grey-text" href="#!">Corporate Banking</a>
        </p>
        <p>
          <a class="dark-grey-text" href="#!">Debit and Credit Cards</a>
        </p>

      </div>
      <!-- Grid column -->

      <!-- Grid column -->
      <div class="col-md-4 col-lg-3 col-xl-3 mx-auto mb-md-0 mb-4">

        <!-- Links -->
        <h6 class="text-uppercase font-weight-bold">Contact</h6>
        <hr class="teal accent-3 mb-4 mt-0 d-inline-block mx-auto" style="width: 60px;">
        <p><i class="fas fa-home mr-3"></i>Sorojini Nagar,Aurobindo Marg,New Delhi 110023</p>
        <p><i class="fas fa-envelope mr-3"></i> info@sashbank.com</p>
        <p><i class="fas fa-phone mr-3"></i> +91-8745882422,</p>
        <p><i class="fas fa-print mr-3"></i> +91-9842406679</p>

      </div>
      <!-- Grid column -->

    </div>
    <!-- Grid row -->

  </div>
  <!-- Footer Links -->

  <!-- Copyright -->
  <div class="footer-copyright text-center text-black-50 py-3">© 2020 Copyright:
    <a class="dark-grey-text" href="https://mdbootstrap.com/"> SASHBank.com</a>
  </div>
  <!-- Copyright -->

</footer>
<!-- Footer -->
	
	<!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js" integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" crossorigin="anonymous"></script>
  

</body>
</html>