package global.coda.hms.mapper;

import global.coda.hms.model.Doctor;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface DoctorMapper {

    @Select("select username,password,first_name,last_name,age,fk_user_id,pk_user_id,fk_role_id,doctor_specialisation,experience from t_doctor join t_user on t_doctor.fk_user_id = t_user.pk_user_id where t_user.is_deleted=0 AND t_doctor.is_deleted=0")
    List<Doctor> getAllDoctors();

    @Select("select username,password,first_name,last_name,age,fk_user_id,pk_user_id,fk_role_id,doctor_specialisation,experience from t_doctor join t_user on t_doctor.fk_user_id = t_user.pk_user_id where fk_user_id=#{id} AND t_user.is_deleted=0 AND t_doctor.is_deleted=0")
    Doctor getDoctor(int id);

    @Insert("INSERT INTO t_user (username,password,fk_role_id,first_name,last_name,age) VALUES (#{username},#{password}, 2, #{firstName}, #{lastName}, #{age})")
    @Options(useGeneratedKeys = true, keyProperty = "pkUserId", keyColumn = "pk_user_id")
    int createUser(Doctor doctor);

    @Insert("INSERT INTO t_doctor (fk_user_id,doctor_specialisation,experience) VALUES (#{pkUserId},#{doctorSpecialisation}, #{experience})")
    int createDoctor(Doctor doctor);

    @Update("update t_user SET is_deleted=1 where pk_user_id=#{id}")
    int deleteUser(int id);

    @Update("update t_doctor SET is_deleted=1 where fk_user_id=#{id}")
    int deleteDoctor(int id);

    @Update("update t_user SET password=#{password},age=#{age} where pk_user_id=#{pkUserId} and is_deleted=0")
    int updateUser(Doctor doctor);

    @Update("update t_doctor SET doctor_specialisation=#{doctorSpecialisation},experience=#{experience} where fk_user_id=#{pkUserId} and is_deleted=0")
    int updateDoctor(Doctor doctor);
}
