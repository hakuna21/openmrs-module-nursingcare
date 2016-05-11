<!--<link rel="stylesheet" href="http://code.jquery.com/ui/1.10.4/themes/smoothness/jquery-ui.css">-->
<!--<script src="http://code.jquery.com/ui/1.10.4/jquery-ui.js"></script>-->
<script>
\$(function() {
var availableTags = [
"D5IMB",
"D5LR",
"D5NM",
"D5NR",
"D5NSS",
"PLR",
"PNSS",
"Kabiven",
"TPN"
];

var availableVolume = [
"1000",
"500",
"250",
"2000",
"100"
];

\$( "#tags" ).autocomplete({
source: availableTags
});
});

</script>


<div class="firstcolIVT">
<span>
<input type="checkbox" /> PNSS 1L x 8h <br/>
<input type="checkbox" /> PNSS 1L x 16h <br/>
<input type="checkbox" /> PNSS 1L x KVO <br/>
<input type="checkbox" /> D5NR 1L x 8h <br/>
<input type="checkbox" /> D5NR 1L x KVO <br/>
<table border="0">
	<tr>
		<td>
			<div class="ui-widget">
				<label for="tags">IVF: </label>
				<input id="tags">
			</div>
			
			
			<!--<input type="text" size="12" placeholder="IVF"/><br/>-->
			<input type="number" size="7" placeholder="i.e. 1000"/> mL <br/>
		 x	<input type="text" size="10" placeholder="duration"/><br/>
		</td>
	</tr>
</table>
<br/>
<input type="checkbox" /> TPN <br/>
<input type="checkbox" /> pRBC x 4h <br/>
<input type="checkbox" /> FWB x ~2h <br/>
<input type="checkbox" /> FFP x ~2h <br/>
<input type="checkbox" /> PLT x ~30 min <br/>
</span>

<span>
<h5>For BT of:</h5>
<input type="checkbox" />pRBC 
 	<input type="text" size="1"/>u';
 	s/p <input type="text" size="1"/><br/>
<input type="checkbox" />FWB 
	<input type="text" size="1"/>u';
	s/p <input type="text" size="1"/><br/>
<input type="checkbox" />FFP 
	<input type="text" size="1"/>u';
	s/p <input type="text" size="1"/><br/>
<input type="checkbox" />PLT  
	<input type="text" size="1"/>u';
	s/p <input type="text" size="1"/><br/>
<br/>
<input type="checkbox" /> AV Fistula <br/>
<input type="checkbox" /> IJ catheter <br/>
<input type="checkbox" /> Femoral catheter<br/> 
<input type="checkbox" /> Subclavian catheter  <br/>
<input type="checkbox" /> To Remove IV once consumed  <br/>
<input type="checkbox" /> Shift to Heplock  <br/>


<h5>Others</h5>
<textarea rows="2" cols="30"/>
</textarea>

<br/><br/>
<div style="margin-left:0px;">
<a href="/${ ui.contextPath() }/nursingkardex/editKardex.page#tabs-2" class="button" style="font-size:14px;color:#2F514E">
	<i class=icon-save></i>
</a>
</div>
</span>

</div>

<div class="secondcolIVT">
</div>