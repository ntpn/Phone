<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- Khai báo thư viện-->
<%@ page import="java.util.List"%>
<%@ page import="javabean.PhoneInfo"%>
<%@ page import="javabean.SetOfPhones"%>
<%@ page import="java.util.ArrayList"%>

<!--A Design by W3layouts
Author: W3layout
Author URL: http://w3layouts.com
License: Creative Commons Attribution 3.0 Unported
License URL: http://creativecommons.org/licenses/by/3.0/
-->
<!DOCTYPE HTML>
<html>
<head>
<title>Điện thoại di động</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
<link href='//fonts.googleapis.com/css?family=Cabin+Condensed'
	rel='stylesheet' type='text/css'>
</head>
<body>
	<div class="wrap">
		<div class="header">
			<div class="logo">
				<a href="index.html"><img src="images/logo.png" alt=""> </a>
			</div>
			<div class="clear"></div>
		</div>
		<div class="hdr-btm pad-w3l">
			<div class="hdr-btm-bg"></div>
			<div class="hdr-btm-left">
				<div class="search">
					<form action="${pageContext.request.contextPath}/home" method="get">
						<input type="text" name="input"> <input type="submit"
							value="Search" class="pad-w3l-search">
					</form>
				</div>
				<div class="clear"></div>
			</div>
		</div>
		<div class="main">
			<div class="content">
				<div class="clear"></div>
				<div class="cnt-main">
					<div class="grid">
						<div class="grid-img">
							<a href="details.html"><img src="images/pic1.jpg" alt="" /></a>
						</div>
						<div class="clear"></div>
					</div>
				</div>
				<div class="cnt-main btm">
					<div class="section group">
						<%
									SetOfPhones setOfPhones = new SetOfPhones();
									String serverOfPages = "home";
									ArrayList<PhoneInfo> phones = new ArrayList<PhoneInfo>();
									if ((request.getAttribute("listOfPhones") == null)) {
								%>
						Không có thông tin để hiển thị.
						<%
									} else {
										setOfPhones = (SetOfPhones) request.getAttribute("listOfPhones");
										//news = newsfeed.getSet();
										if (request.getAttribute("mode") == "search") {
								%>
						<p>
							Kết quả tìm kiếm cho:
							<%=request.getAttribute("input")%>. &nbsp; Có
							<%=setOfPhones.getNum()%>
							kết quả tìm kiếm.
						</p>
						<%
									} 
										for (PhoneInfo phone : setOfPhones.getSet()) {
								%>
						<div class="grid_1_of_3 images_1_of_3">
							<a
								href="${pageContext.request.contextPath}/phonedetail?id=<%=phone.getId()%>"><img
								src="<%=phone.getUrl_image()%>" width="200"  alt="" /></a>
							<a
								href="${pageContext.request.contextPath}/phonedetail?id=<%=phone.getId()%>"><h3><%=phone.getName()%></h3></a>
						</div>
						<!-- 
						<div class="grid_1_of_3 images_1_of_3">
							<a href="details.html"><img src="images/pic3.png" alt="" /></a> <a
								href="details.html"><h3>Lorem Ipsum is simply</h3></a>
							<div class="cart-b">
								<span class="price left"><sup>$91.00</sup><sub></sub></span>
								<div class="btn top-right right">
									<a href="details.html">Add to Cart</a>
								</div>
								<div class="clear"></div>
							</div>
						</div>
						 -->
						<%
									} 
								%>
						<!-- /.pagination -->

						<ul>
							<%
										long numPages = setOfPhones.getNum()/10;
											int pages = 0;
											if (setOfPhones.getNum() % 10 != 0) {
												numPages += 1;
											}
											if (request.getAttribute("pages") != null) {
												pages = (int) Integer.parseInt(request.getAttribute("pages").toString());
											}
											if (pages > 0) {
									%>
							<li><a
								href="${pageContext.request.contextPath}/<%=serverOfPages%>?input=<%=request.getAttribute("input").toString()%>&search=search&pages=<%=pages-1%>">Previous</a></li>
							<%
										}

											if (pages < numPages - 1) {
									%>
							<li><a
								href="
											${pageContext.request.contextPath}/<%=serverOfPages%>?input=<%=request.getAttribute("input").toString()%>&search=search&pages=<%=pages+1%>">Next</a></li>
							<%
										}
									%>

						</ul>

						<!-- /.pagination -->

						<%
								}
							%>
					</div>
				</div>
			</div>
			<div class="clear"></div>
		</div>
	</div>
	<div class="footer-bg">
		<div class="wrap">
			<div class="footer">
				<div class="footer1">
					<p>
						&copy; 2013 SmartSale. All rights reserved | Design by <a
							href="http://w3layouts.com/">W3layouts</a>
					</p>
				</div>
			</div>
		</div>
	</div>
</body>
</html>