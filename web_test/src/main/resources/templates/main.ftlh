<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>TestSystem</title>
    <style>
        @import url('https://fonts.googleapis.com/css2?family=Montserrat:wght@400;600;800&display=swap');
    </style>
    <!--    <link rel="stylesheet" href="../static/css/normalize.css">-->
    <link rel="stylesheet" href="css/normalize.css">
    <!--    <link rel="stylesheet" href="../static/fonts/font-awesome-4.7.0/css/font-awesome.min.css">-->
    <link rel="stylesheet" href="fonts/font-awesome-4.7.0/css/font-awesome.min.css">
    <!--    <link rel="stylesheet" href="../static/css/main.min.css">-->
    <link rel="stylesheet" href="css/main.min.css">
</head>
<body>
<section class="main-container">
    <div class="main-column main-column-left">
        <img class="header-logo-img" src="img/logo.svg" alt="logo">
        <img class="main-img" src="img/main-Img.png" alt="logo">
    </div>
    <div class="main-column main-column-right">
        <img class="right-img" src="img/right-img.svg" alt="img">
        <div class="title-rows">
            <div class="title-column title">
                <img class="title-img" src="img/title.svg" alt="title-img">
            </div>
            <div class="title-column title-column-description">
                <p>Профессиональный инструмент автоматизации процесса тестирования и обработки результатов,
                    контроль знаний и определение профессионального уровня сотрудников.</p>
            </div>
            <div class="title-column title-column-entrance">
                <form action="/entrance" method="post">
                    <input class="entrance-button" type="submit" value="Вход">
                </form>
            </div>
            <div class="reg-container title-column">
                <form action="/reg" method="post">
                    <input class="iksweb" type="submit" value="Регистрация">
                </form>
                <p>/</p>
                <form action="/recovery_pass" method="post">
                    <input class="iksweb" type="submit" value="Забыли пароль?">
                </form>
            </div>
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
        </div>
    </div>
</section>


</body>
</html>
