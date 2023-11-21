<?php
session_start();

$message="";

if(count($_POST)>0){
	$con=mysqli_connect("127.0.0.1:3306","root","","company") or die("Unable to connect");
	$username=$_POST["username"];
	$password=$_POST["pass"];
	$query="select * from employee where name='".$username."' and password='".$password."'";
	$result=mysqli_query($con,$query);
	$row=mysqli_fetch_array($result);
	if(is_array($row)){
		$_SESSION["name"]=$row["name"];
	}else{
		$message="Invalid username and password";
	}
}
if(isset($_SESSION["name"])){
	header("Location:Dashboard.php");
}
?>

<html>
<head>
	<title>Employee Login</title>
</head>
<body>
<form method="post" action="">
<div> <?php if($message!=""){ echo $message; } ?>
<h3>Enter Login Details</h3>
Username:<br>
<input type="text" name="username">
<br>
Password:<br>
<input type="password" name="pass">
<br>
<input type="submit" name="Login">

</form>

</body>
</html>