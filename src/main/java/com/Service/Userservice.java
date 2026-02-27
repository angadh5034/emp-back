package com.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.Dto.Userdto;
import com.Repository.Userrepository;
import com.entity.User;

@Service
public class Userservice {
	@Autowired
	Userrepository urepo;

    public String register(User u){
        User existinguser=urepo.findByUsername(u.getUsername());
        if (existinguser==null){
            urepo.save(u);
            return "registration successful";
        }else {
            return "Username already exists";
        }
    }

    public User login(Userdto userdto){
        User existinguser=urepo.findByUsername((userdto.getUsername()));
        if(existinguser==null){
            return null;

        }else 
            if(existinguser.getPassword().equals(userdto.getPassword()))
            {
             return existinguser;
            }
            else {
                return null;
            }
        }
    }



