(function() {
    var y = document.getElementById("myDIV1");
     y.style.display = "none";
 })();
     
 function myFunction() {
     var x = document.getElementById("myDIV");
     var y = document.getElementById("myDIV1");
        document.getElementById("try").style.backgroundColor = "#0288d1";
        document.getElementById("up").style.backgroundColor = "#f8f9fa";
         x.style.display = "block";
         y.style.display = "none"; 
 }
 
 function myFunction1() {
     var x = document.getElementById("myDIV");
     var y = document.getElementById("myDIV1");
     document.getElementById("try").style.backgroundColor = "#f8f9fa";
        document.getElementById("up").style.backgroundColor = "#0288d1";
         x.style.display = "none";
         y.style.display = "block"; 
 }