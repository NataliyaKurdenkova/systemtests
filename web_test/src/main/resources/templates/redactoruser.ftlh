<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Смена пароля</title>
    <style>
        @import url('https://fonts.googleapis.com/css2?family=Montserrat:wght@400;600;800&display=swap');
    </style>
    <!-- <link rel="stylesheet" href="../static/css/normalize.css">-->
    <link rel="stylesheet" href="../../../css/normalize.css">
    <!--<link rel="stylesheet" href="../static/fonts/font-awesome-4.7.0/css/font-awesome.min.css">-->
    <link rel="stylesheet" href="../../../fonts/font-awesome-4.7.0/css/font-awesome.min.css">
    <!--<link rel="stylesheet" href="../static/css/main.min.css">-->
    <link rel="stylesheet" href="../../../css/main.min.css">

</head>
<body>
<header>
    <div class="header-container">
        <div class="header-rows header-rows-1">
            <div class="header-logo">
                <img class="header-logo-img" src="../../../img/logo.svg" alt="logo">
            </div>
            <div class="header-title">
                <img class="header-title-image" src="../../../img/Title.png" alt="title-img">
                <img class="right-img" src="../../../img/right-img.svg" alt="img">
            </div>
        </div>
        <div class="header-rows header-rows-admin">
            <div class="header-columns-menu">
                <form action="/adminka/statistic" method="get">
                    <input class="header-columns-menu-input" type="submit" value="Статистика">
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
                <form action="/logout" method="get">
                    <input class="header-columns-exit-input" type="submit" value="Выход">
                </form>
            </div>
        </div>
    </div>
</header>
<section class="private-container">


        <div class="authorize-form-span">
            <span>
                Редактирование данных пользователя <p>N ${iduser}   ${nameuser} </p>
            </span>
        </div>
    <form class="authorize-form grid" action="/adminka/updateuser/${iduser}" method="post" modelAttribute="userch">
        <div class="authorize-form-input grid" data-validate="Login is required">
            <input class="input-login" type="text" name="login"
                   pattern="^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\.[a-zA-Z0-9-.]+$"
                   title="Логин должен быть в формате электронной почты."
                   placeholder="${login}" value="${login}">
        </div>
        <div class="authorize-form-input grid" data-validate="surname is required">
            <input class="input-surname" type="text" name="name" placeholder="${fio}" value="${fio}">
        </div>
        <div>
            <select name="nameRole">
                <option value="ROLE_ADMIN">ROLE_ADMIN</option>
                <option value="ROLE_EDITOR">ROLE_EDITOR</option>
                <option value="ROLE_USER">ROLE_USER</option>
            </select>
        </div>
        <div class="authorize-form-input grid" data-validate="surname is required">
            <input type="hidden" type="text" name="hashpassword" value="${hashpassword}">
        </div>

        <input class="entrance-button" type="submit" value="Сохранить">


    </form>
</section>
</div>
</body>
</html>