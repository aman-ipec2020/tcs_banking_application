<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">

    <title>SASH - Transfer Service</title>
  </head>
<body>

	<div class="container-fluid">
	
		<%@ include file = "header.jsp" %>
	
		<div class="jumbotron alert alert-danger">
			<div class="row">
				<!-- Search By Account ID -->
				<div class="col">
					<h2><center>VIEW STATMENTS (SPECIFIC CUSTOMER)</center></h2>
					<form method="POST" action="/sash/banking/transaction/statement/id">
						<!-- Enter Account ID -->
						<label><b>Enter Customer ID :</b></label><br>
	    				<input type="text" name="id" class="form-control"><br>
	    				
	    				<div class="row">
	    						<div class="col col-lg-6">
	    								<!-- Enter Start Date -->
										<label><b>Select Start Date :</b></label><br>
	    								<input type="date" name="from" class="form-control"><br>
	    						</div>
	    						<div class="col col-lg-6">
	    				   				<!-- Enter End Date -->
										<label><b>Enter End ID :</b></label><br>
	    								<input type="date" name="to" class="form-control"><br>
	    						</div>
	    				</div>	    				
	  						
	  					<div class="col-sm-10">
	      					<button type="submit" class="btn btn-primary">SEARCH</button>
	    				</div>	
	  				</form>
				</div>
			</div>
		</div>
		
		<div class="jumbotron alert alert-info">
			<div class="row">
				<!-- Search By Account ID -->
				<div class="col">
					<h2><center>VIEW STATMENTS (ALL CUSTOMER)</center></h2>
					<form method="POST" action="/sash/banking/transaction/statement/all">
	    				<div class="row">
	    						<div class="col col-lg-6">
	    								<!-- Enter Start Date -->
										<label><b>Select Start Date :</b></label><br>
	    								<input type="date" name="from" class="form-control"><br>
	    						</div>
	    						<div class="col col-lg-6">
	    				   				<!-- Enter End Date -->
										<label><b>Enter End ID :</b></label><br>
	    								<input type="date" name="to" class="form-control"><br>
	    						</div>
	    				</div>	    				
	  						
	  					<div class="col-sm-10">
	      					<button type="submit" class="btn btn-primary">SEARCH</button>
	    				</div>	
	  				</form>
				</div>
			</div>
		</div>


		<div class="row">
			<div class="col">			
					<!-- Status -->
					<div class="form-group row">
						<label class="col-sm-2 col-form-label"><b>${alert }</b></label>
    				</div>
			</div>
		</div>
		
		<%@ include file = "footer.jsp" %>
		
	</div>