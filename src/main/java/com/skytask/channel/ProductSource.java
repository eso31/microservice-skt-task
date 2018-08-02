package com.skytask.channel;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

public interface ProductSource {

    @Input("productsChannelOutput")
    SubscribableChannel productsOutput();

    @Input("productListChannelOutput")
    SubscribableChannel productListOutput();

    @Output("productListChannelInput")
    MessageChannel productListInput();
}
