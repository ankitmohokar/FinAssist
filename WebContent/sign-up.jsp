<html>

<head>
    <title> Sign Up</title>
    <link rel="stylesheet" type="text/css" href="style.css">
</head>

<body>


  <nav>
        <div class="toggle">

        </div>

        <ul>
            <li><a href="index.html">Home</a></li>
			<li><a href="#">About Us</a></li>
             <li><a href="#">Contact</a></li>       
             <li style="float: right; font-weight: bold;"><a href="sign-in.html">Login</a></li>

        </ul>
    </nav>


    <div class="signupbox">
        <img src="avatar.png" class="avatar">
        <h1> Sign Up Here </h1>
        <form id="sign-up" action="SessionServlet" method="post">
            <p>First Name</p>
            <input type="text" name="fname" id="fname" placeholder="Enter First Name">
            <p>Last Name</p>
            <input type="text" name="lname" placeholder="Enter Last Name">
            <p>Username</p>
            <input type="text" name="username" placeholder="Enter Username">
            <p>Email Address</p>
            <input type="text" name="email" placeholder="Enter Email">
            <p>Password</p>
            <input type="password" name="pass" placeholder="Enter Password" style="border-bottom: 1px white solid; color: white;">
            <input type="submit">
        </form>
    </div>


    <script>
        
        function signupSubmit(){
            document.getElementById("sign-up").submit();
        }
        
    </script>
</body>

</html>