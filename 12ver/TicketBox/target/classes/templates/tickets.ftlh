<#import "blocks/template.ftlh" as t>
<@t.template user>
    <form method="get" action="/">
            <div class="form-group col-md-10">
                <label style="margin-left: 100px" for="searchWord">Поиск по маршруту</label>
                <input style="margin-left: 100px"type="text" name="searchWord" <#if searchWord??>value="${searchWord}"</#if> class="form-control"
                       id="searchWord">
            </div>
            <button style="width: 30%; margin-left: 360px" type="submit" class="btn btn-dark">Поиск</button>
        </div>
    </form>
    <hr>
    <div class="card-columns" style="margin-left: 20px">
        <#list tickets as ticket>
            <#if user.email??>
                <a href="/ticket/${ticket.id}" class="product-link">
            <#else>
                <a href="/login" class="product-link">
            </#if>
                <div class="card text-white bg-dark my-3 product">
                    <div class="card-body" style="background-color: #dee760;">
                        <h5 class="card-title">${ticket.route}</h5>
                        <p class="card-text">${ticket.price} ₽</p>
                    </div>
                    <#if user.isAdmin()>
                        <div class="card-top">
                            <form action="/ticket/delete/${ticket.id}" method="post">
                                <input type="hidden" name="_csrf" value="${_csrf.token}"/>
                                <button type="submit" class="btn btn-danger m-3">
                                    Удалить
                                </button>
                            </form>
                        </div>
                    <#--  <#else>
                        <div class="card-top">
                        <form action="/ticket/buy/${ticket.id}" method="post">
                            <input type="hidden" name="ticket_id" value="${ticket.id}"/>
                            <input name="user_id" value="${user.id}"/>
                            <input type="hidden" name="_csrf" value="${_csrf.token}"/>
                            <button type="submit" class="btn btn-success">
                             Купить
                            </button>
                        </form>
                        </div>  -->
                    </#if>
                    <div class="card-footer">
                        ${ticket.day}
                        ${ticket.startend}
                    </div>
                </div>
            </a>
        <#else>
            <h1 style="text-align: center">Не найдено</h1>
        </#list>
    </div>

    <#if user.isAdmin()>
    <hr>
    <h4 style="text-align: left; margin-left: 10px">Добавить новый билет</h4>
    <form action = "/ticket/create" method = "post">
        <h5 style="text-align: left; margin-left: 10px">Маршрут:</h5> <input style="margin-left: 10px" type = "text" name="route"><br><br>
        <h5 style="text-align: left; margin-left: 10px">Цена билета:</h5> <input style="margin-left: 10px" type = "number" name="price"><br><br>
        <h5 style="text-align: left; margin-left: 10px">День:</h5> <input style="margin-left: 10px" type = "text" name="day"><br><br>
        <h5 style="text-align: left; margin-left: 10px">Время отправления и прибытия:</h5> <input style="margin-left: 10px" type = "text" name="startend"><br><br>
        <h5 style="text-align: left; margin-left: 10px">Место отправления:</h5> <input style="margin-left: 10px" type = "text" name="startstation"><br><br>
        <h5 style="text-align: left; margin-left: 10px">Место прибытия:</h5> <input style="margin-left: 10px" type = "text" name="endstation"><br><br>
        <h5 style="text-align: left; margin-left: 10px">Число мест:</h5> <input style="margin-left: 10px" type = "number" name="seatsleft"><br><br>
        <input type="hidden" name="_csrf" value="${_csrf.token}">
        <input class="btn btn-success" style="margin-left: 10px" type="submit" value="Добавить билет"/>
     </form>
    </#if>
</@t.template>