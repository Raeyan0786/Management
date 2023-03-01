package com.example.Management.controller;

import com.example.Management.model.Management;
import com.example.Management.service.ManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user/manage-app")
public class ManagementController {
    @Autowired
    ManagementService service;
    @PostMapping("add-user")
    public void add(@RequestBody Management management)
    {
        service.addUser(management);
    }

    @GetMapping("get-user")
    public List<Management> getAllUser()
    {
        return service.getAllUser();
    }

    @GetMapping("/get-user/id/{id}")
    public Management getUserById(@PathVariable int id){
        return service.getUserById(id);
    }

    @PutMapping("/update-user/id/{id}")
    public void updateById(@PathVariable  int id,@RequestBody Management management){
        service.updateById(id,management);
    }

    @DeleteMapping("/delete-user/id/{id}")
    public void deleteUserById(@PathVariable int id)
    {
        service.deleteById(id);
    }

}
