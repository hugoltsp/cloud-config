package br.com.devcave.springcloud.configclient.queue;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class SimpleListener {

    private final String QUEUE_NAME = "test-queue";

    private final String EXCHANGE_NAME = "test-exchange";

    @Bean
    Queue queue () {
        return new Queue(QUEUE_NAME, false);
    }

    @Bean
    TopicExchange exchange () {
        return new TopicExchange(EXCHANGE_NAME);
    }

    @Bean
    Binding binding (Queue queue, TopicExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with(QUEUE_NAME);
    }

    @Bean
    SimpleMessageListenerContainer container (
            @Qualifier("alternativeConnectionFactory")
                    ConnectionFactory connectionFactory,
            MessageListenerAdapter listenerAdapter) {
        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
        container.setConnectionFactory(connectionFactory);
        container.setQueueNames(QUEUE_NAME);
        container.setMessageListener(listenerAdapter);
        return container;
    }

    @Bean
    MessageListenerAdapter listenerAdapter (Receiver receiver) {
        return new MessageListenerAdapter(receiver, "receiveMessage");
    }
}
