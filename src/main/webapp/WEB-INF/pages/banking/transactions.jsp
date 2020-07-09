<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">

    <title>SASH - Transaction Service</title>
  </head>
<body>

	<div class="container-fluid">
	
		<%@ include file = "header.jsp" %>
		
		<div class="row">
			<div class="col col-lg-6">
				<div class="jumbotron  alert alert-danger">
					<h2><center>VIEW STATMENTS (SPECIFIC)</center></h2><hr>
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
			
			<div class="col col-lg-6">
				<div class="jumbotron alert alert-danger">
					<h2><center>VIEW STATMENTS (ALL CUSTOMER)</center></h2><hr>
					
					<form method="POST" action="/sash/banking/transaction/statement/all">
	    				<div class="row">
	    						<div class="col">
	    								<!-- Enter Start Date -->
										<label><b>Select Start Date :</b></label><br>
	    								<input type="date" name="from" class="form-control"><br>
	    						</div>
	    				</div>		
	    				<div class="row">
	    						<div class="col">
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
				
		
		<div class="jumbotron alert alert-success">
			<center><strong><h2>ALL TRANSACTIONS DETAILS</h2></strong></center>		
			<hr>
			<div class="table-responsive">
 				<table id="txTable" class="table table-striped table-hover">
 					<thead>
					    <tr>
					      <th scope="col">Transaction ID</th>
					      <th scope="col">Customer ID</th>
					      <th scope="col">Source Account</th>
					      <th scope="col">Destination Account</th>
					      <th scope="col">Date of Transaction</th>
					      <th scope="col">Amount</th>
					    </tr>
					  </thead>
					  <tbody>
					    <c:forEach items="${tx}" var="obj">
						    <tr>
						      <td>${obj.tx_id }			</td>
						      <td>${obj.customerId }	</td>
						      <td>${obj.source }		</td>
						      <td>${obj.destination }	</td>
						      <td>${obj.dot }			</td>
						      <td>${obj.amount }		</td>
						    </tr>
					    </c:forEach>
					  </tbody>
  				</table>
			</div>
			<div class="row">
				<div class="col">
					Download Transaction <input type="button" id="btnExport" value="Export" onclick="Export()" />
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
		</div>
		
		<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/pdfmake/0.1.22/pdfmake.min.js"></script>
    	<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/html2canvas/0.4.1/html2canvas.min.js"></script>
    	<script type="text/javascript">
	        function Export() {
	            html2canvas(document.getElementById('txTable'), {
	                onrendered: function (canvas) {
	                    var data = canvas.toDataURL();
	                    var docDefinition = {
	                        content: [{
	                            image: data,
	                            width: 500
	                        }]
	                    };
	                    pdfMake.createPdf(docDefinition).download("Table.pdf");
	                }
	            });
	        }
 	   	</script>
		<%@ include file = "footer.jsp" %>