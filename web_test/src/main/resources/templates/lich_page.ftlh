<!doctype html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Personal Cabinet</title>
    <style>
        @import url('https://fonts.googleapis.com/css2?family=Montserrat:wght@400;600;800&display=swap');
    </style>
    <!-- <link rel="stylesheet" href="../static/css/normalize.css">-->
       <link rel="stylesheet" href="css/normalize.css">
    <!--<link rel="stylesheet" href="../static/fonts/font-awesome-4.7.0/css/font-awesome.min.css">-->
        <link rel="stylesheet" href="fonts/font-awesome-4.7.0/css/font-awesome.min.css">
    <!--<link rel="stylesheet" href="../static/css/main.min.css">-->
        <link rel="stylesheet" href="css/main.min.css">
</head>
<body>
<header>
    <div class="header-container">
        <div class="header-rows header-rows-1">
            <div class="header-logo">
                <img class="header-logo-img" src="img/logo.svg" alt="logo">
            </div>
            <div class="header-title">
                <img class="header-title-image" src="img/Title.png" alt="title-img">
                <img class="right-img" src="img/right-img.svg" alt="img">
            </div>
        </div>
        <div class="header-rows header-rows-2">
            <div class="header-columns-menu">
                <form action="/" method="post">
                    <input class="header-columns-menu-input active" type="submit" value="Назначенные тесты">
                </form>
            </div>
            <div class="header-columns-menu">
                <form action="/" method="post">
                    <input class="header-columns-menu-input" type="submit" value="Пройденные тесты">
                </form>
            </div>
            <div class="header-columns-output">
                <p class="header-columns-output-p" id="FIO-output"> ${name}</p>
            </div>
            <div class="header-columns-exit">
                <form action="/" method="post">
                    <input class="header-columns-exit-input" type="submit" value="Выход">
                </form>
            </div>
        </div>
    </div>
</header>
<section class="private-container">
    <!--<div class="private-title">

    <p>Ваши данные</p>
    <table>
        <tr>
            <th>№</th>
            <th>ФИО</th>
            <th>Роль</th>
        </tr>

      </div>-->
    <div class="private-title">
        <p class="private-title-p">Вам назначены следующие тесты:</p>
    </div>
    <div class="private-table table-styles">
        <div class="private-table-n table-styles"><p>№</p></div>
        <div class="private-table-title table-styles"><p>Название теста</p></div>
        <div class="private-table-estimation table-styles"><p>Проходной балл</p></div>
        <div class="private-table-time table-styles"><p>Время(мин)</p></div>
        <div class="private-table-action table-styles"></div>
    </div>
      <#list tests as test>
    <div class="private-table private-table-content">
        <div class="private-table-n content-styles"><p>${test.idtest}</p></div>
        <div class="private-table-title "><p>${test.name}</p></div>
        <div class="private-table-estimation content-styles"><p>${test.passball}</p></div>
        <div class="private-table-time content-styles"><p>${test.time}</p></div>
        <div class="private-table-action">
            <form action="">
                <input class="private-table-content-button" type="submit" value="Начать">
            </form>
        </div>
    </div>
        </#list>

</section>
<footer class="footer">
    <div class="title-column title-column-social">
        <ul class="wrapper">
            <li class="icon facebook">
                <span class="tooltip">Facebook</span>
                <i class="fa fa-facebook"></i>
            </li>
            <li class="icon twitter">
                <span class="tooltip">Twitter</span>
                <i class="fa fa-twitter"></i>
            </li>
            <li class="icon instagram">
                <span class="tooltip">Instagram</span>
                <i class="fa fa-instagram"></i>
            </li>
            <li class="icon github">
                <span class="tooltip">Github</span>
                <i class="fa fa-github"></i>
            </li>
            <li class="icon youtube">
                <span class="tooltip">Youtube</span>
                <i class="fa fa-youtube"></i>
            </li>
        </ul>
    </div>
</footer>
</body>
</html>