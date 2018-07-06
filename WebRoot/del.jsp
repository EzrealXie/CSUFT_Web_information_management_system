<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login Page</title>
	<meta name="viewport" content="width=device-width, initial-scale=1">
  	<base href="<%=basePath%>">
	<meta property="og:title" content=""/>
	<meta property="og:image" content=""/>
	<meta property="og:url" content=""/>
	<meta property="og:site_name" content=""/>
	<meta property="og:description" content=""/>
	<meta name="twitter:title" content="" />
	<meta name="twitter:image" content="" />
	<meta name="twitter:url" content="" />
	<meta name="twitter:card" content="" />
	<link rel="shortcut icon" href="favicon.ico">
	<link href="https://fonts.googleapis.com/css?family=Open+Sans:400,700,300" rel="stylesheet" type="text/css">
	<link rel="stylesheet" href="css/bootstrap.min.css">
	<link rel="stylesheet" href="css/animate.css">
	<link rel="stylesheet" href="css/style.css">
	<script src="js/modernizr-2.6.2.min.js"></script>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false);
function hideURLbar(){ window.scrollTo(0,1); } </script>
<!-- Meta tag Keywords -->
<!-- css files -->
<link href="css/style.css" rel="stylesheet" type="text/css" media="all">
<link href="css/bootstrap.min.css" rel="stylesheet" type="text/css" media="all">
<link href="css/font-awesome.min.css" rel="stylesheet" type="text/css" media="all">
<!-- //css files -->
<!-- online-fonts -->
<link href="http://fonts.googleapis.com/css?family=Source+Sans+Pro:200,200i,300,300i,400,400i,600,600i,700,700i,900,900i&subset=latin-ext,vietnamese" rel="stylesheet">
<link href="http://fonts.googleapis.com/css?family=Roboto:100,100i,300,300i,400,400i,500,500i,700,700i,900,900iSource+Sans+Pro:200,200i,300,300i,400,400i,600,600i,700,700i,900,900i&subset=cyrillic,cyrillic-ext,greek,greek-ext,latin-ext,vietnamese" rel="stylesheet">
<!-- js -->
<script type="text/javascript" src="js/jquery-2.1.4.min.js"></script>
<!-- //js -->
<script type="text/javascript" src="js/bootstrap-3.1.1.min.js"></script>

	<script src="js/jquery.chocolat.js"></script>
	<link rel="stylesheet" href="css/chocolat.css" type="text/css" media="screen">
	<!--light-box-files -->
	<script>
	$(function() {
		$('.gallery-grid a').Chocolat();
	});
	</script>



</head>

<body>
	<div class="header" id="home">
<div class="logo">
	<a href="#"><h1>Education Hub</h1></a>
</div>
<!-- navigation -->
	<div class="ban-top-con">
		<div class="top_nav_left">
			<nav class="navbar navbar-default">
			  <div class="container-fluid">
				<!-- Brand and toggle get grouped for better mobile display -->
				<div class="navbar-header">
				  <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
					<span class="sr-only">Toggle navigation</span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
				  </button>
				</div>
				<!-- Collect the nav links, forms, and other content for toggling -->
				<div class="collapse navbar-collapse menu--shylock" id="bs-example-navbar-collapse-1">
				  <ul class="nav navbar-nav menu__list">
					<li class="active menu__item menu__item--current"><a class="menu__link scroll" href="########">Del</a></li>
				  </ul>
				</div>
			  </div>
			</nav>	
			
		</div>
		<div class="clearfix"></div>
		</div>
<!-- //navigation -->
<!-- Slider -->
	<div class="slider">
		
		<div class="callbacks_container">
			<ul class="rslides" id="slider">
				<li>
					<div class="slider-img">
						<img src="images/bg1.jpg" class="img-responsive" alt="education">
				<div class="col-md-4 col-md-push-8" style="left: 70%; width: 20%; position: absolute; top: 35%; bottom: 35%;">
					<form action="lessonedit" method="post" class="fh5co-form animate-box" data-animate-effect="fadeInRight">
						<h2>Del Class</h2>
						<div class="form-group">
							<label for=classname class="sr-only">classname</label>
							<input type="text" class="form-control" id="inputclassname" name="inputclassname" placeholder="Classname" autocomplete="off">
						</div>
						<div class="form-group">
							<label for="password" class="sr-only">Password</label>
							<input type="text" class="form-control" id="inputClassNum" name="inputClassNum" placeholder="ClassNum" autocomplete="off">
						</div>
						<div class="form-group">
							<input type="submit" value="Del" class="btn btn-primary">
						</div>
					</form>
				</div>
					</div>
					
				</li>
			</ul>
		</div>
		<div class="clearfix"></div>
	</div>
	</div>
</body>
</html>
