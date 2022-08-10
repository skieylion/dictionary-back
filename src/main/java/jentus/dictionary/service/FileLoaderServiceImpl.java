package jentus.dictionary.service;

import jentus.dictionary.exception.FileUploadException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Base64;

@Service
public class FileLoaderServiceImpl implements FileLoaderService {

    @Override
    public ResponseEntity<String> download(final String url, final String format) throws FileUploadException {
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
                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=file" + format)
                    .body(body);
        } catch (URISyntaxException | IOException | InterruptedException e) {
            throw new FileUploadException();
        }
    }
}
