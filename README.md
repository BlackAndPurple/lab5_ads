# lab5_ads
<h2>Laboratory work #5<br>
Algorithms and data structures, ITMO, 4th semester</h2>


<h3>Вариант 8</h3>
Некоторые школы связаны компьютерной сетью. Между школами заключены соглашения: каждая школа имеет список школ получателей, которым она рассылает программное обеспечение всякий раз, получив новое бесплатное программное обеспечение (извне сети или из другой школы). При этом, если школа В есть в списке получателей школы А, то школа А может и не быть в списке получателей школы В. 
Требуется написать програму, определяющую минимальное количество школ, которым надо передать по экземпляру нового программного обеспечения, что бы распространить его по всем школам сети в соответствии с соглашениями (подзадача А). 
Кроме того, надо обеспечить возможность рассылки нового программного обеспечения из любой школы по всем остальным школам. Для этого расширить списки получателей некоторых школ, добавляя в них новые школы. Требуется найти минимальное суммарное количество расширений списков, при которых программное обеспечение из любой школы достигло бы остальных школ (подзадача В). Одно расширение означает добавление одной новой школы-получателя в список получателей одной из школ. 
<p><b>Входные данные </b><br>
Первая строка файла INPUT.TXT содержит целое число N - количество школ в сети (2<=N<=100). Школы нумеруются первыми N положительными целыми числами. Каждая из следующих N строк задает список получателей. Строка i+1 содержит номера получателей i-й школы. Каждый такой список заканчивается нулем. Пустой список содержит только 0. 
Выходные данные 
Ваша программа должна записать 2 строки в файл OUTPUT.TXT. Его первая строка должна содержать одно положительное целое число - решение подзадачи А. Вторая строка должна содержать решение подзадачи B. 
<p><b>Пример ввода и вывода </b><br>
INPUT.TXT<br> 
5 <br>
2 4 3 0 <br>
4 5 0 <br>
0 <br>
0 <br>
1 0 <br>
OUTPUT.TXT <br>
1 <br>
2 <br>

