<div>
    <h3>${ ui.message("nursingkardex.diet") }</h3>

    <ul>
        <% prevDiets.each{ %>
        <li>${ it }</li>
        <% } %>

    </ul>
    <br>
    ${ui.includeFragment("uilibrary", "widget/button", [
        label: ui.message("nursingkardex.addDiet"),
        href: "addDiet.page"])
    }
</div>