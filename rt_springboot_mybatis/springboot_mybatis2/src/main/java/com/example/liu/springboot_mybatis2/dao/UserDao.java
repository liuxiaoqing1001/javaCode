package com.example.liu.springboot_mybatis2.dao;

import com.example.liu.springboot_mybatis2.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserDao {
//     select 根据用户名和密码查找用户
    @Select("select * from tb_user where name=#{uname} and password=#{pwd}")
    User select(@Param("uname") String name , @Param("pwd") String password) ;

//     -- select 用户名是否存在
    @Select("select count(*) from tb_user where name=#{name}")
    int nameSearch(String name) ;

//     -- insert 添加用户
    @Insert("insert into tb_user(name,password,regdatetime,status,activecode) values(#{name},#{password},now(),0,#{activecode})")
    int add(User user) ;

//     -- update 根据id，修改电话
    @Update("update tb_user set mobile=#{mobile} where id=#{id}")
    int updateMobile(@Param("id") Integer id , @Param("mobile") String mobile) ;

//    -- select 邮箱是否存在
    @Select("select count(*) from tb_user where email=#{email}")
    int emailSearch(String email);

//    -- select 根据id，验证密码
    @Select("select * from tb_user where id=#{id} and password=#{pwd}")
    User identifyPwd(@Param("id") Integer id ,@Param("pwd") String password);

//    -- update 根据id，修改密码
    @Update("update tb_user set password=#{password} where id=#{id}")
    int modifyPwd(@Param("id") Integer id , @Param("password") String password);

//    -- update 根据id，修改头像url
    @Update("update tb_user set photourl=#{photourl} where id=#{id}")
    int modifyPhotourl(@Param("id") Integer id, @Param("photourl") String photourl );

//    -- update 根据id，修改状态
    @Update("update tb_user set status=#{status} where id=#{id}")
    int modifyStatus(@Param("id") Integer id , @Param("status")Integer status);


//  1  根据用户名关键字，实现模糊查询   \转义字符
    @Select("<script>" +
            "<bind name=\"namekey\" value=\"'%'+name+'%'\"/>" +
            "        select * from tb_user where name like #{namekey}"
            +"</script>")
    List<User> getByName(String name) ;

//    查询用户表记录总数
    @Select("select count(*) from tb_user")
    int getCount() ;
//    返回限定个数行数据
//      Integer offset  跳过的行数
//      Integer rows    返回的行数
    @Select("select * from tb_user limit #{offset} , #{rows}")
    List<User> getLimitRows(Integer offset , Integer rows);


//    动态sql <set>
    /**
     * 根据用户的id修改用户的信息
     * @param user id不允许为空，密码，头像，电话，状态至少一个不为null
     * @return
     */
    @Update("<script>" +
            "update tb_user" +
            "        <set>" +
            "            <if test=\"null!=password\">" +
            "                password=#{password}," +
            "            </if>" +
            "            <if test=\"null!=photourl\">" +
            "                photourl=#{photourl}," +
            "            </if>" +
            "            <if test=\"null!=status\">" +
            "                status=#{status}," +
            "            </if>" +
            "            <if test=\"null!=mobile\">" +
            "                mobile=#{mobile}," +
            "            </if>" +
            "        </set>" +
            "        where id=#{id}" +
            "</script>")
    int updateById(User user);


    //  2  根据用户名关键字，实现模糊查询   \转义字符
    @Select("<script>" +
            "select * from tb_user" +
            "        <if test=\"nameKey != null\">" +
            "            <bind name=\"name\" value=\"'%'+nameKey+'%'\"/>" +
            "            where name like #{name}" +
            "        </if>" +
            "</script>")
    List<User> getByName2(String nameKey) ;

//    动态sql
//    多分支，最多只能修改一项
    @Update("<script>" +
            "update tb_user" +
            "        <set>" +
            "            <choose>" +
            "                <when test=\"null!=password\">" +
            "                    password=#{password}" +
            "                </when>" +
            "                <when test=\"null!=status\">" +
            "                    status=#{status}" +
            "                </when>" +
            "                <when test=\"null != photourl\">" +
            "                    photourl = #{photourl}" +
            "                </when>" +
            "                <when test=\"null != mobile\">" +
            "                    mobile = #{mobile}" +
            "                </when>" +
            "            </choose>" +
            "        </set>" +
            "</script>")
    int updateById2(User user);
}