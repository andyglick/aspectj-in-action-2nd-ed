/*
Copyright 2009 Ramnivas Laddad

Licensed under the Apache License, Version 2.0 (the "License"); 
you may not use this file except in compliance with the License. 
You may obtain a copy of the License at 
    http://www.apache.org/licenses/LICENSE-2.0 

Unless required by applicable law or agreed to in writing, software 
distributed under the License is distributed on an "AS IS" BASIS, 
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. 
See the License for the specific language governing permissions and 
limitations under the License. 
*/

package ajia.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import ajia.domain.Order;
import ajia.domain.Product;
import ajia.service.InventoryService;
import ajia.service.OrderService;
import ajia.service.ProductService;

public class Main {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("META-INF/spring/*.xml");
        
        OrderService orderService = (OrderService) context.getBean("orderService");
        ProductService productService = (ProductService)context.getBean("productService");
        Order order = new Order();
        Product product = productService.findProduct(1001L);
        orderService.addProduct(order, product, 1);
        
        InventoryService inventoryService = (InventoryService) context.getBean("inventoryService");
        inventoryService.expireProduct(product);
    }
}
