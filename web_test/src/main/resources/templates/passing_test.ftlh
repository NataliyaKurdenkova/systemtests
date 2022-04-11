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

    <link rel="stylesheet" href="css/normalize.css">
    <link rel="stylesheet" href="fonts/font-awesome-4.7.0/css/font-awesome.min.css">
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
        <div class="header-rows header-rows-3">
            <div class="header-columns-time">
                <p>${time}</p>
            </div>
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
<section class="test-container">
    <div class="test-question-container">
        <!-- <p class="test-question-id">${idtest}</p>-->
        <p class="test-question-title">Вопрос:</p>
        <p class="test-question">${question}</p>
    </div>
    <div class="test-answers-title">Варианты ответов:</div>
    <div class="test-answers-block">
        <!--    <#list answers as answer>-->
        <div class="test-answer">
            <input id="${answer.id} 1" class="test-answer-checkbox" type="checkbox" name="answer" value="${answer.id}">
            <label for="${answer.id} 1" class="test-answer-label"><span>${answer.name}</span></label>
        </div>
        <!--</#list>-->
    </div>
    <div class="test-action-block">
        <form action="/back" method="post">
            <input type="submit" value="Назад">
        </form>
        <form action="/skip" method="post">
            <input type="submit" value="Пропустить">
        </form>
        <form action="/pass_test/${idtest}/answer" method="post">
            <input type="submit" value="Ответить">
        </form>
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