package com.uplifther.upliftherservice.services;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.model.*;
import com.uplifther.upliftherservice.model.Insight;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class MoodService {

    @Autowired
    AmazonDynamoDB dynamoDB;

    public void doSomething() {

    }

    public Insight getMoodInsights(String startDate, String endDate) {
        // We're using queryrequest because we expect multiple records based on query.
        QueryRequest request = new QueryRequest()
                .withTableName("mood_selection")
                .withKeyConditionExpression("start_date <= ..."); // need to complete it


        // need to do more here to use start date and end date.
        QueryResult result = dynamoDB.query(request);
        // need to convert result to Insight object
        return new Insight("test");
    }
}
