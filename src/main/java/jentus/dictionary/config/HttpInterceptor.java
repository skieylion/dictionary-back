package jentus.dictionary.config;

import feign.RequestInterceptor;
import feign.RequestTemplate;

public class HttpInterceptor implements RequestInterceptor {
    @Override
    public void apply(RequestTemplate requestTemplate) {
        requestTemplate.header("app_id", "6a210e8a");
        requestTemplate.header("app_key", "60a358aa1cddc58b426dd8b7b974da5d");
//        requestTemplate.query("client_id","asd");
//        System.out.println(requestTemplate.queries());
    }
}
