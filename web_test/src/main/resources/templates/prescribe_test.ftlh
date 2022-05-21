<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Назначенние теста</title>
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
        <div class="header-rows header-rows-4">
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
<section class="redactor-container">
    <div class="redactor-table table-styles">
        <div class="redactor-table-n table-styles"><p>№</p></div>
        <div class="redactor-table-title table-styles"><p>Название теста</p></div>
        <div class="redactor-table-action table-styles"></div>
    </div>

    <#list tests as test>
        <div class="redactor-table redactor-table-content">
            <div class="redactor-table-n content-styles"><p>${test.idtest}</p></div>
            <div class="redactor-table-title "><p>${test.name}</p></div>
            <div class="redactor-table-action">
                <form action="/prescribetest/${test.idtest}" method="get">
                    <!--   <input type="submit" value="Назначить">-->
                    <button type="submit"><i class="fa fa-pencil" aria-hidden="true"></i></button>
                </form>
            </div>
        </div>
    </#list>

</section>
</div>
</body>
</html>