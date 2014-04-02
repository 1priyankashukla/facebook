<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<style>
.alert-box {
    color:#555;
    
    font-family:Tahoma,Geneva,Arial,sans-serif;font-size:18px;
    
    
    background:#ffecec url('images/error.png') no-repeat 10px 50%;
    
}
</style>
<head>
<script>
function validateForm()
{
var x=document.forms["signUpForm"]["fname"].value;
if (x==null || x=="")
  {
  alert("First name must be filled out");
  return false;
  }
}
</script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="shortcut icon" href="Images\favicon.ico">
<title>Welcome to Facebook</title>
</head>

<body style="background-color:#EEEEEE">

<div style="position:static;width:1500px;height:100px;background-color:#3b5998">
 <form action="login"><br>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; 
 &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
 <font color="white" size="7"><b> facebook </b></font>
 &nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
 &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
 &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; 
  <font color="white" size="2">Email or Phone </font><input type="text" name="emailOrPhone" size="18" >
  <font color="white" size="2">Password </font><input type="password" name="password" size="18">
  <input type="submit" value="Log in">
<s:if test="hasActionErrors()"> <div class="alert-box"> <s:actionerror/> </div> </s:if>
</form>
</div>
  <div id="content" style="position:absolute; background-color:#EEEEEE;height:1000px;width:1500px;left:700px;top:120px">
  
 <h1><b> Create an account</b></h1>
<h3>It's free and always will be.</h3>
<form name="signUpForm" action="signUp" onsubmit="return validateForm()" method="post">

<br>
<br>
   <input type="text" name="fname" placeholder="First Name" size="22" style="height:39px">
   <input type="text" name="lname" placeholder="Last Name" size="21" style="height:39px"><br><br>
   <input type="text" name="email" placeholder="Your email address" size="50" style="height:39px"><br><br>
  <input type="text" name="reEnteredEmail" placeholder="Re-enter email address" size="50" style="height:39px"><br><br>
  <input type="password" name="password" placeholder="New Password" size="50" style="height:39px"><br><br>
 
<label for="birthday">Birthday</label>
<br><br>
<select name="day">
  <option value="-1">Day</option>
  <option value="d1">1</option>
  <option value="d2">2</option>
  <option value="d3">3</option>
  <option value="d4">4</option>
  <option value="d5">5</option>
  <option value="d6">6</option>
  <option value="d7">7</option>
  <option value="d8">8</option>
  <option value="d9">9</option>
  <option value="d10">10</option>
  <option value="d">11</option>
  <option value="d">12</option>
  <option value="d">13</option>
  <option value="d">14</option>
  <option value="d">15</option>
  <option value="d">16</option>
  <option value="d">17</option>
  <option value="d">18</option>
  <option value="d">19</option>
  <option value="d">20</option>
  <option value="d">21</option>
  <option value="d">22</option>
  <option value="d">23</option>
  <option value="d">24</option>
  <option value="d">25</option>
  <option value="d">26</option>
  <option value="d">27</option>
  <option value="d">28</option>
  <option value="d">29</option>
  <option value="d">30</option>
  <option value="d">31</option>
</select>
<select name="month">
  <option value="-1">Month</option>
  <option value="jan">Jan</option>
  <option value="feb">Feb</option>
  <option value="mar">Mar</option>
  <option value="apr">Apr</option>
  <option value="may">May</option>
  <option value="jun">Jun</option>
  <option value="jul">Jul</option>
  <option value="aug">Aug</option>
  <option value="sept">Sept</option>
  <option value="oct">Oct</option>
  <option value="nov">Nov</option>
  <option value="dec">Dec</option>
  
  </select>
<select name="year">
  <option value="-1">Year</option>
  <option value="1">2014</option>
  <option value="2">2013</option>
  <option value="3">2012</option>
  <option value="4">2011</option>
  <option value="5">2010</option>
  <option value="6">2009</option>
  <option value="7">2008</option>
  <option value="8">2007</option>
  <option value="9">2006</option>
  <option value="10">2005</option>
  <option value="11">2004</option>
  <option value="12">2003</option>
  <option value="13">2002</option>
  <option value="14">2001</option>
  <option value="15">2000</option>
  <option value="16">1999</option>
  <option value="17">1998</option>
  <option value="18">1997</option>
  <option value="19">1996</option>
  <option value="20">1995</option>
  <option value="21">1994</option>
  <option value="22">1993</option>
  <option value="23">1992</option>
  <option value="24">1991</option>
  <option value="25">1990</option>
  <option value="26">1989</option>
  <option value="27">1988</option>
  <option value="28">1987</option>
  <option value="29">1986</option>
  <option value="30">1985</option>
  <option value="31">1984</option>
  <option value="32">1983</option>
  <option value="33">1982</option>
  <option value="34">1981</option>
  <option value="35">1980</option>
  <option value="36">1979</option>
  <option value="37">1978</option>
  <option value="38">1977</option>
  <option value="39">1976</option>
  <option value="40">1975</option>
  <option value="41">1974</option>
  <option value="42">1973</option>
  <option value="43">1972</option>
  <option value="44">1971</option>
  <option value="45">1970</option>
  <option value="46">1969</option>
  <option value="47">1968</option>
  <option value="48">1967</option>
  <option value="49">1966</option>
  <option value="50">1965</option>
  <option value="51">1964</option>
  <option value="52">1963</option>
  <option value="53">1962</option>
  <option value="54">1961</option>
  <option value="55">1960</option>
  <option value="56">1959</option>
  <option value="57">1958</option>
  <option value="58">1957</option>
  <option value="59">1956</option>
  <option value="60">1955</option>
  <option value="61">1954</option>
  <option value="62">1953</option>
  <option value="63">1952</option>
  <option value="64">1951</option>
  <option value="65">1950</option>
  <option value="66">1949</option>
  <option value="67">1948</option>
  <option value="68">1947</option>
  <option value="69">1946</option>
  <option value="70">1945</option>
  <option value="71">1944</option>
  <option value="72">1943</option>
  <option value="73">1942</option>
  <option value="74">1941</option>
  <option value="75">1940</option>
  <option value="76">1939</option>
  <option value="77">1938</option>
  <option value="78">1937</option>
  <option value="79">1936</option>
  <option value="80">1935</option>
  <option value="90">1934</option>
  <option value="100">1933</option>
  <option value="101">1932</option>
  <option value="102">1931</option>
  <option value="103">1930</option>
  <option value="104">1929</option>
  <option value="105">1928</option>
  <option value="106">1927</option>
  <option value="107">1926</option>
  <option value="108">1925</option>
  <option value="109">1924</option>
  <option value="110">1923</option>
  <option value="111">1922</option>
  <option value="112">1921</option>
  <option value="113">1920</option>
  <option value="114">1919</option>
  <option value="115">1918</option>
  <option value="116">1917</option>
  <option value="117">1916</option>
  <option value="118">1915</option>
  <option value="119">1914</option>
  <option value="120">1913</option>
  <option value="121">1912</option>
  <option value="122">1911</option>
  <option value="123">1910</option>
  <option value="124">1909</option>
  <option value="125">1908</option>
  <option value="126">1907</option>
  <option value="125">1906</option>
  <option value="126">1905</option>
  
  </select>
<br><br>
 <input type="radio" name="gender" id="female" value="female">
 <label for="female">Female</label>
 
 <input type="radio" name="gender" id="male" value="male">
  <label for="male">Male</label>
  <br><br>
  <input type="image" src="Images\b1.png" alt="Create an account" width="260" height="65"><br></form>
</div>
</body>
</html>