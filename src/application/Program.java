package application;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

import java.util.Date;
import java.util.List;
import java.util.ServiceLoader;

public class Program {
    public static void main(String[] args){


        SellerDao sellerdao = DaoFactory.createSellerDao();

        System.out.println ("=== TEST 1: Seller findById ===");
       Seller seller = sellerdao.findById(3);

       System.out.println (seller);

        System.out.println ("=== TEST 2: Seller findByDepartment ===");
        Department dep = new Department(2, null);
        List<Seller> list = sellerdao.findByDepartment(dep);

        for(Seller obj : list){
            System.out.println (obj);
        }

        System.out.println ("=== TEST 3: Seller findAll ===");

        list = sellerdao.findAll();

        for(Seller obj : list){
            System.out.println (obj);
        }
    }
}
