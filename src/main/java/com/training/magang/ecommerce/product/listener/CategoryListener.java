package com.training.magang.ecommerce.product.listener;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.training.magang.ecommerce.product.model.Category;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Slf4j
@Component
public class CategoryListener {

    @Autowired
    private ObjectMapper objectMapper;

    @KafkaListener(topics = "categories")
    public void listenTopicCategory(String body) throws IOException {

        Category category = objectMapper.readValue(body, Category.class);

        log.info("Receive Message {}", category);
    }
}
