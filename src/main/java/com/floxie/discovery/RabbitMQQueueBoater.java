package com.floxie.discovery;

import org.commons.rabbitmq.RabbitMqUserQueues;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Queue;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class RabbitMQQueueBoater implements CommandLineRunner {

  private final AmqpAdmin amqpAdmin;

  public RabbitMQQueueBoater(AmqpAdmin amqpAdmin) {
    this.amqpAdmin = amqpAdmin;
  }

  @Override
  public void run(String... args) throws Exception {
    Queue queue1 = new Queue(RabbitMqUserQueues.RECORD_USER_CREATE, false);
    Queue queue2 = new Queue(RabbitMqUserQueues.RECORD_USER_DELETION, false);
    Queue queue3 = new Queue(RabbitMqUserQueues.CUSTOM_FOOD_USER_DELETION, false);

    amqpAdmin.declareQueue(queue1);
    amqpAdmin.declareQueue(queue2);
    amqpAdmin.declareQueue(queue3);
  }
}
