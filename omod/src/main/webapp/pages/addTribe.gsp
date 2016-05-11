<%
 ui.decorateWith("appui", "standardEmrPage")
%>

<div id="content" class="container">
   <h1>${ ui.message("nursingkardex.addDiet.title") } Tribe</h1>
   <fieldset>
       <legend>${ ui.message("nursingkardex.DietDetails") }</legend>
       <form class="simple-form-ui" id="addTribe" method="POST">
           ${ ui.includeFragment("uicommons", "field/text", [label:ui.message("nursingkardex.tribe"), formFieldName:"tribe"]) }
           ${ ui.includeFragment("uicommons", "field/text", [label:ui.message("nursingkardex.description"), formFieldName:"description"]) }
           <input type="submit" class="button" value="${ ui.message("general.save") }"/>
       </form>
   </fieldset>
</div>

