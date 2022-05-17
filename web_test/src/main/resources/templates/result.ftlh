<!doctype html>
<html lang="ru" xmlns:form="http://www.w3.org/1999/html">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Test</title>
    <style>
        <!--
        @import url('https://fonts.googleapis.com/css2?family=Montserrat:wght@400;500;600;700;800&display=swap');
        -->
        @import url('https://fonts.googleapis.com/css2?family=Montserrat:wght@400;600;800&display=swap');
    </style>
    <!-- <link rel="stylesheet" href="../static/css/normalize.css">-->
    <link rel="stylesheet" href="../css/normalize.css">
    <!--<link rel="stylesheet" href="../static/fonts/font-awesome-4.7.0/css/font-awesome.min.css">-->
    <link rel="stylesheet" href="../fonts/font-awesome-4.7.0/css/font-awesome.min.css">
    <!--<link rel="stylesheet" href="../static/css/main.min.css">-->
    <link rel="stylesheet" href="../css/main.min.css">
</head>

<body>

<header>

    <div class="header-container">
        <div class="header-rows header-rows-1">
            <div class="header-logo">
                <img class="header-logo-img" src="../img/logo.svg" alt="logo">
            </div>
            <div class="header-title">
                <img class="header-title-image" src="../img/Title.png" alt="title-img">
                <img class="right-img" src="../img/right-img.svg" alt="img">
            </div>
        </div>
        <div class="header-rows header-rows-3">
            <div class="header-columns-output">
                <p class="header-columns-output-p" id="FIO-output">${name}</p>
            </div>
            <div class="header-columns-exit">
                <form action="/logout" method="post">
                    <input class="header-columns-exit-input" type="submit" value="Выход">
                </form>
            </div>
        </div>
    </div>
</header>
<section class="test-container">
    <div class="test-question-container">

        <div class="private-table table-styles">
            <div class="private-table-n table-styles"><p>Дата и время прохождения теста</p></div>
            <div class="private-table-title table-styles"><p>Номер пользователя</p></div>
            <div class="private-table-estimation table-styles"><p>Номер теста</p></div>
            <div class="private-table-action table-styles">Время прохождения</div>
            <div class="private-table-action table-styles">Количество набранных баллов</div>
            <div class="private-table-action table-styles">Количество попыток</div>
        </div>

        <div class="private-table-n content-styles"><p>${currenttime}</p></div>
        <div class="private-table-title "><p>${iduser}</p></div>
        <div class="private-table-estimation content-styles"><p>${idtest}</p></div>
        <div class="private-table-time content-styles"><p>${timetest}</p></div>
        <div class="private-table-time content-styles"><p>${timetest}</p></div>
        <div class="private-table-time content-styles"><p>${balls}</p></div>
        <div class="private-table-time content-styles"><p>${attempt}</p></div>

        <div class="test-action-block">
            <form  action="/start/${idtest}" method="get">
                <input type="submit" value="Пересдать">
            </form>

            <form  action="/lich_page" method="get">
                <input type="submit" value="Домой">
            </form>

        </div>


    </div>
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