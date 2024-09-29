package com.example.petprojecteshopspringboot2.ws.greeting;


import jakarta.xml.bind.annotation.*;

import javax.xml.datatype.XMLGregorianCalendar;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "greeting", propOrder = {
        "text",
        "date"
})
public class Greeting {
    @XmlElement(required = true)
    protected String text;
    @XmlElement(required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar date;

    public String getText() {
        return text;
    }
    public void setText(String value) {
        this.text = value;
    }
    public XMLGregorianCalendar getDate() {
        return date;
    }

    public void setDate(XMLGregorianCalendar value) {
        this.date = value;
    }
}
