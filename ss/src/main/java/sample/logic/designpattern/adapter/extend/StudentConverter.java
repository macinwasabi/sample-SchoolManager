package sample.logic.designpattern.adapter.extend;

import sample.dto.StudentDto;

public class StudentConverter {

  /**
   * 文字列から姓名を取り出して、生徒情報DTOを返す。
   *
   * @param str 姓名の文字列
   * @return 生徒情報DTO
   */
  public StudentDto convertSeiMei(String str) {
    // 半角or全角スペースで分割
    String[] seimei = str.split("[ 　]");

    // 分割されていないor必要以上の分割があればエラー
    if (seimei.length != 2) {
      throw new RuntimeException();
    }

    // 生徒情報DTOへセットしてreturn
    StudentDto dto = new StudentDto();
    dto.setFamilyName(seimei[0]);
    dto.setFirstName(seimei[1]);
    return dto;
  }
}
