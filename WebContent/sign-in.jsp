<html>
    <head>
        <title> Login</title>
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
             <li style="float: right; font-weight: bold;"><a href="sign-in.jsp">Login</a></li>

        </ul>
    </nav>


        <div class="loginbox">
            <img src="avatar.png" class="avatar" >
            <h1> Login Here </h1>
            <form id="sign-in" action="LoginServlet" method="post">
                <p>Username</p>
                <input type="text" name="username" placeholder="Enter Username">
                <p>Password</p>
                <input type="password" name="pass" placeholder="Enter Password">
                <input type="submit" name="submit" value="submit">
                <a href="lost-password.html"> Lost your Password?</a><br />
                <a href="sign-up.jsp"> Don't have an account?</a>
            </form>
        </div>

        <script>
            
            function goToHome(){
                document.getElementById("sign-in").submit();
            }
        </script>

    </body>
</html>