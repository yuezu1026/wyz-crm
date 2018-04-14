package service.reg.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import service.reg.entity.ResponseData;
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

	@RequestMapping(value = "/login", method = RequestMethod.POST,consumes="application/json",produces="application/json;charset=UTF-8")
	@ResponseBody
	public ResponseData<String> login(@RequestBody UserEntity user) {
		ResponseData<String> reponse = new ResponseData<String>();
		user = userMapper.checkAccount(user.getUsername(),user.getPassword());
		String data = "-1";
		if(user != null) {
			data = "1";
		}
		if(user != null && user.getUsername().equals("admin")) {
			data="admin";
		}
		reponse.setData(data);
		return reponse;
	}

}
