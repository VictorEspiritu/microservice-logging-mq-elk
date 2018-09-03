### Microservice Logging

##### Docker machine
$ docker-machine create --driver virtualbox dev


##### Rabbit MQ
>docker run -d -it --name mq-rabbit --hostname rabbit -p 30000:5672 -p 30001:15672 rabbitmq:management

http://192.168.99.100:30001
queue: queue_logstash
exchange: exc_logstash --> queue_logstash (queue_logstash)

##### ELK
>docker run -d -it --name storage-es -p 9200:9200 -p 9300:9300 elasticsearch
>docker run -d -it --name console-kibana --link storage-es:elasticsearch -p 5601:5601 kibana
>docker run -d -it --name logstash logstash -e 'input { rabbitmq { host => "192.168.99.100" port => 30000 durable => true } } output { elasticsearch { hosts => ["192.168.99.100"] } }'