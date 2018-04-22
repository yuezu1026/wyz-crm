package service.reg.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.github.pagehelper.Page;

import service.reg.entity.TenantEntity;
import service.reg.enums.TenantSexEnum;
import service.reg.enums.UserSexEnum;

public interface TenantMapper {
	
	@Select("SELECT * FROM tenant")
	@Results({
		@Result(property = "tenantSex",  column = "tenant_sex", javaType = TenantSexEnum.class)
	})
	List<TenantEntity> getAll();
	
	@Select("SELECT * FROM tenant WHERE id = #{tenant_id}")
	@Results({
		@Result(property = "tenantSex",  column = "tenant_sex", javaType = TenantSexEnum.class)
	})
	TenantEntity getOne(Long id);
	
	@Select("SELECT * FROM tenant WHERE tenant_account = #{tenantAccount} AND tenant_password = #{tenantPassword}")
	@Results({
		@Result(property = "tenantSex",  column = "tenant_sex", javaType = TenantSexEnum.class)
	})
	TenantEntity checkAccount(@Param("tenantAccount")String userName,@Param("tenantPassword")String passWord);

	@Select("SELECT * FROM tenant WHERE tenant_account = #{tenantAccount}")
	@Results({
		@Result(property = "tenantSex",  column = "user_sex", javaType = TenantSexEnum.class)
	})
	TenantEntity checkUsername(@Param("tenantAccount")String userName);
	
	@Insert("INSERT INTO tenant(tenant_account,tenant_password,tenant_name,email) VALUES(#{tenantAccount}, #{tenantPassword},#{tenantName}, #{email})")
	void insert(TenantEntity tenant);

	@Update("UPDATE tenant SET tenant_password=#{tenantPassword},tenant_name=#{tenantName} WHERE tenant_id =#{tenantId}")
	void update(TenantEntity tenant);

	@Delete("DELETE FROM tenant WHERE tenant_id =#{tenantId}")
	void delete(Long id);
	
	 /**
     * 分页查询数据
     * @return
     */
	@Select("SELECT * FROM tenant")
	@Results({
		@Result(property = "tenantSex",  column = "tenant_sex", javaType = UserSexEnum.class)
	})
    Page<TenantEntity> findByPage();

}