<?php

class User 
{	
	function login($user,$db) {
		$pass = md5($user['password']);
		$sql = "SELECT
				  `cursistid`,
				  `cursistww`,
				  `admin`,
				  `emailadres`,
				  `roepnaam`,
				  `tussenvoegsels`,
				  `achternaam`,
				  `adres`,
				  `woonplaats`,
				  `telefoon`
				FROM
				  `cursist`
				WHERE
				 `emailadres`='{$user['email']}' AND
				 `cursistww`='{$pass}'
				 ";
		$result = $db->query($sql);
		if ($result->num_rows > 0) {
			while($row = $result->fetch_assoc()) { 
				$_SESSION['user'] = $row;
			}
			$_SESSION['m'] = "U bent ingelogd.";
			header("Location: {$_SERVER['PHP_SELF']}?q=home");
		} else {
			$_SESSION['m'] = "Error: Gebruiker niet gevonden!";
			//header("Location: {$_SERVER['PHP_SELF']}?q=login");
		}
	}
	
	function logout() {
		session_destroy();
		header("Location: {$_SERVER['PHP_SELF']}?q=home");
	}
	
	function register($user,$db) {
		$pass = md5($user['password']);
		$user['pass'] = $pass; 
		$sql = "INSERT INTO
				  `cursist`(
					`emailadres`,
					`cursistww`,
					`roepnaam`,
					`tussenvoegsels`,
					`achternaam`,
					`adres`,
					`woonplaats`,
					`telefoon`
				  )
				VALUES(
				  '{$user['emailadres']}',
				  '{$user['pass']}',
				  '{$user['roepnaam']}',
				  '{$user['tussenvoegsels']}',
				  '{$user['achternaam']}',
				  '{$user['adres']}',
				  '{$user['woonplaats']}',
				  '{$user['telefoon']}'
				)";
		$db->query($sql);
		$_SESSION['m'] = "Uw account is aangemaakt, u kan nu gaan inloggen.";
	}
}