package com.g2academy.mybatis.springbootmybatis.resource;


import com.g2academy.mybatis.springbootmybatis.mapper.UsersMapper;
import com.g2academy.mybatis.springbootmybatis.model.Users;
import org.json.simple.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sekolah/student")
public class UsersResource {

    private UsersMapper usersMapper;

    public UsersResource(UsersMapper usersMapper) {
        this.usersMapper = usersMapper;
    }



    @GetMapping("/all")
    public List<Users> getAll(){
        return usersMapper.findAll();
    }

    @PostMapping("/insert")
    public ResponseEntity<?> insert(@RequestBody Users users){
        Users users1 = new Users(users.getName(),users.getBranch(),users.getPercentage(),users.getPhone(),users.getEmail());
        usersMapper.insert(users1);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("berhasil menambahkan",users1);
        return new ResponseEntity<>(jsonObject, HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable int id,@RequestBody Users users){
        Users usr = new Users(id,users.getName(),users.getBranch(),users.getPercentage(),users.getPhone(),users.getEmail());
        usersMapper.update(usr);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("update berhasil",usr);
        return new ResponseEntity<>(jsonObject,HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable int id){
        Users user = new Users();
        user.setId(id);
        usersMapper.delete(user);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("berhasi menghapus id",id);
        return new ResponseEntity<>(jsonObject,HttpStatus.ACCEPTED);
    }


}
