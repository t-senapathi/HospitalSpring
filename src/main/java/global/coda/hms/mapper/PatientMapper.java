package global.coda.hms.mapper;

import java.util.List;

import global.coda.hms.model.Patient;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface PatientMapper {

	@Select("select username,password,first_name,last_name,patient_height,patient_weight,door_no,street,city,age,blood_group,pk_user_id,fk_role_id from t_patient join t_user on t_patient.fk_user_id = t_user.pk_user_id")
	List<Patient> getAllPatients();

	@Select("select username,password,first_name,last_name,patient_height,patient_weight,door_no,street,city,age,blood_group,pk_user_id,fk_role_id from t_patient join t_user on t_patient.fk_user_id = t_user.pk_user_id where fk_user_id=#{id}")
	Patient getPatient(int id);

	@Insert("INSERT INTO t_user (username,password,fk_role_id,first_name,last_name,age) VALUES (#{username},#{password}, 1, #{firstName}, #{lastName}, #{age})")
	@Options(useGeneratedKeys = true, keyProperty = "pkUserId", keyColumn = "pk_user_id")
	int createUser(Patient patient);

	@Insert("INSERT INTO t_patient (fk_user_id,patient_height,patient_weight,door_no,street,city,blood_group) VALUES (#{pkUserId},#{patientHeight}, #{patientWeight},#{doorNo},#{street},#{city},#{bloodGroup})")
	int createPatient(Patient patient);
}
