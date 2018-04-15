package service.reg.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.ISelect;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

import service.reg.entity.ResponseData;
import service.reg.entity.UserEntity;
import service.reg.mapper.UserMapper;

@RestController
@RefreshScope
@RequestMapping("/register")
class RegisterController {

	@Autowired
	private UserMapper userMapper;

	@RequestMapping("/getUsers")
	public ResponseData<List<UserEntity>> getUsers() {
		ResponseData<List<UserEntity>> reponse = new ResponseData<List<UserEntity>>();
		List<UserEntity> users = userMapper.getAll();
		reponse.setData(users);
		reponse.setSuccess(true);
		return reponse;
	}
	
	/**
     * 分页查询
     * @param pageNo 页号
     * @param pageSize 每页显示记录数
     * @return
     */
	@RequestMapping("/findByPage/{pageNo}/{pageSize}")
	ResponseData<Page<UserEntity>> findByPage(@PathVariable("pageNo")int pageNo, @PathVariable("pageSize")int pageSize){
		ResponseData<Page<UserEntity>> response = new ResponseData<Page<UserEntity>>();
    	PageHelper.startPage(pageNo, pageSize);
    	response.setData(userMapper.findByPage()); 
    	
    	long count = PageHelper.count(new ISelect() {
    	    @Override
    	    public void doSelect() {
    	    	userMapper.findByPage();
    	    }
    	});
    	response.setCount(count);
    	response.setSuccess(true);
    	return response;
    }

	@RequestMapping("/getUser")
	public UserEntity getUser(Long id) {
		UserEntity user = userMapper.getOne(id);
		return user;
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST,consumes="application/json") 
	public ResponseData<String> save(@RequestBody UserEntity user) {
		ResponseData<String> reponse = new ResponseData<String>();
		UserEntity check = userMapper.checkUsername(user.getUsername());
		if(check == null) {
			userMapper.insert(user);
			reponse.setData("ok");
			reponse.setSuccess(true);
		}else {
			reponse.setSuccess(false);
		}
		return reponse;
	}

	@RequestMapping(value = "update")
	public void update(UserEntity user) {
		userMapper.update(user);
	}

	@RequestMapping(value = "/delete/{id}")
	public void delete(@PathVariable("id") Long id) {
		userMapper.delete(id);
	}
}
