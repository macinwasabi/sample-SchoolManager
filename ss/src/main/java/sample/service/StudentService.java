package sample.service;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sample.dto.StudentDto;
import sample.entity.gen.Student;
import sample.entity.gen.StudentExample;
import sample.mapper.gen.StudentMapper;

/**
 * 生徒情報サービス
 */
@Service
public class StudentService {

  @Autowired
  StudentMapper studentMapper;

  /**
   * 全件取得
   *
   * @return 生徒情報リスト
   */
  public List<StudentDto> selectAll() {
    // 条件無し
    StudentExample example = new StudentExample();
    example.createCriteria();
    // 取得
    List<Student> studentList = studentMapper.selectByExample(example);
    return studentList.stream().map(entity -> convert(entity)).collect(Collectors.toList());
  }

  /**
   * 1件取得
   *
   * @param studentId 生徒番号
   * @return 生徒情報
   */
  public StudentDto select(long studentId) {
    Student entity = studentMapper.selectByPrimaryKey(studentId);
    return convert(entity);
  }

  /**
   * 登録<br> dtoに生徒番号をセットする。
   *
   * @param dto 登録する生徒情報
   * @return 登録件数
   */
  public int insert(StudentDto dto) {
    // 登録処理
    Student entity = convert(dto);
    int inserted = studentMapper.insertSelective(entity);
    // dtoに生徒番号をセット
    dto.setStudentId(entity.getStudentId());
    return inserted;
  }

  /**
   * 更新。
   *
   * @param dto 更新する生徒情報
   * @return 更新件数
   */
  public int update(StudentDto dto) {
    return studentMapper.updateByPrimaryKeySelective(convert(dto));
  }

  /**
   * 削除
   *
   * @param studentId 削除する生徒番号
   * @return 削除件数
   */
  public int delete(long studentId) {
    return studentMapper.deleteByPrimaryKey(studentId);
  }

  /**
   * Studentエンティティへ変換を行う。
   *
   * @param dto 変換元
   * @return 変換後
   */
  public Student convert(StudentDto dto) {
    Student entity = new Student();

    entity.setStudentId(dto.getStudentId());
    entity.setFamilyName(dto.getFamilyName());
    entity.setFirstName(dto.getFirstName());

    return entity;
  }

  /**
   * StudentDtoへ変換を行う。
   *
   * @param entity 変換元
   * @return 変換後
   */
  public StudentDto convert(Student entity) {
    StudentDto dto = new StudentDto();

    dto.setStudentId(entity.getStudentId());
    dto.setFamilyName(entity.getFamilyName());
    dto.setFirstName(entity.getFirstName());

    return dto;
  }
}
