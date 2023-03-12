package com.example.rabbitmqdemo.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author: Xingweicheng
 * @description: Topic-- 模式
 * @date: 12/03/2023 10:20 PM
 */
@Configuration
public class TopicConifg {

    @Bean
    TopicExchange topicExchange(){
        return new TopicExchange("TopicExchange",true,false);
    }

    @Bean
    Queue TopicqueueA(){
        return new Queue("TopicA",true,false,false);
    }

    @Bean
    Queue TopicqueueB(){
        return new Queue("TopicB",true,false,false);
    }

    @Bean
    Queue TopicqueueC(){
        return new Queue("TopicC",true,false,false);
    }

    @Bean
    Binding TopicbindingA(){       // #：匹配一个或者多个词
        return BindingBuilder.bind(TopicqueueA()).to(topicExchange()).with("test.#");
    }
    @Bean
    Binding TopicbindingB(){      //匹配1个或者0个
        return BindingBuilder.bind(TopicqueueB()).to(topicExchange()).with("test.*");
    }

    @Bean
    Binding TopicbindingC(){
        return BindingBuilder.bind(TopicqueueC()).to(topicExchange()).with("test.topic");
    }
}

