package cn.jaimecai.myblog.controller;

import cn.jaimecai.myblog.beans.pojo.NewsType;
import cn.jaimecai.myblog.repository.NewsTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

/**
 * @author:jaimecai
 * @date:17-12-6 下午2:55
 * @description:
 */
@Controller
public class IndexController {

    @Autowired
    private NewsTypeRepository newsTypeRepository;

    @RequestMapping(path={"/","/index"})
    @ResponseBody
    public String index(){
       return "Hello World!";
    }

    @RequestMapping(value={"/profile/{groupId}/{userId}"})//value和path一样
    @ResponseBody
    public String profile(@PathVariable("groupId") String groupId,
                          @PathVariable("userId") int userId,
                          @RequestParam(value="type",defaultValue = "1") int type,
                          @RequestParam(value = "key",defaultValue = "nowCoder") String key){
        return String.format("GID{%s},UID{%d},TYPE{%d},KEY{%s}",groupId,userId,type,key);
    }

    @RequestMapping("/vm")
    public String news(Map<String,Object> model){
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String fdate=simpleDateFormat.format(new Date());
        model.put("time",fdate);
        return "news";
    }
    @GetMapping("/all")
    @ResponseBody
    public Iterable<NewsType> getAllNewsType(){
        return newsTypeRepository.findAll();
    }
}
