package com.example.demo.Controller;
import com.example.demo.Models.LikeList;
import com.example.demo.Models.Product;
import com.example.demo.Models.User;
import com.example.demo.Repos.UserRepo;
import com.example.demo.Server.LikeListRequest;
import com.example.demo.Server.LikeListResponse;
import com.example.demo.Server.LikeListUpdateRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import com.example.demo.Repos.ProductRepo;
import com.example.demo.Repos.LikeListRepo;


import java.util.ArrayList;
import java.util.List;
@RestController
public class ApiController {

    @Autowired
    private ProductRepo productRepo;
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private LikeListRepo likeListRepo;

    //新增喜好金融商品
    @PostMapping(value = "/addLikeList")
    public String addLikeList(@RequestBody LikeListRequest request){
        Product product = productRepo.findByProductname(request.getproductname());
        if (product == null) {
            return "未找到商品";
        }
        //創建喜好清單
        LikeList likeList = new LikeList();
        likeList.setproduct(product);
        likeList.setordername(request.getordername());
        likeList.setaccount(request.getaccount());
        //totalfee及totalamount計算
        double feerate = (float) product.getfeerate();
        int price = product.getprice();
        int ordername = request.getordername();
        int totalfee = (int)(price * feerate);
        int totalamount = price * ordername + totalfee;
        likeList.settotalfee(totalfee);
        likeList.settotalamount(totalamount);

        likeListRepo.save(likeList);
        return "已加入喜好清單";
    }

    //查詢喜好金融商品清單
    @GetMapping(value = "/getLikeList")
    public List<LikeListResponse> getLikeList()
    {
        List<LikeList> likeList = likeListRepo.findAll();
        List<LikeListResponse> responseList = new ArrayList<>();

        for (LikeList item : likeList) {
            LikeListResponse response = new LikeListResponse(
                    item.getsn(),
                    item.getproduct().getproductname(),
                    item.getaccount(),
                    item.gettotalfee(),
                    item.gettotalamount()
            );

            User user = userRepo.findByAccount(item.getaccount());
            if (user != null) {
                response.setaccount(item.getaccount());
                response.setemail(user.getemail());
            }

            responseList.add(response);
        }

        return responseList;

    }
    //刪除喜好金融商品資訊
    @DeleteMapping("/removeLikeList/{sn}")
    public String removeLikeList(@PathVariable Long sn) {
        LikeList likeList = likeListRepo.findById(sn).orElse(null);
        if (likeList != null) {
            // 删除记录
            likeListRepo.delete(likeList);
            return "成功從喜好清單中移除";
        } else {
            return "喜好清單中未找到";
        }
    }
    //更改喜好金融商品
    @PutMapping("/updateLikeList/{sn}")
    public String updateLikeList(@PathVariable long sn, @RequestBody LikeListUpdateRequest request) {
        LikeList likeList = likeListRepo.findBySn(sn);
        if (likeList == null) {
            return "喜好清單中未找到";
        }
        likeList.setproduct(productRepo.findByProductname(request.getproductname()));
        likeList.setaccount(request.getaccount());
        likeList.setordername(request.getordername());

        //重新計算totalfee及totalamount
        Product product = likeList.getproduct();
        if (product != null) {
            double feerate = (float) product.getfeerate();
            int price = product.getprice();
            int totalfee = (int)(price * feerate);
            likeList.settotalfee(totalfee);
            likeList.settotalamount(product.getprice() * request.getordername() + likeList.gettotalfee());
        }
        likeListRepo.save(likeList);
        return "喜好清單更新成功";
    }


        @GetMapping(value = "/product")
    public List<Product> getProduct() {
        return productRepo.findAll();
    }

    @GetMapping(value = "/user")
    public List<User> getUser(){
        return userRepo.findAll();
    }

    @GetMapping(value = "/likelist")
    public List<LikeList> getLikelist(){
        return likeListRepo.findAll();
    }

    @PostMapping(value = "/product/save")
    public String saveProduct(@RequestBody Product product) {
        productRepo.save(product);
        return "Saved";
    }

    @PostMapping(value = "/likelist/save")
    public String saveLikeList(@RequestBody LikeList likelist) {
        likeListRepo.save(likelist);
        return "Saved";
    }
    @PutMapping(value = "/update/{no}")
    public String updateProduct(@PathVariable long no, @RequestBody Product product){
        Product updatedProduct = productRepo.findById(no).get();
        updatedProduct.setproductname(product.getproductname());
        updatedProduct.setprice(product.getprice());
        updatedProduct.setfeerate(product.getfeerate());
        productRepo.save(updatedProduct);
        return "Updated";
    }
    @DeleteMapping(value = "/delete/{no}")
    public String deleteProduct(@PathVariable long no){
        Product deleteProduct = productRepo.findById(no).get();
        productRepo.delete(deleteProduct);
        return "Deleted";
    }
}
