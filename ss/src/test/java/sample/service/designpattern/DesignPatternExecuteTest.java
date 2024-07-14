package sample.service.designpattern;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import java.util.Iterator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import sample.dto.StudentDto;
import sample.dto.TeacherDto;
import sample.entity.gen.Teacher;
import sample.logic.designpattern.adapter.extend.StudentLogic;
import sample.logic.designpattern.adapter.extend.StudentLogicImpl;
import sample.logic.designpattern.adapter.instance.TeacherLogic;
import sample.logic.designpattern.adapter.instance.TeacherLogicImpl;
import sample.logic.designpattern.iterator.IterableClassDto;
import sample.logic.designpattern.templatemethod.AbstractClassIntroduciton;
import sample.logic.designpattern.templatemethod.ClassIntroduction;

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
      System.out.println(student); // 適当なチェック
    }
    System.out.println();

    // 拡張forを使う方法
    for (StudentDto student : classDto) {
      System.out.println(student);
    }
  }

  /**
   * 生徒情報を登録するシナリオ。登録時の姓名の区切りが全角or半角スペースのものを分けて生徒情報DTOに格納して返される。
   */
  @Test
  @DisplayName("adapter 実行")
  public void adapterExecute() {
    // 継承によるパターン
    StudentLogic studentLogic = new StudentLogicImpl();
    StudentDto student = studentLogic.getStudent("テスト 太郎");
    assertThat(student.getFamilyName(), is("テスト"));
    assertThat(student.getFirstName(), is("太郎"));

    // インスタンスによるパターン
    TeacherLogic teacherLogic = new TeacherLogicImpl();
    TeacherDto teacher = teacherLogic.getTeacher("テスト　花子");
    assertThat(teacher.getFamilyName(), is("テスト"));
    assertThat(teacher.getFirstName(), is("花子"));
  }

  /**
   * クラス紹介文を生成するシナリオ。
   */
  @Test
  @DisplayName("templatemethod 実行")
  public void templatemethodExecute() {
    AbstractClassIntroduciton introduciton = new ClassIntroduction(
        "1年A組です。", "仲のいいクラスです。");
    assertThat(introduciton.get(), is("1年A組です。¥n仲のいいクラスです。¥n"));
  }
}
