package br.com.cliente.infra.dynamodb

import com.amazonaws.auth.AWSStaticCredentialsProvider
import com.amazonaws.auth.BasicAWSCredentials
import com.amazonaws.client.builder.AwsClientBuilder
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder
import org.socialsignin.spring.data.dynamodb.repository.config.EnableDynamoDBRepositories
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import java.util.*

@Configuration
@EnableDynamoDBRepositories(basePackages = ["br.com.cliente.infra.repository"])
class DynamoDBConfig(
    @Value("\${amazon.dynamodb.endpoint}") private val endpoint: String,
    @Value("\${amazon.aws.accesskey}") private val accessKey: String,
    @Value("\${amazon.aws.secretkey}") private val secretKey: String,
    @Value("\${amazon.aws.region}") private val region: String
) {
    @Bean
    fun amazonDynamoDB(): AmazonDynamoDB {
        val awsCredentials = BasicAWSCredentials(accessKey, secretKey)
        val awsCredentialsProvider = AWSStaticCredentialsProvider(awsCredentials)
        val endpointConfiguration = AwsClientBuilder.EndpointConfiguration(endpoint, region)
        return AmazonDynamoDBClientBuilder.standard()
            .withCredentials(awsCredentialsProvider)
            .withEndpointConfiguration(endpointConfiguration)
            .build()
    }

    @Bean
    fun awsCredentials() = BasicAWSCredentials(accessKey, secretKey)
}