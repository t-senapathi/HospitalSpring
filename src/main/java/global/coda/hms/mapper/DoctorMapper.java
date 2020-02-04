package global.coda.hms.mapper;

import global.coda.hms.model.Doctor;
import global.coda.hms.model.Patient;
import org.apache.ibatis.annotations.*;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

/**
 * The interface Doctor mapper.
 */
@Mapper
public interface DoctorMapper {

    /**
     * Gets all doctors.
     *
     * @return the all doctors
     */
    @Select("select username,password,first_name,last_name,age,fk_user_id,pk_user_id,fk_role_id,doctor_specialisation,experience from t_doctor join t_user on t_doctor.fk_user_id = t_user.pk_user_id where t_user.is_deleted=0 AND t_doctor.is_deleted=0")
    List<Doctor> getAllDoctors();

    /**
     * Gets doctor.
     *
     * @param id the id
     * @return the doctor
     */
    @Select("select username,password,first_name,last_name,age,fk_user_id,pk_user_id,fk_role_id,doctor_specialisation,experience from t_doctor join t_user on t_doctor.fk_user_id = t_user.pk_user_id where fk_user_id=#{id} AND t_user.is_deleted=0 AND t_doctor.is_deleted=0")
    Doctor getDoctor(int id);

    /**
     * Create user int.
     *
     * @param doctor the doctor
     * @return the int
     * @throws SQLIntegrityConstraintViolationException the sql integrity constraint violation exception
     */
    @Insert("INSERT INTO t_user (username,password,fk_role_id,first_name,last_name,age) VALUES (#{username},#{password}, 2, #{firstName}, #{lastName}, #{age})")
    @Options(useGeneratedKeys = true, keyProperty = "pkUserId", keyColumn = "pk_user_id")
    int createUser(Doctor doctor);

    /**
     * Create doctor int.
     *
     * @param doctor the doctor
     * @return the int
     * @throws SQLIntegrityConstraintViolationException the sql integrity constraint violation exception
     */
    @Insert("INSERT INTO t_doctor (fk_user_id,doctor_specialisation,experience) VALUES (#{pkUserId},#{doctorSpecialisation}, #{experience})")
    int createDoctor(Doctor doctor);

    /**
     * Delete user int.
     *
     * @param id the id
     * @return the int
     */
    @Update("update t_user SET is_deleted=1 where pk_user_id=#{id}")
    int deleteUser(int id);

    /**
     * Delete doctor int.
     *
     * @param id the id
     * @return the int
     */
    @Update("update t_doctor SET is_deleted=1 where fk_user_id=#{id}")
    int deleteDoctor(int id);

    /**
     * Update user int.
     *
     * @param doctor the doctor
     * @return the int
     */
    @Update("update t_user SET password=#{password},age=#{age} where pk_user_id=#{pkUserId} and is_deleted=0")
    int updateUser(Doctor doctor);

    /**
     * Update doctor int.
     *
     * @param doctor the doctor
     * @return the int
     */
    @Update("update t_doctor SET doctor_specialisation=#{doctorSpecialisation},experience=#{experience} where fk_user_id=#{pkUserId} and is_deleted=0")
    int updateDoctor(Doctor doctor);

    /**
     * Gets patient under a doctor.
     *
     * @param id the id
     * @return the patient under a doctor
     */
    @Select("select pk_user_id,first_name,last_name,username,age,door_no,street,city,blood_group,patient_height,patient_weight from t_user join t_patient on t_user.pk_user_id = t_patient.fk_user_id join t_patient_doctor_mapping on t_patient_doctor_mapping.fk_patient_id = t_user.pk_user_id  where t_user.is_deleted =0 and t_patient.is_deleted=0 and t_patient_doctor_mapping.is_deleted=0 and t_patient_doctor_mapping.fk_doctor_id=#{id}")
    List<Patient> getPatientUnderADoctor(int id);

    /**
     * Gets all patient under all doctors.
     *
     * @param id the id
     * @return the all patient under all doctors
     */
    @Select("<script>select pk_user_id,age,first_name,last_name,username,password,fk_role_id,doctor_specialisation,experience from t_user join t_doctor on t_user.pk_user_id = t_doctor.fk_user_id  where t_user.is_deleted=0 and t_doctor.is_deleted=0<if test='id!=0'>and pk_user_id=#{id}</if></script>")
    @Results(value = {
            @Result(property = "patientList", javaType = List.class, column = "pk_user_id",
                    many = @Many(select = "getPatientUnderADoctor"))
    })
    List<Doctor> getAllPatientUnderAllDoctors(int id);


}
