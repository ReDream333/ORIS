# 01.11
дз создать клиент-сервер, который сможет отправлять разного вида запросы
функции доступа к сетевым службам - прикладной уровень
hhtp - протокол передачи гипер текста
html - язык разметки гипер текста
сервер - приложение,которое умеет принимать и отдавать запросы
кодировки - уровень представления
транспортный уровень и сетевой - безопасность данных и связь между узлами сети
сетевой - ip4 (четыре сегмента по 256) Ip6 (шесть сегментов и больше)
физический - можно потрогать

запрос - стартовая строка. заголовки. тело.
стартовая строка - метод, путь, версия http протокола
http первой и второй версии в том, что первая не может обрабатывать сразу несколько запросов

всякий мусор в гит не заливать
в мавен описане зависимости это xml

ресурсес - это статические и конфигурационные файлы
папки ру кпфц итис фамилия


# Ниже описаны шаги по отправке HTTP-запросов с помощью класса HttpURLConnection:

1. Создайте URL объект из URL-строки GET или POST.
2. Для URL объекта вызовите метод openConnection(), который возвращает экземпляр HttpURLConnection.
3. Установите метод запроса в экземпляре HttpURLConnection (значение по умолчанию — GET).
4. Вызовите метод setRequestProperty() для экземпляра HttpURLConnection, чтобы установить значения заголовков запроса (например, “User-Agent”, “Accept-Language” и т. д.).
5. Для получения HTTP-кода ответа можно вызвать getResponseCode(). Так мы узнаем, был ли запрос успешно обработан или возникла ошибка HTTP.
6. Для GET с помощью Reader и InputStream нужно прочитать ответ и обработать его соответствующим образом.
7. Запрос POST, прежде чем код обработает ответ, должен получить OutputStream из экземпляра HttpURLConnection и записать в него параметры POST.

