package com.skytask.listener;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.skytask.channel.ProductSource;
import com.skytask.model.Product;
import com.skytask.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.SendTo;

import java.util.List;

@EnableBinding(ProductSource.class)
public class Listener {

    private ProductService productService;

    public Listener(ProductService productService) {
        this.productService = productService;
    }

    private static Logger logger = LoggerFactory.getLogger(Listener.class);

    @StreamListener("createProductChannel")
    @SendTo("responseProductListChannel")
    public String createProduct(Product product) throws JsonProcessingException {
        logger.info("I received: {}", product);
        productService.create(product);
        List<Product> products = productService.getList();
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(products);
    }

    @StreamListener("requestProductListChannel")
    @SendTo("responseProductListChannel")
    public String getProductList(String message) throws JsonProcessingException {
        logger.info("I received {}", message);
        List<Product> products = productService.getList();
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(products);
    }
}
