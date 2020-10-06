package com.isoft.news.dao;


import com.isoft.news.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserDao {
    @Select("select * from tb_user where id=#{id}")
    User getById(Integer id) ;

    // select 根据用户名和密码查找用户
    @Select("select * from tb_user where name=#{uname} and password=#{pwd}")
    User select(@Param("uname") String name, @Param("pwd") String password) ;

    // -- select 用户名是否存在
    @Select("select count(*) from tb_user where name=#{name}")
    int nameSearch(String name) ;

    // -- insert 添加用户
    @Insert("insert into tb_user(name,password,regdatetime,status,activecode) values(#{name},#{password},now(),0,#{activecode})")
    int add(User user) ;

    // -- update 根据id，修改电话
    @Update("update tb_user set mobile=#{mobile} where id=#{id}")
    int updateMobile(@Param("id") Integer id, @Param("mobile") String mobile) ;

    /**
     * 根据用户名关键字，实现模糊查询
     */
    @Select("<script>" +
            "select * from tb_user " +
            "        <if test=\"nameKey != null\"> " +
            "            <bind name=\"name\" value=\"'%'+nameKey+'%'\"/> " +
            "            where name like #{name} " +
            "        </if>"
            +"</script>")
    List<User> getByName(String nameKey) ;

    /**
     * 查询用户表记录总数
     */
    @Select("select count(*) from tb_user")
    int getCount() ;
    /**
     * 返回限定个数行数据
     */
    @Select("select * from tb_user limit #{offset} , #{rows}")
    List<User> getLimitRows(Integer offset, Integer rows);

    /**
     * 根据用户id修改用户信息 : 密码、头像、电话、状态
     * @param user id不允许为空，密码、头像、电话、状态 四个属性至少一个不为null
     * @return
     */
    @Update("<script>" +
            "update tb_user " +
            "        <set> " +
            "            <if test=\"null != password\">" +
            "                password=#{password} , " +
            "            </if>\n" +
            "            <if test=\"null != photourl\"> " +
            "                photourl=#{photourl}, " +
            "            </if>\n" +
            "            <if test=\"null != status\"> " +
            "                status = #{status} , " +
            "            </if>\n" +
            "            <if test=\"null != mobile\"> " +
            "                mobile=#{mobile} , " +
            "            </if>" +
            "        </set> " +
            "        where id=#{id}"
            +"</script>")
    int updateById(User user) ;


    @Update("<script>" +
            "update tb_user" +
            "        <set>" +
            "            <choose>" +
            "                <when test=\"null != password\">" +
            "                    password=#{password}" +
            "                </when>" +
            "                <when test=\"null != status\">" +
            "                    status = #{status}" +
            "                </when>" +
            "                <when test=\"null != photourl\">" +
            "                    photourl = #{photourl}" +
            "                </when>" +
            "                <when test=\"null != mobile\">" +
            "                    mobile = #{mobile}" +
            "                </when>" +
            "            </choose>" +
            "        </set>" +
            "        where id=#{id}"
            +"</script>")
    int updateById2(User user) ;

/*
-- select 邮箱是否存在
-- insert 添加用户
-- select 根据id，验证密码
-- update 根据id，修改密码
-- update 根据id，修改头像url
-- update 根据id，修改电话
-- update 根据id，修改状态
*/
}
