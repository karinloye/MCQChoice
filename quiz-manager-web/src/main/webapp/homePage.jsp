<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%
boolean auth = (Boolean) session.getAttribute("authenticated");
if (! auth){
    response.sendRedirect("index.html");
}
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Page Title</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB" crossorigin="anonymous">

    <!-- Custom CSS-->
    <style>
    	* {
    margin: 0px;
    padding: 0px;
    font: 16px 'Source Sans Pro', sans-serif;
    border: none;
    box-sizing: border-box;
  }

  html, body {
    background: #dae1e7;
    width: 100%;
    height: 100%;
  }

  .main{
      margin-top: 30px;
      padding: 20px;
      background: white;
      box-sizing: border-box;
      box-shadow: 0 0 10px 0 rgba(0,0,0,.1);
  }

  .navbar-brand{
      padding: 10px 50px;
      font-size: 1.5em;
      color: white !important;
  }

  .nav-link{
    font-size: 1.5em;
    color: whitesmoke !important;
  }

  .mainTitle{
      padding: 20px;
      text-align: center;
  }
  
  ul{
      list-style: disc;
      
  }
    </style>
</head>
<body>
    <nav class="navbar navbar-expand-lg navbar-light sticky-top" 
    style='background-color:#0e90d2; line-height: 50px'>
        <a class="navbar-brand" href="#">Java Quiz App</a>
            <ul class="navbar-nav ml-auto">
                <li><a class="nav-item nav-link" href="/quiz-manager-web">Log out</a></li>
            </ul>
    </nav>

    <div class="container main">
        <div class="mainTitle">
            <h2>Welcome to JAVA Quiz Application</h2>
        </div>
        <div class="container">
            <ul>
                <li><p>Please answer the Online Quiz below. You will receive 2 points for every correct answer submitted.</p></li>
                <li><p>You have only one attempt to take the Online Quiz test. </p></li>
            </ul>
            <hr>
            
            <div class="container">
                <h6>Questions</h6>
                <p style="font-weight: bold"><h4>What is JAVA?</h4></p>
                <form action="/qcreate" method="GET">
                    <div class="custom-control custom-radio form-group">
                        <input type="radio" id="customRadio1" name="customRadio" class="custom-control-input">
                        <label class="custom-control-label" for="customRadio1">A Programming Language</label>
                    </div>
                    <div class="custom-control custom-radio form-group">
                        <input type="radio" id="customRadio2" name="customRadio" class="custom-control-input">
                        <label class="custom-control-label" for="customRadio2">A Scripting Language</label>
                    </div>
                    <div class="custom-control custom-radio form-group">
                        <input type="radio" id="customRadio3" name="customRadio" class="custom-control-input">
                        <label class="custom-control-label" for="customRadio3">A Machine Language</label>
                    </div>
                    <div class="custom-control custom-radio form-group">
                        <input type="radio" id="customRadio4" name="customRadio" class="custom-control-input">
                        <label class="custom-control-label" for="customRadio4">An Ordinary Language</label>
                    </div>
                    <div class="custom-control custom-radio form-group" style="text-align:right">
                        <button class="btn btn-primary disabled">previous</button>
                        <button class="btn btn-primary">Next</button>          
                    </div>
                </form>
            </div>
            
        </div>
    </div>

    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js" integrity="sha384-smHYKdLADwkXOn1EmN1qk/HfnUcbVRZyYmZ4qpPea6sjB/pTJ0euyQp0Mk8ck+5T" crossorigin="anonymous"></script>
</body>
</html>