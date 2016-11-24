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