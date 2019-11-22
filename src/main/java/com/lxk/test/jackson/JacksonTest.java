package com.lxk.test.jackson;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lxk.test.bean.SecurityPolicyLog;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import java.util.Collections;
import java.util.Properties;

public class JacksonTest {
    @SuppressWarnings("all")
    public static void main(String[] args) {

        Properties props = new Properties();
        props.put("bootstrap.servers", "192.168.40.151:9092");
        props.put("group.id", "test-fastjson");
        props.put("key.deserializer","org.apache.kafka.common.serialization.StringDeserializer");
        // 设置反序列化类为自定义的avro反序列化类
        props.put("value.deserializer","org.apache.kafka.common.serialization.StringDeserializer");
        props.put("auto.offset.reset","latest");
//        props.put("fetch.min.bytes",104857600);//broker返回给消费者最小的数据量
//        props.put("fetch.max.bytes",1048576000);//broker返回给消费者最小的数据量
//        props.put("fetch.max.wait.ms",100000);//broker的等待时间
//        props.put("max.poll.records",100000);//单次poll调用返回的最大消息数
//        props.put("min.poll.records",10000);//单次poll调用返回的最小消息数
//        props.put("max.partition.fetch.bytes",104857600);//每个分区里返回给消费者的最大字节数  默认1MB


        KafkaConsumer<String, String> consumer = new KafkaConsumer<>(props);

        consumer.subscribe(Collections.singletonList("test-json"));
        int count=0;
        long start = System.currentTimeMillis();
        try {
            while(true) {
//                long start = System.currentTimeMillis();
                ConsumerRecords<String, String> records = consumer.poll(1000);
                //System.out.println("records count:"+records.count());
                for(ConsumerRecord<String, String> record : records) {
                    String value = record.value();
//TODO json转对象

//                  SecurityPolicyLog securityPolicyLog = JSONObject.parseObject(value, SecurityPolicyLog.class);
                    ObjectMapper mapper = new ObjectMapper();
                    SecurityPolicyLog securityPolicyLog = mapper.readValue(value, SecurityPolicyLog.class);
                    System.out.println(securityPolicyLog.toString());
                    //System.out.println(record.value());
//                    System.out.println("offset:"+record.offset());
                }
                count=count+records.count();
                long end = System.currentTimeMillis();
                if(end-start >= Long.valueOf(1000)){
                    System.out.println("time:"+(end-start));
                    System.out.println("count:"+count);
                    start = System.currentTimeMillis();
                    count=0;
                }
                //System.out.println("时间："+ String.valueOf(System.currentTimeMillis()-start));
            }
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        } finally {
            consumer.close();
        }
    }
}

