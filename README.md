# cloud-config
POC para testar o Cloud Config do Spring Cloud

### Rabbit em docker ###
docker run -d --hostname my-rabbit --name some-rabbit -p 15672:15672 -p 5671:5671 -p 5672:5672 rabbitmq:3-management

### Rodar o cliente com porta diferente ###
java -jar -Dserver.port=8090 configclient-0.0.1-SNAPSHOT.jar
