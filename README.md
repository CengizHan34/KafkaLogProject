# Kafka Log Project

Kullanılan teknolojiler 
  - Spring Boot
  - Java 1.8
  - Hibernate
  - Zookeeper
  - Kafka
  - Docker
  - JavaScript
  
  Uygulamamızı çalıştırabilmek için zookeeper ve kafkayı ayağa kaldırmamız gerekmektedir.Bunun için terminalde KafkaLogProject ana dizininde iken asagidaki satiri calistirmak yeterli olacaktir.
  
  > docker-compose up -d
  
  Çalıştırdığımız containerları asagidaki komut satirini calistirarak durdurabiliriz.
  
  > docker-compose down
  
  İlgili containerları çalıştırdıktan sonra projemizi ayağa kaldırabiliriz.
  
  Projemizin çalışma mantığı, scheduler kullanılarak saniyede bir random log üretilemtedir.Üretilen bu loglar 30 sn boyunca toplandıktan sonra websocket'e gönderilerek real-time olarak line chart'da gösterilmektedir.
  
  
```sh
  Uygulamanın dashboard sayfası : localhost:8080
  Zookeeper'ın çalıştığı ip adresi ve port numarası :  192.168.99.100:2181
  Kafka'nın çalıştığı ip adresi ve port numarası : 192.168.99.100:9092
```

  
