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
    <h1>Авторизируйтесь для продолжения работы</h1><br>
<#if model.error.isPresent()>
<div class="alert alert-danger" role="alert">Логин или пароль введены неверно</div>
</#if>
<div class="content-block">
    <form class="form-horizontal" action="/login" method="post">
        <input name="login" placeholder="Логин"><br><br>
        <input name="pass" placeholder="Пароль"><br><br>
        <input type="submit">
    </form>
</div>
</div>
</body>