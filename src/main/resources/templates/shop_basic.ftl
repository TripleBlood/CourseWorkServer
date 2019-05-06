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
        <li><a href='/user/shop'>Магазин</a></li>
        <li><a href='/user/shop/cart'>Корзина</a></li>
        <li><a href='/logout'>Выход</a></li>
    </ul>
</div>
</body>