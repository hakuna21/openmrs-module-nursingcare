        <link rel="shortcut icon" type="image/ico" href="/openmrs/images/openmrs-favicon.ico"/>
        <link rel="icon" type="image/png\" href="/openmrs/images/openmrs-favicon.png"/>
        <script type="text/javascript" src="/openmrs/ms/uiframework/resource/uicommons/scripts/jquery-1.8.3.min.js?cache=1461473249705"></script>
<script type="text/javascript" src="/openmrs/ms/uiframework/resource/uicommons/scripts/jquery-ui-1.9.2.custom.min.js?cache=1461473249705"></script>
<script type="text/javascript" src="/openmrs/ms/uiframework/resource/uicommons/scripts/underscore-min.js?cache=1461473249705"></script>
<script type="text/javascript" src="/openmrs/ms/uiframework/resource/uicommons/scripts/knockout-2.1.0.js?cache=1461473249705"></script>
<script type="text/javascript" src="/openmrs/ms/uiframework/resource/uicommons/scripts/emr.js?cache=1461473249705"></script>
<script type="text/javascript" src="/openmrs/ms/uiframework/resource/uicommons/scripts/jquery.toastmessage.js?cache=1461473249705"></script>
<script type="text/javascript" src="/openmrs/ms/uiframework/resource/uicommons/scripts/jquery.simplemodal.1.4.4.min.js?cache=1461473249705"></script>
        <script type="text/javascript">
            var OPENMRS_CONTEXT_PATH = 'openmrs';
            window.translations = window.translations || {};
        </script>


<script type="text/javascript">

    var sessionLocationModel = {
        id: ko.observable(),
        text: ko.observable()
    };

    jq(function () {
        jq(".change-location a").click(function () {
            jq('#session-location').show();
            jq(this).addClass('focus');
            jq(".change-location a i:nth-child(3)").removeClass("icon-caret-down");
            jq(".change-location a i:nth-child(3)").addClass("icon-caret-up");
        });

        jq('#session-location').mouseleave(function () {
            jq('#session-location').hide();
            jq(".change-location a").removeClass('focus');
            jq(".change-location a i:nth-child(3)").addClass("icon-caret-down");
            jq(".change-location a i:nth-child(3)").removeClass("icon-caret-up");
        });

        ko.applyBindings(sessionLocationModel, jq('.change-location').get(0));
        sessionLocationModel.id(70);
        sessionLocationModel.text("DPPS");

        jq("#session-location ul.select li").click(function (event) {
            var element = jq(event.target);
            var locationId = element.attr("locationId");
            var locationName = element.attr("locationName");

            var data = { locationId: locationId };

            jq("#spinner").show();

            jq.post(emr.fragmentActionLink("appui", "session", "setLocation", data), function (data) {
                sessionLocationModel.id(locationId);
                sessionLocationModel.text(locationName);
                jq('#session-location li').removeClass('selected');
                element.addClass('selected');
                jq("#spinner").hide();

                //this is being used for dispensing app to update medication list
                if (reloadPageToUpdateListMedicationDispensingByLocation != undefined) {
                    reloadPageToUpdateListMedicationDispensingByLocation();
                }
            })

            jq('#session-location').hide();
            jq(".change-location a").removeClass('focus');
            jq(".change-location a i:nth-child(3)").addClass("icon-caret-down");
            jq(".change-location a i:nth-child(3)").removeClass("icon-caret-up");
        });
    });

</script>

<header>
    <div class="logo">
        <a href="/openmrs/referenceapplication/home.page">
            <img src="/openmrs/ms/uiframework/resource/uicommons/images/logo/openmrs-with-title-small.png"/>
        </a>
    </div>
    
    <ul class="user-options">
        <li class="identifier">
            <i class="icon-user small"></i>
            ${user }
        </li>
        <li class="change-location">
            <a href="#">
                <i class="icon-map-marker small"></i>
                <span data-bind="text: text"></span>
                <i class="icon-caret-down link"></i>
            </a>
        </li>
        <li class="logout">
            <a href="/openmrs/logout">
                Logout
                <i class="icon-signout small"></i>
            </a>
        </li>
    </ul>

    <div id="session-location">
        <div id="spinner" style="position:absolute; display:none">
            <img src="/openmrs/ms/uiframework/resource/uicommons/images/spinner.gif">
        </div>
        <ul class="select">
            
            <li class="" locationId="69" locationName="Charity">Charity</li>
            
            <li class="" locationId="56" locationName="DEM">DEM</li>
            
            <li class="selected" locationId="70" locationName="DPPS">DPPS</li>
            
            <li class="" locationId="67" locationName="OBAS">OBAS</li>
            
            <li class="" locationId="7" locationName="Outpatient Clinic">Outpatient Clinic</li>
            
        </ul>
    </div>
    
</header>

<!-- 
<ul id="breadcrumbs"></ul>

<div id="body-wrapper">
	<div id="error-message" class="note-container">
	    <div class="note error"  style="display: none" >
	        <div class="text">
	            <i class="icon-remove medium"></i>
	            
	        </div>
	        <div class="close-icon"><i class="icon-remove"></i></div>
	    </div>
	</div>
	 
	 
	<div id="info-message" class="note-container">
	    <div class="note success"  style="display: none" >
	        <div class="text">
	            <i class="icon-ok medium"></i>
	            
	        </div>
	        <div class="close-icon"><i class="icon-remove"></i></div>
	    </div>
	</div>
	
	    <div id="content" class="container">		
			<div id="home-container">
			</div>
	    </div>

</div>	 
 -->