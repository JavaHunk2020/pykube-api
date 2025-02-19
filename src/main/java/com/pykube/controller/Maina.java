package com.pykube.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

 class MultiDateDeserializer  extends JsonDeserializer<Date> {

   
    // List of date formats to handle
    private static final List<SimpleDateFormat> DATE_FORMATS = Arrays.asList(
    		new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSSSSS"),
    		new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSSSS"),
    	    new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS"),
            new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS"),
            new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
    );

    @Override
    public Date deserialize(JsonParser jsonParser, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        String dateStr = jsonParser.getText();
        String dateString = jsonParser.getText();
        for (SimpleDateFormat dateFormat : DATE_FORMATS) {
            try {
                return dateFormat.parse(dateStr);
            } catch (ParseException e) {
            	e.printStackTrace();
            }
        }
        // If no format matches, throw an exception
        return new Date();
    }
}

class LocalDateTimeToDateDeserializer extends JsonDeserializer<Date> {
    @Override
    public Date deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        String dateStr = p.getText();
        LocalDateTime localDateTime = LocalDateTime.parse(dateStr, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        return Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
    }
}

 class MyDate {

    @JsonDeserialize(using = MultiDateDeserializer.class)
	//@JsonFormat(pattern = "yyyy-mm-dd HH:mm:ss")
    
    //@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSSSSS")
    private Date myDate;

    public Date getMyDate() {
        return myDate;
    }

    public void setMyDate(Date myDate) {
        this.myDate = myDate;
    }
}

public class Maina {
    public static void main(String[] args) throws Exception {
        String jsonString = "{\"myDate\":\"2024-07-19 15:09:50.218\"}";

        ObjectMapper objectMapper = new ObjectMapper();
        MyDate myObject = objectMapper.readValue(jsonString, MyDate.class);

        // Access the deserialized Date
        Date date = myObject.getMyDate();
        System.out.println("Deserialized Date: " + date);
    }
}
