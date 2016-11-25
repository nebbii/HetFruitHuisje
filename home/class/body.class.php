<?php

// miscellaneous text 
class Body 
{
	function home(){
		echo "<h4>Welkom bij Het Fruithuisje!</h4>
		Commoda autem et incommoda in eo genere sunt, quae praeposita et reiecta diximus; Quod dicit Epicurus etiam de voluptate, quae minime sint voluptates, eas obscurari saepe et obrui. Id Sextilius factum negabat. Quasi vero, inquit, perpetua oratio rhetorum solum, non etiam philosophorum sit. An me, inquis, tam amentem putas, ut apud imperitos isto modo loquar? Suo enim quisque studio maxime ducitur. Sin dicit obscurari quaedam nec apparere, quia valde parva sint, nos quoque concedimus; Magna laus. Bonum patria: miserum exilium.";
		
	}
	
	function about(){
		echo "<h4>Over Ons</h4>
		Tum mihi Piso: Quid ergo? Primum in nostrane potestate est, quid meminerimus? Sed ego in hoc resisto; Et quidem iure fortasse, sed tamen non gravissimum est testimonium multitudinis. Aliter enim explicari, quod quaeritur, non potest. Ut necesse sit omnium rerum, quae natura vigeant, similem esse finem, non eundem. Ubi ut eam caperet aut quando?<br>
		<br>
		Maximas vero virtutes iacere omnis necesse est voluptate dominante. Nihil ad rem! Ne sit sane; Atque haec ita iustitiae propria sunt, ut sint virtutum reliquarum communia. Eademne, quae restincta siti? Quid est, quod ab ea absolvi et perfici debeat? Ab his oratores, ab his imperatores ac rerum publicarum principes extiterunt. Non enim, si omnia non sequebatur, idcirco non erat ortus illinc.";
	}
	
	function contact(){
		echo "<h4>Contact</h4>
		Eademne, quae restincta siti? Quid est, quod ab ea absolvi et perfici debeat? Ab his oratores, ab his imperatores ac rerum publicarum principes extiterunt. Non enim, si omnia non sequebatur, idcirco non erat ortus illinc.<br>
		<img width=48px src='img/social/fb.png' alt='facebook'>
		<img width=48px src='img/social/tw.png' alt='twitter'>
		";
	}
	
	function bestelling_aanmaken($db){
		$sql = "SELECT
				  `productnr`,
				  `product_soort`,
				  `product_naam`,
				  `prijs`,
				  `hoeveelheid`,
				  `eenheid`
				FROM
				  `product`";
		$result = $db->query($sql);
		while($row = $result->fetch_assoc()) {
			$store_product[$row['productnr']] = $row;
		}
		
		echo "<h4>Bestelling Aanmaken</h4>";
		echo "<form action='{$_SERVER['PHP_SELF']}?q=bestelling_aanmaken' method='POST'><table>";
		echo "<tr>";
		echo "<td>Product: </td>";
		echo "<td><select name='product'>";
		foreach($store_product as $row) {
			echo "<option value={$row['productnr']}>#{$row['productnr']} - {$row['product_naam']} &euro;{$row['prijs']} per {$row['eenheid']}</option>";
		}
		echo "</select></td>";
		echo "</tr>";
		echo "<tr><td><input type='submit'></td></tr>";
		echo "</table></form>";
	}
	
	function bestelling_aanmaken_process($db){
		$sql = "INSERT INTO `klant_order`(
					`klantnr`,
					`btw_percentage`
				) VALUES (
				  {$_SESSION['user']['klantnr']},
				  21
				)";
		$db->query($sql);
		$orderid = $db->insert_id;
		
		$sql = "INSERT INTO
				  `klant_order_item`(
					`ordernr`,
					`aantal`)
				VALUES({$orderid}, {$_POST['product']})";
		$db->query($sql);
		echo "<h4>Order Aangemaakt!</h4>";
	}
	
	function bestelling_bekijken($db) {
		echo "<h4>Bestellingen Bekijken</h4>";
		$sql = "SELECT
				  `ordernr`,
				  `klantnr`,
				  `datum_betaling`,
				  `btw_percentage`
				FROM
				  `klant_order`
				WHERE
				  `klantnr`={$_SESSION['user']['klantnr']}";
		$result = $db->query($sql);
		
		echo "<table border=1>";
		while($row = $result->fetch_assoc()) {
			foreach($row as $key => $value) {
				$store[$row['ordernr']][$key] = $value;
			}
		}
		echo "<tr>";
		echo  "<th></th>";
		echo  "<th>#</th>";
		echo  "<th>Datum</th>";
		echo "</tr>";
		foreach($store as $row) {
			echo "<tr>";
			echo "<td><a href='#'>Bekijk</a></td>";
			echo "<td>#{$row['ordernr']}</td>";
			echo "<td>{$row['datum_betaling']}</td>";
			/*foreach($row as $key => $value) {
				echo "<td>{$value}</td>";
			}*/
			echo "</tr>";
		}
		echo "</table>";
		
		//echo "<pre>";print_r($store);echo "</pre>";
	}
	
	function bestelling_bekijken_form($db,$orderid) {
		echo "<h4>Bestelling Bekijken</h4>";
		$sql = "SELECT
				  k.`productnr`,
				  k.`ordernr`,
				  k.`aantal`
				FROM
				  `klant_order_item` as k
				WHERE
				  `ordernr`={$orderid}";
	}
	
	// global function to process any table!
	function form_process($db,$action,$table,$pk){
		// build sql
		if($action=='new') {
			$sql = "INSERT INTO `{$table}`(";

			foreach ($_POST as $key => $value) 
			{
				$sql .= "`".$key."`,";
			}
			
			$sql = substr($sql,0,-1).") VALUES (";
			
			foreach ($_POST as $key => $value) 
			{
				$sql .= "\"".$value."\",";
			}
			
			$sql = substr($sql,0,-1).")";
		} elseif($action=='edit') {
			$sql = "UPDATE `{$table}` SET ";
			foreach ($_POST as $key => $value) {
				$sql .= "`".$key."` = '".$value."', ";
				if($key==$pk) { $pval=$value; }
			}
			$sql = substr($sql,0,-2); 
			
			$sql .= " WHERE `{$pk}` = '".$pval."'";
			$_SESSION['m'] = "Item gewijzigd.";
		}
		//echo $sql;
		$db->query($sql);
	}
	
	// Login processing
	function loginpage(){
		echo "<h4>Inlogpagina</h4>
		<form action='".$_SERVER['PHP_SELF']."?q=login&user=login' method='post'>
		<table>
			<tr>
				<td>Emailadres:</td>
				<td><input name='user[email]]' type='email' required></td>
			</tr>
			<tr>
				<td>Wachtwoord:</td>
				<td><input name='user[password]]' type='password' required></td>
			</tr>
			<tr>
				<td>&nbsp;</td>
				<td><input name='login' type='submit' value='Login'></td>
			</tr>
		</table>
		</form>";
	}
}