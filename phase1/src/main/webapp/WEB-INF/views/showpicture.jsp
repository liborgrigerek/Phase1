<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
<title>Show picture</title>
</head>
<body>
	<section>
		<div class="jumbotron">
			<div class="container">
				<h1>Show picture</h1>
			</div>
		</div>
	</section>
	<section class="container">
		<div class="row">
			<div class="col-sm-6 col-md-3" style="padding-bottom: 15px">
				<div class="thumbnail">
					<div class="caption">
						<h3>Picture name</h3>
						<p>${filename}</p>
						<p>
							<c:if test="${showpicture == 'true'}">
                                <h3>Picture preview</h3>
								<img src="data:image/jpeg;base64,${image}" alt="Loaded picture" width="230">
							</c:if>
							<c:if test="${showpicture == 'false'}">
                                <h3>Message</h3>
						        ${message}
                            </c:if>
						</p>
					</div>
				</div>
			</div>
		</div>
	</section>
</body>
</html>