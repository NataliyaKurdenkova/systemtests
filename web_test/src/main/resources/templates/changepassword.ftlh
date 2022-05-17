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

    <script>
        function show_hide_password(target) {
            var input = document.getElementById('input-password');
            if (input.getAttribute('type') == 'password') {
                target.classList.add('view');
                input.setAttribute('type', 'text');
            } else {
                target.classList.remove('view');
                input.setAttribute('type', 'password');
            }
            return false;
        }
    </script>
    <script>
        function show_hide_password2(target) {
            var input = document.getElementById('passwordConfirm');
            if (input.getAttribute('type') == 'password') {
                target.classList.add('view');
                input.setAttribute('type', 'text');
            } else {
                target.classList.remove('view');
                input.setAttribute('type', 'password');
            }
            return false;
        }
    </script>
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
    <form class="authorize-form grid" action="/adminka/savepassword/${iduser}" method="post">

        <div><h1>Смена пароля пользователя:</h1>
            <h2>N ${iduser}    <p>${fio}</p></h2>
        </div>
        <div class="authorize-form-input grid" data-validate="password is required">
            <input class="input-password" id="input-password" type="password" name="password"
                   pattern="^.*(?=.{8,})(?=.*[a-zA-Z])(?=.*\d)(?=.*[!#$%&?+-_ ]).*$"
                   title="Пароль должен содержать от 8 знаков латинского алфавита и иметь
                       буквы в различных регистрах, цифры и спец. символы (!@#$%^&*?+-_ )."
                   placeholder="Введите пароль">
            <a href="#" class="password-control" onclick="return show_hide_password(this);"></a>
            <input class="input-password" id="passwordConfirm" type="password" name="passwordConfirm"
                   pattern="^.*(?=.{8,})(?=.*[a-zA-Z])(?=.*\d)(?=.*[!#$%&?+-_ ]).*$"
                   title="Пароль должен содержать от 8 знаков латинского алфавита и иметь
                       буквы в различных регистрах, цифры и спец. символы (!@#$%^&*?+-_ )."
                   placeholder="Повторите пароль">
            <a href="#" class="password-control" onclick="return show_hide_password2(this);"></a>
            <input class="entrance-button" type="submit" value="Сохранить">
        </div>
    </form>
</section>
</div>
</body>
</html>