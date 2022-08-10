package jentus.dictionary.controller;

import jentus.dictionary.exception.FileUploadException;
import jentus.dictionary.service.FileLoaderService;
import jentus.dictionary.service.PhotoService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@CrossOrigin("http://localhost:3000")
@RestController
@AllArgsConstructor
public class PhotoCtrl {
    private final PhotoService photoService;
    private final FileLoaderService fileLoaderService;

    private String getFormat(String url) {
        MultiValueMap<String, String> params = UriComponentsBuilder.fromUriString(url).build().getQueryParams();
        return "." + params.getFirst("fm");
    }

    @GetMapping("/search/photos")
    public List<String> find(@RequestParam("query") String query) {
        return photoService.findPhotos(query);
    }

    @GetMapping("loader/photo")
    public ResponseEntity<String> download(@RequestParam("url") String url) throws FileUploadException {
        return fileLoaderService.download(url, getFormat(url));
    }
}
