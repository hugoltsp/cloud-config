package br.com.devcave.springcloud.configclient.queue;

import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "spring.rabbitmq")
public class AmqpConnectionAlternativeConfig {

    private String alternativeAddresses;

    private String alternativeUsername;

    private String alternativePassword;

    private String alternativeVirtualHost;

    @Bean(name = "alternativeConnectionFactory")
    public ConnectionFactory alternativeConnectionFactory () {
        CachingConnectionFactory connectionFactory = new CachingConnectionFactory();
        connectionFactory.setAddresses(alternativeAddresses);
        connectionFactory.setUsername(alternativeUsername);
        connectionFactory.setPassword(alternativePassword);
        connectionFactory.setVirtualHost(alternativeVirtualHost);
        return connectionFactory;
    }

    public void setAlternativeAddresses (final String alternativeAddresses) {
        this.alternativeAddresses = alternativeAddresses;
    }

    public void setAlternativeUsername (final String alternativeUsername) {
        this.alternativeUsername = alternativeUsername;
    }

    public void setAlternativePassword (final String alternativePassword) {
        this.alternativePassword = alternativePassword;
    }

    public void setAlternativeVirtualHost (final String alternativeVirtualHost) {
        this.alternativeVirtualHost = alternativeVirtualHost;
    }
}