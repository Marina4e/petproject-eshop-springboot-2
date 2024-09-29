package com.example.petprojecteshopspringboot2.ws.greeting;

import jakarta.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "greeting"
})
@XmlRootElement(name = "getGreetingResponse")
public class GetGreetingResponse {

    @XmlElement(required = true)
    protected Greeting greeting;

    public Greeting getGreeting() {
        return greeting;
    }
    public void setGreeting(Greeting value) {
        this.greeting = value;
    }
}
