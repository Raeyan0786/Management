package com.example.Management.service;

import com.example.Management.model.Management;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Service
public class ManagementService {
    private static List<Management> ls=new ArrayList<>();
    static  {
        ls.add(new Management(1, "sks12", "sonu", "patna Bihar", "123456789"));
    }

    public void addUser(Management management)
    {
        ls.add(management);
    }

    public List<Management>  getAllUser(){
        return ls;
    }

    public Management getUserById(int id)
    {
        Predicate<? super Management> predicate= management -> management.getId()==id;
        return ls.stream().filter(predicate).findFirst().get();
    }

    public void updateById(int id,Management management)
    {
        Management temp=getUserById(id);
        temp.setId(management.getId());
        temp.setUsername(management.getUsername());
        temp.setName(management.getName());
        temp.setAddress(management.getAddress());
        temp.setNo(management.getNo());
    }

    public void deleteById(int id)
    {
        Predicate<? super Management> predicate=management -> management.getId()==id;
        ls.removeIf(predicate);
    }
}
