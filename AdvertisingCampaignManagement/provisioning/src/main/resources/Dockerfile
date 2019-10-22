FROM mysql/mysql-server:latest

ENV MYSQL_ROOT_PASSWORD="devcamp"

#For Windows, we need to add uncomment the following command
#RUN sed -i.bak 's/\r$//' start.sh

ADD start.sh /start.sh
ADD nosql.sql /nosql.sql

ENTRYPOINT ["./start.sh"]
HEALTHCHECK CMD /healthcheck.sh
