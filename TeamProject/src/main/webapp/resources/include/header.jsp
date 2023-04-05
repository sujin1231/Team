<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-idth, initial-scale=1">
   

    <title>영화 커뮤니티</title>

    <!-- Bootstrap Core CSS -->
    <link href="${pageContext.request.contextPath }/resources/css/bootstrap.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="${pageContext.request.contextPath }/resources/css/business-casual.css" rel="stylesheet">

    <!-- Fonts -->
    <link href="https://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Josefin+Slab:100,300,400,600,700,100italic,300italic,400italic,600italic,700italic" rel="stylesheet" type="text/css">
	
	 <!-- jQuery -->
    <script src="${pageContext.request.contextPath }/resources/js/jquery.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="${pageContext.request.contextPath }/resources/js/bootstrap.min.js"></script>

    <!-- Script to Activate the Carousel -->
    <script>
    $('.carousel').carousel({
        interval: 2000 //changes the speed
    })
    </script>

    
    
</head>

<body>
	<!-- header -->
	<div class="brand">(가제)영화 커뮤니티</div>        
    <div class="address-bar">영화 좋아하신다구요? 얼른 가입하세요 ^o^</div>
		
    
    <nav class="navbar navbar-default" role="navigation">
        <div class="container">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                
                <a class="navbar-brand" href="/">영화 커뮤니티</a>
            </div>
           
                    
                    <!-- 세션이 없다면 로그인과 조인 메뉴를 나타냄. 
                   	<c:choose>
	                    	<c:when test="${sessionScope.user_id == null }">
	                    <li>
	                        <a href="/user/user_login">LOGIN</a>
	                    </li>
	                    <li>
	                        <a href="/user/user_join" style="color:red">JOIN</a>
	                    </li>
	                   		</c:when>
	                   		<c:otherwise>
	                    <li>
	                        <a href="/user/user_logout">LOGOUT</a>
	                    </li>
	                    <li>
	                        <a href="/user/user_mypage" style="color:red">MyPage</a>
	                    </li>
	                    	</c:otherwise>
					</c:choose>
					-->
             
            
            
            <!-- /.navbar-collapse -->
        </div>
        <!-- /.container -->
    </nav>
 	<!-- end header -->
 	
 	
	  