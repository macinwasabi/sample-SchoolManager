package sample.service;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sample.dto.TeacherDto;
import sample.entity.gen.Teacher;
import sample.entity.gen.TeacherExample;
import sample.mapper.gen.TeacherMapper;

/**
 * 先生情報サービス
 */
@Service
public class TeacherService {

  @Autowired
  TeacherMapper teacherMapper;

  /**
   * 全件取得
   *
   * @return 先生情報リスト
   */
  public List<TeacherDto> selectAll() {
    // 条件無し
    TeacherExample example = new TeacherExample();
    example.createCriteria();
    // 取得
    List<Teacher> teacherList = teacherMapper.selectByExample(example);
    return teacherList.stream().map(entity -> convert(entity)).collect(Collectors.toList());
  }

  /**
   * 1件取得
   *
   * @param teacherId 先生番号
   * @return 先生情報
   */
  public TeacherDto select(long teacherId) {
    Teacher entity = teacherMapper.selectByPrimaryKey(teacherId);
    return convert(entity);
  }

  /**
   * 登録<br> dtoに先生番号をセットする。
   *
   * @param dto 登録する先生情報
   * @return 登録件数
   */
  public int insert(TeacherDto dto) {
    // 登録処理
    Teacher entity = convert(dto);
    int inserted = teacherMapper.insertSelective(entity);
    // dtoに先生番号をセット
    dto.setTeacherId(entity.getTeacherId());
    return inserted;
  }

  /**
   * 更新
   *
   * @param dto 更新する先生情報
   * @return 更新件数
   */
  public int update(TeacherDto dto) {
    return teacherMapper.updateByPrimaryKeySelective(convert(dto));
  }

  /**
   * 削除
   *
   * @param teacherId 削除する先生番号
   * @return 削除件数
   */
  public int delete(long teacherId) {
    return teacherMapper.deleteByPrimaryKey(teacherId);
  }

  /**
   * Teacherエンティティへ変換を行う。
   *
   * @param dto 変換元
   * @return 変換後
   */
  public Teacher convert(TeacherDto dto) {
    Teacher entity = new Teacher();

    entity.setTeacherId(dto.getTeacherId());
    entity.setFamilyName(dto.getFamilyName());
    entity.setFirstName(dto.getFirstName());

    return entity;
  }

  /**
   * TeacherDtoへ変換を行う。
   *
   * @param entity 変換元
   * @return 変換後
   */
  public TeacherDto convert(Teacher entity) {
    TeacherDto dto = new TeacherDto();

    dto.setTeacherId(entity.getTeacherId());
    dto.setFamilyName(entity.getFamilyName());
    dto.setFirstName(entity.getFirstName());

    return dto;
  }
}
