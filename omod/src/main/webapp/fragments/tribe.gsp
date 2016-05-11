<div>
    <h3>${ ui.message("nursingkardex.tribe") }</h3>

    <ul>
        <% tribeList.each{ %>
        <li>${ it }</li>
        <% } %>

    </ul>
    <br>
    ${ui.includeFragment("uilibrary", "widget/button", [
        label: ui.message("nursingkardex.diet"),
        href: "addDiet.page"])
    }
    ${ui.includeFragment("uilibrary", "widget/button", [
        label: ui.message("nursingkardex.nursingkardex"),
        href: "nursingKardex.page"])
    }
</div>