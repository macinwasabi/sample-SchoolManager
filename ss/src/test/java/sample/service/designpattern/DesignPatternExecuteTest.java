package sample.service.designpattern;

import java.util.Iterator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import sample.dto.StudentDto;
import sample.logic.designpattern.iterator.IterableClassDto;

/**
 * デザインパターンの実装を実行してみるクラス。テストとは違うがここに置いています。
 */
@SpringBootTest
public class DesignPatternExecuteTest {

  @Test
  @DisplayName("iterator 実行")
  public void iteratorExecute() {
    IterableClassDto classDto = new IterableClassDto(4);
    classDto.add(new StudentDto(1L, "相澤", "太郎"));
    classDto.add(new StudentDto(2L, "石田", "二郎"));
    classDto.add(new StudentDto(3L, "上田", "三郎"));
    classDto.add(new StudentDto(4L, "枝先", "四郎"));

    // 明治的にIteratorを使う方法
    Iterator<StudentDto> iterator = classDto.iterator();
    while (iterator.hasNext()) {
      StudentDto student = iterator.next();
      System.out.println(student);
    }
    System.out.println();

    // 拡張forを使う方法
    for (StudentDto student : classDto) {
      System.out.println(student);
    }
  }
}
