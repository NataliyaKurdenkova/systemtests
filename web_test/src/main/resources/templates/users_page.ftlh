<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Пользователи</title>
    <style>
        @import url('https://fonts.googleapis.com/css2?family=Montserrat:wght@400;600;800&display=swap');
    </style>
    <link rel="stylesheet" href="../../css/normalize.css">
    <link rel="stylesheet" href="../../fonts/font-awesome-4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="../../css/main.min.css">
</head>
<body>
<header>
    <div class="header-container">
        <div class="header-rows header-rows-1">
            <div class="header-logo">
                <img class="header-logo-img" src="../../img/logo.svg" alt="logo">
            </div>
            <div class="header-title">
                <img class="header-title-image" src="../../img/Title.png" alt="title-img">
                <img class="right-img" src="../../img/right-img.svg" alt="img">
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
                    <input class="header-columns-menu-input active" type="submit" value="Пользователи">
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
<section class="users-container">
    <div class="users-table table-styles">
        <div class="users-table-n table-styles"><p>№</p></div>
        <div class="users-table-title table-styles"><p>ФИО</p></div>
        <div class="users-table-estimation table-styles"><p>Почта/Логин</p></div>
        <div class="users-table-action table-styles">Роль</div>
        <div class="users-table-action"></div>
    </div>
    <#list users as user>
        <div class="users-table users-table-content">
            <div class="users-table-n content-styles"><p>${user.iduser}</p></div>
            <div class="users-table-title "><p>${user.name}</p></div>
            <div class="users-table-estimation content-styles"><p>${user.login}</p></div>
            <div class="users-table-time content-styles"><p>${user.getRolesUser()}</p></div>
            <div class="users-table-action">
                <form action="/adminka/change_password/${user.iduser}" method="get">
                    <!--   <input type="submit" value="Сменить пароль">-->
                    <button type="submit"><i class="fa fa-pencil-square-o" aria-hidden="true"></i><i
                                class="fa fa-unlock-alt" aria-hidden="true"></i></button>
                </form>
                <form action="/adminka/edit_user/${user.iduser}" method="get">
                    <!--<input type="submit" value="Редактировать">-->
                    <button type="submit"><i class="fa fa-pencil" aria-hidden="true"></i></button>
                </form>
                <form action="/adminka/delete_user/${user.iduser}" method="post">
                    <!-- <input type="submit" value="Удалить">-->
                    <button type="submit"><i class="fa fa-trash-o" aria-hidden="true"></i></button>
                </form>
            </div>
        </div>
    </#list>
</section>
</body>
</html>