<#ftl encoding='UTF-8'>
<#import "/spring.ftl" as spring/>

<head>
    <head>
        <link rel="stylesheet" type="text/css" href="<@spring.url '/css/menu.css'/>"/>
        <link rel="stylesheet" type="text/css" href="<@spring.url '/css/table.css'/>"/>
    </head>
</head>

<body>

<div id='cssmenu'>
    <ul>
        <li><a href="/">Домой</a></li>
        <li><a href='/login'>Авторизация</a></li>
        <li><a href='/signUp'>Регистрация</a></li>
        <li><a href='/logout'>Выход</a></li>
    </ul>
</div>

<div class="shop-container">
<h1>Добро пожаловать в магический магазинчик!</h1>

<#if error??>
<br>
<div>${error}</div>
</#if>

<br>
<div class="content-block">
    <form class="form-horizontal" action="/signUp" method="post">
        <p><input name="login" placeholder="Логин">
        <p><input name="pass" placeholder="Пароль">
        <p><input type="submit">
    </form>
</div>
</div>
</body>