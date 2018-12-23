# PrintPages
Пояснения:
1)У меня windows, и команда curl почему-то не работает, start.bat сделать не удалось, я сделала отдельный файл с XML file.xml и работала через браузер
2)Из Java8 применяла LocalDateTime для конвертации времени в TimeStamp, но для Java7 есть отдельная библиотека JodaTime
3)Решила создать отдельный класс для вывода в json, чтобы не копаться по внутренностях json generation, хотя знаю о такой возможности и использовала это



Сервис учёта использования печатных устройств
Необходимо написать сервис учёта использования печатных устройств и предоставления 
статистики.
Сервис должен выполнять следующее:
1. по HTTP получать данные по использованию печатных устройств;
2. аггрегировать получаемые данные (при рестарте сервера данные должны сохраняться);
3. по HTTP предоставлять статистические данные по использованию печатных устройств.
Данные передаются на сервер через POST HTTP запрос (например, POST /jobs) в XML 
формате. Ответ возвращается в виде JSON.
Формат входящего XML следующий:
<jobs>
<job id="1">
<type>print</type>
  <user>user1</user>
  <device>device1</device>
  <amount>10</amount>
</job>
<job id="2">
<type>scan</type>
  <user>user1</user>
  <device>device1</device>
  <amount>12</amount>
</job>
<job id="3">
<type>fax</type>
  <user>user2</user>
  <device>device1</device>
  <amount>5</amount>
</job>
</jobs>
где:
 jobs - корневой элемент xml, содержащий элементы типа job (количество >=1);
 - job - информация о задании;
- type - тип задания. Возможные значения: print, copy, scan, fax;
- user - имя пользователя;
- device - адрес или имя устройства;
- amount - число страниц (распечатанных, отсканированных и т. п в зависимости от типа 
задания);
Формат ответа: JSON-объект следующего вида:
{ "user1" : "22",  "user2" : "5"}
где: 
- ключём является идентификатор пользователя;
- значением - суммарное количество обработанных страниц для данного пользователя в 
данной транзакции.
Статистика доступна по HTTP через запрос GET /statistics. Должна быть возможность 
фильтрации данных, в соответствии с переданными параметрами запроса:
- user — фильтр по пользователю;
- type — фильтр по типу задания;
- device — фильтр по устройству;
- timeFrom — начиная с указанного момента времени (формат произвольный);
- timeTo — до указанного момента времени (формат произвольный); 
Параметры могут появляться в любых комбинациях, в том числе отсутствовать вообще.
Пример запроса:
GET /statistics?type=copy&device=device9
Результатом должен быть ответ в формате JSON в виде:
[
{ 
"jobId" : 1,
"device": "device1",
"user": "user1",
   "type": "scan",
"amount": 23,
"time": "21.03.2016 10:45"
},
{ 
"jobId" : 2,
"device": "device1",
"user": "user2",
   "type": "copy",
"amount": 11,
"time": "21.03.2016 11:30"
},
...
]
Данные в списке отсортированы в хронологическом порядке.
Примечания
1. Идентификатор задания следует считать уникальным в рамках одного и того же 
устройства.
2. Время задания фиксируется по времени прихода данных на сервер.
3. Для хранения данных не использовать то, что требует дополнительных действий по 
установке и настройке (например, корпоративные БД, типа MSSQL Server, Oracle и 
подобные). 
Ожидаемый результат
В качестве результата работы должен быть архив с:
1. исходным кодом приложения;
2. файлом build.bat или build.sh, с помощью которого приложение компилируется и 
собирается;
3. файлом start.bat или start.sh, с помощью которого приложение запускается;
4. файл readme.txt с пояснениями (при необходимости).


