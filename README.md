# cloud-config
POC para testar o Cloud Config do Spring Cloud

### Rabbit em docker ###
docker run -d --hostname my-rabbit --name some-rabbit -p 15672:15672 -p 5671:5671 -p 5672:5672 rabbitmq:3-management

### Rodar o cliente com porta diferente ###
java -jar -Dserver.port=8090 configclient-0.0.1-SNAPSHOT.jar


### Curl para refresh ####
- uma instancia especifica 
curl -X POST –d {} localhost:8090/refresh
- Propagaçao para todas as instancias e aplicaçoes
curl -X POST –d {} localhost:8090/bus/refresh
- Uma aplicacao especifica e todas as instancias
curl -X POST –d {} localhost:8090/bus/refresh?destination=test-app2:**