<style type="text/css">

	#navcontainer3
	{
	background: #FCF1E3; /** light orange*/
	width: 95%;
	margin: 0 auto;
	padding: 0px;
	text-align: center;
	font-size:12px;
	}
	
	ul#navlist3
	{
	text-align: center;
	list-style: none;
	padding: 0px;
	margin: 0px;
	width: 100%;
	}
	
	ul#navlist3 li
	{
	display: block;
	margin: 3px;
	background:#AFC7C2;  /**dark green*/
	}
	
	ul#navlist3 li a
	{
	display: block;
	padding: 5px 0 0 0;
	width: 100%;
	/**padding: 0px 0 0px 10px;*/
	text-align:center
	border-width: 0px;
	/**border-color: #ffe #aaab9c #ccc #fff;*/
	text-decoration: none;
	background: #536B6C;/**grayish*/
	color:white; /**white*/
	}
	
	#navcontainer3>ul#navlist3 li a { width: auto; 
		color:white;
		padding: 5px 0 0 0;
	}
	
	ul#navlist3 li#active a
	{
		background: #52888A;/**lighter dark green*/
		color: #D8E6E7;/**grayish white*/
		padding: 5px 0 0 0;
		
	}
	
	ul#navlist3 li a:hover, ul#navlist3 li#active a:hover
	{
	background: transparent;
	/**border-color: #aaab9c #fff #fff #ccc;*/
	color:#E9F2F2;/**lighter gray;*/
		padding: 5px 0 0 0;
	}

	i{
	padding:0px;
	margin:0px
	color:black;
	}

</style>

<div id="navcontainer3" style="overflow-y:scroll;height:510px;width:100px;padding:0px;margin:0px">
<ul id="navlist3">
<li>SERVICE</li>
<li><a href="${ui.pageLink("nursingkardex", "nursingWardCensusReport")}">Form</a></li>
<li><a href="${ui.pageLink("nursingkardex", "nursingWardCensusReport")}">Report</a></li>
</ul>
</div>