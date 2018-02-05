package br.com.devcave.springcloud.configclient.queue;

import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
@ConfigurationProperties(prefix = "spring.rabbitmq")
public class AmqpConnectionPrimaryConfig {

    private String addresses;

    private String username;

    private String password;

    private String virtualHost;

    @Primary
    @Bean("primaryConnectionFactory")
    public ConnectionFactory connectionFactory () {
        CachingConnectionFactory connectionFactory = new CachingConnectionFactory();
        connectionFactory.setAddresses(addresses);
        connectionFactory.setUsername(username);
        connectionFactory.setPassword(password);
        connectionFactory.setVirtualHost(virtualHost);
        return connectionFactory;
    }

    public void setAddresses (final String addresses) {
        this.addresses = addresses;
    }

    public void setUsername (final String username) {
        this.username = username;
    }

    public void setPassword (final String password) {
        this.password = password;
    }

    public void setVirtualHost (final String virtualHost) {
        this.virtualHost = virtualHost;
    }
}