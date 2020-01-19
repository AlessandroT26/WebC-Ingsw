<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<title>Login Page</title>
   <!--Made with love by Mutiullah Samim -->

   <script type="text/javascript" src="jquery.min.js"></script>
   
	<!--Bootsrap 4 CDN-->
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
    
    <!--Fontawesome CDN-->
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css" integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU" crossorigin="anonymous">

	<!--Custom styles-->
	<link rel="stylesheet" type="text/css" href="styles.css">
	<style>
		
		.card{
			height: 500px;
			margin-top: auto;
			margin-bottom: auto;
			width: 560px;
			background-color: rgba(0,0,0,0.5) !important;
		}

		#errorMessage {
                
                color: red;
                font-size: 90% !important;
                
            }
            
            #successMessage {
                
                color: green;
                font-size: 90% !important;
                display:none;
                margin-bottom:20px;
                
            }

	</style>

</head>
<body>
<div class="container">
		<div class="d-flex justify-content-center h-100">
		<div class="card">
			<div class="card-header">
				<h3>Registrazione</h3>
				<div class="d-flex justify-content-end social_icon">
					<span><i class="fab fa-facebook-square"></i></span>
					<span><i class="fab fa-google-plus-square"></i></span>
					<span><i class="fab fa-twitter-square"></i></span>
				</div>
			</div>
			<div class="card-body">
				<form action="<%=request.getContextPath()+"/ChangePage" %>" method="post">
					<div class="input-group form-group">
						<div class="input-group-prepend">
							<span class="input-group-text"><i class="fas fa-user"></i></span>
						</div>
						<label for="nomeUtente"></label> <!--USIAMO NAME PER MANDARE I DATI-->
						<input type="text" class="form-control" name="nome" id="nome" placeholder="Nome Utente">
					</div>
					<div class="input-group form-group">
						<div class="input-group-prepend">
							<span class="input-group-text"><i class="fas fa-user"></i></span>
						</div>
						<label for="email"></label>
						<input type="text" class="form-control" name="email"  id="email" placeholder="Email">
						
					</div>
					<div class="input-group form-group">
						<div class="input-group-prepend">
							<span class="input-group-text"><i class="fas fa-key"></i></span>
						</div>
						<label for="password"></label>
						<input type="password" class="form-control" name="password" id="password" placeholder="password">
					</div>
					<div class="input-group form-group">
						<div class="input-group-prepend">
							<span class="input-group-text"><i class="fas fa-key"></i></span>
						</div>
						<label for="passwordConfirm"></label>
						<input type="password" class="form-control" id="passwordConfirm" placeholder="ripeti password">
					</div>
					<div class="row align-items-center remember">
						<input type="checkbox">Acconsenti ai trattamenti per la privacy
					</div>
					<div clas=s"form-group">
						<input type="submit" id="submitButton" value="SignUp" class="btn float-right login_bt">
					</div>
				</form>
				 <div id="successMessage">You've done it! Congratulations.</div>
            
            <div id="errorMessage"></div>
			</div>
		</div>
	</div>
</div>
<div id="successMessage">You've done it! Congratulations.</div>
    <div id="errorMessage"></div>

	<script type="text/javascript">
            
            function isEmail(email) {
  
                var regex = /^([a-zA-Z0-9_.+-])+\@(([a-zA-Z0-9-])+\.)+([a-zA-Z0-9]{2,4})+$/;
  
                return regex.test(email);
                
            }
            
            $("#submitButton").click(function() {
                
                var errorMessage = "";
                var fieldsMissing = "";
                
                if ($("#email").val() == "") {
                    
                    fieldsMissing += "<br>Email";
                    
                }
                
                if ($("#nomeUtente").val() == "") {
                    alert("FUCK")
                    fieldsMissing += "<br>Nome Utente";
                    
                }
                
                if ($("#password").val() == "") {
                    alert("fuck2")
                    fieldsMissing += "<br>Password";
                    
                }
                
                if ($("#passwordConfirm").val() == "") {
                    alert("fuck3")
                    fieldsMissing += "<br>Conferma Password";
                    
                }
                
                if (fieldsMissing != "") {
                    alert("fuck4")
                    errorMessage += "<p>The following field(s) are missing:" + fieldsMissing;
                    
                }
                
                if (isEmail($("#email").val()) == false) {
                    alert("fuck5")
                    errorMessage += "<p>Il tuo indirizzo email non è valido</p>";
                    
                }
                
                if ($("#password").val() != $("#passwordConfirm").val()) {
                    errorMessage += "<p>Your passwords don't match</p>";
                    
                }
                
                if (errorMessage != "") {
                    
                    $("#errorMessage").html(errorMessage);
                    
                } else {
                    
                    $("#successMessage").show();
                    $("#errorMessage").hide();
                    
                }
                
            });
            
            
        </script>

</body>
</html>