@echo off
javac -d bin src\*.java src\Inimigos\*.java src\ElementosDeCenario\*.java
java -cp bin src.Game
pause
