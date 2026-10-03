package thjava.thbuoi2;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import thjava.thbuoi2.models.Category;
import thjava.thbuoi2.models.Product;
import thjava.thbuoi2.repository.CategoryRepository;
import thjava.thbuoi2.repository.ProductRepository;

@Configuration
public class DataInitializer {

    @Bean
    public CommandLineRunner initDatabase(CategoryRepository categoryRepository, ProductRepository productRepository) {
        return args -> {
            if (categoryRepository.count() == 0) {
                Category c1 = new Category();
                c1.setName("Điện thoại");
                categoryRepository.save(c1);

                Category c2 = new Category();
                c2.setName("Laptop");
                categoryRepository.save(c2);

                Product p1 = new Product();
                p1.setName("iPhone 15 Pro Max");
                p1.setPrice(30000000.0);
                p1.setDescription("Điện thoại Apple cao cấp");
                p1.setCategory(c1);
                productRepository.save(p1);

                System.out.println("=================================================");
                System.out.println(">>> KẾT NỐI VÀ KHỞI TẠO BẢNG CSDL THÀNH CÔNG! <<<");
                System.out.println("=================================================");
            }
        };
    }
}
