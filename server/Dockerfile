FROM tomcat:10.1.18-jre17

LABEL org.opencontainers.image.source=https://github.com/hardingadonis/saledock
LABEL org.opencontainers.image.description="Container that runs Tomcat for Sale Dock"
LABEL org.opencontainers.image.licenses=Apache-2.0

LABEL maintainer=hardingadonis@gmail.com

# Copy the war file to the container
COPY ./*.war /usr/local/tomcat/webapps/saledock.war

# Set the default port
EXPOSE 8080

# Set the default command
CMD ["catalina.sh", "run"]