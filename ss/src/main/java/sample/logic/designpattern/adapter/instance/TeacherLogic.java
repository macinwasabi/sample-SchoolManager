package sample.logic.designpattern.adapter.instance;

import sample.dto.TeacherDto;

/**
 * 先生情報に関するロジック。
 */
public abstract class TeacherLogic {

  /**
   * 文字列から姓名を取り出して、先生情報DTOを返す。
   *
   * @param str 姓名の文字列
   * @return 先生情報DTO
   */
  public abstract TeacherDto getTeacher(String str);
}
