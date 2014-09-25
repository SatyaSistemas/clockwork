package br.com.satyasistemas.resource;

import org.primefaces.push.annotation.OnMessage;
import org.primefaces.push.annotation.PushEndpoint;
import org.primefaces.push.impl.JSONEncoder;

import br.com.satyasistemas.bean.BugBean;
 
@PushEndpoint(BugBean.CHANNEL)
public class BugResource{
 
    @OnMessage(encoders = {JSONEncoder.class})
    public String onMessage(String s) {
	     return s;
    }
}  
