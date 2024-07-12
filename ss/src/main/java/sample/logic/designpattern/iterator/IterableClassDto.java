package sample.logic.designpattern.iterator;

import java.util.Iterator;
import sample.dto.StudentDto;

/**
 * クラスのDTO。生徒たちなどを扱う。
 */
public class IterableClassDto implements Iterable<StudentDto> {

  /**
   * 生徒たち。
   */
  private StudentDto[] students;

  /**
   * 格納された生徒情報の数。
   */
  private int last = 0;

  /**
   * @param maxsize 最大数
   */
  public IterableClassDto(int maxsize) {
    this.students = new StudentDto[maxsize];
  }

  /**
   * 生徒情報を取得する。
   *
   * @param index インデックス
   * @return 生徒情報
   */
  public StudentDto get(int index) {
    return students[index];
  }

  /**
   * 生徒情報を追加する。
   *
   * @param student 生徒情報
   */
  public void add(StudentDto student) {
    students[last] = student;
    last++;
  }

  /**
   * 格納された生徒情報の数を返す。
   *
   * @return
   */
  public int length() {
    return students.length;
  }

  @Override
  public Iterator<StudentDto> iterator() {
    return new ClassIterator(this);
  }
}
