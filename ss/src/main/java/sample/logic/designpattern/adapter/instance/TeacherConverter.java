package sample.logic.designpattern.adapter.instance;

import sample.dto.TeacherDto;

public class TeacherConverter {

  /**
   * 文字列から姓名を取り出して、先生情報DTOを返す。
   *
   * @param str 姓名の文字列
   * @return 先生情報DTO
   */
  public TeacherDto convertSeiMei(String str) {
    // 半角or全角スペースで分割
    String[] seimei = str.split("[ 　]");

    // 分割されていないor必要以上の分割があればエラー
    if (seimei.length != 2) {
      throw new RuntimeException();
    }

    // 先生情報DTOへセットしてreturn
    TeacherDto dto = new TeacherDto();
    dto.setFamilyName(seimei[0]);
    dto.setFirstName(seimei[1]);
    return dto;
  }
}
