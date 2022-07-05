package com.example.ManagerShoers.common.security;

import com.example.ManagerShoers.common.Constants;
import com.example.ManagerShoers.common.ServiceResponse;
import com.example.ManagerShoers.dao.entity.Account;
import com.example.ManagerShoers.dao.repo.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthUtil {
    @Autowired
    private AccountRepository accountRepository;

    public ServiceResponse<Boolean> checkToken(String accessToken){
        List<Account> list = accountRepository.findAll();
        ServiceResponse<Boolean> response = new ServiceResponse<>();
        for(Account item : list){
            if (item.getToken().equals(accessToken)){
                response.setCode(Constants.SUCCESS);
                response.setMessage(Constants.SUCCESS_AUT_MESSAGE);
                response.setData(true);
                return response;
            }
        }
        response.setCode(Constants.ERROR);
        response.setMessage(Constants.ERROR_AUT_MESSAGE);
        response.setData(false);
        return response;
    }
}
