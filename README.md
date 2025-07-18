# JAVA-QAP4

## Overview
This project is a console based Java application that demonstrates two types of data persistance. A file I/O that reads and writes from a file and a database I/O that reads and writes from a database, both just locally hosted on my mac in this instance. It functions using a simple scanner menu that asks a user to pick from a list of options numbered 1 through 5.

---

## How to run
Here is how I have been running my program using the terminal within VScode:

First I open my macs terminal and start my database. I have installed postgresql through homebrew on my mac and run/manage it through the terminal. Once this is running I can create my database now or if it is already created I insert my table as found in CreatePatientTable.sql  .

Now that my database is up and running and my table exists I start my program. I start my program by compiling with my library: javac -cp "lib/postgresql-42.7.7.jar" src/*.java
then run: java -cp "lib/postgresql-42.7.7.jar:src" Main
because this program hooks and runs from the projects root the other part of my project, the text file I read and write from, had to be moved to my root folder as well so it could be accessed. 


---

## How it went 
The project went well overall. I did not find it difficult, especially since we’ve been working with databases in other classes. The JDBC setup was straightforward, and working with both file and database persistence helped reinforce the differences between the two approaches. Everything functioned as expected.