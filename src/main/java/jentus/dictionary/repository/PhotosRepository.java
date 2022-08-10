package jentus.dictionary.repository;

import jentus.dictionary.config.UnsplashHttpInterceptor;
import jentus.dictionary.model.UnsplashPhotos;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(
        url = "https://api.unsplash.com",
        value = "searchPhotosRepository",
        configuration = UnsplashHttpInterceptor.class
)
public interface PhotosRepository {
    @GetMapping("/search/photos")
    UnsplashPhotos findPhotos(@RequestParam("query") String query);
}
