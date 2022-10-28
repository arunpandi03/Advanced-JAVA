package controller;

import java.util.Map;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication(scanBasePackages= {"com.ta"})
@RestController
@RequestMapping
public class TestController {
	@RequestMapping(value="testAPI",method=RequestMethod.GET)
	public ResponseEntity<?>testAPI(@RequestParam Map<String,String>requestParams) throws Exception
	{
		requestParams.put("STATUS", "Sucsses");
		requestParams.put("DESC", " Test Sucsses");
		 
		return new ResponseEntity<>(requestParams,HttpStatus.OK);
	}
	

}
