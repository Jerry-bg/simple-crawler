package wow.kons.controller;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import wow.kons.bean.User;
import wow.kons.service.TestService;

@RestController
@RequestMapping("/api")
public class TestController {

    @Autowired
    private TestService testService;

    @RequestMapping("/test")
    @ResponseBody
    public String obtainTest(){
        User user = testService.obtainUser(1);
        return JSON.toJSONString(user);
    }

    @RequestMapping(value = "/register",method = RequestMethod.POST)
    @ResponseBody
    public String register(@RequestBody User user){

        //testService.register(user);
        return JSON.toJSONString(user);
    }
}
