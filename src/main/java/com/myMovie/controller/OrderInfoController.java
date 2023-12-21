package com.myMovie.controller;

import com.myMovie.entity.User;
import com.myMovie.mapper.OrdInfoMapper;
import com.myMovie.service.OrderInfoService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/order")
public class OrderInfoController {

    @Resource
    private OrderInfoService orderInfoService;

    @RequestMapping("/buyTickets")
    @ResponseBody
    public Object buyTickets(int scheduleId, @RequestParam("position[]") String[] position,int price, HttpSession session){
        System.out.println(scheduleId+","+position+","+price);
        User user = (User)session.getAttribute("user");
        Map map = new HashMap();
        if (user == null) {
            map.put("msg","请登录");
        } else {
            int row = orderInfoService.addOrderInfo(scheduleId, position, price, (int) user.getUserId());
            if (row == 1) {
                map.put("code", 0);
            } else {
                map.put("msg", "存入失败");
            }
        }
        return map;
    }
}
