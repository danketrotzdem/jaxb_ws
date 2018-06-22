package com.boring.webservice.example.demo;


import com.boring.webservice.example.domain.*;
import com.boring.webservice.example.domain.Number;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;

@Controller
public class LoeweController {

    private static Logger log = LoggerFactory.getLogger(LoeweController.class);

    @RequestMapping(method = RequestMethod.GET, value = "/loewe", produces=MediaType.APPLICATION_XML_VALUE )
    public @ResponseBody
    ProductWrapper mockLoewe(HttpServletRequest httpRequest, @RequestParam(required = false) String timestamp, HttpServletResponse httpResponse) {

        log.debug("before if statement");

        Enumeration headerNames = httpRequest.getHeaderNames();
        boolean found = false;
        while (headerNames.hasMoreElements()) {
            String key = (String) headerNames.nextElement();
            if (key.equalsIgnoreCase("API_KEY")) {
                found = true;
            }
        }


        if (found) {

            log.debug("passed API check. Security established");
            Product product = new Product();
            Product product2 = new Product();
            product.setNumber("WAP0001");
            product2.setNumber("WAP0002");
            Name name = new Name();
            name.setName("T-Shirt");
            name.setLanguage("de_DE");
            product.setNames(Collections.singletonList(name));
            product2.setNames(Collections.singletonList(name));

            ValueUnit lenght = new ValueUnit();
            lenght.setScala("cm");
            lenght.setValue("100");
            ValueUnit height = new ValueUnit();
            height.setScala("cm");
            height.setValue("100");
            ValueUnit width = new ValueUnit();
            width.setScala("cm");
            width.setValue("100");

            Size sizes = new Size();
            sizes.setHeight(height);
            sizes.setLength(lenght);
            sizes.setWidth(width);

            product.setSizes(sizes);
            product2.setSizes(sizes);


            ValueUnit weight = new ValueUnit();
            weight.setScala("kg");
            weight.setValue("1.4");

            product.setWeight(weight);
            product2.setWeight(weight);

            Mark mark = new Mark();
            mark.setType("fire");
            mark.setValue(true);

            Shipping shipping = new Shipping();
            shipping.setHazmat(true);
            shipping.setMarks(Collections.singletonList(mark));

            product.setShipping(shipping);
            product2.setShipping(shipping);

            Number number = new Number();
            number.setCountry("AT");
            number.setValue("456ZH7");



            Toll toll = new Toll();
            toll.setProductionCountry("DE");
            toll.setNumbers(Collections.singletonList(number));

            product.setToll(toll);

            List<Product> productList = new ArrayList<>();
            productList.add(product);
            productList.add(product2);

            ProductWrapper productWrapper = new ProductWrapper();
            productWrapper.setProducts(productList);


            return productWrapper;

        } else {
            log.debug("Authentification brutaly failed");
            httpResponse.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return null;
        }


    }
}
