
[![Oracle JDK 1.8](https://img.shields.io/badge/JDK-1.8-blue.svg?style=plastic)](http://www.oracle.com/technetwork/java/javase/downloads/index.html)

ProgkornyBeadando-parent
====
A klasszikus 2048 játék adoptálása. A játék lényege, hogy 4x4-es mátrixban kell a számokat úgy tologatni, hogy végül kijöjjön 
a kettő hatványaiból a 2048.

Verzió
------
##### 1.0

Leírás
------
A Programozási környezetek tárgyra készített többmodulos 2048 JavaFX-s projekt, melynek motorját a matematikai eszközök segítségével készítettem el.

Jellemzők
---------
  - Többmodulos projekt
  - XML feldolgozás
  - JUnit teszt
  - JavaFX
  - Dokumentáció
  
Modulok
-------
 - progkornybeadando-database
 - progkornybeadando-javafx
 - progkornybeadano-model

Telepítés
---------
 A főmodulban  :
 ````
 mvn package install
 ````
 A progkornybeadando-javafx modulban:
  ````
 mvn exec:java -Dexec.mainClass="hu.unideb.inf.pkg.progkornybeadando.javafx.MainApp"
 ````
