package org.gleason;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.QueryRequest;
import com.amazonaws.services.dynamodbv2.model.QueryResult;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class UserRepoService {
    private AmazonDynamoDB ddb;
    public UserRepoService( @Value("${amazon.accessKey}") String accessKey,
                            @Value("${amazon.secretKey}") String secretKey
                            ){
        BasicAWSCredentials awsCreds = new BasicAWSCredentials(
                accessKey,
                secretKey);
        ddb = AmazonDynamoDBClientBuilder.standard()
                .withRegion(Regions.US_EAST_2)
                .withCredentials(
                        new AWSStaticCredentialsProvider(awsCreds)
                )
                .build();
    }
    private QueryResult search(String email){
        Map<String,AttributeValue> expressionAttributeValues = new HashMap<>();
        expressionAttributeValues.put(":email",new AttributeValue().withS(email));
        QueryRequest spec = new QueryRequest()
                .withKeyConditionExpression("email = :email")
                .withExpressionAttributeValues(expressionAttributeValues)
                .withTableName("second_ave_users");

        return ddb.query(spec);
    }
    private Map<String,AttributeValue> addUser(String email){
        Map<String,AttributeValue> item_values =
                new HashMap<>();
        item_values.put("email", new AttributeValue(email));
        item_values.put("count", new AttributeValue("1"));
        saveUser(item_values);
        return item_values;
    }
    private void saveUser(Map<String,AttributeValue> user){
        ddb.putItem("second_ave_users", user);
    }
    public Map<String,AttributeValue> updateUser(Map<String,AttributeValue> obj){
        Integer count = obj.get("count") == null ? 0 : Integer.parseInt(obj.get("count").getS());
        count += 1;
        obj.put("count", new AttributeValue(count.toString()));
        saveUser(obj);
        return obj;
    }
    public Map<String,AttributeValue> getUser(String email){
        QueryResult resultSet = this.search(email);
        return resultSet.getCount() == 0 ? addUser(email) : updateUser(resultSet.getItems().get(0));
    }
}
