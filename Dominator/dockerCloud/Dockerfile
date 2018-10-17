#
# Dockerfile order manager service
#
FROM openjdk:8-jdk
MAINTAINER Michael Gut "michael.gut@ergon.ch"

# Install vert.x service
COPY OrderManager-1.0-SNAPSHOT.tar /data/OrderManager-1.0-SNAPSHOT.tar
RUN tar xvf /data/OrderManager-1.0-SNAPSHOT.tar

# Define working directory.
WORKDIR /OrderManager-1.0-SNAPSHOT

# Start service
CMD /OrderManager-1.0-SNAPSHOT/bin/OrderManager server /OrderManager-1.0-SNAPSHOT/app_config.yml
EXPOSE 19140
