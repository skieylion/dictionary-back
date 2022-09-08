package jentus.dictionary.repository;

import jentus.dictionary.model.FileS3;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Repository
public interface FileRepository {
//    @PostMapping("/Files")
//    @Headers("Content-Type: multipart/form-data")
//    Search upload(@RequestParam("fileId") String fileId, @RequestPart("file") byte[] bytes);
//
//    @DeleteMapping("/Files/{fileId}")
//    void delete(@PathVariable("fileId") String fileId);

    void save(String fileId, MultipartFile multipartFile) throws IOException;
    FileS3 get(String fileId) throws IOException;
    void delete(String fileId);
    List<String> getAll() throws IOException;
}
