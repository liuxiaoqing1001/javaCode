package com.isoft.news.controller;

import com.isoft.news.bean.ResponseData;
import com.isoft.news.entity.User;
import com.isoft.news.utils.FileUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/user")
public class UserController {
    //  Get  http://localhost:8090/user/{name}/{pwd}
    @GetMapping("{name}/{pwd}")
    public ResponseData login(@PathVariable("name") String name , @PathVariable("pwd") String password) {
        // 调用service中方法进行login处理
        User u = new User() ;
        u.setId(1) ;u.setName(name); u.setPassword(DigestUtils.md5DigestAsHex("123".getBytes())); u.setEmail("zs@qq.com"); u.setRegdatetime(new Date());
        return new ResponseData(
                u != null ? 0 : 1 ,
                u != null ? "登录成功" : "登录失败" ,
                u
        ) ;
    }

    // POST   http://localhost:8090/user , 上传信息是json格式数据
    //				{"name":"张三","password":"123"}
    @PostMapping()
    public ResponseData register(@RequestBody User user) {
        System.out.println(user);
        return new ResponseData(
                0 ,
                "注册成功",
                true
        ) ;
    }
    @PostMapping("r2")
    public ResponseData register(@RequestBody Map<String , Object> map) {
        System.out.println(map);
        return new ResponseData(
                0 ,
                "注册成功",
                true
        ) ;
    }

    //request : PUT  	http://localhost:8090/user，上传信息是 js对象
    //				 {id:1,password:"123"} 或者 {id:1,mobile:"12345676453"}
    @PutMapping()
    public ResponseData update(User user) {
        return  new ResponseData(
                0 ,
                "修改成功" ,
                user
        ) ;
    }

    /**
     * 用户上传头像
     */
    @Value("${userphoto.path}")    // 从配置文件中读取 userphoto.path属性的值
    private String upPhotoPath ;
    @PostMapping("photo")
    public ResponseData upPhoto(@RequestParam("userphoto") MultipartFile file, Integer id , HttpServletRequest request) {
        // 保存是否成功boolean
        boolean  result = false ;
        // 上传文件物理路径,构造文件名
        String photoPath , newFile , photoUri = null;
        if(! file.isEmpty()) {
            // 构造上传文件新名字
            // 1）获取上传文件名
            String originName = file.getOriginalFilename() ;
            // 2）获取文件扩展名
            String extName = originName.substring(originName.lastIndexOf(".")) ;
            // 3）构造文件新名字
            newFile = new SimpleDateFormat("yyyyMMddHHmmssSSSS").format(new Date()) + "_" + id + extName ;
            System.out.println(newFile);

            // 构造文件上传保存物理路径
            ServletContext app = request.getServletContext() ;
            photoPath = app.getRealPath(upPhotoPath) + "/" ;
            // 判断文件保存的物理路径是否存在，不存在创建
            File f = new File(photoPath) ;
            if(! f.exists()) {
                f.mkdirs() ;
            }
            // 保存文件
            try {
                file.transferTo(new File(photoPath + newFile));
                System.out.println(new File(photoPath + newFile  + "---ok"));
                result  = true ;
                // 构造所保存文件的基于http协议的uri
                photoUri = FileUtil.url(request , upPhotoPath , newFile) ;
                System.out.println(photoUri);
                // 修改数据库
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        User u = null ;
        if(result) {
            // 应该是从数据库获取到的用户对象信息
            u = new User() ;
            u.setId(id);
            u.setName("admin");
            u.setPhotourl(photoUri);
        }
        return new ResponseData(
                result ? 0 : 1 ,
                result ? "修改成功" : "修改失败" ,
                u
        ) ;
    }
}
