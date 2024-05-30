<#import "blocks/template.ftlh" as t>
<@t.template user>
    <h1 style="text-align: center">Авторизация</h1>
    <hr>
    <form action="/login " method="post">
        <div class="form-outline mb-4">
            <input style="width: 30%; margin-left: 385px" type="email" name="username" class = "form-control">
            <label style="margin-left: 385px" class="form-label" for="form2Example1">Эл почта</label>
        </div>
    <div class="form-outline mb-4">
        <input style="width: 30%; margin-left: 385px" type="password" name="password" class = "form-control">
        <label style="margin-left: 385px" class="form-label" for="form2Example2">Пароль</label>
    </div>
    <div>
        <input type="hidden" name="_csrf" value="${_csrf.token}">
        <button style="width: 30%; margin-left: 385px" type="submit" style="width: 100%" class="btn btn-dark">Вход</button>
    </div>
    </form>
    <hr>
    <h3 style="text-align: center"><a href="/registration">Регистрация</a></h3>
</@t.template>

