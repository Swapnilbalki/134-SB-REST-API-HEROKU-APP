package in.ashokit.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.ashokit.dao.ProductDao;
import in.ashokit.entity.Product;

@RestController
public class ProductRestController {

	@Autowired
	private ProductDao pd;
	
	@PostMapping(value = "/saveProduct",consumes = {"application/json"})
	public ResponseEntity<String> saveProduct(@RequestBody Product product)
	{
		 pd.save(product);
		 return new ResponseEntity<String>("product saved", HttpStatus.CREATED);
	}
	
	@GetMapping(value = "/getProduct", produces ={"application/json"} )
	public ResponseEntity<List<Product>> getProduct()
	{
		List<Product> list = pd.findAll();
		return new ResponseEntity<List<Product>>(list, HttpStatus.OK);
	}
}
