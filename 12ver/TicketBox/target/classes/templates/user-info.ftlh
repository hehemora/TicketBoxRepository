<#import "blocks/template.ftlh" as t>
<@t.template user>   
    <h1 style="text-align: center">Информация о пользователе</h1>
    <div style="text-align: center">
        <h2>${user.name}</h2>
        <h2>${user.email}</h2>
        <h2>${user.initials}</h2>
        <h2>Дата регистрации ${user.dateOfCreated}</h2>
    </div>
</@t.template>

