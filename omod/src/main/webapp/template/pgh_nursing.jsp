<link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css"/>
<style>

body{
	background:#EEE !important;
}

#openmrs_msg{
	position:absolute;top:70px;left:60px;width:1200px;height:25px;
}

.pghnc_leftpanel{
	position:absolute;
	top:110px;
	left:20px;
	width:160px;
}

.pghnc_frame table td{
	text-align:text-top;
}

.pghnc_frame {
   background: white;
   padding-left: 180px;
   padding-top: 10px;
   height: auto;
}
.pghnc_frame div {
   background: #abc7c7/***#689B98*/ top right;
   padding-right: 0px;
   min-height:450px;
   border-radius:10px;
}
.pghnc_frame div div {
   background: #abc7c7;/***#689B98*/ 
   padding: 10px;
   height: auto;
}



.pghnc_rightpanel{
	width:auto;
	float: right;
	margin-right:0px;
	position:relative;
	margin-top:20px;;
	text-align:left;
	
}

/**
.pghnc_rightpanel{
	width:auto;
	float: right;
	margin-right:0px;
	position:relative;
	margin-top:-430px;
	text-align:left;
	
}
*/

.pghnc_bednumbers ul{
	overflow-y:scroll;
	overflow-x:none;
	background: transparent;
	width:110px;
	margin-right:5px;
	height:420px;
	border-left: 2px dotted white;
	margin-top:-1px;
}

.pghnc_bednumbers ul li{
	background:white;
	margin-bottom:12px;
	font:green;
	margin-left:-30px;
	font-size: 12px;
	border-top-right-radius:5px;
	list-style-type:none;
	text-align:center;
	background:white;
}

.pghnc_bednumbers ul li a{
	text-decoration:none;
}
.pghnc_bednumbers ul li a:hover{
	text-decoration:underline;
}

.pghnc_menu{
	font-size:50px;
}
.pghnc_edit{
	font-size:25px;
	color:#3b3b3b;
	float:right;
	margin-top:-30px;
	margin-right:150px;
	padding:0px;
	margin-botton:0px;
}
.pghnc_save{
	font-size:34px;
	color:#3b3b3b;
	float:right;
	padding:0px;
}

.pghnc_kardexcontent table th{
	background:#c0edde;
	padding:2px;
	color:#49655C;
	font-size:12px;
}

.pghnc_kardexcontent table td{
	background:#d5e8e2;
	padding:2px;
	color:#112C54;
	font-size:12px;
}

.mediumTable td{
font-size:11px;
}

.mediumTable th{
font-size:11px;
background:#bacbcf;
}

/***NAVIGATOR 


*/

	#navcontainer
	{
	background: #D5E8E2;
	width: 95%;
	margin: 0 auto;
	padding: 0px;
	text-align: center;
	font-size:12.5px;
	}
	
	ul#navlist
	{
	text-align: center;
	list-style: none;
	padding: 0px;
	margin: 0 auto;
	width: 90%;
	}
	
	ul#navlist li
	{
	display: block;
	margin: 5px;
	background:#BFE9DC; /**light green*/
	}
	
	ul#navlist li a
	{
	display: block;
	padding: 5px 0 0 0;
	width: 100%;
	/**padding: 0px 0 0px 10px;*/
	text-align:center;
	border-width: 1px;
	border-color: #ffe #aaab9c #ccc #fff;
	border-style: solid;
	text-decoration: none;
	background:#B4DCCC; /**not so light green*/
	}
	
	#navcontainer>ul#navlist li a { width: auto; 
		color:#3A564D; /** darker green*/
		padding: 5px 0 0 0;
	}
	
	ul#navlist li#active a
	{
	background: #c0edde;/**#A2DAC8;*/ /**active*/
		padding: 5px 0 0 0;
		
	}
	
	ul#navlist li a:hover, ul#navlist li#active a:hover
	{
	background: transparent;
	border-color: #aaab9c #fff #fff #ccc;
	color:#318067;/**dark green;*/
		padding: 5px 0 0 0;
	}

	i{
	padding:0px;
	margin:0px
	color:black;
	}

/**end navig*/
.warn{
	color:red;
}

.pghnc_toplabel{
	float:right;
  	margin-right:100px;
  	background:#F1F8F5;
	background:#E0E0E0;
	color:#C8C8CD;
	border-collapse: collapse;
	border-radius:5px;
}

.pghnc_toplabel td{
	font-size:10px;/**8.5px;*/
	background:#c0edde;/**#c0edde;/**#F1F1F1;*/
	color:#47595C;/**#17594c;/**#47595C;*/
	padding:1px 5px 1px 5px;
	margin-right:15px;
	border-style: solid;
    border-width: 0px;
}
.pghnc_toplabel td span{
	font-style:italic;
	font-size:9px
}
#pghnc_info{
  	float:right;
  	background:#F1F8F5;
  	margin-top:-45px;
  	margin-right:100px;
    border-radius: 10px;
}


.pghnc_info td{
	font-size:11px;
	background:#FEFEFE;/**#C3CDE6;/**white;/**#F1F1F1;*/
	color:#47595C;
	padding-left:5px;
	margin:0px;
	text-align:left;
	border-radius: 3px;
}

.pghnc_info th{
	font-size:12px;
	background:#c0edde;
	color: #17594c;
	padding-left:5px;
	margin:0px;
	text-align:left;
}

.pghnc_info span{
	font-size:12px;
	/**font-style:italic;*/
	font-family:arial;
	color:#47595C; /**gray;/**#003326;/**black;*/
}

#pghnc_ncp{
    float:right;
	margin-right:100px;
}

#pghnc_ncp th{
	background:#F1F8F5;
	color:#2E4C48;
	font-size:11px;
}

#pghnc_ncp td{
	background:#F1F8F5;
	color:#2E4C48;
	font-size:11px;
	border-collapse: collapse;
	padding-left:5px;
}

.pghnc_ncp1{
	backgound:#F1F8F5;
	font-size: 12px;
}



.pghnc_ncp1 th{
	 background:#c0edde;
	 color: #17594c;/**#49655C;*/;
	 text-align:left;
	 vertical-align:text-top;
	 font-weight:350;
	 font-size:12px;
	 padding-left:5px;
}

.pghnc_ncp1 td{
	 background:#d5e8e2;
	 text-align:left;
	 color: #3b3b3b;/**black;/**#49655C;*/
	 vertical-align:text-top;
	 	font-size:12px;
	 	
	padding-left:5px;
	 
}


.pghnc_ncp1 span{
	margin: 0px 10px 0px 0px;
	font-size:10px;
	float:left;
	font-style:italic;
	font-weight:320;
	font-family:arial;
}

h1,h2,h3,h4,h5,h6{
	color:#003b40;
}



/**********TAB*********/
/*! jQuery UI - v1.11.4 - 2015-03-11
* http://jqueryui.com
* Includes: core.css, accordion.css, autocomplete.css, button.css, datepicker.css, dialog.css, draggable.css, menu.css, progressbar.css, resizable.css, selectable.css, selectmenu.css, slider.css, sortable.css, spinner.css, tabs.css, tooltip.css, theme.css
* To view and modify this theme, visit http://jqueryui.com/themeroller/?ffDefault=Verdana%2CArial%2Csans-serif&fwDefault=normal&fsDefault=1.1em&cornerRadius=4px&bgColorHeader=cccccc&bgTextureHeader=highlight_soft&bgImgOpacityHeader=75&borderColorHeader=aaaaaa&fcHeader=222222&iconColorHeader=222222&bgColorContent=ffffff&bgTextureContent=flat&bgImgOpacityContent=75&borderColorContent=aaaaaa&fcContent=222222&iconColorContent=222222&bgColorDefault=e6e6e6&bgTextureDefault=glass&bgImgOpacityDefault=75&borderColorDefault=d3d3d3&fcDefault=555555&iconColorDefault=888888&bgColorHover=dadada&bgTextureHover=glass&bgImgOpacityHover=75&borderColorHover=999999&fcHover=212121&iconColorHover=454545&bgColorActive=ffffff&bgTextureActive=glass&bgImgOpacityActive=65&borderColorActive=aaaaaa&fcActive=212121&iconColorActive=454545&bgColorHighlight=fbf9ee&bgTextureHighlight=glass&bgImgOpacityHighlight=55&borderColorHighlight=fcefa1&fcHighlight=363636&iconColorHighlight=2e83ff&bgColorError=fef1ec&bgTextureError=glass&bgImgOpacityError=95&borderColorError=cd0a0a&fcError=cd0a0a&iconColorError=cd0a0a&bgColorOverlay=aaaaaa&bgTextureOverlay=flat&bgImgOpacityOverlay=0&opacityOverlay=30&bgColorShadow=aaaaaa&bgTextureShadow=flat&bgImgOpacityShadow=0&opacityShadow=30&thicknessShadow=8px&offsetTopShadow=-8px&offsetLeftShadow=-8px&cornerRadiusShadow=8px
* Copyright 2015 jQuery Foundation and other contributors; Licensed MIT */

/* Layout helpers
----------------------------------*/
.ui-helper-hidden {
	display: none;
}
.ui-helper-hidden-accessible {
	border: 0;
	clip: rect(0 0 0 0);
	height: 1px;
	margin: -1px;
	overflow: hidden;
	padding: 0;
	position: absolute;
	width: 1px;
}
.ui-helper-reset {
	margin: 0;
	padding: 0;
	border: 0;
	outline: 0;
	line-height: 1.3;
	text-decoration: none;
	font-size: 100%;
	list-style: none;
}
.ui-helper-clearfix:before,
.ui-helper-clearfix:after {
	content: "";
	display: table;
	border-collapse: collapse;
}
.ui-helper-clearfix:after {
	clear: both;
}
.ui-helper-clearfix {
	min-height: 0; /* support: IE7 */
}
.ui-helper-zfix {
	width: 100%;
	height: 100%;
	top: 0;
	left: 0;
	position: absolute;
	opacity: 0;
	filter:Alpha(Opacity=0); /* support: IE8 */
}

.ui-front {
	z-index: 100;
}


/* Interaction Cues
----------------------------------*/
.ui-state-disabled {
	cursor: default !important;
}


/* Icons
----------------------------------*/

/* states and images */
.ui-icon {
	display: block;
	text-indent: -99999px;
	overflow: hidden;
	background-repeat: no-repeat;
}


/* TR overrides */
.ui-spinner .ui-icon-triangle-1-s {
	/* need to fix icons sprite */
	background-position: -65px -16px;
}
.ui-tabs {
	position: relative;/* position: relative prevents IE scroll bug (element with position: relative inside container with overflow: auto appear as "fixed") */
	padding: .2em;
}
.ui-tabs .ui-tabs-nav {
	margin: 0;
	padding: .2em .2em 0;
}
.ui-tabs .ui-tabs-nav li {
	list-style: none;
	float: left;
	position: relative;
	top: 0;
	margin: 1px .2em 0 0;
	border-bottom-width: 0;
	padding: 0;
	white-space: nowrap;
}
.ui-tabs .ui-tabs-nav .ui-tabs-anchor {
	float: left;
	padding: .5em 1em;
	text-decoration: none;
}
.ui-tabs .ui-tabs-nav li.ui-tabs-active {
	margin-bottom: -1px;
	padding-bottom: 1px;
}
.ui-tabs .ui-tabs-nav li.ui-tabs-active .ui-tabs-anchor,
.ui-tabs .ui-tabs-nav li.ui-state-disabled .ui-tabs-anchor,
.ui-tabs .ui-tabs-nav li.ui-tabs-loading .ui-tabs-anchor {
	cursor: text;
}
.ui-tabs-collapsible .ui-tabs-nav li.ui-tabs-active .ui-tabs-anchor {
	cursor: pointer;
}
.ui-tabs .ui-tabs-panel {
	display: block;
	border-width: 0;
	padding: 1em 1.4em;
	background: none;
}
.ui-tooltip {
	padding: 8px;
	position: absolute;
	z-index: 9999;
	max-width: 300px;
	-webkit-box-shadow: 0 0 5px #aaa;
	box-shadow: 0 0 5px #aaa;
}
body .ui-tooltip {
	border-width: 2px;
}

/* Component containers
----------------------------------*/
.ui-widget {
	font-family: Verdana,Arial,sans-serif;
	font-size: 12px;
	background:pink;
}
.ui-widget .ui-widget {
	font-size: 12px;
	background:yellow
}
.ui-widget input,
.ui-widget select,
.ui-widget textarea,
.ui-widget button {
	font-family: Verdana,Arial,sans-serif;
	font-size: 1em;
}
.ui-widget-content {
	border: 1px solid #aaaaaa;
	background: pink/**#ffffff url("images/ui-bg_flat_75_ffffff_40x100.png") 50% 50% repeat-x;*/
	color: #222222;
}
.ui-widget-content a {
	color: #222222;
}
.ui-widget-header {
	border: 1px solid #aaaaaa;
	background: #cccccc url("images/ui-bg_highlight-soft_75_cccccc_1x100.png") 50% 50% repeat-x;
	color: #222222;
	font-weight: bold;
}
.ui-widget-header a {
	color: #222222;
}

/* Interaction states
----------------------------------*/
.ui-state-default,
.ui-widget-content .ui-state-default,
.ui-widget-header .ui-state-default {
	border: 1px solid #d3d3d3;
	background: #e6e6e6 url("images/ui-bg_glass_75_e6e6e6_1x400.png") 50% 50% repeat-x;
	font-weight: normal;
	color: #555555;
}
.ui-state-default a,
.ui-state-default a:link,
.ui-state-default a:visited {
	color: #555555;
	text-decoration: none;
}
.ui-state-hover,
.ui-widget-content .ui-state-hover,
.ui-widget-header .ui-state-hover,
.ui-state-focus,
.ui-widget-content .ui-state-focus,
.ui-widget-header .ui-state-focus {
	border: 1px solid #999999;
	background: #dadada url("images/ui-bg_glass_75_dadada_1x400.png") 50% 50% repeat-x;
	font-weight: normal;
	color: #212121;
}
.ui-state-hover a,
.ui-state-hover a:hover,
.ui-state-hover a:link,
.ui-state-hover a:visited,
.ui-state-focus a,
.ui-state-focus a:hover,
.ui-state-focus a:link,
.ui-state-focus a:visited {
	color: #212121;
	text-decoration: none;
}
.ui-state-active,
.ui-widget-content .ui-state-active,
.ui-widget-header .ui-state-active {
	border: 1px solid #aaaaaa;
	background: #ffffff url("images/ui-bg_glass_65_ffffff_1x400.png") 50% 50% repeat-x;
	font-weight: normal;
	color: #212121;
}
.ui-state-active a,
.ui-state-active a:link,
.ui-state-active a:visited {
	color: #212121;
	text-decoration: none;
}

/* Corner radius */
.ui-corner-all,
.ui-corner-top,
.ui-corner-left,
.ui-corner-tl {
	border-top-left-radius: 4px;
}
.ui-corner-all,
.ui-corner-top,
.ui-corner-right,
.ui-corner-tr {
	border-top-right-radius: 4px;
}
.ui-corner-all,
.ui-corner-bottom,
.ui-corner-left,
.ui-corner-bl {
	border-bottom-left-radius: 4px;
}
.ui-corner-all,
.ui-corner-bottom,
.ui-corner-right,
.ui-corner-br {
	border-bottom-right-radius: 4px;
}

#tabs{
	background:white;/**#ebf4f5;*/
}

.inside_table {
	background:#E7E6FF;
	border-collapse:collapse;
	border-radius:20px;
	margin-left:30px;
	margin-right:130px;
}

.inside_table td{ 
		background:#E7E6FF;
		color:black;/**#003366;*/
		padding-left:10px;
		padding-right:10px;
		font-size:11px;
	}
	.inside_table th{ background: #E0E0E0  ;/**#E7E6FF;  /**ok #006699;/**#007f80;/**#003366;*/
	color: #001f33; /**ok white;*/
	font-size:11px;
	padding-top:8px;
	padding-bottom:5px;
	padding-left:10px;
	padding-right:10px;
	text-align:left;
	}



.content_table {
	background:#E7E6FF;
	border-collapse:collapse;
	border-radius:20px;
}

.content_table td{ 
		background: #f0f5f5;
		color:black;/**#003366;*/
		padding-left:10px;
		padding-right:10px;
		font-size:11px;
		border-width:0px;
	}
	.content_table th{ background:   #d1e0e0  ;/**#E7E6FF;  /**ok #006699;/**#007f80;/**#003366;*/
	color: #001f33; /**ok white;*/
	font-size:11px;
	padding-top:8px;
	padding-bottom:5px;
	padding-left:10px;
	padding-right:10px;
	text-align:left;
	}


.ncp_inside {
	background:#BFE9DC;
	border-radius:20px;
	margin-left:30px;
	margin-right:130px;

	 border-collapse:separate;
    border:solid black 1px;
    -moz-border-radius:6px;
}

.ncp_inside td:first-child {
     border-left: none;
}

.ncp_inside td{ 
		background:#FEFEFE;
		color:black;/**#003366;*/
		padding-left:10px;
		padding-right:10px;
		font-size:11px;
	}
	.ncp_inside th{ background: #BFE9DC  ;/**#E7E6FF;  /**ok #006699;/**#007f80;/**#003366;*/
	color:  black; /**ok white;*/
	font-size:11px;
	padding-top:8px;
	padding-bottom:5px;
	padding-left:10px;
	padding-right:10px;
	text-align:left;
	}




.indicator {
	background:#E7E6FF;
	margin-left:30px;
	margin-right:130px;
	border-left-width:2px;
}

.indicator td{ 
		background:#E7E6FF;
		color:black;/**#003366;*/
		border-top-style:none;
		border-left-style:none;
		border-right-style:none;
		padding-left:10px;
		padding-right:10px;
		font-size:11px;
		vertical-align:text-top;
	}
	.indicator th{ background: #E0E0E0  ;/**#E7E6FF;  /**ok #006699;/**#007f80;/**#003366;*/
	color: #001f33; /**ok white;*/
	font-size:11px;
	padding-top:8px;
	padding-bottom:5px;
	padding-left:10px;
	padding-right:10px;
	text-align:left;
	border-style:none;
	}



.indicator_general {
	background:#E7E6FF;
	margin-left:30px;
	margin-right:130px;
	border-left-width:2px;
}

.indicator_general td{ 
		background:#E7E6FF;
		color:black;/**#003366;*/
		border-top-style:none;
		border-left-style:none;
		border-right-style:none;
		padding-left:10px;
		padding-right:10px;
		font-size:11px;
	}
	.indicator_general th{ background: #E0E0E0  ;/**#E7E6FF;  /**ok #006699;/**#007f80;/**#003366;*/
	color: #001f33; /**ok white;*/
	font-size:11px;
	padding-top:8px;
	padding-bottom:5px;
	padding-left:2px;
	padding-right:2px;
	text-align:left;
	border-style:none;
	}

.tabletop td {
		vertical-align:top;
		text-align:left;
	}
/**
	.indicator td{ 
		background:#E7E6FF;
		color:black
		padding-left:10px;
		padding-right:10px;
		font-size:12px;
	}
	.indicator th{ background: #E0E0E0  ;
	color: #001f33; 
	font-size:12px;
	padding-top:10px;
	padding-bottom:7px;
	}

*/	
	

</style>