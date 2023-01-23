package com.bank.customer.Respository;

import com.bank.customer.entity.Customer;
import com.bank.customer.response.entity.CustomerResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.websocket.server.PathParam;
import java.util.List;

public interface CutomerRepository extends JpaRepository<Customer,Integer> {

    @Query("select c from Customer c  JOIN  c.accounts a  where c.gender= :gender and a.bankName= :bankName")
   public List<Customer> findByBankNameAndGender(@Param("bankName") String name, @Param("gender") String gender);
}
