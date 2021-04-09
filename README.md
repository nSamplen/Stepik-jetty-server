# Stepik-jetty-server
Сервлет, который обрабатывает запросы на /mirror
При получении GET запроса с параметром key=value сервлет возвращает в response строку содержащую value.
Например, при GET запросе /mirror?key=hello сервер должен вернуть страницу, на которой есть слово "hello".

Соберитеь сервер со всеми зависимостями на библиотеки в server.jar
Для этого -> Maven projects/<Project name>/Plugins/assembly/assembly:single
либо assembly.sh (assembly.bat)

Запустить start.(sh/bat)
java -jar server.jar
