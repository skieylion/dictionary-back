package jentus.dictionary.repository;

import feign.Headers;
import jentus.dictionary.config.HttpConfig;
import jentus.dictionary.model.Search;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;

@FeignClient(
        url = "http://localhost:8082",
        value = "fileRepository",
        configuration = HttpConfig.class
)
public interface FileRepository {
    @PostMapping("/Files")
    @Headers("Content-Type: multipart/form-data")
    Search upload(@RequestParam("fileId") String fileId, @RequestPart("file") byte[] bytes);

}
