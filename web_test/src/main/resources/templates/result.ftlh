<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Результат</title>
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
                <form action="/" method="post">
                    <input class="header-columns-exit-input" type="submit" value="Выход">
                </form>
            </div>
        </div>
    </div>
</header>
<section class="result-container grid">
    <div class="result-question-container grid">
        <!-- <p class="test-question-id">${idtest}</p>-->
        <p class="result-title ffs">${nametest}</p>
    </div>
    <div class="result-title ffs"><p>${msg}</p></div>
    <div class="result-title ffs"><p>Время прохождения теста ${time}.</p></div>
    <div class="result-title ffs"><p>Набрали ${ball} баллов.</p></div>
    <div class="result-action-block">
        <form action="/start" method="post">
            <input type="submit" value="Пройти заново">
        </form>
        <form action="/lich_page" method="post">
            <input type="submit" value="Главная страница">
        </form>
    </div>
</section>
</body>
</html>