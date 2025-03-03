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
    Queue userDeletionNotifyCustomFoodQueue = new Queue(RabbitMqUserQueues.USER_DELETION_NOTIFY_CUSTOM_FOOD, false);
    Queue userDeletionNotifyUserDetailsQueue = new Queue(RabbitMqUserQueues.USER_DELETION_NOTIFY_USER_DETAILS, false);
    Queue userDeletionNotifyRecordQueue = new Queue(RabbitMqUserQueues.USER_DELETION_NOTIFY_RECORD, false);
    Queue userDetailsCreationNotifyRecordQueue = new Queue(RabbitMqUserQueues.USER_DETAILS_CREATION_NOTIFY_RECORD, false);

    amqpAdmin.declareQueue(userDeletionNotifyCustomFoodQueue);
    amqpAdmin.declareQueue(userDeletionNotifyUserDetailsQueue);
    amqpAdmin.declareQueue(userDeletionNotifyRecordQueue);
    amqpAdmin.declareQueue(userDetailsCreationNotifyRecordQueue);
  }
}
