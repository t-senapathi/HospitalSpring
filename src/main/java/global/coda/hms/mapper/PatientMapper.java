package global.coda.hms.mapper;

import java.util.List;

import global.coda.hms.model.Patient;
import org.apache.ibatis.annotations.*;

@Mapper
public interface PatientMapper {

	@Select("select username,password,first_name,last_name,patient_height,patient_weight,door_no,street,city,age,fk_user_id,blood_group,pk_user_id,fk_role_id from t_patient join t_user on t_patient.fk_user_id = t_user.pk_user_id where t_user.is_deleted=0 AND t_patient.is_deleted=0")
	List<Patient> getAllPatients();

	@Select("select username,password,first_name,last_name,patient_height,patient_weight,door_no,street,fk_user_id,city,age,blood_group,pk_user_id,fk_role_id from t_patient join t_user on t_patient.fk_user_id = t_user.pk_user_id where fk_user_id=#{id} AND t_user.is_deleted=0 AND t_patient.is_deleted=0")
	Patient getPatient(int id);

	@Insert("INSERT INTO t_user (username,password,fk_role_id,first_name,last_name,age) VALUES (#{username},#{password}, 1, #{firstName}, #{lastName}, #{age})")
	@Options(useGeneratedKeys = true, keyProperty = "pkUserId", keyColumn = "pk_user_id")
	int createUser(Patient patient);

	@Insert("INSERT INTO t_patient (fk_user_id,patient_height,patient_weight,door_no,street,city,blood_group) VALUES (#{pkUserId},#{patientHeight}, #{patientWeight},#{doorNo},#{street},#{city},#{bloodGroup})")
	int createPatient(Patient patient);

	@Update("update t_user SET is_deleted=1 where pk_user_id=#{id}")
	int deleteUser(int id);

	@Update("update t_patient SET is_deleted=1 where fk_user_id=#{id}")
	int deletePatient(int id);

	@Update("update t_user SET password=#{password},age=#{age} where pk_user_id=#{pkUserId} and is_deleted=0")
	int updateUser(Patient patient);

	@Update("update t_patient SET patient_height=#{patientHeight},patient_weight=#{patientWeight} where fk_user_id=#{pkUserId} and is_deleted=0")
	int updatePatient(Patient patient);
}
