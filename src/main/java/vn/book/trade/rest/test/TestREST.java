package vn.book.trade.rest.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import vn.book.trade.dao.BookDAO;
import vn.book.trade.entity.Book;

@RestController
public class TestREST {
	@Autowired
	BookDAO testDao;
	@RequestMapping(value = "/book", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<Object> isNull() {
		Book a = testDao.findById(1);

		return  ResponseEntity.ok(a);
	}
	@RequestMapping(value = "/book", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<Object> isNull(@RequestBody Book t) {
			
			Book test = testDao.insert(t);
			return  ResponseEntity.ok(test);
		
	}


	


	

	
}
