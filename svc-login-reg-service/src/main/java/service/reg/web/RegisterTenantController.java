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
import service.reg.entity.TenantEntity;
import service.reg.mapper.TenantMapper;

@RestController
@RefreshScope
@RequestMapping("/regtenant")
class RegisterTenantController {

	@Autowired
	private TenantMapper tenantMapper;

	@RequestMapping("/getTenants")
	public ResponseData<List<TenantEntity>> getUsers() {
		ResponseData<List<TenantEntity>> reponse = new ResponseData<List<TenantEntity>>();
		List<TenantEntity> users = tenantMapper.getAll();
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
	@RequestMapping("/findTenantByPage/{pageNo}/{pageSize}")
	ResponseData<Page<TenantEntity>> findByPage(@PathVariable("pageNo")int pageNo, @PathVariable("pageSize")int pageSize){
		ResponseData<Page<TenantEntity>> response = new ResponseData<Page<TenantEntity>>();
    	PageHelper.startPage(pageNo, pageSize);
    	response.setData(tenantMapper.findByPage()); 
    	
    	long count = PageHelper.count(new ISelect() {
    	    @Override
    	    public void doSelect() {
    	    	tenantMapper.findByPage();
    	    }
    	});
    	response.setCount(count);
    	response.setSuccess(true);
    	return response;
    }

	@RequestMapping("/getTenant")
	public TenantEntity getUser(Long id) {
		TenantEntity user = tenantMapper.getOne(id);
		return user;
	}

	@RequestMapping(value = "/addTenant", method = RequestMethod.POST,consumes="application/json") 
	public ResponseData<String> save(@RequestBody TenantEntity user) {
		ResponseData<String> reponse = new ResponseData<String>();
		TenantEntity check = tenantMapper.checkUsername(user.getTenantAccount());
		if(check == null) {
			tenantMapper.insert(user);
			reponse.setData("ok");
			reponse.setSuccess(true);
		}else {
			reponse.setSuccess(false);
		}
		return reponse;
	}

	@RequestMapping(value = "updateTenant")
	public void update(TenantEntity user) {
		tenantMapper.update(user);
	}

	@RequestMapping(value = "/deleteTenant/{id}")
	public void delete(@PathVariable("id") Long id) {
		tenantMapper.delete(id);
	}
}
