package jentus.dictionary.service;

import jentus.dictionary.exception.FileUploadException;
import jentus.dictionary.repository.PhotosRepository;
import jentus.dictionary.service.mapper.PhotosMapper;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Base64;
import java.util.List;

@Service
@AllArgsConstructor
public class PhotoServiceImpl implements PhotoService {

    private final PhotosRepository photosRepository;
    private final PhotosMapper photosMapper;

    @Override
    public List<String> findPhotos(String query) {
        return photosMapper.convert(photosRepository.findPhotos(query).getResults());
    }

    @Override
    public ResponseEntity<String> downloadPhoto(final String url) throws FileUploadException {
        MultiValueMap<String, String> params = UriComponentsBuilder.fromUriString(url).build().getQueryParams();
        final String fm = "." + params.getFirst("fm");

        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(new URI(url))
                    .GET()
                    .build();
            HttpResponse<byte[]> response = HttpClient.newBuilder()
                    .build()
                    .send(request, HttpResponse.BodyHandlers.ofByteArray());
            String body = Base64.getEncoder().encodeToString(response.body());
            return ResponseEntity
                    .ok()
                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=photo" + fm)
                    .body(body);
        } catch (URISyntaxException | IOException | InterruptedException e) {
            throw new FileUploadException();
        }
    }
}
