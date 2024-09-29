package com.example.petprojecteshopspringboot2.ws.greeting;


import jakarta.xml.bind.annotation.XmlRegistry;

@XmlRegistry
public class ObjectFactory {
    public ObjectFactory() {
    }

    public  GetGreetingResponse createGetGreetingResponse() {
        return new GetGreetingResponse();
    }

    public  Greeting createGreeting() {
        return new Greeting();
    }

    public GetGreetingRequest createGetGreetingRequest() {
        return new GetGreetingRequest();
    }
}
