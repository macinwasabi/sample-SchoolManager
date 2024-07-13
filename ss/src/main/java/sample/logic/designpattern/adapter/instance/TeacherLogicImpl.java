package sample.logic.designpattern.adapter.instance;

import sample.dto.TeacherDto;

/**
 * 先生情報に関するロジック。
 */
public class TeacherLogicImpl extends TeacherLogic {

  TeacherConverter converter;

  public TeacherLogicImpl() {
    this.converter = new TeacherConverter();
  }

  /**
   * 文字列から姓名を取り出して、先生情報DTOを返す。
   *
   * @param str 姓名の文字列
   * @return 先生情報DTO
   */
  @Override
  public TeacherDto getTeacher(String str) {
    return converter.convertSeiMei(str);
  }
}
