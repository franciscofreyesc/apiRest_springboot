package com.init.products.productapi.rest;

import java.util.List;
import java.util.Optional;

import com.init.products.productapi.dao.ProductDAO;
import com.init.products.productapi.entities.Product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//Indicar a la clase que será un Rest 
@RestController
//Indicar url de la clase
@RequestMapping("/api/products")
public class ProductRest {
    
    @Autowired
    private ProductDAO productDAO;
    
    //No se le puede setear ruta
    @GetMapping
    //Se puede setear la ruta
    //@RequestMapping(value = "hello", method = RequestMethod.GET)
    
    //Todos los productos
    public ResponseEntity<List<Product>> getProductos(){
        List<Product> products = productDAO.findAll();
        return ResponseEntity.ok(products);
    }
    //Solo un producto
    @RequestMapping(value="{productId}")
    public ResponseEntity<Product> getProductoById(@PathVariable("productId") long productId){
        Optional<Product> optionalProduct = productDAO.findById(productId);
        if (!optionalProduct.isPresent()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(optionalProduct.get());
    }

    //Crear un producto nuevo
    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody Product producto){
        Product newProduct = productDAO.save(producto);
        return ResponseEntity.ok(newProduct);

    }

    //Eliminar producto por id
    @DeleteMapping(value="{productId}")
    public ResponseEntity<Void> removeProduct(@PathVariable("productId") long productId){
        Optional<Product> optionalProduct = productDAO.findById(productId);
        if (!optionalProduct.isPresent()){
            return ResponseEntity.noContent().build();
        }
        productDAO.deleteById(productId);
        return ResponseEntity.ok(null);
    }

    //Actualizar producto por id
    //Solo un producto
    @PutMapping
    public ResponseEntity<Product> updateProduct(@RequestBody Product producto){
        Optional<Product> optionalProduct = productDAO.findById(producto.getId());
        if (!optionalProduct.isPresent()){
            return ResponseEntity.noContent().build();
        }
        Product updateProduct = optionalProduct.get();
        updateProduct.setNombre(producto.getNombre());
        productDAO.save(updateProduct);
        return ResponseEntity.ok(updateProduct);
    }
}