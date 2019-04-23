# VocabularyTrainer
Der Vokabeltrainer ein Programm, welches die Funktionen eines klassischem Worterbuchs mit denen eines reinen Trainers kombiniert. Damit können Wörter nachgeschlagen werden und dann direkt im Trainier gespeichert werden, sodass man diese später trainieren kann. Die Anwendung arbeitet komplett offline, sodass für die Nutzung keine Internetanbindung erforderlich ist.

### Requirements
Diese Anwendung basiert auf Java und benötigt daher mindestens eine aktuelle Java-Version (Java 8).
Die Anwendung bringt selbst kein Wörterbuch (Datensatz) mit, kann aber jede Datei einlesen, die ein bestimmtes Format einhält (siehe Unten). Dazu bietet sich zum Beispiel der Datensatz der TU Chemnitz an, welches auch von der Seite dict.cc verwendet wird. Dieser Datensatz kann unter folgendem Link heruntergeladen werden (Link anklicken, Rechtsklick, Speichern unter...). Dabei reicht es aus, wenn sich das Wörterbuch im selben Ordner befindet, wie der Vokabeltrainer.
[Download Wörterbuch](ftp://ftp.tu-chemnitz.de/pub/Local/urz/ding/de-en/de-en.txt)
Grunsätzlich eignet sich jeder Datensatz, welcher ein bestimmtes Format einhält. Wichtig dabei ist, dass in der Datei die Wörter zeilenweise gelistet sind und die Vokabeln, mit dem Deutsch beginnend, durch zwei Doppelpunkte ('::') voneinander getrennt sind. Es können jeweils auf der Deutschen sowie auf der Englischen Seite mehrere Synonyme vorhanden sein.

### Verwendung
Auf der linken Hälfte befindet sich ein Wörderbuch, über das Vokabeln nachgeschlagen werden können. Die Eingabe ist dabei Case-Sensitiv und somit ist die Groß-Kleinschreibung zu beachten. Über den Button 'Random' können zufällig Wörter rausgesucht werden, die dann dem Trainier zugefügt werden können. Sollte einem eine Übersetzung unpassend erscheinen, kann diese mit einem Doppelklick in das entsprechende Feld bearbeitet werden.
Auf der rechten oberen Hälfte befindet sich der Trainier. Hier werden in beliebiger Reihenfolge Wörter aus dem Trainier ausgewählt und abgefragt. Die Übersetzung wird in das Textfeld eingegeben und kann mit dem Button 'Check' überprüft werden. Die Eingabe wird dann mit Grün hinterlegt, wenn sie Korrekt war, oder mit Rot, falls nicht. Über den Button 'Next' kann die nächste Vokabel abgefragt werden.
In dem unteren rechten Bereicht sind alle Vokabeln des Trainiers aufgelistet. Hier kann eine bereits erlernte Vokabel wieder aus dem Trainier gelöscht werden.
