package jentus.dictionary.config;

import feign.RequestInterceptor;
import feign.RequestTemplate;

public class HttpInterceptor implements RequestInterceptor {
    @Override
    public void apply(RequestTemplate requestTemplate) {
        requestTemplate.header("app_id", "3881dc47");
        requestTemplate.header("app_key", "f4bc19bc86aea1c804ca1e722a48357c");
//        requestTemplate.query("client_id","asd");
//        System.out.println(requestTemplate.queries());
    }
}
