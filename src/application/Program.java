package application;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.ServiceLoader;

public class Program {
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

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

        System.out.println ("=== TEST 4: Seller Insert ===");

        Seller newSeller = new Seller("Greg", null, "greg@gmail.com", new Date(), 4000.0, dep );
        sellerdao.insert(newSeller);

        System.out.println ("Inserted! New id = " + newSeller.getId());

        System.out.println ("=== TEST 5: Seller Insert ===");
        seller = sellerdao.findById(1);
        seller.setName("Marta Waine");
        sellerdao.update(seller);

        System.out.println ("Update completed.");

        System.out.println ("=== TEST 6: Seller Delete ===");
        System.out.println ("Enter ID: ");
        int id = sc.nextInt();

        sellerdao.deleteById(id);

        System.out.println ("Delete completed.");

        sc.close();



    }
}
