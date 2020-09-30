package SpringMvc;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

public class Control {
    @RequestMapping("/login6.from")
    public String checkLogin6(@ModelAttribute("user") User user){
//        System.out.println("---方法六---");
        System.out.println(user.getUsername());
        System.out.println(user.getPassword());
        if("liu".equals(user.getUsername()) && "qing".equals(user.getPassword())){
            return "ok";
        }
        return "redirect:toLogin.from";
    }

    @ModelAttribute("user")
    public User getUser(){//避免HttpSessionRequiredException Session attribute ‘user’ required异常
        return new User();
    }
}
