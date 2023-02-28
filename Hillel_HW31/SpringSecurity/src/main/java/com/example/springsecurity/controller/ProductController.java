package com.example.springsecurity.controller;

import com.example.springsecurity.dto.ProductDto;
import com.example.springsecurity.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Slf4j
@RequiredArgsConstructor
@RequestMapping("/products")
@Controller
public class ProductController {

    private final ProductService productService;

    @GetMapping(value = "/{id}")
    public String getProductById(Model model, @RequestParam int id) {
        model.addAttribute("productById", productService.getById(id));
        return "product/productbyid";
    }

    @GetMapping("add")
    public String addProduct(Model model) {
        log.info("ProductRestController Add Product");
        model.addAttribute("errorMsgs", new ArrayList<>());
        model.addAttribute("product", new ProductDto());
        return "product/addproduct";
    }

    @PostMapping
    public String saveAddProduct(ProductDto productDto) {
        productService.createProduct(productDto);
        return "redirect:/product/addproduct";
    }

    @GetMapping
    public String getProductAll(Model model) {
        model.addAttribute("listProducts", productService.getAllProducts());
        return "product/allproducts";
    }

    @DeleteMapping(value = "{id}")
    public String removeProductById(@RequestParam int id) {
        productService.removeProductById(id);
        return "redirect:/menu";
    }

    @DeleteMapping
    public String removeAllProducts() {
        productService.removeAllProducts();
        return "redirect:/menu";
    }
}
