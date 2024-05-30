<#import "blocks/printtemplate.ftlh" as t>
<@t.printtemplate user>
<h2 style="text-align: center"></h2>
    <p><small class="text"><h3 style="text-align: left; margin-left: 900px">Цена: ${order.getticket().route}</small></h3></p>
    <p><small class="text"><h4 style="text-align: left; margin-left: 900px">ФИО: ${user.initials} </small></h4></p>
    <p><small class="text"><h4 style="text-align: left; margin-left: 900px">Цена: ${order.getticket().price} ₽</small></h4></p>
    <p><small class="text"><h4 style="text-align: left; margin-left: 900px">Дата отправления: ${order.getticket().day}</small></h4></p>
    <p><small class="text"><h4 style="text-align: left; margin-left: 900px">Время начала и конца поездки: ${order.getticket().startend}</small></h4></p>
    <p><small class="text"><h4 style="text-align: left; margin-left: 900px">Место отправления: ${order.getticket().startstation}</small></h4></p>
    <p><small class="text"><h4 style="text-align: left; margin-left: 900px">Место прибытия: ${order.getticket().endstation}</small></h4></p>
    <img src="http://qrcoder.ru/code/?5&4&0" style="text-align: left; margin-left: 900px" width="116" height="116" border="0" title="QR код"></a>
</@t.printtemplate>