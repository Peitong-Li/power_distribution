package com.yjw.power_distribution.controller;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.yjw.power_distribution.pojo.*;
import com.alibaba.fastjson.JSON;
import com.yjw.power_distribution.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.UUID;

@Controller
public class TestController {

    @Autowired
    DeviceService deviceService;

    @PostMapping("/uploadPicture")
    @ResponseBody
    public String uploadPicture(MultipartFile imageFile, String PictureName, String Transformers)throws Exception{
        System.out.println("获取的台区名称："+PictureName);
        System.out.println("获取的变压器："+Transformers);
        if(!imageFile.isEmpty()){
            System.out.println("imageFile不为空");
            String imageFileName = imageFile.getOriginalFilename();//获取图片名
            //System.out.println("图片名："+imageFileName);

            String image_suffixName = imageFileName.substring(imageFileName.lastIndexOf("."));//图片后缀
            String new_imageFileName = UUID.randomUUID()+image_suffixName;   //UUID生成前缀
            String imagePath = "C:\\upload_2021\\Project_2021\\images\\"+new_imageFileName;  //上传图片路径

            File image_dest = new File(imagePath);
            if(!image_dest.getParentFile().exists()){
                image_dest.getParentFile().mkdirs();  //不存在路径  创建路径
            }
            try{
                imageFile.transferTo(image_dest);  //图片转移到指定路径
            }catch (Exception exception){
                exception.printStackTrace();
                System.out.println("上传失败");
                return "{\"uploadMsg\":\"0\"}";//上传失败
            }
        }
//        System.out.println("上传成功");
//        JSONObject json =new JSONObject();
        return "{\"uploadMsg\":\"1\"}";//上传成功
    }

}
