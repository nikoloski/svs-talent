package com.seavus.restcontroller;

import com.seavus.service.associationservice.LendBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/lendbooks")
public class LendBookRestController {

    private LendBookService lendBookService;

    public LendBookRestController(LendBookService lendBookService) {
        this.lendBookService = lendBookService;
    }

    @PostMapping
    public void lendBook(@RequestBody String text) {
        String[] requestBody = text.split(" ");
        System.out.println(requestBody[0] + " " + requestBody[1]);
        lendBookService.lendBook(requestBody[0], requestBody[1]);
    }
}
