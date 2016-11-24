<?php

class User 
{	
	function login($user,$db) {
		$sql = "SELECT
				  `klantnr`,
				  `email`,
				  `pass`,
				  `naam`,
				  `woonplaats`,
				  `straat`,
				  `huisnummer`,
				  `postcode`
				FROM
				  `klant`
				WHERE
				 `email`='{$user['email']}' AND
				 `pass`='{$user['password']}'
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
}