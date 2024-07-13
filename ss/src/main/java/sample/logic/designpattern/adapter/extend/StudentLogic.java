package sample.logic.designpattern.adapter.extend;

import sample.dto.StudentDto;

/**
 * 生徒情報に関するロジック。
 */
public interface StudentLogic {

  /**
   * 文字列から姓名を取り出して、生徒情報DTOを返す。
   *
   * @param str 姓名の文字列
   * @return 生徒情報DTO
   */
  public StudentDto getStudent(String str);
}
