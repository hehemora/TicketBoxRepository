<#import "blocks/template.ftlh" as t>
<@t.template user>
    <h1 style="text-align: center">Личный кабинет</h1>
    <div style="text-align: center">
        <h2>${user.initials}</h2>
        <h2>${user.name}</h2>
        Электоронная почта: <b>${user.email}</b>
        <br>
        <a class="btn btn-dark mb-3" style="text-align: center; width: 100%"
           href="/my/tickets">
            Мои билеты
        </a>
        <form action="/logout" method="post">
            <input type="hidden" name="_csrf" value="${_csrf.token}"/>
            <button type="submit" style="text-align: center; width: 100%" class="btn btn-danger mb-2">
                Выйти из аккаунта
            </button>
        </form>
    </div>
</@t.template>