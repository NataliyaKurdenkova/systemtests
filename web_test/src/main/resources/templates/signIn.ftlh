<!--<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
</head>
<body>
<div>
    <h1>Авторизация</h1>
    <br>

    <form action="/signIn" method="post" modelAttribute="personAttribute">
        <input name="login" placeholder="email">
        <br>
         <input name="password" type="password" placeholder="Пароль">
        <br>
        <input type="submit" value="Войти" >
    </form>

</div>

</body>
</html>-->
<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Авторизация</title>
    <style>
        @import url('https://fonts.googleapis.com/css2?family=Montserrat:wght@400;600;800&display=swap');
    </style>
    <link rel="stylesheet" href="css/normalize.css">
    <!--    <link rel="stylesheet" href="css/normalize.css">-->
    <link rel="stylesheet" href="fonts/font-awesome-4.7.0/css/font-awesome.min.css">
    <!--    <link rel="stylesheet" href="fonts/font-awesome-4.7.0/css/font-awesome.min.css">-->
    <link rel="stylesheet" href="css/main.min.css">
    <!--    <link rel="stylesheet" href="css/main.min.css">-->
</head>
<body>

<div class="authorize grid">
    <div class="authorize-container grid">
        <div class="authorize-form-logo grid">
            <img class="logo-img" src="img/logo.svg" alt="logo">
            <img class="logo-title" src="img/Title.png" alt="logo-title">
        </div>
        <form class="authorize-form grid" action="/signIn" method="post" modelAttribute="personAttribute">
            <div class="authorize-form-input grid">
                <!--  <div class="authorize-form-input grid" data-validate="Login is required">-->
                <input class="input-login" type="text" name="login" placeholder="Введите ваш логин">
            </div>
            <div class="authorize-form-input grid">
                <!--<div class="authorize-form-input grid" data-validate="Password is required">-->
                <input class="input-password" type="password" name="password" placeholder="Введите ваш пароль">
            </div>
            <input class="entrance-button" type="submit" value="Вход">
        </form>
        <div class="authorize-form-recovery">
            <form action="/recovery" method="post">
                <input class="iksweb" type="submit" value="Забыли пароль?">
            </form>
        </div>
        <div class="authorize-form-span">
                <span>
                    войти через
                </span>
        </div>

        <div class="authorize-form-wrapper grid">
            <ul class="wrapper">
                <li class="icon facebook">
                    <span class="tooltip">Facebook</span>
                    <i class="fa fa-facebook"></i>
                </li>
                <li class="icon twitter">
                    <span class="tooltip">Twitter</span>
                    <i class="fa fa-twitter"></i>
                </li>
                <li class="icon github">
                    <span class="tooltip">Github</span>
                    <i class="fa fa-github"></i>
                </li>
                <li class="icon google">
                    <span class="tooltip">Google</span>
                    <i class="fa fa-google"></i>
                </li>
            </ul>
        </div>
        <div class="authorize-form-span">
                <span>
                    или зарегистрируйтесь
                </span>
        </div>
        <div class="authorize-form-registration">
            <form action="/reg" method="post">
                <input class="iksweb" type="submit" value="Регистрация">
            </form>
        </div>
    </div>
</div>

</body>
</html>