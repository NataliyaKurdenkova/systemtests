<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Восстановление</title>
    <style>
        @import url('https://fonts.googleapis.com/css2?family=Montserrat:wght@400;500;600;700;800&display=swap');
    </style>
    <!-- <link rel="stylesheet" href="../static/css/normalize.css">-->
        <link rel="stylesheet" href="css/normalize.css">
    <!-- <link rel="stylesheet" href="../static/fonts/font-awesome-4.7.0/css/font-awesome.min.css">-->
        <link rel="stylesheet" href="fonts/font-awesome-4.7.0/css/font-awesome.min.css">
    <!--  <link rel="stylesheet" href="../static/css/main.min.css">-->
       <link rel="stylesheet" href="css/main.min.css">
</head>
<body>

<div class="authorize grid">
    <div class="authorize-container grid">
        <div class="authorize-form-logo grid">
            <img class="logo-img" src="img/logo.svg" alt="logo">
            <img class="logo-title" src="img/Title.png" alt="logo-title">
        </div>
        <div class="authorize-form-span">
            <span>
                Восстановление пароля
            </span>
        </div>
        <form class="authorize-form grid" action="/afterRecovery" method="post">
            <div class="authorize-form-input grid" data-validate="Login is required">
                <input class="input-login" type="text" name="login"
                       pattern="^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\.[a-zA-Z0-9-.]+$"
                       title="Логин должен быть в формате электронной почты."
                       placeholder="Введите email">
            </div>
            <input class="entrance-button" type="submit" value="Отправить код">
        </form>
    </div>
</div>
</body>
</html>