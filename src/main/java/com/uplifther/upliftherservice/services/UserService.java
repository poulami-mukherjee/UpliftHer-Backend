package com.uplifther.upliftherservice.services;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.model.*;
import com.uplifther.upliftherservice.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserService {

    @Autowired
    AmazonDynamoDB dynamoDB;

    public User getUserDetails(int userId) {
        GetItemRequest request = new GetItemRequest()
                .withTableName("user_details")
                .withKey(Map.of("user_id", new AttributeValue(Integer.toString(userId))));

        // need to do more here to use start date and end date.
        GetItemResult result = dynamoDB.getItem(request);
        // convert result to User
        return User.builder().userName("Test").build();
    }

    public User insertUserDetails(User user) {
        Map<String,AttributeValue> attributeValues = new HashMap<>();
        attributeValues.put("user_name",new AttributeValue().withS(user.getUserName()));
        attributeValues.put("user_id",new AttributeValue().withN(Integer.toString(user.getUserId())));

        // need to do more and find way to directly use pojo for insertion.
        PutItemRequest putRequest = new PutItemRequest();
        putRequest.setItem(attributeValues);

        dynamoDB.putItem(putRequest);
        return user;
    }
}
