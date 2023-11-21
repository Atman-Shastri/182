<html>
<head>
	<title>Dashbaord</title>
</head>
<body bgcolor="green">
<?php

session_start();
	if($_SESSION["name"]){
?>	
	<h1>Welcome <?php echo $_SESSION["name"]; ?></h1>
	<a href="Logout.php">Logout me!</a>
<?php 
	}else{
		echo "<h1>Please Login first</h1>";
	}
?>
</body>
</html>