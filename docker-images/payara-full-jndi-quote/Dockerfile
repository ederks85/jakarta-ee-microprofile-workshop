FROM ivonet/payara:5.193

ARG PWD
LABEL maintainer="IvoNet.nl"
ENV MYSQL_VERION="5.1.48"

ENV PASSWORD ${PWD:-secret}
RUN echo "AS_ADMIN_PASSWORD=${PASSWORD}">${PAYARA_HOME}/pwd.txt \
 && curl -s "http://central.maven.org/maven2/mysql/mysql-connector-java/$MYSQL_VERION/mysql-connector-java-$MYSQL_VERION.jar" -o "${PAYARA_HOME}/mysql-connector-java-$MYSQL_VERION.jar" \
 && asadmin start-domain domain1 \
 && asadmin --user admin --passwordfile ${PAYARA_HOME}/pwd.txt add-library "${PAYARA_HOME}/mysql-connector-java-$MYSQL_VERION.jar" \
 && asadmin --user admin --passwordfile ${PAYARA_HOME}/pwd.txt create-jdbc-connection-pool \
     --datasourceclassname com.mysql.jdbc.jdbc2.optional.MysqlDataSource \
     --restype javax.sql.ConnectionPoolDataSource \
     --property portNumber=3306:password=secret:user=root:serverName=mysql:databaseName=quote:useSSL=false quote_dbConnectionPool \
 && asadmin --user admin --passwordfile ${PAYARA_HOME}/pwd.txt create-jdbc-resource \
    --connectionpoolid quote_dbConnectionPool jdbc/quote_db \
 && asadmin stop-domain domain1 \
 && rm -f "${PAYARA_HOME}/pwd.txt" "${PAYARA_HOME}/mysql-connector-java-$MYSQL_VERION.jar"
