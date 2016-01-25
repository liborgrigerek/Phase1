<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>
<meta http-equiv="Content-Type"
    content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
    href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
<title>Welcome</title>
</head>
<body>
    <section>
        <div class="jumbotron">
            <div class="container">
                <h1>Welcome page</h1>
            </div>
        </div>
    </section>
    <section class="container">
        <div class="row">
                <p>
                    <a href="<spring:url value="/showdata" />" class="btn btn-default">
                        <span class="glyphicon-hand-left glyphicon"></span>Controller1: Show test data
                    </a> 
                </p>
                <p>
                    <a href="<spring:url value="/showpicture" />" class="btn btn-default">
                        <span class="glyphicon-hand-left glyphicon"></span>Controller2: Show picture
                    </a> 
                </p>
            </div>
        </div>
    </section>
</body>
</html>