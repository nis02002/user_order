package com.ning;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ProductService {

	@Autowired
	private ProductRepository prorepo;
	
	public List<Product> listAll() {
		return prorepo.findAll();
	}
	
	public Product get(long id) {
		return prorepo.findById(id).get();
	}
	
/*	
	public void save(Product product) {
		prorepo.save(product);
	}
	
	
	public void delete(long id) {
		prorepo.deleteById(id);
	}
	*/
}
