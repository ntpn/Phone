<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="javabean.PhoneInfo"%>
<!DOCTYPE HTML>
<html>
<head>
<title>The Free Smart-Sale Website Template | Details ::
	w3layouts</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
<link href='//fonts.googleapis.com/css?family=Cabin+Condensed'
	rel='stylesheet' type='text/css'>
<!--image slider-->
<script type="text/javascript" src="js/jquery-1.7.2.min.js"></script>
<!-- <script src="js/jquery-slider.js" type="text/javascript"></script> -->
<script src="js/easyResponsiveTabs.js" type="text/javascript"></script>
<link href="css/easy-responsive-tabs.css" rel="stylesheet"
	type="text/css" media="all" />
<link rel="stylesheet" href="css/global.css">
<script src="js/slides.min.jquery.js"></script>
</head>
<body>
	<div class="wrap">
		<div class="header">
			<div class="logo">
				<a href="index.html"><img src="images/logo.png" alt=""> </a>
			</div>
			<div class="clear"></div>
		</div>
		<div class="hdr-btm">
			<div class="hdr-btm-bg"></div>
			<div class="hdr-btm-left">
				<div class="search">
				</div>
				<div class="clear"></div>
			</div>
		</div>
		<div class="main">
			<div class="details">
				<%
					PhoneInfo phone = new PhoneInfo();
					if (request.getAttribute("phone") != null) {
						phone = (PhoneInfo) request.getAttribute("phone");
					} else {
				%>
				<p style="color: red;"><%=request.getAttribute("error").toString()%></p>
				<%
					}
				%>
				<div class="product-details">
					<div class="images_3_of_2">
						<div id="container">
							<div id="products_example">
								<div id="products">
									<div class="slides_container">
										<a href="#" target="_blank"><img
											src="<%=phone.getUrl_image() %>" alt="Không có hình ảnh minh họa" /></a> 
									</div>
									<ul class="pagination">
										<li><a href="#"><img
												src="<%=phone.getUrl_image() %>" alt="Không có hình ảnh minh họa" /></a></li>
									</ul>
								</div>
							</div>
						</div>
					</div>
					<div class="desc span_3_of_2">
						<h2><%=phone.getName() %></h2>
						<div class="available">
							<p>Các cửa hàng điện thoại :</p>
							<ul>
							<% if (phone.getPrice_fpt()!=null){
								%>
								<li>Cửa hàng FPT: 
									<% 
									for (int i = 0; i < phone.getPrice_fpt().size(); i++){
										%>
										<p>
										<a href="<%=phone.getUrl_link_fpt().get(i)%>">Sản phẩm</a>: giá <%=phone.getPrice_fpt().get(i) %>
									</p>
										<% 
									}
									%>	
								</li>
								<% 
							}
							%>
							<% if (phone.getPrice_hoangha()!=null){
								%>
								<li>Cửa hàng Hoàng Hà: 
									<% 
									for (int i = 0; i < phone.getPrice_hoangha().size(); i++){
										%>
										<li>
										<a href="<%=phone.getUrl_link_hoangha().get(i)%>">Sản phẩm <%=i%></a>: giá <%=phone.getPrice_hoangha().get(i) %>
									</li>
										<% 
									}
									%>	
								</li>
								<% 
							}
							%>
							<% if (phone.getPrice_tgdd()!=null){
								%>
								<li>Cửa hàng THế giới di động: 
									<% 
									for (int i = 0; i < phone.getPrice_tgdd().size(); i++){
										%>
										<li>
										<a href="<%=phone.getUrl_link_tgdd().get(i)%>">Sản phẩm <%=i%></a>: giá <%=phone.getPrice_tgdd().get(i) %>
									</li>
										<% 
									}
									%>	
								</li>
								<% 
							}
							%>
								
							</ul>
						</div>
					</div>
					<div class="clear"></div>
				</div>
				<div class="product_desc">
					<div id="horizontalTab"
						style="display: block; width: 100%; margin: 0px;">
						<div class="resp-tabs-container">
							<h2 class="resp-accordion resp-tab-active" role="tab"
								aria-controls="tab_item-0">
								<span class="resp-arrow"></span>Thông tin sản phẩm
							</h2>
							<div
								class="product-desc resp-tab-content resp-tab-content-active"
								style="display: block" aria-labelledby="tab_item-0">
								<%
								if (phone.getDisplay()!=null){
									%>
									<p>
									Display: <%=phone.getDisplay() %>
								</p>
									<% 
								}
								%>
								
								<%
								if (phone.getCpu()!=null){
									%>
									<p>
									CPU: <%=phone.getCpu()%>
								</p>
									<% 
								}
								%>
								
								<%
								if (phone.getOs()!=null){
									%>
									<p>
									Hệ điều hành: <%=phone.getOs() %>
								</p>
									<% 
								}
								%>
								
								<%
								if (phone.getSim()!=null){
									%>
									<p>
									Sim: <%=phone.getSim() %>
								</p>
									<% 
								}
								%>
								
								<%
								if (phone.getCamera()!=null){
									%>
									<p>
									Camera: <%=phone.getCamera() %>
								</p>
									<% 
								}
								%>
								
								<%
								if (phone.getPin()!=null){
									%>
									<p>
									Pin: <%=phone.getPin() %>
								</p>
									<% 
								}
								%>
								
								<%
								if (phone.getRom()!=null){
									%>
									<p>
									Rom: <%=phone.getRom() %>
								</p>
									<% 
								}
								%>
								
								<%
								if (phone.getRam()!=null){
									%>
									<p>
									Ram: <%=phone.getRam() %>
								</p>
									<% 
								}
								%>
								
								
								</div>
						</div>
					</div>
				</div>
				
			</div>
			<div class="sidebar">
				<div class="s-main">
				</div>
			</div>
			<div class="clear"></div>
		</div>
	</div>
	<div class="footer-bg">
		<div class="wrap">
			<div class="footer">
				<div class="f_nav">
					
				</div>
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