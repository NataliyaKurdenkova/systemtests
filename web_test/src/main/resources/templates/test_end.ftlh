<!doctype html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Завершение тестирования</title>
    <style>
        @import url('https://fonts.googleapis.com/css2?family=Montserrat:wght@400;600;800&display=swap');
    </style>

    <link rel="stylesheet" href="../css/normalize.css">
    <link rel="stylesheet" href="../fonts/font-awesome-4.7.0/css/font-awesome.min.css">
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
        <div class="header-rows header-rows-4">
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
    <div class="test-answers-title-start ffs"><p>${Msg}</p><br><p> Вы набрали - ${balls} баллов.</p><br><p> Врямя прохождения теста - ${timetest} .</p></div>
    <div class="test-action-block test-end">
        <form  action="/restart/${idtest}" method="get">
            <input type="submit" value="Пересдать">
        </form>
        <form  action="/reslich_page" method="get">
            <input type="submit" value="Домой">
        </form>
        <form  action="/result" method="get">
            <input type="submit" value="Посмотреть результат">
        </form>
    </div>
</section>

</body>
</html>