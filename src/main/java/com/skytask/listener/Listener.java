package com.skytask.listener;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.skytask.channel.ProductSource;
import com.skytask.model.Product;
import com.skytask.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.SendTo;

import java.util.List;

@EnableBinding(ProductSource.class)
public class Listener {

    @Autowired
    private ProductService productService;

    @StreamListener("productsChannelOutput")
    public void gettingProduct(Product product) {
        System.out.println("I received: " + product);
        productService.create(product);
    }

    @StreamListener("productListChannelOutput")
    @SendTo("productListChannelInput")
    public String gettingRequest(String message) throws JsonProcessingException {
        System.out.println("I received " + message);
        List<Product> products = productService.getList();
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(products);
    }
}
