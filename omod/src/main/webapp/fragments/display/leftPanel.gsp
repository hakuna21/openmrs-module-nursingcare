<style type="text/css">

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
	text-align:center
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

</style>

<div id="navcontainer">
<br/>
<ul id="navlist">
<li id="active" ><a href="${ui.pageLink("nursingkardex", "nursingKardex")}" id="current">
	<i class=icon-edit></i><br/>Kardex<br/></a></li>
<li><a href="${ui.pageLink("nursingkardex", "searchKardex")}">
		<i class=icon-search></i><br/>Search<br/></a></li>
<li><a href="${ui.pageLink("nursingkardex", "patientList")}">
	<i class=icon-group></i><br/>Patient List</a></li>
<li><a href="${ui.pageLink("nursingkardex", "oRSchedule")}">
	<i class=icon-tags></i><br/>Preop Nursing<br/></a></li>
<li><a href="${ui.pageLink("nursingkardex", "nursingCareIndicator")}">
	<i class=icon-list></i><br/>Nursing Indicator<br/></a></li>
<li><a href="${ui.pageLink("nursingkardex", "nursingWardCensus")}">
	<i class=icon-bar-chart></i><br/>Ward Census<br/></a></li>


</ul>
<br/>
</div>

<br/>
