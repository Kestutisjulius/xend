# xend
final project for automatic generate and send invoices

first configute your application properties for MySQL

spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL5Dialect
spring.jpa.show-sql=true
spring.datasource.url=jdbc:mysql://localhost:3306/YOURDATABASENAME?serverTimezone=UTC&useSSL=false&allowPublicKeyRetrieval=true
spring.datasource.username=YOURDATABASEUSERNAME
spring.datasource.password=PASSWORD
spring.jpa.hibernate.ddl-auto=create-drop
