<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<head>
<meta charset="UTF-8">
<title>Cart</title>
</head>
<body>
	<div class="row">
		<div class="span12">
			<ul class="breadcrumb">
				<li><a href="index.html">Home</a> <span class="divider">/</span></li>
				<li class="active">List Cart</li>
			</ul>
			<div class="well well-small">
				<h1>
					List Cart <small class="pull-right"> ${TotalQuatityCart} Items are in the
						cart </small>
				</h1>
				<hr class="soften" />

				<table class="table table-bordered table-condensed">
					<thead>
						<tr>
							<th>Product</th>
							<th>Description</th>
							<th>Color</th>
							<th>Unit price</th>
							<th>Qty</th>
							<th>Edit</th>
							<th>Delete</th>
							<th>Total</th>
						</tr>
					</thead>
					<tbody>
							<c:forEach var="item" items="${Cart }">
								<tr>
									<td><img width="100" src="<c:url value="/assets/user/img/${item.value.product.img }"/>" alt=""></td>
									<td>${item.value.product.name }<br>Carate : 22<br>Model :
										n/a
									</td>

									<td><span class="shopBtn" style="background-color: ${item.value.product.code}"><span class="icon-ok"></span></span>
									</td>
									<td>$<fmt:formatNumber
												type="number" groupingUsed="true" value="${item.value.product.price }" /></td>

									<td><input type="number" min="1" class="span1"
										style="max-width: 34px" placeholder="1"
										id="quatity-cart-${item.key }" size="16" type="text" value="${item.value.quatity }">
										<div class="input-append">
											<button class="btn btn-mini" type="button">-</button>
											<button class="btn btn-mini" type="button">+</button>
										</div></td>

									<td><button data-id="${item.key }"
										class="btn btn-mini btn-danger edit-cart" type="button"> <span
											class="icon-edit"></span>
									</button></td>
									<td><a href="<c:url value="/DeleteCart/${item.key }"></c:url>"
										class="btn btn-mini btn-danger" type="button"> <span
											class="icon-remove"></span>
									</a></td>

									<td>$<fmt:formatNumber
												type="number" groupingUsed="true" value="${item.value.totalPrice }" /></td>
								</tr>
							</c:forEach>


						<tr>
							<td colspan="7" class="alignR">Total products:</td>
							<td style="color:red">$<fmt:formatNumber
												type="number" groupingUsed="true" value="${TotalPriceCart}" /></td>
						</tr>
					</tbody>
				</table>
				<br />


				<table class="table table-bordered">
					<tbody>
						<tr>
							<td>
								<form class="form-inline">
									<label style="min-width: 159px"> VOUCHERS Code: </label> <input
										type="text" class="input-medium" placeholder="CODE">
									<button type="submit" class="shopBtn">ADD</button>
								</form>
							</td>
						</tr>

					</tbody>
				</table>
				<table class="table table-bordered">
					<tbody>
						<tr>
							<td>ESTIMATE YOUR SHIPPING & TAXES</td>
						</tr>
						<tr>
							<td>
								<form class="form-horizontal">
									<div class="control-group">
										<label class="span2 control-label" for="inputEmail">Country</label>
										<div class="controls">
											<input type="text" placeholder="Country">
										</div>
									</div>
									<div class="control-group">
										<label class="span2 control-label" for="inputPassword">Post
											Code/ Zipcode</label>
										<div class="controls">
											<input type="password" placeholder="Password">
										</div>
									</div>
									<div class="control-group">
										<div class="controls">
											<button type="submit" class="shopBtn">Click to check
												the price</button>
										</div>
									</div>
								</form>
							</td>
						</tr>
					</tbody>
				</table>
				<a href="products.html" class="shopBtn btn-large"><span
					class="icon-arrow-left"></span> Continue Shopping </a> <a
					href="login.html" class="shopBtn btn-large pull-right">Next <span
					class="icon-arrow-right"></span></a>

			</div>
		</div>
	</div>
	<content tag="script">
	<script>
		$(".edit-cart").on("click",function(){
			var id = $(this).data("id");
			var quatity = $("#quatity-cart-" + id).val();
			//alert(quatity);
			window.location = "EditCart/" + id + "/"+ quatity;
		});
	</script>
	</content>
</body>