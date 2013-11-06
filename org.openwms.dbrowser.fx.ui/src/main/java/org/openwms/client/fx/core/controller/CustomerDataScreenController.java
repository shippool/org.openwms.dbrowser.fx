/*
 * openwms.org, the Open Warehouse Management System.
 *
 * This file is part of openwms.org.
 *
 * openwms.org is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as 
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * openwms.org is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software. If not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */
package org.openwms.client.fx.core.controller;

import javafx.collections.ObservableList;

import org.openwms.client.fx.core.model.Customer;
import org.openwms.client.fx.core.model.CustomerModel;
import org.openwms.client.fx.core.spring.CoreViewConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;

/**
 * A CustomerDataScreenController.
 * 
 * @author <a href="mailto:scherrer@openwms.org">Heiko Scherrer</a>
 * @version $Revision: $
 * 
 */
public class CustomerDataScreenController {

    @Autowired
    private CustomerModel customerModel;
    private CoreViewConfiguration screens;

    /**
     * Create a new CustomerDataScreenController.
     */
    public CustomerDataScreenController() {}

    /**
     * Create a new CustomerDataScreenController.
     * 
     * @param screens
     */
    public CustomerDataScreenController(CoreViewConfiguration screens) {
        this.screens = screens;
    }

    /**
     * FIXME [scherrer] Comment this
     * 
     */
    public void showErrorDialog() {
        screens.errorDialog().show();
    }

    /**
     * FIXME [scherrer] Comment this
     * 
     * @return
     */
    public ObservableList<Customer> getCustomers() {
        return customerModel.getCustomers();
    }

    /**
     * FIXME [scherrer] Comment this
     * 
     */
    @Secured({ "ROLE_MANAGER", "ROLE_EMPLOYEE" })
    public void addCustomer() {
        screens.addCustomerDialog().show();
    }

    /**
     * FIXME [scherrer] Comment this
     * 
     * @param customer
     */
    public void removeCustomer(Customer customer) {
        customerModel.remove(customer);
    }
}
