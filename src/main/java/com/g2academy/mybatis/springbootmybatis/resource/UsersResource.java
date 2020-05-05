package com.g2academy.mybatis.springbootmybatis.resource;


import com.g2academy.mybatis.springbootmybatis.mapper.UsersMapper;
import com.g2academy.mybatis.springbootmybatis.model.Users;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student/")
public class UsersResource {

    @Autowired
    private UsersMapper usersMapper;

    @GetMapping("/")
    public List<Users> getAll(){
        return usersMapper.findAll();
    }

    @PostMapping("/")
    public ResponseEntity<?> insert(@RequestBody Users users){
        usersMapper.insert(users);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("berhasil menambahkan",users);
        return new ResponseEntity<>(jsonObject, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable int id,@RequestBody Users users){
        users.setId(id);
        usersMapper.update(users);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("update berhasil",users);
        return new ResponseEntity<>(jsonObject,HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable int id){
        usersMapper.delete(id);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("berhasi menghapus id",id);
        return new ResponseEntity<>(jsonObject,HttpStatus.ACCEPTED);
    }


}
