package sample.service;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import java.util.function.Consumer;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import sample.dto.StudentDto;
import sample.entity.gen.Student;
import sample.mapper.gen.StudentMapper;

@SpringBootTest
@Transactional
public class StudentServiceTest {

  @Autowired
  StudentService studentService;

  @Autowired
  StudentMapper studentMapper;

  @Test
  @DisplayName("select 正常系")
  public void select_normal() {
    Student student = getStudent(null);
    studentMapper.insertSelective(student);

    StudentDto dto = studentService.select(student.getStudentId());

    assertEqual(dto, student);
  }

  @Test
  @DisplayName("update 異常系 トランザクション確認")
  public void update_normal() {
    // 2つのことをする中で、1件目の後にエラーが起きてロールバックすることを確認するケース
    // テストクラスのトランザクションがテスト対象のサービスまで伝播してしまって確認できない気がする
    // サービスにNESTEDをつける意外に、テストをする方法はあるのだろうか...
  }

  /**
   * 生徒情報エンティティを生成する。
   *
   * @param setters 個別のセッター
   * @return 生徒情報エンティティ
   */
  public static Student getStudent(Consumer<Student> setters) {
    Student entity = new Student();

    entity.setStudentId(1L);
    entity.setFamilyName("テスト");
    entity.setFirstName("太郎");

    if (setters != null) {
      setters.accept(entity);
    }

    return entity;
  }

  /**
   * 生徒情報DTOとエンティティをAssertする。
   *
   * @param actual 生徒情報DTO
   * @param expect 生徒情報エンティティ
   */
  private void assertEqual(StudentDto actual, Student expect) {
    assertThat(actual.getStudentId(), is(expect.getStudentId()));
    assertThat(actual.getFamilyName(), is(expect.getFamilyName()));
    assertThat(actual.getFirstName(), is(expect.getFirstName()));
  }
}
