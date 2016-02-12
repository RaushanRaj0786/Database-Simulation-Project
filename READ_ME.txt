2nd graded assignment
name                               entry number
Raushan                         2012CSB1028
Jaideep Singh Takkar    2012CSB1015

INTRODUCTION
 We have used Java to write the program. The backend is PostgreSQL with the database "rating" as given in the ungraded lab 3.
We have worked in pairs.
There are 6 files when extracted from 2012csb1028_2012csb1015.zip
One is text file READ_ME.txt
Rest are-
1) home.java->this file connect with database and ask the user to input the relation algebra.
2) selects.java->this file do select operation.
3) projects.java->this file do project operation.
4) cartesianproducts.java-> this file do Cartesian products on any multiple number of relations.
5) naturaljoins.java-> this file do natural join on two relations
 
COMPILATION
the user first need to open the home.java and make the following changes in the line 46
c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/rating","username", "password");

rating->database name. If there is any other database name , then change it.
username->here one should enter his username of postgres.
password->here one should enter his corresponding password.

The code have been compiled on Java ecilipse. Ecilipse runs on windows and linux. 
The external jar file for postgres should be added by build path.
Right click on the hame file->build path -> configure build path->libraries-> add external jars-> add the jar file 
One just needs to run the home.java on the machine
ecilipse.

INPUT FORMAT
each word or symbols should be separated by the space.
1) select predicate relation-
      a) Here predicate must be in the brackets ()
          e.g.    "select ( t < 5 ) relation"     where t<5 is the predicate
      b) If the relation is not nested then it should be written directly
          e.g.   "select ( t < 5 ) movie"        where movie is the relation or table name
          if the relation is nested then it should be written in brackets
          e.g.   "select ( t < 5 ) ( select ( v > 5 ) movie )

2)project column list relation-
      a) Here column list must be in the brackets ()
          e.g.    "project ( a , b ) relation"     where a,b is the column list
      b) If the relation is not nested then it should be written directly
          e.g.   "project ( a , b ) movie"        where movie is the relation or table name
          if the relation is nested then it should be written in brackets
          e.g.   "project ( a , b ) ( select ( v > 5 ) movie )

3) naturaljoin relation1 relation2-
      here relation1 and relation2 are wrutten in curly brackets {}
       eg   naturaljoin { relation1 } { relation2 }

4) cartesianproduct relation1, ..., relationK
      here relation1, relation2  ....,   relationK  are written in curly brackets {}
       e.g.  cartesianproduct { relation1 } , ..., { relation }
