package service.reg.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import service.reg.entity.UserEntity;
import service.reg.mapper.UserMapper;

@RestController
@RefreshScope
class LoginController {

	@Autowired
	private UserMapper userMapper;

	@Value("${wayne.from}")
	private String from;

	@RequestMapping("/from")
	public String from() {
		return this.from;
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST,consumes="application/json") 
	public Boolean login(@RequestBody UserEntity user) {
		user = userMapper.checkAccount(user.getUserName(),user.getPassWord());
		if(user != null) {
			return true;
		}
		return false;
	}

}
