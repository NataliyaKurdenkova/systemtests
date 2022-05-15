<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Statistic</title>
    <style>
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
        <div class="header-rows header-rows-admin">
            <div class="header-columns-menu">
                <form action="/adminka/statistic" method="get">
                    <input class="header-columns-menu-input active" type="submit" value="Статистика">
                </form>
            </div>
            <div class="header-columns-menu">
                <form action="/users" method="get">
                    <input class="header-columns-menu-input" type="submit" value="Пользователи">
                </form>
            </div>

            <div class="header-columns-menu">
                <form action="/tests" method="get">
                    <input class="header-columns-menu-input" type="submit" value="База тестов">
                </form>
            </div>

            <div class="header-columns-output">
                <p class="header-columns-output-p" id="FIO-output"> ${name}</p>
            </div>
            <div class="header-columns-exit">
                <form action="/logout" method="post">
                    <input class="header-columns-exit-input" type="submit" value="Выход">
                </form>
            </div>
        </div>
    </div>
</header>
<section class="private-container">
    <div class="private-table table-styles">
        <div class="private-table-n table-styles"><p>№</p></div>
        <div class="private-table-time table-styles"><p>Дата и время</p></div>
        <div class="private-table-title table-styles"><p>Пользователь</p></div>
        <div class="private-table-title table-styles"><p>Название теста</p></div>
        <div class="private-table-time table-styles"><p>Баллы</p></div>
        <div class="private-table-time table-styles"><p>Время(мин)</p></div>
        <div class="private-table-action table-styles"></div>
    </div>
    <div class="private-table private-table-content">
        <div class="private-table-n content-styles"><p>1</p></div>
        <div class="private-table-time content-styles"><p>Иванов Иван иванович</p></div>
        <div class="private-table-time content-styles"><p>14/05/2022</p></div>
        <div class="private-table-time content-styles"><p>Тест по Бережливому производству</p></div>
        <div class="private-table-estimation content-styles"><p>22</p></div>
        <div class="private-table-estimation content-styles"><p>26</p></div>

    </div>
    <div class="private-table private-table-content">
        <div class="private-table-n content-styles"><p>2</p></div>
        <div class="private-table-time content-styles"><p>hfhgjfhf</p></div>
        <div class="private-table-time content-styles"><p>14/05/2022</p></div>
        <div class="private-table-time content-styles"><p>Тест по антивирусной защите</p></div>
        <div class="private-table-estimation content-styles"><p>10</p></div>
        <div class="private-table-estimation content-styles"><p>11</p></div>

    </div>
</section>

</body>
</html>