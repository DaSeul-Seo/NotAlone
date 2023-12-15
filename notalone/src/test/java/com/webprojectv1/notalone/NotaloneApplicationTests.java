package com.webprojectv1.notalone;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.webprojectv1.notalone.product.IProductRepository;
import com.webprojectv1.notalone.product.Product;
import com.webprojectv1.notalone.product.ProductDao;

@SpringBootTest
class NotaloneApplicationTests {

	@Autowired
	IProductRepository iProductRepository;

	@Test
	void createProduct() {
		Product p = new Product();
		p.setProductName("Sample Product");
		p.setProductCategory(CategoryEnum.MEAT);
		p.setProductPrice(10.0);
		p.setProductRating(4.5);
		p.setProductStock(100);
		p.setProductImage("sample_image.jpg");

		iProductRepository.save(p);


	}

}
