package com.example.api.controller;

import com.example.api.enums.ResultEnum;
import com.example.api.response.WebResponse;
import com.example.api.service.ImageService;
import com.example.dal.entity.vxInfo;
import com.example.dal.entity.vxUser;
import lombok.extern.slf4j.Slf4j;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@Slf4j
public class wxController {
    //    private Logger logger = Logger.getLogger(wxController.class);
    @Resource
    ImageService imageService;

    @PostMapping("test1")
    public WebResponse<String> test1(String nickName, String lrImage) {
        System.out.println();
        return new WebResponse<>(ResultEnum.SUCCESS, "s");
    }


    @RequestMapping("getUser")
    public Map<String, Object> getUser() {
        System.out.println("微信小程序正在调用。。。");
        Map<String, Object> map = new HashMap<String, Object>();
        List<String> list = new ArrayList<String>();
        list.add("0");
        list.add("1");
        list.add("哈哈哈");
        list.add("嘻嘻嘻");
        map.put("list", list);
        System.out.println("微信小程序调用完成。。。");
        return map;
    }

    @RequestMapping("getWord")
    public Map<String, Object> getText(String word) {
        Map<String, Object> map = new HashMap<String, Object>();
        String message = "我能力有限，不要为难我";
        if ("后来".equals(word)) {
            message = "正在热映的后来的我们是刘若英的处女作。";
        } else if ("微信小程序".equals(word)) {
            message = "想获取更多微信小程序相关知识，请更多的阅读微信官方文档，还有其他更多微信开发相关的内容，学无止境。";
        } else if ("西安工业大学".equals(word)) {
            message = "西安工业大学（Xi'an Technological University）简称”西安工大“，位于世界历史名城古都西安，是中国西北地区唯一一所以兵工为特色，以工为主，理、文、经、管、法协调发展的教学研究型大学。原中华人民共和国兵器工业部直属的七所本科院校之一（“兵工七子”），陕西省重点建设的高水平教学研究型大学、陕西省人民政府与中国兵器工业集团、国防科技工业局共建高校、教育部“卓越工程师教育培养计划”试点高校、陕西省大学生创新能力培养综合改革试点学校。国家二级保密资格单位，是一所以\"军民结合，寓军于民\"的国防科研高校。";
        }
        map.put("message", message);
        return map;
    }

    @RequestMapping("")
    public String getText() {
        return "hello world";
    }

    @RequestMapping("getHR")
    public WebResponse<String> getHR() {
        return new WebResponse<>(ResultEnum.SUCCESS, "http://10.103.238.99:82/img/17.jpg");
    }

    @PostMapping("/addImage1")
    public WebResponse<String> addImage(HttpServletRequest request, @RequestParam(value = "file", required = false) MultipartFile file) throws IOException {
        System.out.println();
        String res = imageService.imageFtpRegister(file);
        return new WebResponse<>(ResultEnum.SUCCESS, res);
    }

    @ResponseBody
    @RequestMapping("upload")
    public String upload(HttpServletRequest request, @RequestParam(value = "file", required = false) MultipartFile file) throws IOException {
        System.out.println("执行upload");
        request.setCharacterEncoding("UTF-8");
        log.info("执行图片上传");
        String user = request.getParameter("user");
        log.info("user:" + user);
        if (!file.isEmpty()) {
            log.info("成功获取照片");
            String fileName = file.getOriginalFilename();
            String path;
            String type;
            assert fileName != null;
            type = fileName.contains(".") ? fileName.substring(fileName.lastIndexOf(".") + 1, fileName.length()) : null;
            log.info("图片初始名称为：" + fileName + " 类型为：" + type);
            if (type != null) {
                if ("GIF".equals(type.toUpperCase()) || "PNG".equals(type.toUpperCase()) || "JPG".equals(type.toUpperCase())) {
                    // 项目在容器中实际发布运行的根路径
                    String realPath = request.getSession().getServletContext().getRealPath("/");
                    // 自定义的文件名称
                    String trueFileName = String.valueOf(System.currentTimeMillis()) + fileName;
                    // 设置存放图片文件的路径
                    path = "/Users/zuoyuanxun/Java/IdeaProjects/study/image/" + trueFileName;
                    log.info("存放图片文件的路径:" + path);
                    file.transferTo(new File(path));
                    log.info("文件成功上传到指定目录下");
                } else {
                    log.info("不是我们想要的文件类型,请按要求重新上传");
                    return "error";
                }
            } else {
                log.info("文件类型为空");
                return "error";
            }
        } else {
            log.info("没有找到相对应的文件");
            return "error";
        }
        return "success";
    }

}
