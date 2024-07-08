package sample.entity.gen;

import java.util.Date;

public class Student {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column student.student_id
     *
     * @mbg.generated Sun May 19 17:10:55 JST 2024
     */
    private Long studentId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column student.family_name
     *
     * @mbg.generated Sun May 19 17:10:55 JST 2024
     */
    private String familyName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column student.first_name
     *
     * @mbg.generated Sun May 19 17:10:55 JST 2024
     */
    private String firstName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column student.created_at
     *
     * @mbg.generated Sun May 19 17:10:55 JST 2024
     */
    private Date createdAt;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column student.updated_at
     *
     * @mbg.generated Sun May 19 17:10:55 JST 2024
     */
    private Date updatedAt;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column student.student_id
     *
     * @return the value of student.student_id
     *
     * @mbg.generated Sun May 19 17:10:55 JST 2024
     */
    public Long getStudentId() {
        return studentId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column student.student_id
     *
     * @param studentId the value for student.student_id
     *
     * @mbg.generated Sun May 19 17:10:55 JST 2024
     */
    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column student.family_name
     *
     * @return the value of student.family_name
     *
     * @mbg.generated Sun May 19 17:10:55 JST 2024
     */
    public String getFamilyName() {
        return familyName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column student.family_name
     *
     * @param familyName the value for student.family_name
     *
     * @mbg.generated Sun May 19 17:10:55 JST 2024
     */
    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column student.first_name
     *
     * @return the value of student.first_name
     *
     * @mbg.generated Sun May 19 17:10:55 JST 2024
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column student.first_name
     *
     * @param firstName the value for student.first_name
     *
     * @mbg.generated Sun May 19 17:10:55 JST 2024
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column student.created_at
     *
     * @return the value of student.created_at
     *
     * @mbg.generated Sun May 19 17:10:55 JST 2024
     */
    public Date getCreatedAt() {
        return createdAt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column student.created_at
     *
     * @param createdAt the value for student.created_at
     *
     * @mbg.generated Sun May 19 17:10:55 JST 2024
     */
    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column student.updated_at
     *
     * @return the value of student.updated_at
     *
     * @mbg.generated Sun May 19 17:10:55 JST 2024
     */
    public Date getUpdatedAt() {
        return updatedAt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column student.updated_at
     *
     * @param updatedAt the value for student.updated_at
     *
     * @mbg.generated Sun May 19 17:10:55 JST 2024
     */
    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table student
     *
     * @mbg.generated Sun May 19 17:10:55 JST 2024
     */
    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Student other = (Student) that;
        return (this.getStudentId() == null ? other.getStudentId() == null : this.getStudentId().equals(other.getStudentId()))
            && (this.getFamilyName() == null ? other.getFamilyName() == null : this.getFamilyName().equals(other.getFamilyName()))
            && (this.getFirstName() == null ? other.getFirstName() == null : this.getFirstName().equals(other.getFirstName()))
            && (this.getCreatedAt() == null ? other.getCreatedAt() == null : this.getCreatedAt().equals(other.getCreatedAt()))
            && (this.getUpdatedAt() == null ? other.getUpdatedAt() == null : this.getUpdatedAt().equals(other.getUpdatedAt()));
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table student
     *
     * @mbg.generated Sun May 19 17:10:55 JST 2024
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getStudentId() == null) ? 0 : getStudentId().hashCode());
        result = prime * result + ((getFamilyName() == null) ? 0 : getFamilyName().hashCode());
        result = prime * result + ((getFirstName() == null) ? 0 : getFirstName().hashCode());
        result = prime * result + ((getCreatedAt() == null) ? 0 : getCreatedAt().hashCode());
        result = prime * result + ((getUpdatedAt() == null) ? 0 : getUpdatedAt().hashCode());
        return result;
    }
}