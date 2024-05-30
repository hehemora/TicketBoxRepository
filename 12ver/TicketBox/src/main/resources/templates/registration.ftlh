<#import "blocks/template.ftlh" as t>
<@t.template user>
    <h1 style="text-align: center">Регистрация</h1>
    <hr>
    <form action="/registration" method="post">
        <div class="form-outline mb-4">
            <input style="width: 30%; margin-left: 385px" type="text" name="name" class = "form-control">
            <label style="margin-left: 385px" class="form-label" for="form2Example1">Имя пользователя</label>
        </div>
        <div class="form-outline mb-4">
            <input style="width: 30%; margin-left: 385px" type="text" name="initials" class = "form-control">
            <label style="margin-left: 385px" class="form-label" for="form2Example1">ФИО</label>
        </div>
    <div class="form-outline mb-4">
        <input style="width: 30%; margin-left: 385px" type="email" name="email" class = "form-control">
        <label style="margin-left: 385px" class="form-label" for="form2Example2">Эл почта</label>
    </div>
    <div class="form-outline mb-4">
        <input style="width: 30%; margin-left: 385px" type="password" name="password" class = "form-control">
        <label style="margin-left: 385px" class="form-label" for="form2Example2">Пароль</label>
    </div>
    
    <div>
        <input type="hidden" name="_csrf" value="${_csrf.token}">
        <button style="width: 30%; margin-left: 385px" type="submit" style="width: 100%" class="btn btn-dark">Регистрация</button>
    </div>
    </form>
    <#if errorMessage??>
    <h2 style="color: red">${errorMessage}</h2>
    </#if>
    <hr>
    <h3 style="text-align: center"><a href="/registration">Регистрация</a></h3>
</@t.template>

