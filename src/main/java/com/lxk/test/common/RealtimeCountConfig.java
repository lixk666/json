package com.lxk.test.common;

import com.lxk.test.utils.RealtimeCountConfigurations;

import java.io.Serializable;

public class RealtimeCountConfig implements Serializable {
    private static final long serialVersionUID = 1641809911536544588L;

    /**
     * 通用log表字段数
     */
    //kafka集群地址
    public static final String BOOTSTRAP_SERVERS = RealtimeCountConfigurations.getStringProperty(0, "bootstrap.servers");
    public static final String CUSTOM_COMPRESSION_TYPE = RealtimeCountConfigurations.getStringProperty(0, "custom.compression.type");
    public static final String GROUP_ID = RealtimeCountConfigurations.getStringProperty(0, "kafka.group.id");
    public static final String GROUP_ID_PREFIX = RealtimeCountConfigurations.getStringProperty(0, "kafka.group.id.prefix");

    public static final Integer TOPOLOGY_CONFIG_MAX_SPOUT_PENDING = 300000;
    public static final Integer TOPOLOGY_NUM_ACKS = 0;
    public static final String KAFKA_TOPIC = "";
    public static final String KAFKA_HA_TOPIC = RealtimeCountConfigurations.getStringProperty(0, "kafka.ha.topic");

    public static final String KAFKA_RRL_TOPIC = RealtimeCountConfigurations.getStringProperty(0, "kafka.rrl.topic");
    public static final String KAFKA_SEL_TOPIC = RealtimeCountConfigurations.getStringProperty(0, "kafka.sel.topic");
    public static final String KAFKA_PEL_TOPIC = RealtimeCountConfigurations.getStringProperty(0, "kafka.pel.topic");
    public static final String KAFKA_CRL_TOPIC = RealtimeCountConfigurations.getStringProperty(0, "kafka.crl.topic");
//    public static final String KAFKA_CCRL_TOPIC = RealtimeCountConfigurations.getStringProperty(0, "kafka.ccrl.topic");
//    public static final String KAFKA_CHML_TOPIC = RealtimeCountConfigurations.getStringProperty(0, "kafka.chml.topic");
//    public static final String KAFKA_CSRL_TOPIC = RealtimeCountConfigurations.getStringProperty(0, "kafka.csrl.topic");
//    public static final String KAFKA_CMRL_TOPIC = RealtimeCountConfigurations.getStringProperty(0, "kafka.cmrl.topic");
//    public static final String KAFKA_CBRL_TOPIC = RealtimeCountConfigurations.getStringProperty(0, "kafka.cbrl.topic");
//    public static final String KAFKA_CPRL_TOPIC = RealtimeCountConfigurations.getStringProperty(0, "kafka.cprl.topic");



    public static final Integer SPEED_NUM = RealtimeCountConfigurations.getIntProperty(0, "speed.num");
    public static final Integer INSERT_NUM = RealtimeCountConfigurations.getIntProperty(0, "insert.num");
    public static final Integer SLEEP_NUM = RealtimeCountConfigurations.getIntProperty(0, "sleep.num");

    public static final String COMMON_POLICY_ID = RealtimeCountConfigurations.getStringProperty(0, "common.policy.id");

    public static final String AUTO_OFFSET_RESET = "latest";

//    public static void configShow() {
//        System.out.println("BOOTSTRAP_SERVERS: " + BOOTSTRAP_SERVERS);
//        System.out.println("GROUP_ID_PREFIX: " + GROUP_ID_PREFIX);
//        System.out.println("GROUP_ID: " + GROUP_ID);
//    }

    public static final String IPV4_DATAS= RealtimeCountConfigurations.getStringProperty(0, "IPV4Datas");
    public static final String IPV6_DATAS= RealtimeCountConfigurations.getStringProperty(0, "IPV6Datas");
    public static final String URL_DATAS= RealtimeCountConfigurations.getStringProperty(0, "urlDatas");
}
