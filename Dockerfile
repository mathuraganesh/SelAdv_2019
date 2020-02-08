FROM maven:latest
COPY  . .
CMD ["mvn","clean","test"]