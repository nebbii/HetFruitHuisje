<html>
<head>
	<title>'t Fruithuisje</title>
	<link rel="stylesheet" type="text/css" href="css\main.css">
	<?php 
	session_start();
	include("class/body.class.php"); // Pagination
	include("class/user.class.php"); // login/register processing
	include("include/config.php"); // server credentials
	
	// prepare route 
	$q = "";
	if(isset($_GET['q'])) { $q = $_GET['q']; }
	
	// initialize db
	$db = new mysqli(DB_SERVER,DB_USERNAME,DB_PASSWORD,DB_DATABASE);
	
	// initialize paginator
	$body = new Body;
	
	// process user 
	if(isset($_GET['user'])) {
		$process = new User();
		switch($_GET['user']) {
			case 'register':
				$process->register($_POST['user'],$db);
				break;
			case 'logout':
				$process->logout();
				break;
			case 'login':
			default:
				$process->login($_POST['user'],$db);
				break;
		}
	}
	?>
	
</head>

<body>
<div id="wrapper">
	<div id="container">
		<div id="header">
			<div id="logo">
				<img src="img/fruithuisje-logo.png" width=30px>
			</div>
			<div id="pagetitle">
				't Fruithuisje
			</div>
		</div>
		<div id="body">
		<div id="body">
		<div id="sidenav">
			<ul>
				<li><a href="<?php echo $_SERVER['PHP_SELF']; ?>">Home</a></li>
				<li><a href="<?php echo $_SERVER['PHP_SELF']; ?>?q=about">Over Ons</a></li>
				<li><a href="<?php echo $_SERVER['PHP_SELF']; ?>?q=contact">Contact</a></li>
				
				<li><a><hr></a></li>
				
				<?php if(!isset($_SESSION['user'])): // user ?>
					<li><a href="<?php echo $_SERVER['PHP_SELF']; ?>?q=login">Inloggen</a></li>
				<?php else: ?>
					<li><a href="<?php echo $_SERVER['PHP_SELF']; ?>?q=bestelling_aanmaken">Bestelling Aanmaken</a></li>
					<li><a href="<?php echo $_SERVER['PHP_SELF']; ?>?q=bestelling_bekijken">Bestellingen Bekijken</a></li>
					<li><a href="<?php echo $_SERVER['PHP_SELF']; ?>?user=logout">Log uit</a></li>
				<?php endif; ?>
			</ul>
		</div>
		<div id="bodycontent">
			<?php
				// error message ?
				if(isset($_SESSION['m'])) {
					echo "<h4>".$_SESSION['m']."</h4><hr>";
					unset($_SESSION['m']);
				}
				// page gets generated
				switch($q) {
					case 'about':
						$body->about();
						break;
					case 'contact':
						$body->contact();
						break;
					case 'login':
						$body->loginpage();
						break;
					case 'bestelling_aanmaken':
						if(isset($_POST['product'])) {
							$body->bestelling_aanmaken_process($db);
						}
						$body->bestelling_aanmaken($db);
						break;
					case 'bestelling_bekijken':
						$body->bestelling_bekijken($db);
						break;
					case 'bestelling_bekijken_form':
						if(isset($_GET['id'])) {
							$body->bestelling_bekijken_form($db,$_GET['id']);
						}
						break;
					default:
						$body->home();
				}
			?>
		</div>
	</div>
	</div>
</div>