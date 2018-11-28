package top.imlgw.sms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class SmsTestDemo {
    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;

    @RequestMapping("/sendSms")
    public void sendMessage(String text){
        Map map=new HashMap<>();
        map.put("mobile", "18727217669");
        map.put("template_code", "SMS_151090525");
        map.put("sign_name", "品优购");
        map.put("param", "{\"code\":\"123456\"}");
        jmsMessagingTemplate.convertAndSend("sms",map);
    }
}
