<#import "blocks/template.ftlh" as t>
<@t.template user>
    <hr>
    <p><h1 style="text-align: center">${ticket.route}</h1></p>
    <p><small class="text-muted"><h3 style="text-align: left; margin-left: 400px">Цена билета: ${ticket.price} ₽</small></h3></p>
    <p><small class="text-muted"><h3 style="text-align: left; margin-left: 400px">Дата отправления: ${ticket.day}</small></h3></p>
    <p><small class="text-muted"><h3 style="text-align: left; margin-left: 400px">Время начала и конца поездки: ${ticket.startend}</small></h3></p>
    <p><small class="text-muted"><h3 style="text-align: left; margin-left: 400px">Место отправления: ${ticket.startstation}</small></h3></p>
    <p><small class="text-muted"><h3 style="text-align: left; margin-left: 400px">Место прибытия: ${ticket.endstation}</small></h3></p>
    <p><small class="text-muted"><h3 style="text-align: left; margin-left: 400px">Мест осталось: ${ticket.seatsleft} </small></h3></p>
    <hr>

    <#if user.email??>
        <form action="/ticket/buy/${ticket.id}" method="post">
            <input type="hidden" name="ticket_id" value="${ticket.id}">
            <input type="hidden" name="user_id" value="${user.name}">
            <input type="hidden" name="_csrf" value="${_csrf.token}"/>
            <button style="margin-left: 420px; width: 25%" type="submit" class="btn btn-success">
                Купить
            </button>
        </form>
    </#if>
</@t.template>
