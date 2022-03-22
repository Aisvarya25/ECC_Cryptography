import React from 'react';
import { BrowserRouter as Router, Switch, NavLink ,Route, Link } from "react-router-dom";
import Login from './Login';
import Registration from './Registration';
const Header = () => {
  return (
    <div>
       
    <div id="preloader">
        <div class="loader">
			<div class="loader__bar"></div>
			<div class="loader__bar"></div>
			<div class="loader__bar"></div>
			<div class="loader__bar"></div>
			<div class="loader__bar"></div>
			<div class="loader__ball"></div>
		</div>
    </div>

    
	<div class="top-bar">
		<div class="container-fluid">
			<div class="row">
				<div class="col-md-6 col-sm-6">
					<div class="left-top">
						
						<div class="phone-box">
							
						</div>
					</div>
				</div>
				<div class="col-md-6 col-sm-6">
					<div class="right-top">
						<div class="social-box">
							<ul>
				
							</ul>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
    <header class="header header_style_01">
        <nav class="megamenu navbar navbar-default">
            <div class="container-fluid">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="index.html"><img src="./images/logos/logo.png" alt="image" /></a>
                </div>
                <div id="navbar" class="navbar-collapse collapse">
                    <ul class="nav navbar-nav navbar-right">
                        <li><NavLink to="/">Home</NavLink></li>
                        
                        <li><a href="services.html">Our Services</a></li>
                        <li><NavLink to="/Registration">Registration</NavLink></li>						
                        <li><NavLink to="/Login">Login</NavLink></li>                     
						<li></li>
                       

                    </ul>

                    <Switch> 
                        <Route path="/Registration" element={ <Registration /> } > Registration </Route> 
                        <Route path="/Login" element={ <Login /> } > Login </Route> 
					</Switch> 

                </div>
            </div>
        </nav>
    </header>
	
	<div class="slider-area">
		<div class="slider-wrapper owl-carousel">
			<div class="slider-item home-one-slider-otem slider-item-four slider-bg-one">
				<div class="container">
					<div class="row">
						<div class="slider-content-area">
							<div class="slide-text">
								<h1 class="homepage-three-title">Outstanding <span>Installation</span> Services</h1>
								<h2>With GoodWEB Solutions responsive landing page template, <br />you can promote your all web design & development services. </h2>
								<div class="slider-content-btn">
									<a class="button btn btn-light btn-radius btn-brd" href="#">Read More</a>
									<a class="button btn btn-light btn-radius btn-brd" href="#">Contact</a>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="slider-item text-center home-one-slider-otem slider-item-four slider-bg-two">
				<div class="container">
					<div class="row">
						<div class="slider-content-area">
							<div class="slide-text">
								<h1 class="homepage-three-title">Outstanding <span>Installation</span> Services</h1>
								<h2>With GoodWEB Solutions responsive landing page template, <br />you can promote your all web design & development services. </h2>
								<div class="slider-content-btn">
									<a class="button btn btn-light btn-radius btn-brd" href="#">Read More</a>
									<a class="button btn btn-light btn-radius btn-brd" href="#">Contact</a>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="slider-item home-one-slider-otem slider-item-four slider-bg-three">
				<div class="container">
					<div class="row">
						<div class="slider-content-area">
							<div class="slide-text">
								<h1 class="homepage-three-title">Outstanding <span>Installation</span> Services</h1>
								<h2>With GoodWEB Solutions responsive landing page template, <br />you can promote your all web design & development services.</h2>
								<div class="slider-content-btn">
									<a class="button btn btn-light btn-radius btn-brd" href="#">Read More</a>
									<a class="button btn btn-light btn-radius btn-brd" href="#">Contact</a>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
    </div>
);
};

export default Header;