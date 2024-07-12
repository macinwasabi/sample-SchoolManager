package sample.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentDto {

  private Long studentId;
  private String familyName;
  private String firstName;

  @Override
  public String toString() {
    return "生徒番号:" + studentId + " " + familyName + " " + firstName;
  }
}
