<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Category</title>
<style>
.pagination {
	display: flex;
	justify-content: right;
}

.pagination a {
	color: black;
	float: left;
	padding: 8px 16px;
	text-decoration: none;
	transition: background-color .3s;
	border: 1px solid #ddd;
}

.pagination a.active {
	background-color: #f89406;
	color: white;
	border: 1px solid #f89406;
}

.pagination a:hover:not(.active) {
	background-color: #ddd;
}
</style>
</head>
<body>
	<div class="well well-small">
		<div class="row">
			<span style="margin-left: 25px; font-size: 25px; font-weight: bold;">Our
				Products</span> <select class="pull-right">
				<option>A - Z</option>
				<option>Low - High</option>
			</select>
		</div>
		
		<c:if test="${productPaginate.size() > 0 }">
				<div class="row-fluid">
			<ul class="thumbnails">
					<c:forEach var="item" items="${productPaginate }" varStatus="loop">
						<li class="span4">
					<div class="thumbnail">
						<a href="product_details.html" class="overlay"></a> <a
							class="zoomTool" href="<c:url value="/chi-tiet-san-pham/${item.id_product}"></c:url>" title="add to cart"><span
							class="icon-search"></span> QUICK VIEW</a> <a
							href="<c:url value="/chi-tiet-san-pham/${item.id_product}"></c:url>"><img src="<c:url value="/assets/user/img/${item.img}"></c:url>"
							alt=""></a>
						<div class="caption cntr">
							<p>${item.name }</p>
							<p>
								<strong> $<fmt:formatNumber
												type="number" groupingUsed="true" value="${item.price}" /></strong>
							</p>
							<h4>
								<a class="shopBtn" href="#" title="add to cart"> Add to cart
								</a>
							</h4>
							<div class="actionList">
								<a class="pull-left" href="#">Add to Wish List </a> <a
									class="pull-left" href="#"> Add to Compare </a>
							</div>
							<br class="clr">
						</div>
					</div>
				</li>
						<c:if
							test="${(loop.index + 1) % 3 == 0 || (loop.index + 1) == productPaginate.size()}">
				</ul></div>
				<c:if test="${(loop.index + 1) < productPaginate.size()}">
					<div class="row-fluid">
			<ul class="thumbnails">
				</c:if>
			</c:if>
			</c:forEach>
			</c:if>
		
		
		
		
		<!-- <div class="row-fluid">
			<ul class="thumbnails">
				<li class="span4">
					<div class="thumbnail">
						<a href="product_details.html" class="overlay"></a> <a
							class="zoomTool" href="product_details.html" title="add to cart"><span
							class="icon-search"></span> QUICK VIEW</a> <a
							href="product_details.html"><img src="assets/img/a.jpg"
							alt=""></a>
						<div class="caption cntr">
							<p>Manicure & Pedicure</p>
							<p>
								<strong> $22.00</strong>
							</p>
							<h4>
								<a class="shopBtn" href="#" title="add to cart"> Add to cart
								</a>
							</h4>
							<div class="actionList">
								<a class="pull-left" href="#">Add to Wish List </a> <a
									class="pull-left" href="#"> Add to Compare </a>
							</div>
							<br class="clr">
						</div>
					</div>
				</li>
				<li class="span4">
					<div class="thumbnail">
						<a href="product_details.html" class="overlay"></a> <a
							class="zoomTool" href="product_details.html" title="add to cart"><span
							class="icon-search"></span> QUICK VIEW</a> <a
							href="product_details.html"><img src="assets/img/b.jpg"
							alt=""></a>
						<div class="caption cntr">
							<p>Manicure & Pedicure</p>
							<p>
								<strong> $22.00</strong>
							</p>
							<h4>
								<a class="shopBtn" href="#" title="add to cart"> Add to cart
								</a>
							</h4>
							<div class="actionList">
								<a class="pull-left" href="#">Add to Wish List </a> <a
									class="pull-left" href="#"> Add to Compare </a>
							</div>
							<br class="clr">
						</div>
					</div>
				</li>
				<li class="span4">
					<div class="thumbnail">
						<a href="product_details.html" class="overlay"></a> <a
							class="zoomTool" href="product_details.html" title="add to cart"><span
							class="icon-search"></span> QUICK VIEW</a> <a
							href="product_details.html"><img src="assets/img/c.jpg"
							alt=""></a>
						<div class="caption cntr">
							<p>Manicure & Pedicure</p>
							<p>
								<strong> $22.00</strong>
							</p>
							<h4>
								<a class="shopBtn" href="#" title="add to cart"> Add to cart
								</a>
							</h4>
							<div class="actionList">
								<a class="pull-left" href="#">Add to Wish List </a> <a
									class="pull-left" href="#"> Add to Compare </a>
							</div>
							<br class="clr">
						</div>
					</div>
				</li>
			</ul>
		</div> -->



	</div>
	<div class="pagination">
	<a href="#">&laquo;</a>
	<c:forEach var="item" begin= "1" end="${paginateInfo.totalPage }" varStatus="loop">
		 <c:if test="${(loop.index) == paginateInfo.currentPage}">
		 <a href='<c:url value="/san-pham/${idCate }/${loop.index }"></c:url>' class="active">${loop.index }</a>
		 </c:if>
		 <c:if test="${(loop.index) != paginateInfo.currentPage}">
		 <a href="<c:url value="/san-pham/${idCate }/${loop.index }"></c:url>">${loop.index }</a>
		 </c:if>
		</c:forEach>
		<a href="#">&raquo;</a>
		 
		
	</div>
</body>
</html>