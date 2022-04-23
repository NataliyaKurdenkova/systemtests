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
    <h1>Регистрация</h1>
<form action="/registration" method="post">
    <input name="login" placeholder="email">
    <br>
    <input name="name" placeholder="ФИО">
    <br>
    <input name="password" type="password" placeholder="Пароль">
    <br>
    <input type="submit" value="Сохранить">
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
    <title>Регистрация</title>
    <style>
        @import url('https://fonts.googleapis.com/css2?family=Montserrat:wght@400;500;600;700;800&display=swap');
    </style>
    <link rel="stylesheet" href="css/normalize.css">
    <!--    <link rel="stylesheet" href="css/normalize.css">-->
    <link rel="stylesheet" href="fonts/font-awesome-4.7.0/css/font-awesome.min.css">
    <!--    <link rel="stylesheet" href="fonts/font-awesome-4.7.0/css/font-awesome.min.css">-->
    <link rel="stylesheet" href="css/main.min.css">
    <!--    <link rel="stylesheet" href="css/main.min.css">-->


    <!--скрипт для того, чтоб был глазок на поле пароля-->
    <script>
        function show_hide_password(target){
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
                Регистрация
            </span>
        </div>
        <form class="authorize-form grid" action="/registration" method="post">
            <div class="authorize-form-input grid" data-validate="Login is required">
                <input class="input-login" type="text" name="login"
                       pattern="^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\.[a-zA-Z0-9-.]+$"
                       title="Логин должен быть в формате электронной почты."
                       placeholder="Введите email">
            </div>
            <div class="authorize-form-input grid" data-validate="surname is required">
                <input class="input-surname" type="text" name="name" placeholder="Введите Фамилию Имя Отчество">
            </div>
           <!-- <div class="authorize-form-input grid" data-validate="name is required">
                <input class="input-name" type="text" name="name" placeholder="Введите Имя">
            </div>
            <div class="authorize-form-input grid" data-validate="middle name is required">
                <input class="input-middle-name" type="text" name="middle-name" placeholder="Введите Отчество">
            </div>-->
            <!--Проверка на соответсвие пароля требованиям парольной политики скриптом show_hide_password(this)-->

            <div class="authorize-form-input grid" data-validate="password is required">
                <input class="input-password" id="input-password" type="password" name="password"
                       pattern="^.*(?=.{8,})(?=.*[a-zA-Z])(?=.*\d)(?=.*[!#$%&?+-_ ]).*$"
                       title="Пароль должен содержать от 8 знаков латинского алфавита и иметь
                       буквы в различных регистрах, цифры и спец. символы (!@#$%^&*?+-_ )."
                       placeholder="Введите пароль">
                <a href="#" class="password-control" onclick="return show_hide_password(this);"></a>
                <input class="input-password" id="input-password" type="password" name="passwordConfirm"
                       pattern="^.*(?=.{8,})(?=.*[a-zA-Z])(?=.*\d)(?=.*[!#$%&?+-_ ]).*$"
                       title="Пароль должен содержать от 8 знаков латинского алфавита и иметь
                       буквы в различных регистрах, цифры и спец. символы (!@#$%^&*?+-_ )."
                       placeholder="Повторите пароль">
                <a href="#" class="password-control" onclick="return show_hide_password(this);"></a>


                <!--<input class="input-password" name="password" type="password" placeholder="Пароль">-->
              </div>

              <input class="entrance-button" type="submit" value="Сохранить">
          </form>
      </div>
  </div>
  </body>
  </html>