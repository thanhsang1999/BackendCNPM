package vn.book.trade.rest.test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import vn.book.trade.dao.BookDAO;
import vn.book.trade.entity.Book;
import vn.book.trade.fileprocess.FileProcess;

@RestController
public class TestMultiPartREST {
	
	@Autowired BookDAO bookDAO;
	@PostMapping(value = "/test/upload/multipartfile", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	@ResponseBody
	public ResponseEntity<Object> testUploadFilePart(@RequestPart String title,@RequestPart String description,
			@RequestPart MultipartFile img) {
		String pathContain = "test";
		try {
			System.out.println(String.format("Name: %s", title));
			System.out.println(String.format("File: %s", img.getOriginalFilename()));
			
			File p = FileProcess.getPath(pathContain, img.getOriginalFilename()).toFile();
			System.out.println(p.getAbsolutePath());
			p.getParentFile().mkdirs();
			InputStream initialStream = img.getInputStream();
			OutputStream outStream = new FileOutputStream(p);

			byte[] buffer = new byte[8 * 1024];
			int bytesRead;
			while ((bytesRead = initialStream.read(buffer)) != -1) {
				outStream.write(buffer, 0, bytesRead);
			}
			IOUtils.closeQuietly(initialStream);
			IOUtils.closeQuietly(outStream);
			//TODO
			Book test =  new Book(title.toString(), img.getOriginalFilename(),description);
			Book t1 = bookDAO.insert(test);
			//
			return ResponseEntity.ok(t1);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}

	}

}
