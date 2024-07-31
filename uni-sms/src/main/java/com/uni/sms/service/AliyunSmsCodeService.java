package com.uni.sms.service;


import com.aliyun.dysmsapi20170525.Client;
import com.aliyun.dysmsapi20170525.models.SendSmsRequest;
import com.aliyun.dysmsapi20170525.models.SendSmsResponse;
import com.aliyun.teaopenapi.models.Config;
import com.aliyun.teautil.models.RuntimeOptions;

public class AliyunSmsCodeService implements SmsService {

    private final static String ALIYUN_ENDPOINT = "dysmsapi.aliyuncs.com";
    private Client client;

    public AliyunSmsCodeService(String accessKeyId, String accessKeySecret) {
        client = createAliyunSmsClient(accessKeyId, accessKeySecret);
    }

    public Client createAliyunSmsClient(String accessKeyId, String accessKeySecret) {
        Config config = new Config();
        config.setAccessKeyId(accessKeyId);
        config.setAccessKeySecret(accessKeySecret);
        config.endpoint = ALIYUN_ENDPOINT;
        Client client;
        try {
            client = new Client(config);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return client;
    }

    public void sendSms(String phoneNumber, String code) {
        SendSmsRequest request =
                new SendSmsRequest()
                    .setSignName("阿里云短信测试")
                    .setTemplateCode("SMS_154950909")
                    .setPhoneNumbers(phoneNumber)
                    .setTemplateParam("{\"code\":\"" + code + "\"}");
        System.out.println(request);
        RuntimeOptions runtime = new RuntimeOptions();
        try {
            SendSmsResponse sendSmsResponse = client.sendSmsWithOptions(request, runtime);
            System.out.println("sendSmsResponse = " + sendSmsResponse.toString());
        } catch (Exception exception) {
            System.out.println("exception = " + exception);
            throw new RuntimeException(exception);
        }
    }
}
