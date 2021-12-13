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

//Listing 16.29 Marking a non-root class
//Listing A.3 LineItem: An entry in order describing the product and its quanity
package ajia.domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import ajia.enforcement.Aggregate;
import ajia.util.DomainEntity;
import ajia.service.impl.ReadOnly;

@Aggregate("order")
@Entity
@Table(name = "lineItems")
public class LineItem extends DomainEntity {
    @ManyToOne(cascade = CascadeType.ALL)
    private Product product;
    @ManyToOne
    private Order order;
    private int quantity;
    private double unitPrice;

    private LineItem() {
    }

    public LineItem(Order order, Product product, int quantity) {
        this.order = order;
        this.product = product;
        this.quantity = quantity;
        this.unitPrice = product.getPrice();
    }

    public int getQuantity() {
        return quantity;
    }

    public int setQuantity(int quantity) {
        return this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public double getLineTotal() {
        return getQuantity() * getUnitPrice();
    }
    
    private static aspect ReadOnlyDesignator {
        declare @method
            : * LineItem.get*(..) : @ReadOnly;
    }
}