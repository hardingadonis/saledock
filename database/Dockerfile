FROM mysql:8.2.0

LABEL org.opencontainers.image.source=https://github.com/hardingadonis/saledock
LABEL org.opencontainers.image.description="Container that runs MySQL for Sale Dock"
LABEL org.opencontainers.image.licenses=Apache-2.0

LABEL maintainer=hardingadonis@gmail.com

# Copy the database schema to the container
COPY ./setup.sql /docker-entrypoint-initdb.d/setup.sql

# Set the empty password for the root user
ENV MYSQL_ALLOW_EMPTY_PASSWORD yes

# Set the default database name
ENV MYSQL_DATABASE=saledock

# Set the default charset and collation
ENV LANG=C.UTF-8
ENV MYSQL_CHARSET=utf8mb4
ENV MYSQL_COLLATION=utf8mb4_general_ci

# Set the default port
EXPOSE 3306