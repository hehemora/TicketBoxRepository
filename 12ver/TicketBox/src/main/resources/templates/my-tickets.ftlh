<#import "blocks/template.ftlh" as t>
<@t.template user>
    <h2 style="text-align: center">Ваши билеты</h2>
    <div class="card-columns" style="margin-left: 20x">
        <#list orders as order>
            <div class="card text-white bg-dark my-3 product">
                <div class="card-body" style="background-color: #dee760;">
                        <h3 class="card-title">${order.getticket().route}</h3>
            </div>
                <div class="card-footer">
                    <p><small class="text"><h5 style="text-align: center">Цена: ${order.getticket().price} ₽</small></h5></p>
                    <p><small class="text"><h5 style="text-align: center">Дата отправления: ${order.getticket().day}</small></h5></p>
                    <p><small class="text"><h5 style="text-align: center">Время начала и конца поездки: ${order.getticket().startend}</small></h5></p>
                    <p><small class="text"><h5 style="text-align: center">Место отправления: ${order.getticket().startstation}</small></h5></p>
                    <p><small class="text"><h5 style="text-align: center">Место прибытия: ${order.getticket().endstation}</small></h5></p>

                    <form action="/order/delete/${order.id}" method="post">
                        <input type="hidden" name="_csrf" value="${_csrf.token}"/>
                        <button type="submit" class="btn btn-danger m-3">                           
                        Вернуть билет
                        </button>
                    </form>
                    <form action="/order/print/${order.id}" method="post">
                        <input type="hidden" name="_csrf" value="${_csrf.token}"/>
                        <button type="submit" class="btn btn-success">                           
                        Версия для печати
                        </button>
                    </form>
                </div>
            </div>
        <#else>
            <h1 style="text-align: center">Не найдено</h1>
        </#list>
    </div>
</@t.template>