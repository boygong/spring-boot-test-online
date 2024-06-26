package indi.gong.xu.system.mapper;

import indi.gong.xu.model.entity.Admin;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface AdminMapper {

    @Select("select adminName,sex,tel,email,cardId,role from sys_admin")
    public List<Admin> findAll();

    @Select("select adminName,sex,tel,email,cardId,role from sys_admin where adminId = #{adminId}")
    public Admin findById(Integer adminId);

    @Delete("delete from sys_admin where adminId = #{adminId}")
    public int deleteById(int adminId);

    @Update("update sys_admin set adminName = #{adminName},sex = #{sex}," +
            "tel = #{tel}, email = #{email},pwd = #{pwd},cardId = #{cardId},role = #{role} where adminId = #{adminId}")
    public int update(Admin admin);

    @Options(useGeneratedKeys = true,keyProperty = "adminId")
    @Insert("insert into sys_admin(adminName,sex,tel,email,pwd,cardId,role) " +
            "values(#{adminName},#{sex},#{tel},#{email},#{pwd},#{cardId},#{role})")
    public int add(Admin admin);
}
