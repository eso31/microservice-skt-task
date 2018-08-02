package com.skytask.channel;

import org.springframework.cloud.stream.annotation.EnableBinding;

@EnableBinding(ProductSource.class)
public class ProductProcessor {
}
