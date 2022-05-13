<!doctype html>
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
    <div class="header-rows header-rows-2">
        <div class="header-columns-menu">
            <form action="/adminka" method="get">
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
            <form action="/logout" method="post">
                <input class="header-columns-exit-input" type="submit" value="Выход">
            </form>
        </div>
    </div>


    <table>
        <tr>
            <th>№</th>
            <th>ФИО</th>
            <th>Почта/Логин</th>
            <th>Роль</th>
        </tr>
        <#list users as user>
            <tr>
                <td>${user.iduser}</td>
                <td>${user.name}</td>
                <td>${user.login}</td>
                <td>Роль</td>
                <td>

                    <form action="/change_user/${user.iduser}" method="post">
                        <input type="submit" value="Сменить пароль">
                    </form>
                </td>
                <td>
                    <form action="/edit_user/${user.iduser}" method="post">
                        <input type="submit" value="Редактировать">
                    </form>
                </td>
                <td>
                    <form action="/delete_user/${user.iduser}" method="post">
                        <input type="submit" value="Удалить">
                    </form>

                </td>
            </tr>
        </#list>
    </table>

</div>
</body>
