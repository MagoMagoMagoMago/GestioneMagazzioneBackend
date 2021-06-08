FROM mysql:8.0

LABEL MAINTAINER Dardan Baljaj <dardab.baljaj@tecnicosuperiorekennedy.it>
LABEL description="Immagine DBMS MySql"

ENV MYSQL_DATABASE GestioneMagazzino

ADD schema.sql /docker-entrypoint-initdb.d

EXPOSE 3306
