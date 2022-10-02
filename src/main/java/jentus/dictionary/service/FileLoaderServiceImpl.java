package jentus.dictionary.service;

import jentus.dictionary.exception.FileUploadException;
import jentus.dictionary.model.dto.FileDto;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.List;

@Service
public class FileLoaderServiceImpl implements FileLoaderService {

    private static String content(String fileName, String format) {
        return "attachment; filename=" + fileName + "." + format;
    }

    @Override
    public ResponseEntity<FileDto> download(String fileName, String format, String url) throws FileUploadException {
        try {
            HttpRequest request = HttpRequest.newBuilder().uri(new URI(url)).GET().build();
            HttpResponse<byte[]> response = HttpClient.newBuilder().build().send(request, HttpResponse.BodyHandlers.ofByteArray());
            String data64 = Base64.getEncoder().encodeToString(response.body());
            return ResponseEntity
                    .ok()
                    .header(HttpHeaders.CONTENT_DISPOSITION, content(fileName, format))
                    .body(new FileDto(fileName, format, data64));
        } catch (URISyntaxException | IOException | InterruptedException e) {
            throw new FileUploadException();
        }
    }
}
