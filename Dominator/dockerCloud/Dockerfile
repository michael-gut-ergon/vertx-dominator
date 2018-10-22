#
# Dockerfile order manager service
#
FROM openjdk:8-jdk
MAINTAINER Michael Gut "michael.gut@ergon.ch"

# Install vert.x service
COPY Dominator-1.0.0.tar /data/Dominator-1.0.0.tar
RUN tar xvf /data/Dominator-1.0.0.tar

# Define working directory.
WORKDIR /Dominator-1.0.0

# Start service
CMD /Dominator-1.0.0/bin/Dominator server /Dominator-1.0.0/app_config.yml
EXPOSE 15000
