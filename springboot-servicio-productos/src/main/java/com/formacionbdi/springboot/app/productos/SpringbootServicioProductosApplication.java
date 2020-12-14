package com.formacionbdi.springboot.app.productos;

import com.formacionbdi.springboot.app.productos.models.dao.ProductoDao;
import com.formacionbdi.springboot.app.productos.models.entity.Producto;
import com.formacionbdi.springboot.app.productos.models.service.IProductoService;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@EnableEurekaClient
@SpringBootApplication
public class SpringbootServicioProductosApplication {

    @Autowired
    private ProductoDao productoDao;

    public static void main(String[] args) {
        SpringApplication.run(SpringbootServicioProductosApplication.class, args);
    }


    @Bean
    InitializingBean sendDatabase() {
        return () -> {

            // Pedidos
            productoDao.save(new Producto("Panasonic", 800.2, new Date()));
            productoDao.save(new Producto("Sony", 700.3, new Date()));
            productoDao.save(new Producto("Apple", 1000.4, new Date()));
            productoDao.save(new Producto("Sony Notebook", 100.0, new Date()));
            productoDao.save(new Producto("Nike", 100.3, new Date()));

        };
    }

}
