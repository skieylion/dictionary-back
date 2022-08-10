package jentus.dictionary.service.mapper;

import jentus.dictionary.model.UnsplashPhotos;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PhotosMapper {

    default String convert(UnsplashPhotos.Result r) {
        return r.getUrls().getFull();
    }

    List<String> convert(List<UnsplashPhotos.Result> r);
}