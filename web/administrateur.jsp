<%-- 
    Document   : administrateur
    Created on : 30 déc. 2014, 01:42:28
    Author     : hedi
--%>


<%@page import="java.sql.Connection"%>
<%@page import="singleton.ConnectionDb"%>
<%@page import="java.util.Vector"%>
<%@page import="DAO.Article"%>
<%@page import="DAO.ArticleDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    
    if(session.getAttribute("login") == null)
    {
     response.sendRedirect("index.jsp");;
    }
    
    
%> 
<!DOCTYPE html> <html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>Home | E-Shopper</title>
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/font-awesome.min.css" rel="stylesheet">
    <link href="css/prettyPhoto.css" rel="stylesheet">
    <link href="css/price-range.css" rel="stylesheet">
    <link href="css/animate.css" rel="stylesheet">
	<link href="css/main.css" rel="stylesheet">
	<link href="css/responsive.css" rel="stylesheet">
    <!--[if lt IE 9]>
    <script src="js/html5shiv.js"></script>
    <script src="js/respond.min.js"></script>
    <![endif]-->       
    <link rel="shortcut icon" href="images/ico/favicon.ico">
    <link rel="apple-touch-icon-precomposed" sizes="144x144" href="images/ico/apple-touch-icon-144-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="114x114" href="images/ico/apple-touch-icon-114-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="72x72" href="images/ico/apple-touch-icon-72-precomposed.png">
    <link rel="apple-touch-icon-precomposed" href="images/ico/apple-touch-icon-57-precomposed.png">
</head><!--/head-->

<body>
	<header id="header"><!--header-->
		<div class="header_top"><!--header_top-->
			<div class="container">
				<div class="row">
					<div class="col-sm-6">
						<div class="contactinfo">
							<ul class="nav nav-pills">
								<li><a href="#"><i class="fa fa-phone"></i> (+216) 22 41 29 13</a></li>
								<li><a href="#"><i class="fa fa-envelope"></i> contact: medhedi.haddar@gmail.com</a></li>

							</ul>
						</div>
					</div>
					<div class="col-sm-6">
						<div class="social-icons pull-right">
							<ul class="nav navbar-nav">
								<li><a href="#"><i class="fa fa-facebook"></i></a></li>
								<li><a href="#"><i class="fa fa-twitter"></i></a></li>
								<li><a href="#"><i class="fa fa-linkedin"></i></a></li>
								<li><a href="#"><i class="fa fa-dribbble"></i></a></li>
								<li><a href="#"><i class="fa fa-google-plus"></i></a></li>
							</ul>
						</div>
					</div>
				</div>
			</div>
		</div><!--/header_top-->
		
		<div class="header-middle"><!--header-middle-->
			<div class="container">
				<div class="row">
					<div class="col-sm-3">
						<div class="logo pull-left">
							<a href="index.html"><img src="images/home/logo.png" alt="" /></a>
						</div>
						<!--<div class="btn-group pull-right">
							<div class="btn-group">

								<button type="button" class="btn btn-default dropdown-toggle usa" data-toggle="dropdown">
									USA
									<span class="caret"></span>
								</button>
								<ul class="dropdown-menu">
									<li><a href="#">Canada</a></li>
									<li><a href="#">UK</a></li>
								</ul>
							</div>
							
							<div class="btn-group">
								<button type="button" class="btn btn-default dropdown-toggle usa" data-toggle="dropdown">
									DOLLAR
									<span class="caret"></span>
								</button>
								<ul class="dropdown-menu">
									<li><a href="#">Canadian Dollar</a></li>
									<li><a href="#">Pound</a></li>
								</ul>
							</div>
						</div>-->
					</div>
						<div class="col-sm-4 ">
						<div class="search_box pull-right">
							<input type="text" placeholder="Search"/>
							<a href=""><i class="fa fa-search"></i></a>
						</div>
					</div>
					<div class="col-sm-5">
						<div class="shop-menu pull-right">	
							<ul class="nav navbar-nav">
                                                                <li><a href="#"><i class="fa fa-user"></i><%=session.getAttribute("page")%></a></li>
								<li><a href="#"><i class="fa fa-user"></i> ADMINISTRATEUR</a></li>
								<li><a href="#">|</a></li>
                                                                
								<li><a href="logout.jsp"><i class="fa fa-unlock"></i> Déconnecter</a></form></li>
                                                                
                                                        </ul>
						</div>
					</div>
				</div>
			</div>
		</div><!--/header-middle-->
	
		<div class="header-bottom"><!--header-bottom-->
			<div class="container">
				<div class="row">
					<div class="col-sm-12">
						<div class="navbar-header">
							<button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
								<span class="sr-only">Toggle navigation</span>
								<span class="icon-bar"></span>
								<span class="icon-bar"></span>
								<span class="icon-bar"></span>
							</button>
						</div>
						<div class="mainmenu pull-left">
							<ul class="nav navbar-nav collapse navbar-collapse">
								<li><a href="index.html" class="active"><i class="fa fa-home"></i> Home</a></li>
                                                                <li class="dropdown"><a href="administrateur.jsp"><i class="fa fa-circle"></i> Gestion Articles</a>     </li> 
                                                                <li class="dropdown"><a href="gestionclient.jsp"><i class="fa fa-users"></i> Gestion Clients</a> </li> 
                                                                <li class="dropdown"><a href="gestioncommande.jsp"><i class="fa fa-file-text"></i> Gestion Commandes</a></li> 		
							</ul>
						</div>
					</div>
				</div>
			</div>
		</div><!--/header-bottom-->
	</header><!--/header-->

	
	<section>
		<div class="container">
			<div class="row">
				
				
				<div class="col-sm-12 ">
                                    <% if (session.getAttribute("page").equals("liste")) { %>
                                   
                                    
                                    <div class="t-article">                                        
                                        <p>Liste des articles</p>  
                                       
                                    <table border="0">
                                        <thead>
                                            <tr>
                                                <th></th>
                                                <th>Reference</th>
                                                <th>Article</th>
                                                <th>Description</th>
                                                <th>Prix</th>
                                                <th>Qte</th>
                                                <th>Action</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <%
                                                ArticleDAO dao = new ArticleDAO();
                                             Vector<Article> articles = dao.listerArticles();          
                                                for(int i = 0; i< articles.size(); i ++)              
                                             { 
                                            %>
                                            <tr>
                                        <form action="GestionArticle" method="GET" >
                                                <td class="small-img"><img src="images/articles/<%= articles.get(i).getImg() %>"></td>
                                                <td><%= articles.get(i).getRef()%></td>
                                                <td ><%= articles.get(i).getNom() %></td>
                                                <td><%= articles.get(i).getDes()%></td>
                                                <td id="prix-c"><%= articles.get(i).getPrix()%> DT</td>
                                                <td><%= articles.get(i).getQte()%></td>
                                                <td>
                                                    <input type="hidden" value="<%= articles.get(i).getRef()%>" name="reference">
                                                    <button class="btn btn-red" type="submit" value="supprimer" name="supprimer"  >supprimer  <i class="fa fa-trash-o"></i></button>
                                                    <button class="btn btn-green" type="submit" value="modifier" name="modifier" >modifier  <i class="fa fa-edit"></i></button>
                                                </td>
                                                
                                        </form>        
                                            </tr>
                                            <%} 
                                            %>
                                        </tbody>
                                    </table>
                                    </div>
                                        <%}
                                    else if ((session.getAttribute("page").equals("modifier"))){
                                        
                                            int a =Integer.parseInt(session.getAttribute("reference") + "");
                                               ArticleDAO dao = new ArticleDAO();
                                             Vector<Article> articles = dao.listerArticlesByRef(a);      
                                        %>
                                           <div class="t-article-modif">                                        
                                              <p> Article a modifier </p>
                                              <div class="col-sm-4">
                                                  <div class="image_modif">
                                                      <img src="images/articles/<%=articles.get(0).getImg()%>">
                                                      <p><%=articles.get(0).getNom()%></p>
                                                  </div>
                                                  
                                              </div>
                                               
                                                <div class="col-sm-offset-4">
                                                    <form method="POST" action="ModifierArticle_servlet" >
                                                        <table> 
                                                                <tr>
                                                                    <td>num article :</td><td><input type="number" name="ref_art" id="ref_art" value="<%=articles.get(0).getRef()%>" readonly ></td>
                                                                </tr>
                                                                <tr>
                                                                    <td>Nom article :</td><td><input type="text" name="nom_art" id="nom_art" value="<%=articles.get(0).getNom()%>" required ></td>
                                                                </tr>
                                                                <tr>
                                                                    <td>description :</td> <td><input type="text" name="des_art" id="des_art" value="<%=articles.get(0).getDes()%>" required ></td>
                                                                </tr>
                                                                <tr>
                                                                    <td>Prix :</td><td><input type="number" name="prix_art" id="prix_art" value="<%=articles.get(0).getPrix()%>" required ></td>
                                                                </tr>
                                                                <tr>
                                                                    <td>Quantité :</td><td><input type="number"  name="qte_art" id="qte_art" value="<%=articles.get(0).getQte()%>" required></td>
                                                                </tr>
                                                                <tr>
                                                                    <td>Image :</td><td class="sansdecore"><input type="file" name="image_art" id="image_art"  ></td>
                                                                </tr>
           
           
                                                                    <td></td><td class="sansbordure " >
                                                                        <input type="hidden" value="<%=articles.get(0).getImg()%>" name="old_img">
                                                                        <button class="btn btn-green" type="submit" value="modifier" name="modifier" >Modifier  <i class="fa fa-edit"></i></button>
                                                                        <button class="btn btn-red" type="submit" value="retour" name="retour" >annuler <i class="fa fa-arrow-circle-left"></i></button>
         
                                                        </table>
                                                    </form>
                                                </div>
                                           </div>
                                               
					<%} 
                                    else{%>
                                    <div class="col-sm-12">
                                        <div class="col-sm-4">
                                            <di><i class="fa fa-5x fa-user"></i></di>
                                        </div>
                                        <div class="col-sm-4"></div>
                                        <div class="col-sm-4"></div>
                                    </div>
                                    
                                    <%}%>
					<!--/category-tab-->
					
					<!--/recommended_items-->
					
				</div>
			</div>
		</div>
	</section>
	
	
	<footer id="footer"><!--Footer-->
		
		
		<div class="footer-widget">
			<div class="container">
				<div class="row">
					<div class="col-sm-9">
						<div class="single-widget">
							<script type="text/javascript" src="http://maps.google.com/maps/api/js?sensor=false"></script><div style="overflow:hidden;height:300px;width:850px;"><div id="gmap_canvas" style="height:300px;width:850px;"></div><style>#gmap_canvas img{max-width:none!important;background:none!important}</style><a class="google-map-code" href="http://www.trivoo.net/gutscheine/sheego/" id="get-map-data">sheego gutschein</a></div><script type="text/javascript"> function init_map(){var myOptions = {zoom:13,center:new google.maps.LatLng(35.8352413,10.612540800000033),mapTypeId: google.maps.MapTypeId.ROADMAP};map = new google.maps.Map(document.getElementById("gmap_canvas"), myOptions);marker = new google.maps.Marker({map: map,position: new google.maps.LatLng(35.8352413, 10.612540800000033)});infowindow = new google.maps.InfoWindow({content:"<b>exotec</b><br/>polytech sousse<br/> sousse" });google.maps.event.addListener(marker, "click", function(){infowindow.open(map,marker);});infowindow.open(map,marker);}google.maps.event.addDomListener(window, 'load', init_map);</script>
							
						</div>
					</div>
					
					
					
					<div class="col-sm-3">
						<div class="single-widget">
							<h2>GERANT</h2>
							<img src="images/hedi.jpg">
								<p>HADDAR MOHAMMED HEDI <p>
						</div>
					</div>
					
				</div>
			</div>
		</div>
		
		<div class="footer-bottom">
			<div class="container">
				<div class="row">
					<p class="pull-left">Copyright © 2013 E-SHOPPER Inc. All rights reserved.</p>
					<p class="pull-right">Designed by <span><a target="_blank" href="http://www.themeum.com">HADDAR MOHAMMED HEDI</a></span></p>
				</div>
			</div>
		</div>
		
	</footer>
	

  
    <script src="js/jquery.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/jquery.scrollUp.min.js"></script>
	<script src="js/price-range.js"></script>
    <script src="js/jquery.prettyPhoto.js"></script>
    <script src="js/main.js"></script>
</body>
</html>